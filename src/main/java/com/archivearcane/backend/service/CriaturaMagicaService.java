package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.repository.CasaRepository;
import com.archivearcane.backend.repository.CriaturaMagicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriaturaMagicaService {

    @Autowired
    private CriaturaMagicaRepository repository;

    @Autowired
    private CasaRepository casaRepository;

    // ================= CRUD =================

    public List<CriaturaMagica> listarTodas() {
        return repository.findAll();
    }

    public Optional<CriaturaMagica> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CriaturaMagica salvar(CriaturaMagica criatura) {
        return repository.save(criatura);
    }

    public CriaturaMagica atualizar(Long id, CriaturaMagica criaturaAtualizada) {

        return repository.findById(id)
                .map(criatura -> {

                    criatura.setNome(criaturaAtualizada.getNome());
                    criatura.setCategoria(criaturaAtualizada.getCategoria());
                    criatura.setPericulosidade(criaturaAtualizada.getPericulosidade());
                    criatura.setHabitat(criaturaAtualizada.getHabitat());
                    criatura.setCasa(criaturaAtualizada.getCasa());

                    return repository.save(criatura);

                }).orElseThrow(() -> new RuntimeException("Criatura não encontrada."));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ================= CONSULTAS =================

    public List<CriaturaMagica> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public List<CriaturaMagica> buscarPorPericulosidade(String periculosidade) {
        return repository.findByPericulosidade(periculosidade);
    }

    public List<CriaturaMagica> buscarPorHabitat(String habitat) {
        return repository.findByHabitat(habitat);
    }

    public List<CriaturaMagica> buscarPorCasa(Long idCasa) {

        Casa casa = casaRepository.findById(idCasa)
                .orElseThrow(() -> new RuntimeException("Casa não encontrada."));

        return repository.findByCasa(casa);
    }

}