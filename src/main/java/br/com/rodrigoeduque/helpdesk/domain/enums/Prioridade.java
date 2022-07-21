package br.com.rodrigoeduque.helpdesk.domain.enums;

public enum Prioridade {

    BAIXA(0, "BAIXA"),
    MEDIA(1, "MEDIA"),
    ALTA(2, "ALTA");

    private Integer codigo;
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    private Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Prioridade toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Prioridade prioridade : Prioridade.values()) {
            if (codigo.equals(prioridade.getCodigo())) {
                return prioridade;
            }

        }
        throw new IllegalArgumentException("Tipo Prioridade Inválido/Inexistente");
    }
}
