package com.brunocarvalho.calculadoraclt.negocio.service.impl;

import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by carva on 13/05/2017.
 */

public class CalculadoraImpl implements Calculadora {

    public static final BigDecimal BD_CEM = BigDecimal.valueOf(100);

    public void calcularRescisao(final CalculadoraTO dados) {

    }

    public void calcularFerias(final CalculadoraTO dados) {

    }

    public void calcularSalarioLiquido(final CalculadoraTO dados) {
        dados.setVrResultado(BigDecimal.valueOf(0.0));

        dados.setVrInss(calcularINSS(dados.getVrSalBruto()));
        dados.setVrIrrf(calcularIRRF(dados.getVrSalBruto(), dados.getVrInss(), dados.getVrPensaoAlimenticia(), dados.getNumDependentes()));

        final BigDecimal vrDescontos = dados.getVrInss().add(dados.getVrIrrf()).add(dados.getVrPensaoAlimenticia()).add(dados.getVrPlanoSaude()).add(dados.getVrOutrosDescontos());

        dados.setVrResultado(dados.getVrSalBruto().subtract(vrDescontos).setScale(2, RoundingMode.HALF_UP));
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

        return resultadoINSS.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calcularIRRF(final BigDecimal vrSalBruto, final BigDecimal vrContINSS, final BigDecimal vrPensaoAlimenticia, final Integer numDependentes) {

        BigDecimal baseCalculo = vrSalBruto.subtract(vrContINSS).subtract(vrPensaoAlimenticia).subtract(BigDecimal.valueOf(189.59).multiply(new BigDecimal(numDependentes)));
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

        return baseCalculo.multiply(vrAliquota.divide(BD_CEM)).subtract(vrDeducao).setScale(2, RoundingMode.HALF_UP);
    }

}
