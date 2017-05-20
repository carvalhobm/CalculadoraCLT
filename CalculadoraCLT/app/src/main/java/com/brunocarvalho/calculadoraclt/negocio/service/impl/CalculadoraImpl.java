package com.brunocarvalho.calculadoraclt.negocio.service.impl;

import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by carva on 13/05/2017.
 */

public class CalculadoraImpl implements Calculadora {

    public static final BigDecimal BD_CEM = new BigDecimal("100");
    public static final BigDecimal TRINTA_DIAS = new BigDecimal("30");
    public static final BigDecimal TRES = new BigDecimal("3");
    public static final int SCALE = 2;
    public static final int SCALE_DIVISOR = 10;

    public void calcularRescisao(final CalculadoraTO dados) {

    }

    public void calcularFerias(final CalculadoraTO dados) {
        dados.setVrResultado(BigDecimal.ZERO);

        BigDecimal vrSalarioBase = dados.getVrSalBruto().add(dados.getVrHrsExtras());

        BigDecimal vrBase = vrSalarioBase.divide(TRINTA_DIAS, SCALE_DIVISOR, RoundingMode.CEILING).multiply(new BigDecimal(dados.getVrDiasFerias())).setScale(SCALE, RoundingMode.HALF_UP);
        BigDecimal vrAdicionalFerias = vrBase.divide(TRES, SCALE_DIVISOR, RoundingMode.HALF_UP).setScale(SCALE, RoundingMode.HALF_UP);
        BigDecimal vrInss = calcularINSS(vrBase.add(vrAdicionalFerias));
        BigDecimal vrIrrf = calcularIRRF(vrBase.add(vrAdicionalFerias), vrInss, BigDecimal.ZERO, dados.getNumDependentes());
        BigDecimal vrAbonoPecuniario = BigDecimal.ZERO;
        BigDecimal vrAdicionalAbonoPecuniario = BigDecimal.ZERO;

        if (dados.getIcAbonoPecuniario()) {
            vrAbonoPecuniario = vrSalarioBase.divide(TRINTA_DIAS, SCALE_DIVISOR, RoundingMode.HALF_UP).multiply(BigDecimal.TEN).setScale(SCALE, RoundingMode.HALF_UP);
            vrAdicionalAbonoPecuniario = vrAbonoPecuniario.divide(TRES, SCALE_DIVISOR, RoundingMode.HALF_UP).setScale(SCALE, RoundingMode.HALF_UP);
        }

        dados.setVrFerias(vrBase);
        dados.setVrAdicionalFerias(vrAdicionalFerias.setScale(SCALE, RoundingMode.HALF_UP));
        dados.setVrAbono(vrAbonoPecuniario.setScale(SCALE, RoundingMode.HALF_UP));
        dados.setVrAdicionalAbono(vrAdicionalAbonoPecuniario.setScale(SCALE, RoundingMode.HALF_UP));

        dados.setVrInss(vrInss.setScale(SCALE, RoundingMode.HALF_UP));
        dados.setVrIrrf(vrIrrf.setScale(SCALE, RoundingMode.HALF_UP));

        BigDecimal proventos = vrBase.add(vrAdicionalFerias).add(vrAbonoPecuniario).add(vrAdicionalAbonoPecuniario);
        BigDecimal descontos = vrInss.add(vrIrrf);

        dados.setVrResultado(proventos.subtract(descontos).setScale(SCALE, RoundingMode.HALF_UP));
    }

    public void calcularSalarioLiquido(final CalculadoraTO dados) {
        dados.setVrResultado(BigDecimal.ZERO);

        dados.setVrInss(calcularINSS(dados.getVrSalBruto()));
        dados.setVrIrrf(calcularIRRF(dados.getVrSalBruto(), dados.getVrInss(), dados.getVrPensaoAlimenticia(), dados.getNumDependentes()));

        final BigDecimal vrDescontos = dados.getVrInss().add(dados.getVrIrrf()).add(dados.getVrPensaoAlimenticia()).add(dados.getVrPlanoSaude()).add(dados.getVrOutrosDescontos());

        dados.setVrResultado(dados.getVrSalBruto().subtract(vrDescontos).setScale(SCALE, RoundingMode.HALF_UP));
    }

    private void calcularFGTS() {

    }

    private BigDecimal calcularINSS(final BigDecimal vrSalBruto) {

        BigDecimal resultadoINSS;

        if (vrSalBruto.compareTo(new BigDecimal(1659.38)) < 1) {
            resultadoINSS = vrSalBruto.multiply(new BigDecimal("8").divide(BD_CEM));
        } else if (vrSalBruto.compareTo(BigDecimal.valueOf(1659.39)) >= 0 && vrSalBruto.compareTo(BigDecimal.valueOf(2765.66)) < 1) {
            resultadoINSS = vrSalBruto.multiply(new BigDecimal("9").divide(BD_CEM));
        } else if (vrSalBruto.compareTo(BigDecimal.valueOf(2765.67)) >= 0 && vrSalBruto.compareTo(BigDecimal.valueOf(5531.31)) < 1) {
            resultadoINSS = vrSalBruto.multiply(new BigDecimal("11").divide(BD_CEM));
        } else {
            resultadoINSS = BigDecimal.valueOf(608.44);
        }

        return resultadoINSS.setScale(SCALE, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularIRRF(final BigDecimal vrSalBruto, final BigDecimal vrContINSS, final BigDecimal vrPensaoAlimenticia, final Integer numDependentes) {

        BigDecimal baseCalculo = vrSalBruto.subtract(vrContINSS).subtract(vrPensaoAlimenticia).subtract(new BigDecimal("189.59").multiply(new BigDecimal(numDependentes)));
        BigDecimal vrAliquota = BigDecimal.valueOf(0.0);
        BigDecimal vrDeducao = BigDecimal.valueOf(0.0);


        if (baseCalculo.compareTo(BigDecimal.valueOf(1903.98)) < 1) {
            vrAliquota = BigDecimal.valueOf(0.0);
            vrDeducao = BigDecimal.valueOf(0.0);
        } else if (baseCalculo.compareTo(BigDecimal.valueOf(1903.99)) >= 0 && baseCalculo.compareTo(BigDecimal.valueOf(2826.65)) < 1) {
            vrAliquota = BigDecimal.valueOf(7.5);
            vrDeducao = BigDecimal.valueOf(142.80);
        } else if (baseCalculo.compareTo(BigDecimal.valueOf(2826.66)) >= 0 && baseCalculo.compareTo(BigDecimal.valueOf(3751.05)) < 1) {
            vrAliquota = BigDecimal.valueOf(15);
            vrDeducao = BigDecimal.valueOf(354.80);
        } else if (baseCalculo.compareTo(BigDecimal.valueOf(3751.06)) >= 0 && baseCalculo.compareTo(BigDecimal.valueOf(4664.68)) < 1) {
            vrAliquota = BigDecimal.valueOf(22.5);
            vrDeducao = BigDecimal.valueOf(636.13);
        } else if (baseCalculo.compareTo(BigDecimal.valueOf(4664.68)) > 0) {
            vrAliquota = BigDecimal.valueOf(27.5);
            vrDeducao = BigDecimal.valueOf(869.36);
        }

        return baseCalculo.multiply(vrAliquota.divide(BD_CEM)).subtract(vrDeducao).setScale(SCALE, RoundingMode.HALF_UP);
    }

}
