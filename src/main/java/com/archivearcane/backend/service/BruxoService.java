package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Bruxo;
import com.archivearcane.backend.repository.BruxoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BruxoService {

    @Autowired
    private BruxoRepository repository;

    public List<Bruxo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Bruxo> buscarPorId(Long id) {
        return repository.findById(id);
    }
 
    public Bruxo salvar(Bruxo bruxo) {
        return repository.save(bruxo);
    }

    public Bruxo atualizar(Long id, Bruxo bruxoAtualizado) {
        return repository.findById(id)
                .map(bruxo -> {
                    bruxo.setNome(bruxoAtualizado.getNome());
                    bruxo.setIdade(bruxoAtualizado.getIdade());
                    bruxo.setAnoEscolar(bruxoAtualizado.getAnoEscolar());
                    bruxo.setNivelAprendizadoMagia(bruxoAtualizado.getNivelAprendizadoMagia());
                    bruxo.setCasa(bruxoAtualizado.getCasa());

                    // NOVO
                    bruxo.setFeiticos(bruxoAtualizado.getFeiticos());

                    return repository.save(bruxo);
                })
                .orElseThrow(() -> new RuntimeException("Bruxo não encontrado."));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}