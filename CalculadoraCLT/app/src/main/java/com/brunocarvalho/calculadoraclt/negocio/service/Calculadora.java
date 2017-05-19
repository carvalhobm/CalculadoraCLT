package com.brunocarvalho.calculadoraclt.negocio.service;

import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;

/**
 * Created by admin on 19/05/2017.
 */

public interface Calculadora {

    void calcularRescisao(final CalculadoraTO dados);

    void calcularFerias(final CalculadoraTO dados);

    void calcularSalarioLiquido(final CalculadoraTO dados);
}
