package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.repository.CombinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombinacaoService {

    @Autowired
    private CombinacaoRepository repository;

    public List<Combinacao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Combinacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Combinacao salvar(Combinacao combinacao) {
        return repository.save(combinacao);
    }

    public Combinacao atualizar(Long id, Combinacao combinacaoAtualizada) {
        return repository.findById(id)
                .map(combinacao -> {
                    combinacao.setElemento1(combinacaoAtualizada.getElemento1());
                    combinacao.setElemento2(combinacaoAtualizada.getElemento2());
                    combinacao.setResultado(combinacaoAtualizada.getResultado());
                    combinacao.setDescricao(combinacaoAtualizada.getDescricao());
                    combinacao.setNivelDificuldade(combinacaoAtualizada.getNivelDificuldade());
                    combinacao.setFeitico(combinacaoAtualizada.getFeitico());

                    return repository.save(combinacao);
                })
                .orElseThrow(() -> new RuntimeException("Combinação não encontrada."));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}