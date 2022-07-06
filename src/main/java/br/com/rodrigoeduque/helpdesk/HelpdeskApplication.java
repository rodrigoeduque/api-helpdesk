package br.com.rodrigoeduque.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class HelpdeskApplication {


    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }
}
