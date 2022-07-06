package br.com.rodrigoeduque.helpdesk.repository;

import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
