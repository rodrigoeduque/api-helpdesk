package br.com.rodrigoeduque.helpdesk.domain.dtos;

import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import br.com.rodrigoeduque.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDto implements Serializable {

    private static final long serialVersionUID = -3839211160522639828L;
    protected Integer id;
    @NotNull
    protected String nome;
    @NotNull
    @CPF
    protected String cpf;
    @NotNull
    @Email
    protected String email;
    @NotNull
    protected String senha;
    protected Set<Perfil> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDto() {
        super();
    }

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
        this.perfis = cliente.getPerfis().stream().map(x -> Perfil.toEnum(x.getCodigo())).collect(Collectors.toSet());
        this.dataCriacao = cliente.getDataCriacao();
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

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
