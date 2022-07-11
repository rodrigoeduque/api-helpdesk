package br.com.rodrigoeduque.helpdesk.services;

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

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    TecnicoRepository tecnicoRepository;

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Humberto Frossard Dutra", "82134085860", "humberto.dutra@geradornv.com.br", "123");
        tec1.addPerfil(Perfil.TECNICO);
        Tecnico tec2 = new Tecnico(null, "Nelmo Cavalcanti Aguiar", "52271587549", "nelmo.aguiar@gmail.com.br", "111");
        tec2.addPerfil(Perfil.TECNICO);
        Tecnico tec3 = new Tecnico(null, "Erika Tavares Fonseca", "50548373450", "erika.fonseca@geradornv.com.br", "222");
        tec3.addPerfil(Perfil.TECNICO);

        Cliente cli1 = new Cliente(null, "Thalia Quintanilha Xavier", "13844663207", "thalia.xavier@geradornv.com.br", "321");
        cli1.addPerfil(Perfil.CLIENTE);
        Cliente cli2 = new Cliente(null, "Luiz Robadey Bon", "63887534506", "luiz.bon@geradornv.com.br", "3231");
        cli2.addPerfil(Perfil.CLIENTE);
        Cliente cli3 = new Cliente(null, "Marco Leandro Baptista", "14402211387", "marco.baptista@geradornv.com.br", "33321");
        cli3.addPerfil(Perfil.CLIENTE);
        Cliente cli4 = new Cliente(null, "Lucimberto Teodoro Quindeler", "22948042283", "lucimberto.quindeler@bol.com.br", "=ngHJ0K92np");
        cli4.addPerfil(Perfil.CLIENTE);

        Chamado chamado = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec1, cli1);
        Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec2, cli2);
        Chamado chamado2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec3, cli3);
        Chamado chamado3 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec2, cli3);
        Chamado chamado4 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Orçamento", "Orçamento plano familiar para 4 pessoas: Sendo 2 adultos acima de 40 anos e duas crianças", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));
        chamadoRepository.saveAll(Arrays.asList(chamado, chamado1, chamado2, chamado3, chamado4));
    }
}
