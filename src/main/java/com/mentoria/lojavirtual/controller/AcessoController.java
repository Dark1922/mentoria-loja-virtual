package com.mentoria.lojavirtual.controller;

import com.mentoria.lojavirtual.model.Acesso;
import com.mentoria.lojavirtual.service.AcessoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/acesso")
public class AcessoController {

    private final AcessoService acessoService;

    public AcessoController(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Acesso> salvarAcesso(@Valid @RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.save(acesso);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(acessoSalvo.getId())
                .toUri();

        return ResponseEntity.created(location).body(acessoSalvo);
    }
}