package br.com.rodrigoeduque.helpdesk.controller;

import br.com.rodrigoeduque.helpdesk.domain.Tecnico;
import br.com.rodrigoeduque.helpdesk.domain.dtos.TecnicoDto;
import br.com.rodrigoeduque.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RequestMapping("/tecnicos")
@RestController
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDto> findById(@PathVariable Integer id) {
        Tecnico tecnico = tecnicoService.findById(id);
        return ResponseEntity.ok().body(new TecnicoDto(tecnico));
    }

    @GetMapping
    public List<TecnicoDto> findAll(){
        List<TecnicoDto> tecnicos = tecnicoService.findAll();
        return tecnicos;
    }

    @PostMapping
    public ResponseEntity<TecnicoDto> create(@RequestBody TecnicoDto tecnicoDto){
        Tecnico tecnico = tecnicoService.create(tecnicoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(tecnico.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
