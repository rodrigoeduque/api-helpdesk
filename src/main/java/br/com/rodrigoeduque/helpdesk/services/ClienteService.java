package br.com.rodrigoeduque.helpdesk.services;

import br.com.rodrigoeduque.helpdesk.domain.Pessoa;
import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import br.com.rodrigoeduque.helpdesk.domain.dtos.ClienteDto;
import br.com.rodrigoeduque.helpdesk.exceptions.DataIntegrityValidationException;
import br.com.rodrigoeduque.helpdesk.exceptions.ObjectNotFoundException;
import br.com.rodrigoeduque.helpdesk.repository.PessoaRepository;
import br.com.rodrigoeduque.helpdesk.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);

        return cliente.orElseThrow(() -> new ObjectNotFoundException("Identificador para Cliente não encontrado : " + id));
    }

    public List<ClienteDto> findAll() {
        List<Cliente> lista = repository.findAll();
        List<ClienteDto> listaDto = lista.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
        return listaDto;
    }

    public Cliente create(ClienteDto clienteDto) {
        clienteDto.setId(null);
        Cliente cliente = new Cliente(clienteDto);
        validarPorCpfEmail(clienteDto);
        Cliente save = repository.save(cliente);
        return save;
    }

    private void validarPorCpfEmail(ClienteDto clienteDto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(clienteDto.getCpf());
        if (obj.isPresent() && obj.get().getId() != clienteDto.getId()) {
            throw new DataIntegrityValidationException("CPF Já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(clienteDto.getEmail());
        if (obj.isPresent() && obj.get().getId() != clienteDto.getId()) {
            throw new DataIntegrityValidationException("E-mail Já cadastrado no sistema");
        }
    }

    public Cliente update(Integer id, ClienteDto objDto) {
        objDto.setId(id);
        Cliente cliente = findById(id);
        validarPorCpfEmail(objDto);
        cliente = new Cliente(objDto);
        repository.save(cliente);
        return cliente;
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getChamados().size() > 0) {
            throw new DataIntegrityValidationException("Cliente possui chamados vinculados, não poderá ser excluido");
        }
        repository.deleteById(id);
    }
}
