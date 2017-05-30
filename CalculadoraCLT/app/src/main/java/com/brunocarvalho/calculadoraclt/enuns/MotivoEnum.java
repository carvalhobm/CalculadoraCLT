package com.brunocarvalho.calculadoraclt.enuns;

public enum MotivoEnum {

    DISPENSA_SEM_JUSTA_CAUSA(1, "Dispensa sem Justa Causa"),
    DISPENSA_COM_JUSTA_CAUSA(2, "Dispensa com Justa Causa"),
    PEDIDO_DEMISSAO(3, "Pedido de demissão"),
    FIM_PRAZO_CONTRATO_EXPERIENCIA(4, "Fim contrato de experiência no prazo"),
    FIM_CONTRATO_EXPERIENCIA_ANTES_PRAZO(5, "Fim contrato de experiência antes do prazo"),
    APOSENTADORIA(6, "Aposentadoria do empregado"),
    FALECIMENTO_EMPREGADOR(7, "Falecimento do empregador");

    private final Integer coMotivo;
    private final String deMotivo;

    MotivoEnum(Integer coMotivo, String deMotivo) {
        this.coMotivo = coMotivo;
        this.deMotivo = deMotivo;
    }

    @Override
    public String toString() {
        return this.deMotivo;
    }

    public Integer getCoMotivo() {
        return this.coMotivo;
    }

    public String getDeMotivo() {
        return this.deMotivo;
    }

    public static String getDeMotivoByCodigo(final Integer coMotivo) {
        String deMotivo = "";
        for (MotivoEnum motivo : MotivoEnum.values()) {
            if (motivo.getCoMotivo().equals(coMotivo)) {
                deMotivo = motivo.getDeMotivo();
                break;
            }
        }

        return deMotivo;
    }
}
