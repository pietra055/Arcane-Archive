package com.archivearcane.backend.service;

import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.repository.CriaturaMagicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriaturaMagicaService {

    @Autowired
    private CriaturaMagicaRepository repository;

    public List<CriaturaMagica> listarTodos() {
        return repository.findAll();
    }

    public CriaturaMagica buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Criatura Mágica não encontrada."));
    }

    public CriaturaMagica salvar(CriaturaMagica criaturaMagica) {
        return repository.save(criaturaMagica);
    }

    public CriaturaMagica atualizar(Long id, CriaturaMagica novaCriatura) {

        CriaturaMagica criatura = buscarPorId(id);

        criatura.setNome(novaCriatura.getNome());
        criatura.setCategoria(novaCriatura.getCategoria());
        criatura.setPericulosidade(novaCriatura.getPericulosidade());
        criatura.setHabitat(novaCriatura.getHabitat());

        return repository.save(criatura);
    }

    public void excluir(Long id) {

        CriaturaMagica criatura = buscarPorId(id);

        repository.delete(criatura);
    }
}