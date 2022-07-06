package br.com.rodrigoeduque.helpdesk.repository;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
