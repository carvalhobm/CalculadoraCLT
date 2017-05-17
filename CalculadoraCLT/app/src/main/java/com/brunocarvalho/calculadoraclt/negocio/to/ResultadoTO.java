package com.brunocarvalho.calculadoraclt.negocio.to;

import java.io.Serializable;

/**
 * Created by carva on 15/05/2017.
 */

public class ResultadoTO implements Serializable {

    private String tituloResultado;

    public String getTituloResultado() {
        return tituloResultado;
    }

    public void setTituloResultado(String tituloResultado) {
        this.tituloResultado = tituloResultado;
    }
}
