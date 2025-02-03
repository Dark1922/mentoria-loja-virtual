package com.mentoria.lojavirtual.service;

import com.mentoria.lojavirtual.model.Acesso;
import com.mentoria.lojavirtual.repository.AcessoRepository;
import org.springframework.stereotype.Service;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;

    // Injeção de dependência via construtor
    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    public Acesso save(Acesso acesso) {
        return acessoRepository.save(acesso);
    }
}
