package com.brunocarvalho.calculadoraclt.enuns;

public enum AvisoPrevioEnum {

    TRABALHADO(1, "Trabalhado"),
    INDENIZADO(2, "Indenizado pelo empregador"),
    NAO_CUMPRIDO_PELO_EMPREGADO(3, "Não cumprido pelo empregado"),
    DISPENSADO(4, "Dispensado");

    private final Integer coAvisoPrevio;
    private final String deAvisoPrevio;

    AvisoPrevioEnum(Integer coAvisoPrevio, String deAvisoPrevio) {
        this.coAvisoPrevio = coAvisoPrevio;
        this.deAvisoPrevio = deAvisoPrevio;
    }

    @Override
    public String toString() {
        return this.deAvisoPrevio;
    }

    public Integer getCoAvisoPrevio() {
        return this.coAvisoPrevio;
    }

    public String getDeAvisoPrevio() {
        return this.deAvisoPrevio;
    }

    public static String getDeAvisoPrevisoByCodigo(final Integer coAvisoPrevio) {
        String deAvisoPrevio = "";
        for (AvisoPrevioEnum avisoPrevio : AvisoPrevioEnum.values()) {
            if (avisoPrevio.getCoAvisoPrevio().equals(coAvisoPrevio)) {
                deAvisoPrevio = avisoPrevio.getDeAvisoPrevio();
                break;
            }
        }
        return deAvisoPrevio;
    }
}
