package br.com.rodrigoeduque.helpdesk.domain.enums;

public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "EM_ANDAMENTO"),
    ENCERRADO(2, "ENCERRADO");

    private Integer codigo;
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static Status toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (Status status : Status.values()
        ) {
            if (codigo.equals(status.getCodigo())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Tipo Status Inválido/Inexistente");
    }
}
