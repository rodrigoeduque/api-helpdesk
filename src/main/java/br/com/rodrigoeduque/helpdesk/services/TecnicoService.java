package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.exceptions.ObjectNotFoundException;
import br.com.rodrigoeduque.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> tecnico = repository.findById(id);

        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Identificador para Técnico não encontrado : " + id));
    }
}
