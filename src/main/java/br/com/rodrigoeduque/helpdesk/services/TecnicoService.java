package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Pessoa;
import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.domain.dtos.TecnicoDto;
import br.com.rodrigoeduque.helpdesk.exceptions.DataIntegrityValidationException;
import br.com.rodrigoeduque.helpdesk.exceptions.ObjectNotFoundException;
import br.com.rodrigoeduque.helpdesk.repository.PessoaRepository;
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

    @Autowired
    private PessoaRepository pessoaRepository;

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
        validarPorCpfEmail(tecnicoDto);
        Tecnico save = repository.save(tecnico);
        return save;
    }

    private void validarPorCpfEmail(TecnicoDto tecnicoDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tecnicoDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != tecnicoDto.getId()) {
            throw new DataIntegrityValidationException("CPF Já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(tecnicoDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != tecnicoDto.getId()) {
            throw new DataIntegrityValidationException("E-mail Já cadastrado no sistema");
        }
    }

    public Tecnico update(Integer id, TecnicoDto objDto) {
        objDto.setId(id);
        Tecnico tecnico = findById(id);
        validarPorCpfEmail(objDto);
        tecnico = new Tecnico(objDto);
        repository.save(tecnico);
        return tecnico;
    }

    public void delete(Integer id) {
        Tecnico obj = findById(id);
        if (obj.getChamados().size() > 0) {
            throw new DataIntegrityValidationException("Tecnico possui chamados vinculados, não poderá ser excluido");
        }
        repository.deleteById(id);
    }
}
