package br.com.rodrigoeduque.helpdesk.repository;

import br.com.rodrigoeduque.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
