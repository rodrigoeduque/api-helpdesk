package br.com.rodrigoeduque.helpdesk.service;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.domain.enums.Perfil;
import br.com.rodrigoeduque.helpdesk.domain.enums.Prioridade;
import br.com.rodrigoeduque.helpdesk.domain.enums.Status;
import br.com.rodrigoeduque.helpdesk.repository.ChamadoRepository;
import br.com.rodrigoeduque.helpdesk.repository.ClienteRepository;
import br.com.rodrigoeduque.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    @Autowired
    TecnicoRepository tecnicoRepository;

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(1, "Humberto Frossard Dutra", "82134085860", "humberto.dutra@geradornv.com.br", "123");
        tec1.addPerfil(Perfil.TECNICO);

        Cliente cli1 = new Cliente(2, "Luiz Robadey Bon", "63887534506", "luiz.bon@geradornv.com.br", "321");
        cli1.addPerfil(Perfil.CLIENTE);
        Chamado chamado = new Chamado(1, Prioridade.BAIXA, Status.ABERTO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec1, cli1);

        tecnicoRepository.save(tec1);
        clienteRepository.save(cli1);
        chamadoRepository.save(chamado);
    }
}
