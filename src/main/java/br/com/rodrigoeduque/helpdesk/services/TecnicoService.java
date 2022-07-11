package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.domain.dtos.TecnicoDto;
import br.com.rodrigoeduque.helpdesk.exceptions.ObjectNotFoundException;
import br.com.rodrigoeduque.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> tecnico = repository.findById(id);

        return tecnico.orElseThrow(() -> new ObjectNotFoundException("Identificador para Técnico não encontrado : " + id));
    }

    public List<TecnicoDto> findAll() {
        List<Tecnico> lista = repository.findAll();
        List<TecnicoDto> listaDto = lista.stream().map(obj -> new TecnicoDto(obj)).collect(Collectors.toList());
        return listaDto;
    }

    public Tecnico create(TecnicoDto tecnicoDto) {
        tecnicoDto.setId(null);
        Tecnico tecnico = new Tecnico(tecnicoDto);
        Tecnico save = repository.save(tecnico);
        return save;
    }
}
