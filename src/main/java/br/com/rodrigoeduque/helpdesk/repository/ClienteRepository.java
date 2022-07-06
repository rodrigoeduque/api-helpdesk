package br.com.rodrigoeduque.helpdesk.repository;

import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
