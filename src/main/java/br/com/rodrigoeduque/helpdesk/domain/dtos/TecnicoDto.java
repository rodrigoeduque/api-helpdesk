package br.com.rodrigoeduque.helpdesk.domain.dtos;

import br.com.rodrigoeduque.helpdesk.domain.Tecnico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoDto implements Serializable {

    private static final long serialVersionUID = -3839211160522639828L;

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Set<String> perfis = new HashSet<>();
    protected LocalDate dataCriacao = LocalDate.now();

    public TecnicoDto() {
        super();
    }

    public TecnicoDto(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.email = tecnico.getEmail();
        this.senha = tecnico.getSenha();
        this.perfis = tecnico.getPerfis().stream().map(x -> x.getDescricao()).collect(Collectors.toSet());
        this.dataCriacao = tecnico.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Set<String> getPerfis() {
        return perfis;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
}
