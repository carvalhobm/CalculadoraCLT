package com.brunocarvalho.calculadoraclt.negocio.service;

import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;


public interface Calculadora {

    void calcularRescisao(final CalculadoraTO dados);

    void calcularFerias(final CalculadoraTO dados);

    void calcularSalarioLiquido(final CalculadoraTO dados);
}
