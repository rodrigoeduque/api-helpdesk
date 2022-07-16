package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import br.com.rodrigoeduque.helpdesk.exceptions.ObjectNotFoundException;
import br.com.rodrigoeduque.helpdesk.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public Chamado findById(Integer id){
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(()-> new ObjectNotFoundException("Identificador do chamado não encontrado. ID: " + id));
    }

    public List<Chamado> findAll() {
        List<Chamado> chamados = chamadoRepository.findAll();
        return chamados;
    }
}
