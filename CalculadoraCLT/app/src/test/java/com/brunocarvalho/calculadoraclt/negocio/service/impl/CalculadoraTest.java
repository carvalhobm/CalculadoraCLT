package com.brunocarvalho.calculadoraclt.negocio.service.impl;

import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by admin on 19/05/2017.
 */
public class CalculadoraTest {

    private Calculadora calc;
    private CalculadoraTO dados;

    @Before
    public void setUp() {
        calc = new CalculadoraImpl();
        dados = new CalculadoraTO();
    }

    @Test
    public void calcularRescisao() throws Exception {

    }

    @Test
    public void calcularFerias() throws Exception {

        calc.calcularFerias(dados);

        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularFerias2() throws Exception {

        dados.setVrSalBruto(new BigDecimal("2500"));
        dados.setVrDiasFerias(20);

        dados.setIcAbonoPecuniario(Boolean.TRUE);

        calc.calcularFerias(dados);

        Assert.assertTrue(new BigDecimal("1666.67").compareTo(dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("555.56").compareTo(dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("833.33").compareTo(dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("277.78").compareTo(dados.getVrAdicionalAbono()) == 0);
        Assert.assertTrue(new BigDecimal("200").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("8.87").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("3124.47").compareTo(dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularFerias3() throws Exception {

        dados.setVrSalBruto("2500");
        dados.setVrHrsExtras("100");
        dados.setNumDependentes(1);
        dados.setVrDiasFerias(20);

        dados.setIcAbonoPecuniario(Boolean.TRUE);

        calc.calcularFerias(dados);

        Assert.assertTrue(new BigDecimal("1733.33").compareTo(dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("577.78").compareTo(dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("866.67").compareTo(dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("288.89").compareTo(dados.getVrAdicionalAbono()) == 0);
        Assert.assertTrue(new BigDecimal("3257.96").compareTo(dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularSalarioLiquido() throws Exception {

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite1() throws Exception {

        dados.setVrSalBruto(new BigDecimal(1659.37));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("1526.62").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("132.75").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite2() throws Exception {

        dados.setVrSalBruto(new BigDecimal(1659.38));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("1526.63").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("132.75").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite3() throws Exception {

        dados.setVrSalBruto(new BigDecimal(1659.39));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("1510.04").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("149.35").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite4() throws Exception {

        dados.setVrSalBruto(new BigDecimal(2765.65));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("2470.78").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("248.91").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("45.96").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite5() throws Exception {

        dados.setVrSalBruto(new BigDecimal(2765.66));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("2470.79").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("248.91").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("45.96").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite6() throws Exception {

        dados.setVrSalBruto(new BigDecimal(2765.67));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("2419.64").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("304.22").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("41.81").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite7() throws Exception {

        dados.setVrSalBruto(new BigDecimal(5531.30));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("4438.43").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite8() throws Exception {

        dados.setVrSalBruto(new BigDecimal(5531.31));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("4438.44").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite9() throws Exception {

        dados.setVrSalBruto(new BigDecimal(5531.32));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("4438.45").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }


    @Test
    public void calcularSalarioLiquidoInssLimite10() throws Exception {

        dados.setVrSalBruto(new BigDecimal(50000));

        calc.calcularSalarioLiquido(dados);

        Assert.assertTrue(new BigDecimal("36678.24").compareTo(dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("12713.32").compareTo(dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(dados.getVrTotalOutrosDescontos()) == 0);
    }

}