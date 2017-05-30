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
        this.calc = new CalculadoraImpl();
        this.dados = new CalculadoraTO();
    }

    @Test
    public void calcularRescisao() throws Exception {

    }

    @Test
    public void calcularFerias() throws Exception {

        this.calc.calcularFerias(this.dados);

        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularFerias2() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal("2500"));
        this.dados.setVrDiasFerias(20);

        this.dados.setIcAbonoPecuniario(Boolean.TRUE);

        this.calc.calcularFerias(this.dados);

        Assert.assertTrue(new BigDecimal("1666.67").compareTo(this.dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("555.56").compareTo(this.dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("833.33").compareTo(this.dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("277.78").compareTo(this.dados.getVrAdicionalAbono()) == 0);
        Assert.assertTrue(new BigDecimal("200").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("8.87").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("3124.47").compareTo(this.dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularFerias3() throws Exception {

        this.dados.setVrSalBruto("2500");
        this.dados.setVrHrsExtras("100");
        this.dados.setNumDependentes(1);
        this.dados.setVrDiasFerias(20);

        this.dados.setIcAbonoPecuniario(Boolean.TRUE);

        this.calc.calcularFerias(this.dados);

        Assert.assertTrue(new BigDecimal("1733.33").compareTo(this.dados.getVrFerias()) == 0);
        Assert.assertTrue(new BigDecimal("577.78").compareTo(this.dados.getVrAdicionalFerias()) == 0);
        Assert.assertTrue(new BigDecimal("866.67").compareTo(this.dados.getVrAbono()) == 0);
        Assert.assertTrue(new BigDecimal("288.89").compareTo(this.dados.getVrAdicionalAbono()) == 0);
        Assert.assertTrue(new BigDecimal("3257.96").compareTo(this.dados.getVrResultado()) == 0);
    }

    @Test
    public void calcularSalarioLiquido() throws Exception {

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite1() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(1659.37));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("1526.62").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("132.75").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite2() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(1659.38));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("1526.63").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("132.75").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite3() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(1659.39));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("1510.04").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("149.35").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite4() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(2765.65));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("2470.78").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("248.91").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("45.96").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite5() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(2765.66));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("2470.79").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("248.91").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("45.96").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite6() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(2765.67));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("2419.64").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("304.22").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("41.81").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite7() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(5531.30));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("4438.43").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite8() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(5531.31));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("4438.44").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

    @Test
    public void calcularSalarioLiquidoInssLimite9() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(5531.32));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("4438.45").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("484.43").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }


    @Test
    public void calcularSalarioLiquidoInssLimite10() throws Exception {

        this.dados.setVrSalBruto(new BigDecimal(50000));

        this.calc.calcularSalarioLiquido(this.dados);

        Assert.assertTrue(new BigDecimal("36678.24").compareTo(this.dados.getVrResultado()) == 0);
        Assert.assertTrue(new BigDecimal("608.44").compareTo(this.dados.getVrInss()) == 0);
        Assert.assertTrue(new BigDecimal("12713.32").compareTo(this.dados.getVrIrrf()) == 0);
        Assert.assertTrue(new BigDecimal("0").compareTo(this.dados.getVrTotalOutrosDescontos()) == 0);
    }

}