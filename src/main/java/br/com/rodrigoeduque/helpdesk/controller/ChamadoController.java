package br.com.rodrigoeduque.helpdesk.controller;

import br.com.rodrigoeduque.helpdesk.domain.Chamado;
import br.com.rodrigoeduque.helpdesk.domain.dtos.ChamadoDto;
import br.com.rodrigoeduque.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
