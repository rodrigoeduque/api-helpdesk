package br.com.rodrigoeduque.helpdesk.controller;

import br.com.rodrigoeduque.helpdesk.domain.Cliente;
import br.com.rodrigoeduque.helpdesk.domain.dtos.ClienteDto;
import br.com.rodrigoeduque.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDto(cliente));
    }

    @GetMapping
    public List<ClienteDto> findAll() {
        List<ClienteDto> clientes = clienteService.findAll();
        return clientes;
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@Valid @RequestBody ClienteDto clienteDto) {
        Cliente cliente = clienteService.create(clienteDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Integer id, @Valid @RequestBody ClienteDto objDto) {
        Cliente cliente = clienteService.update(id, objDto);
        return ResponseEntity.ok(new ClienteDto(cliente));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
