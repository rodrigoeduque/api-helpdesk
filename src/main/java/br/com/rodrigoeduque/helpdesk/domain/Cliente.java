package br.com.rodrigoeduque.helpdesk.domain;

import br.com.rodrigoeduque.helpdesk.domain.dtos.ClienteDto;
import br.com.rodrigoeduque.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa {


    private static final long serialVersionUID = -2881530272039719609L;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public Cliente(ClienteDto clienteDto) {
        this.id = clienteDto.getId();
        this.nome = clienteDto.getNome();
        this.cpf = clienteDto.getCpf();
        this.email = clienteDto.getEmail();
        this.senha = clienteDto.getSenha();
        this.dataCriacao = clienteDto.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
