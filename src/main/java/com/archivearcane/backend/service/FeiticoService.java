package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import com.archivearcane.backend.repository.FeiticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeiticoService {

    @Autowired
    private FeiticoRepository repository;

    // ===================== CRUD =====================

    public List<Feitico> listarTodos() {
        return repository.findAll();
    }

    public Optional<Feitico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Feitico salvar(Feitico feitico) {
        return repository.save(feitico);
    }

    public Feitico atualizar(Long id, Feitico feiticoAtualizado) {
        return repository.findById(id)
                .map(feitico -> {
                    feitico.setNome(feiticoAtualizado.getNome());
                    feitico.setElemento(feiticoAtualizado.getElemento());
                    feitico.setTipo(feiticoAtualizado.getTipo());
                    feitico.setDescricao(feiticoAtualizado.getDescricao());
                    feitico.setNivelDificuldade(feiticoAtualizado.getNivelDificuldade());

                    return repository.save(feitico);
                })
                .orElseThrow(() -> new RuntimeException("Feitiço não encontrado."));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    public List<Feitico> buscarPorElemento(Elemento elemento) {
        return repository.findByElemento(elemento);
    }

    public List<Feitico> buscarPorTipo(TipoFeitico tipo) {
        return repository.findByTipo(tipo);
    }

    public List<Feitico> buscarPorNivelDificuldade(NivelDificuldade nivelDificuldade) {
        return repository.findByNivelDificuldade(nivelDificuldade);
    }
}