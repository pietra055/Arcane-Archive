package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo gerenciamento das casas mágicas.
 * Disponibiliza os endpoints para operações de cadastro,
 * consulta, atualização, exclusão e consultas específicas.
 */
@RestController
@RequestMapping("/casas")
@CrossOrigin(origins = "*")
public class CasaController {

    @Autowired
    private CasaService service;

    /**
     * Lista todas as casas cadastradas.
     *
     * @return lista de casas.
     */
    @GetMapping
    public List<Casa> listarTodas() {
        return service.listarTodas();
    }

    /**
     * Retorna o ranking das casas ordenado pela pontuação.
     *
     * @return lista de casas em ordem decrescente de pontuação.
     */
    @GetMapping("/ranking-casas")
    public List<Casa> rankingCasas() {
        return service.rankingCasas();
    }

    /**
     * Busca casas pelo nome do fundador.
     *
     * @param fundador nome do fundador.
     * @return lista de casas encontradas.
     */
    @GetMapping("/fundador/{fundador}")
    public List<Casa> buscarPorFundador(@PathVariable String fundador) {
        return service.buscarPorFundador(fundador);
    }

    /**
     * Busca uma casa pelo seu identificador.
     *
     * @param id identificador da casa.
     * @return casa encontrada.
     */
    @GetMapping("/{id}")
    public Casa buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Cadastra uma nova casa.
     *
     * @param casa objeto contendo os dados da casa.
     * @return casa cadastrada.
     */
    @PostMapping
    public Casa salvar(@RequestBody Casa casa) {
        return service.salvar(casa);
    }

    /**
     * Atualiza os dados de uma casa existente.
     *
     * @param id identificador da casa.
     * @param casa novos dados da casa.
     * @return casa atualizada.
     */
    @PutMapping("/{id}")
    public Casa atualizar(@PathVariable Long id,
                          @RequestBody Casa casa) {
        return service.atualizar(id, casa);
    }

    /**
     * Remove uma casa cadastrada.
     *
     * @param id identificador da casa.
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

}