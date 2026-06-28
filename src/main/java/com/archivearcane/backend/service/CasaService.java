package com.archivearcane.backend.service;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsável pelas regras de negócio relacionadas às casas mágicas.
 * Realiza operações de cadastro, consulta, atualização, exclusão
 * e consultas específicas sobre as casas do sistema.
 */
@Service
public class CasaService {

    @Autowired
    private CasaRepository repository;

    // ===================== CRUD =====================

    /**
     * Lista todas as casas cadastradas.
     *
     * @return lista de casas.
     */
    public List<Casa> listarTodas() {
        return repository.findAll();
    }

    /**
     * Busca uma casa pelo seu identificador.
     *
     * @param id identificador da casa.
     * @return casa encontrada.
     */
    public Casa buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Casa"));

    }

    /**
     * Cadastra uma nova casa.
     *
     * @param casa objeto contendo os dados da casa.
     * @return casa cadastrada.
     */
    public Casa salvar(Casa casa) {
        return repository.save(casa);
    }

    /**
     * Atualiza os dados de uma casa existente.
     *
     * @param id identificador da casa.
     * @param casaAtualizada novos dados da casa.
     * @return casa atualizada.
     */
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

    /**
     * Remove uma casa cadastrada.
     *
     * @param id identificador da casa.
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca casas pelo nome do fundador.
     *
     * @param fundador nome do fundador.
     * @return lista de casas encontradas.
     */
    public List<Casa> buscarPorFundador(String fundador) {
        return repository.findByFundador(fundador);
    }

    /**
     * Retorna o ranking das casas ordenado pela pontuação.
     *
     * @return lista de casas ordenadas por pontuação.
     */
    public List<Casa> rankingCasas() {
        return repository.findAllByOrderByPontuacaoDesc();
    }

}