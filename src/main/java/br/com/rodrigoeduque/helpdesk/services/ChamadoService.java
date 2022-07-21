package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.domain.dtos.ChamadoDto;
import br.com.rodrigoeduque.helpdesk.domain.enums.Prioridade;
import br.com.rodrigoeduque.helpdesk.domain.enums.Status;
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

    @Autowired
    private TecnicoService tecnicoService;

    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> chamado = chamadoRepository.findById(id);
        return chamado.orElseThrow(() -> new ObjectNotFoundException("Identificador do chamado não encontrado. ID: " + id));
    }

    public List<Chamado> findAll() {
        List<Chamado> chamados = chamadoRepository.findAll();
        return chamados;
    }

    public Chamado create(ChamadoDto chamadoDto) {

        Chamado chamado = chamadoRepository.save(newChamado(chamadoDto));

        return chamado;

    }

    private Chamado newChamado(ChamadoDto dto) {
        Tecnico tecnico = tecnicoService.findById(dto.getIdTecnico());
        Cliente cliente = clienteService.findById(dto.getIdCliente());

        Chamado chamado = new Chamado();

        if (dto.getId() != null) {
            chamado.setId(dto.getId());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(dto.getPrioridade()));
        chamado.setStatus(Status.toEnum(dto.getStatus()));
        chamado.setTitulo(dto.getTitulo());
        chamado.setObservacoes(dto.getObservacoes());

        return chamado;
    }
}
