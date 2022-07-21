package br.com.rodrigoeduque.helpdesk.controller;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import br.com.rodrigoeduque.helpdesk.domain.dtos.ChamadoDto;
import br.com.rodrigoeduque.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoController {

    @Autowired
    ChamadoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoDto> findById(@PathVariable Integer id) {
        Chamado chamado = service.findById(id);
        ChamadoDto chamadoDto = new ChamadoDto(chamado);
        return ResponseEntity.ok().body(chamadoDto);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoDto>> findAll() {
        List<Chamado> chamados = service.findAll();
        List<ChamadoDto> chamadosDto = chamados.stream().map(chamado -> new ChamadoDto(chamado)).collect(Collectors.toList());
        return ResponseEntity.ok().body(chamadosDto);
    }

    @PostMapping
    public ResponseEntity<ChamadoDto> create(@Valid @RequestBody ChamadoDto chamadoDto){
        Chamado obj = service.create(chamadoDto);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(chamadoDto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
