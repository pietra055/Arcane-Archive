package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Bruxo;
import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.repository.BruxoRepository;
import com.archivearcane.backend.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio relacionadas aos bruxos.
 * Realiza operações de cadastro, consulta, atualização, exclusão
 * e consultas específicas, além de controlar a pontuação das casas.
 */
@Service
public class BruxoService {

    @Autowired
    private BruxoRepository repository;

    @Autowired
    private CasaRepository casaRepository;

    // ===================== CRUD =====================

    /**
     * Lista todos os bruxos cadastrados.
     *
     * @return lista de bruxos.
     */
    public List<Bruxo> listarTodos() {
        return repository.findAll();
    }

    /**
     * Busca um bruxo pelo seu identificador.
     *
     * @param id identificador do bruxo.
     * @return bruxo encontrado.
     */
    public Bruxo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bruxo"));
    }

    /**
     * Cadastra um novo bruxo.
     * Caso o bruxo pertença a uma casa, a pontuação da casa é incrementada em 10 pontos.
     *
     * @param bruxo objeto contendo os dados do bruxo.
     * @return bruxo cadastrado.
     */
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

    /**
     * Atualiza os dados de um bruxo existente.
     *
     * @param id identificador do bruxo.
     * @param bruxoAtualizado novos dados do bruxo.
     * @return bruxo atualizado.
     */
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

    /**
     * Remove um bruxo do sistema.
     * Caso o bruxo pertença a uma casa, sua pontuação é reduzida em 10 pontos.
     *
     * @param id identificador do bruxo.
     */
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

    /**
     * Busca os bruxos pertencentes a uma casa.
     *
     * @param casaId identificador da casa.
     * @return lista de bruxos encontrados.
     */
    public List<Bruxo> buscarPorCasa(Long casaId) {
        return repository.findByCasaId(casaId);
    }

    /**
     * Busca bruxos pelo ano escolar.
     *
     * @param anoEscolar ano escolar do bruxo.
     * @return lista de bruxos encontrados.
     */
    public List<Bruxo> buscarPorAnoEscolar(Integer anoEscolar) {
        return repository.findByAnoEscolar(anoEscolar);
    }

    /**
     * Busca bruxos pelo nível de aprendizado em magia.
     *
     * @param nivel nível de aprendizado.
     * @return lista de bruxos encontrados.
     */
    public List<Bruxo> buscarPorNivelAprendizado(String nivel) {
        return repository.findByNivelAprendizadoMagia(nivel);
    }

}