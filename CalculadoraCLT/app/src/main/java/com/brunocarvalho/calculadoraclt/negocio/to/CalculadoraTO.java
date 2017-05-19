package com.brunocarvalho.calculadoraclt.negocio.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by carva on 18/05/2017.
 */

public class CalculadoraTO implements Serializable {

    private String tituloResultado;

    // Campos comum
    private BigDecimal vrSalBruto;
    private BigDecimal vrInss;
    private BigDecimal vrIrrf;
    private BigDecimal vrResultado;
    private Integer numDependentes;

    //Campos Ferias
    private BigDecimal vrHrsExtras;
    private Integer vrDiasFerias;
    private Boolean icAbonoPecuniario;
    private Boolean icAdiantamento;
    private BigDecimal vrFerias;
    private BigDecimal vrAdicionalFerias;
    private BigDecimal vrAbono;
    private BigDecimal vrAdiantamento;

    //Campos Sal Liquido
    private BigDecimal vrPensaoAlimenticia;
    private BigDecimal vrPlanoSaude;
    private BigDecimal vrOutrosDescontos;

    public String getTituloResultado() {
        return tituloResultado;
    }

    public void setTituloResultado(String tituloResultado) {
        this.tituloResultado = tituloResultado;
    }

    public BigDecimal getVrSalBruto() {
        if (vrSalBruto == null) {
            vrSalBruto = BigDecimal.ZERO;
        }
        return vrSalBruto;
    }

    public void setVrSalBruto(BigDecimal vrSalBruto) {
        this.vrSalBruto = vrSalBruto;
    }

    public void setVrSalBruto(String vrSalBruto) {
        if (vrSalBruto != null && !vrSalBruto.equals("")) {
            this.vrSalBruto = new BigDecimal(vrSalBruto).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrInss() {
        if (vrInss == null) {
            vrInss = BigDecimal.ZERO;
        }
        return vrInss;
    }

    public void setVrInss(BigDecimal vrInss) {
        this.vrInss = vrInss;
    }

    public void setVrInss(String vrInss) {
        if (vrInss != null && !vrInss.equals("")) {
            this.vrInss = new BigDecimal(vrInss).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrIrrf() {
        if (vrIrrf == null) {
            vrIrrf = BigDecimal.ZERO;
        }
        return vrIrrf;
    }

    public void setVrIrrf(BigDecimal vrIrrf) {
        this.vrIrrf = vrIrrf;
    }

    public void setVrIrrf(String vrIrrf) {
        if (vrIrrf != null && !vrIrrf.equals("")) {
            this.vrIrrf = new BigDecimal(vrIrrf).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrResultado() {
        if (vrResultado == null) {
            vrResultado = BigDecimal.ZERO;
        }
        return vrResultado;
    }

    public void setVrResultado(BigDecimal vrResultado) {
        this.vrResultado = vrResultado;
    }

    public void setVrResultado(String vrResultado) {
        if (vrResultado != null && !vrResultado.equals("")) {
            this.vrResultado = new BigDecimal(vrResultado).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public Integer getNumDependentes() {
        if (numDependentes == null) {
            numDependentes = 0;
        }
        return numDependentes;
    }

    public void setNumDependentes(Integer numDependentes) {
        this.numDependentes = numDependentes;
    }

    public void setNumDependentes(String numDependentes) {
        if (numDependentes != null && !numDependentes.equals("")) {
            this.numDependentes = Integer.valueOf(numDependentes);
        }
    }

    public BigDecimal getVrPensaoAlimenticia() {
        if (vrPensaoAlimenticia == null) {
            vrPensaoAlimenticia = BigDecimal.ZERO;
        }
        return vrPensaoAlimenticia;
    }

    public void setVrPensaoAlimenticia(BigDecimal vrPensaoAlimenticia) {
        this.vrPensaoAlimenticia = vrPensaoAlimenticia;
    }

    public void setVrPensaoAlimenticia(String vrPensaoAlimenticia) {
        if (vrPensaoAlimenticia != null && !vrPensaoAlimenticia.equals("")) {
            this.vrPensaoAlimenticia = new BigDecimal(vrPensaoAlimenticia).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrPlanoSaude() {
        if (vrPlanoSaude == null) {
            vrPlanoSaude = BigDecimal.ZERO;
        }
        return vrPlanoSaude;
    }

    public void setVrPlanoSaude(BigDecimal vrPlanoSaude) {
        this.vrPlanoSaude = vrPlanoSaude;
    }

    public void setVrPlanoSaude(String vrPlanoSaude) {
        if (vrPlanoSaude != null && !vrPlanoSaude.equals("")) {
            this.vrPlanoSaude = new BigDecimal(vrPlanoSaude).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrOutrosDescontos() {
        if (vrOutrosDescontos == null) {
            vrOutrosDescontos = BigDecimal.ZERO;
        }
        return vrOutrosDescontos;
    }

    public void setVrOutrosDescontos(BigDecimal vrOutrosDescontos) {
        this.vrOutrosDescontos = vrOutrosDescontos;
    }

    public void setVrOutrosDescontos(String vrOutrosDescontos) {
        if (vrOutrosDescontos != null && !vrOutrosDescontos.equals("")) {
            this.vrOutrosDescontos = new BigDecimal(vrOutrosDescontos).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public BigDecimal getVrTotalOutrosDescontos() {
        return getVrOutrosDescontos().add(getVrPlanoSaude()).add(getVrPensaoAlimenticia());
    }

    public BigDecimal getVrHrsExtras() {
        if (vrHrsExtras == null) {
            vrHrsExtras = BigDecimal.ZERO;
        }
        return vrHrsExtras;
    }

    public void setVrHrsExtras(BigDecimal vrHrsExtras) {
        this.vrHrsExtras = vrHrsExtras;
    }

    public void setVrHrsExtras(String vrHrsExtras) {
        if (vrHrsExtras != null && !vrHrsExtras.equals("")) {
            this.vrHrsExtras = new BigDecimal(vrHrsExtras).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public Integer getVrDiasFerias() {
        if (vrDiasFerias == null) {
            vrDiasFerias = 0;
        }
        return vrDiasFerias;
    }

    public void setVrDiasFerias(Integer vrDiasFerias) {
        this.vrDiasFerias = vrDiasFerias;
    }

    public void setVrDiasFerias(String vrDiasFerias) {
        if (vrDiasFerias != null && !vrDiasFerias.equals("")) {
            this.vrDiasFerias = Integer.valueOf(vrDiasFerias);
        }
    }

    public Boolean getIcAbonoPecuniario() {
        if (icAbonoPecuniario == null) {
            icAbonoPecuniario = Boolean.FALSE;
        }
        return icAbonoPecuniario;
    }

    public void setIcAbonoPecuniario(Boolean icAbonoPecuniario) {
        this.icAbonoPecuniario = icAbonoPecuniario;
    }

    public Boolean getIcAdiantamento() {
        if (icAdiantamento == null) {
            icAdiantamento = Boolean.FALSE;
        }
        return icAdiantamento;
    }

    public void setIcAdiantamento(Boolean icAdiantamento) {
        this.icAdiantamento = icAdiantamento;
    }

    public BigDecimal getVrFerias() {
        if(vrFerias == null){
            vrFerias = BigDecimal.ZERO;
        }
        return vrFerias;
    }

    public void setVrFerias(BigDecimal vrFerias) {
        this.vrFerias = vrFerias;
    }

    public BigDecimal getVrAdicionalFerias() {
        if(vrAdicionalFerias == null){
            vrAdicionalFerias = BigDecimal.ZERO;
        }
        return vrAdicionalFerias;
    }

    public void setVrAdicionalFerias(BigDecimal vrAdicionalFerias) {
        this.vrAdicionalFerias = vrAdicionalFerias;
    }

    public BigDecimal getVrAbono() {
        if(vrAbono == null){
            vrAbono = BigDecimal.ZERO;
        }
        return vrAbono;
    }

    public void setVrAbono(BigDecimal vrAbono) {
        this.vrAbono = vrAbono;
    }

    public BigDecimal getVrAdiantamento() {
        if(vrAdiantamento == null){
            vrAdiantamento = BigDecimal.ZERO;
        }
        return vrAdiantamento;
    }

    public void setVrAdiantamento(BigDecimal vrAdiantamento) {
        this.vrAdiantamento = vrAdiantamento;
    }
}
