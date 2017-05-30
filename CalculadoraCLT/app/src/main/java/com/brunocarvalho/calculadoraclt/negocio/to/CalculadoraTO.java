package com.brunocarvalho.calculadoraclt.negocio.to;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class CalculadoraTO implements Serializable {

    private String tituloResultado;

    // Campos comum
    private BigDecimal vrSalBruto;
    private BigDecimal vrInss;
    private BigDecimal vrIrrf;
    private BigDecimal vrResultado;
    private Integer numDependentes;

    //Campos Rescisao
    private Date dtContratacao;
    private Date dtDesligamento;
    private Integer icMotivo;
    private Integer icAviso;
    private BigDecimal vrSaldoFgts;
    private Boolean icPossuiFeriasVencidas;
    private Integer vrDiasFeriasVencidas;

    //Campos Ferias
    private BigDecimal vrHrsExtras;
    private Integer vrDiasFerias;
    private Boolean icAbonoPecuniario;
    private Boolean icAdiantamento;
    private BigDecimal vrFerias;
    private BigDecimal vrAdicionalFerias;
    private BigDecimal vrAbono;
    private BigDecimal vrAdicionalAbono;

    //Campos Sal Liquido
    private BigDecimal vrPensaoAlimenticia;
    private BigDecimal vrPlanoSaude;
    private BigDecimal vrOutrosDescontos;

    public String getTituloResultado() {
        return this.tituloResultado;
    }

    public void setTituloResultado(String tituloResultado) {
        this.tituloResultado = tituloResultado;
    }

    public BigDecimal getVrSalBruto() {
        if (this.vrSalBruto == null) {
            this.vrSalBruto = BigDecimal.ZERO;
        }
        return this.vrSalBruto;
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
        if (this.vrInss == null) {
            this.vrInss = BigDecimal.ZERO;
        }
        return this.vrInss;
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
        if (this.vrIrrf == null) {
            this.vrIrrf = BigDecimal.ZERO;
        }
        return this.vrIrrf;
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
        if (this.vrResultado == null) {
            this.vrResultado = BigDecimal.ZERO;
        }
        return this.vrResultado;
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
        if (this.numDependentes == null) {
            this.numDependentes = 0;
        }
        return this.numDependentes;
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
        if (this.vrPensaoAlimenticia == null) {
            this.vrPensaoAlimenticia = BigDecimal.ZERO;
        }
        return this.vrPensaoAlimenticia;
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
        if (this.vrPlanoSaude == null) {
            this.vrPlanoSaude = BigDecimal.ZERO;
        }
        return this.vrPlanoSaude;
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
        if (this.vrOutrosDescontos == null) {
            this.vrOutrosDescontos = BigDecimal.ZERO;
        }
        return this.vrOutrosDescontos;
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
        return this.getVrOutrosDescontos().add(this.getVrPlanoSaude()).add(this.getVrPensaoAlimenticia());
    }

    public BigDecimal getVrHrsExtras() {
        if (this.vrHrsExtras == null) {
            this.vrHrsExtras = BigDecimal.ZERO;
        }
        return this.vrHrsExtras;
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
        if (this.vrDiasFerias == null) {
            this.vrDiasFerias = 0;
        }
        return this.vrDiasFerias;
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
        if (this.icAbonoPecuniario == null) {
            this.icAbonoPecuniario = Boolean.FALSE;
        }
        return this.icAbonoPecuniario;
    }

    public void setIcAbonoPecuniario(Boolean icAbonoPecuniario) {
        this.icAbonoPecuniario = icAbonoPecuniario;
    }

    public Boolean getIcAdiantamento() {
        if (this.icAdiantamento == null) {
            this.icAdiantamento = Boolean.FALSE;
        }
        return this.icAdiantamento;
    }

    public void setIcAdiantamento(Boolean icAdiantamento) {
        this.icAdiantamento = icAdiantamento;
    }

    public BigDecimal getVrFerias() {
        if (this.vrFerias == null) {
            this.vrFerias = BigDecimal.ZERO;
        }
        return this.vrFerias;
    }

    public void setVrFerias(BigDecimal vrFerias) {
        this.vrFerias = vrFerias;
    }

    public BigDecimal getVrAdicionalFerias() {
        if (this.vrAdicionalFerias == null) {
            this.vrAdicionalFerias = BigDecimal.ZERO;
        }
        return this.vrAdicionalFerias;
    }

    public void setVrAdicionalFerias(BigDecimal vrAdicionalFerias) {
        this.vrAdicionalFerias = vrAdicionalFerias;
    }

    public BigDecimal getVrAbono() {
        if (this.vrAbono == null) {
            this.vrAbono = BigDecimal.ZERO;
        }
        return this.vrAbono;
    }

    public void setVrAbono(BigDecimal vrAbono) {
        this.vrAbono = vrAbono;
    }

    public BigDecimal getVrAdicionalAbono() {
        if (this.vrAdicionalAbono == null) {
            this.vrAdicionalAbono = BigDecimal.ZERO;
        }
        return this.vrAdicionalAbono;
    }

    public void setVrAdicionalAbono(BigDecimal vrAdicionalAbono) {
        this.vrAdicionalAbono = vrAdicionalAbono;
    }

    public Date getDtContratacao() {
        return this.dtContratacao;
    }

    public Date getDtDesligamento() {
        return this.dtDesligamento;
    }

    public Integer getIcMotivo() {
        return this.icMotivo;
    }

    public Integer getIcAviso() {
        return this.icAviso;
    }

    public BigDecimal getVrSaldoFgts() {
        if (this.vrSaldoFgts == null) {
            this.vrSaldoFgts = BigDecimal.ZERO;
        }
        return this.vrSaldoFgts;
    }

    public Boolean getIcPossuiFeriasVencidas() {
        return this.icPossuiFeriasVencidas;
    }

    public Integer getVrDiasFeriasVencidas() {
        if (this.vrDiasFeriasVencidas == null) {
            this.vrDiasFeriasVencidas = 0;
        }
        return this.vrDiasFeriasVencidas;
    }

    public void setDtContratacao(Date dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public void setDtDesligamento(Date dtDesligamento) {
        this.dtDesligamento = dtDesligamento;
    }

    public void setIcMotivo(Integer icMotivo) {
        this.icMotivo = icMotivo;
    }

    public void setIcAviso(Integer icAviso) {
        this.icAviso = icAviso;
    }

    public void setVrSaldoFgts(BigDecimal vrSaldoFgts) {
        this.vrSaldoFgts = vrSaldoFgts;
    }

    public void setVrSaldoFgts(String vrSaldoFgts) {
        if (vrSaldoFgts != null && !vrSaldoFgts.equals("")) {
            this.vrSaldoFgts = new BigDecimal(vrSaldoFgts).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public void setIcPossuiFeriasVencidas(Boolean icPossuiFeriasVencidas) {
        this.icPossuiFeriasVencidas = icPossuiFeriasVencidas;
    }

    public void setVrDiasFeriasVencidas(Integer vrDiasFeriasVencidas) {
        this.vrDiasFeriasVencidas = vrDiasFeriasVencidas;
    }
}
