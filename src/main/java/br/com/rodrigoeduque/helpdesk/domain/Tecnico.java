package br.com.rodrigoeduque.helpdesk.domain;

import br.com.rodrigoeduque.helpdesk.domain.dtos.TecnicoDto;
import br.com.rodrigoeduque.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa {


    private static final long serialVersionUID = 5245533118693167947L;
    @OneToMany(mappedBy = "tecnico")
    @JsonIgnore
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public Tecnico(TecnicoDto tecnicoDto) {
        this.id = tecnicoDto.getId();
        this.nome = tecnicoDto.getNome();
        this.cpf = tecnicoDto.getCpf();
        this.email = tecnicoDto.getEmail();
        this.senha = tecnicoDto.getSenha();
        this.dataCriacao = tecnicoDto.getDataCriacao();
        addPerfil(Perfil.TECNICO);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
