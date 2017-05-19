package com.brunocarvalho.calculadoraclt.negocio.to;

import java.io.Serializable;

/**
 * Created by carva on 18/05/2017.
 */

public class CalculadoraTO implements Serializable {

    private String tituloResultado;

    private Double vrSalBruto;
    private Double vrInss;
    private Double vrIrrf;
    private Double vrResultado;

    private Integer numDependentes;
    private Double vrPensaoAlimenticia;
    private Double vrPlanoSaude;
    private Double vrPAT;
    private Double vrOutrosDescontos;

    public String getTituloResultado() {
        return tituloResultado;
    }

    public void setTituloResultado(String tituloResultado) {
        this.tituloResultado = tituloResultado;
    }

    public Double getVrSalBruto() {
        if(vrSalBruto == null){
            vrSalBruto = Double.valueOf(0.0);
        }
        return vrSalBruto;
    }

    public void setVrSalBruto(Double vrSalBruto) {
        this.vrSalBruto = vrSalBruto;
    }

    public Double getVrInss() {
        if(vrInss == null){
            vrInss = Double.valueOf(0.0);
        }
        return vrInss;
    }

    public void setVrInss(Double vrInss) {
        this.vrInss = vrInss;
    }

    public Double getVrIrrf() {
        if(vrIrrf == null){
            vrIrrf = Double.valueOf(0.0);
        }
        return vrIrrf;
    }

    public void setVrIrrf(Double vrIrrf) {
        this.vrIrrf = vrIrrf;
    }

    public Double getVrResultado() {
        if(vrResultado == null){
            vrResultado = Double.valueOf(0.0);
        }
        return vrResultado;
    }

    public void setVrResultado(Double vrResultado) {
        this.vrResultado = vrResultado;
    }

    public Integer getNumDependentes() {
        if(numDependentes == null){
            numDependentes = 0;
        }
        return numDependentes;
    }

    public void setNumDependentes(Integer numDependentes) {
        this.numDependentes = numDependentes;
    }

    public Double getVrPensaoAlimenticia() {
        if(vrPensaoAlimenticia == null){
            vrPensaoAlimenticia = Double.valueOf(0.0);
        }
        return vrPensaoAlimenticia;
    }

    public void setVrPensaoAlimenticia(Double vrPensaoAlimenticia) {
        this.vrPensaoAlimenticia = vrPensaoAlimenticia;
    }

    public Double getVrPlanoSaude() {
        if(vrPlanoSaude == null){
            vrPlanoSaude = Double.valueOf(0.0);
        }
        return vrPlanoSaude;
    }

    public void setVrPlanoSaude(Double vrPlanoSaude) {
        this.vrPlanoSaude = vrPlanoSaude;
    }

    public Double getVrPAT() {
        if(vrPAT == null){
            vrPAT = Double.valueOf(0.0);
        }
        return vrPAT;
    }

    public void setVrPAT(Double vrPAT) {
        this.vrPAT = vrPAT;
    }

    public Double getVrOutrosDescontos() {
        if(vrOutrosDescontos == null){
            vrOutrosDescontos = Double.valueOf(0.0);
        }
        return vrOutrosDescontos;
    }

    public void setVrOutrosDescontos(Double vrOutrosDescontos) {
        this.vrOutrosDescontos = vrOutrosDescontos;
    }
}
