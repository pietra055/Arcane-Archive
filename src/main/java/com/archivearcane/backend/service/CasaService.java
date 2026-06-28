package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    @Autowired
    private CasaRepository repository;

    // ===================== CRUD =====================

    public List<Casa> listarTodas() {
        return repository.findAll();
    }

    public Casa buscarPorId(Long id) {

    return repository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Casa"));

}

    public Casa salvar(Casa casa) {
        return repository.save(casa);
    }

    public Casa atualizar(Long id, Casa casaAtualizada) {
        return repository.findById(id)
                .map(casa -> {
                    casa.setNome(casaAtualizada.getNome());
                    casa.setFundador(casaAtualizada.getFundador());
                    casa.setSimbolo(casaAtualizada.getSimbolo());
                    casa.setPontuacao(casaAtualizada.getPontuacao());

                    return repository.save(casa);
                })
                .orElseThrow(() -> new RuntimeException("Casa"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    public List<Casa> buscarPorFundador(String fundador) {
        return repository.findByFundador(fundador);
    }

    public List<Casa> rankingCasas() {
        return repository.findAllByOrderByPontuacaoDesc();
    }
}