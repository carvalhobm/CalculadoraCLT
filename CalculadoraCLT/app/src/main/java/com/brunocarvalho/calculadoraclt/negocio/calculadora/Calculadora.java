package com.brunocarvalho.calculadoraclt.negocio.calculadora;

import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;

/**
 * Created by carva on 13/05/2017.
 */

public class Calculadora {

    public static final Double DOUBLE_CEM = Double.valueOf(100);

    public static Double calcularFerias() {
        return 0.0;

    }

    public Double calcularFGTS() {
        return 0.0;
    }

    public Double calcularRescisao() {
        return 0.0;
    }

    public void calcularSalarioLiquido(final CalculadoraTO dados) {
        dados.setVrResultado(Double.valueOf(0.0));

        dados.setVrInss(calcularINSS(dados.getVrSalBruto()));
        dados.setVrIrrf(calcularIRRF(dados.getVrSalBruto(), dados.getVrInss(), dados.getVrPensaoAlimenticia(), dados.getNumDependentes()));

        final Double vrDescontos = dados.getVrInss() + dados.getVrIrrf() + dados.getVrPensaoAlimenticia() + dados.getVrPlanoSaude() + dados.getVrPAT() + dados.getVrOutrosDescontos();

        dados.setVrResultado(dados.getVrSalBruto() - vrDescontos);

    }

    private Double calcularINSS(final Double vrSalBruto) {

        Double resultadoINSS;

        if (vrSalBruto.compareTo(Double.valueOf(1659.38)) < 1) {
            resultadoINSS = vrSalBruto * (8 / DOUBLE_CEM);
        } else if (vrSalBruto.compareTo(Double.valueOf(1659.39)) >= 0 && vrSalBruto.compareTo(Double.valueOf(2765.66)) < 1) {
            resultadoINSS = vrSalBruto * (9 / DOUBLE_CEM);
        } else if (vrSalBruto.compareTo(Double.valueOf(2765.67)) >= 0 && vrSalBruto.compareTo(Double.valueOf(5531.31)) < 1) {
            resultadoINSS = vrSalBruto * (11 / DOUBLE_CEM);
        } else {
            resultadoINSS = Double.valueOf(608.44);
        }

        return resultadoINSS;
    }

    private Double calcularIRRF(final Double vrSalBruto, final Double vrContINSS, final Double vrPensaoAlimenticia, final Integer numDependentes) {

        Double baseCalculo = vrSalBruto - vrContINSS - vrPensaoAlimenticia - (numDependentes * Double.valueOf(189.59));
        Double vrAliquota = Double.valueOf(0.0);
        Double vrDeducao = Double.valueOf(0.0);


        if (baseCalculo.compareTo(Double.valueOf(1903.98)) < 1) {
            vrAliquota = Double.valueOf(0.0);
            vrDeducao = Double.valueOf(0.0);
        } else if (baseCalculo.compareTo(Double.valueOf(1903.99)) >= 0 && baseCalculo.compareTo(Double.valueOf(2826.65)) < 1) {
            vrAliquota = Double.valueOf(7.5);
            vrDeducao = Double.valueOf(142.80);
        } else if (baseCalculo.compareTo(Double.valueOf(2826.66)) >= 0 && baseCalculo.compareTo(Double.valueOf(3751.05)) < 1) {
            vrAliquota = Double.valueOf(15);
            vrDeducao = Double.valueOf(354.80);
        } else if (baseCalculo.compareTo(Double.valueOf(3751.06)) >= 0 && baseCalculo.compareTo(Double.valueOf(4664.68)) < 1) {
            vrAliquota = Double.valueOf(22.5);
            vrDeducao = Double.valueOf(636.13);
        } else if (baseCalculo.compareTo(Double.valueOf(4664.68)) > 0) {
            vrAliquota = Double.valueOf(27.5);
            vrDeducao = Double.valueOf(869.36);
        }

        return ((baseCalculo * (vrAliquota / DOUBLE_CEM)) - vrDeducao);
    }

}
