package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Bruxo;
import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.repository.BruxoRepository;
import com.archivearcane.backend.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BruxoService {

    @Autowired
    private BruxoRepository repository;

    @Autowired
    private CasaRepository casaRepository;

    // ===================== CRUD =====================

    public List<Bruxo> listarTodos() {
        return repository.findAll();
    }

    public Bruxo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bruxo"));
    }

    public Bruxo salvar(Bruxo bruxo) {

        if (bruxo.getCasa() != null) {

            Casa casa = casaRepository.findById(bruxo.getCasa().getId())
                    .orElseThrow(() ->
                            new RuntimeException("Casa"));

            // Ao cadastrar um bruxo, a casa recebe +10 pontos.
            casa.setPontuacao(casa.getPontuacao() + 10);

            casaRepository.save(casa);

            bruxo.setCasa(casa);
        }

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
                    bruxo.setFeiticos(bruxoAtualizado.getFeiticos());

                    return repository.save(bruxo);

                })
                .orElseThrow(() ->
                        new RuntimeException("Bruxo"));
    }

    public void deletar(Long id) {

    Bruxo bruxo = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Bruxo"));

    if (bruxo.getCasa() != null) {

        Casa casa = bruxo.getCasa();

        casa.setPontuacao(casa.getPontuacao() - 10);

        casaRepository.save(casa);
    }

    repository.delete(bruxo);
}

    // ===================== CONSULTAS =====================

    public List<Bruxo> buscarPorCasa(Long casaId) {
        return repository.findByCasaId(casaId);
    }

    public List<Bruxo> buscarPorAnoEscolar(Integer anoEscolar) {
        return repository.findByAnoEscolar(anoEscolar);
    }

    public List<Bruxo> buscarPorNivelAprendizado(String nivel) {
        return repository.findByNivelAprendizadoMagia(nivel);
    }

}