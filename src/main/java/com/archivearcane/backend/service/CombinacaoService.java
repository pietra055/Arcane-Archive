package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Combinacao;
import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.repository.CombinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinacaoService {

    @Autowired
    private CombinacaoRepository repository;

    // ===================== CRUD =====================

    public List<Combinacao> listarTodas() {
        return repository.findAll();
    }

    public Combinacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Combinação"));
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

                return repository.save(combinacao);

            })
            .orElseThrow(() ->
                    new RuntimeException("Combinação"));
}

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    public List<Combinacao> buscarPorResultado(Elemento resultado) {
        return repository.findByResultado(resultado);
    }

    public List<Combinacao> buscarPorElemento1(Elemento elemento1) {
        return repository.findByElemento1(elemento1);
    }

    public List<Combinacao> buscarPorElemento2(Elemento elemento2) {
        return repository.findByElemento2(elemento2);
    }

    public Combinacao buscarPorElementos(Elemento elemento1, Elemento elemento2) {

        return repository.findByElemento1AndElemento2(elemento1, elemento2)
                .orElseThrow(() ->
                        new RuntimeException("Combinação"));
    }

}