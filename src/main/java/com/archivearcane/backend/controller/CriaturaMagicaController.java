package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.service.CriaturaMagicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelo gerenciamento das criaturas mágicas.
 * Disponibiliza os endpoints para operações de cadastro,
 * consulta, atualização, exclusão e consultas específicas.
 */
@RestController
@RequestMapping("/criaturas")
@CrossOrigin(origins = "*")
public class CriaturaMagicaController {

    @Autowired
    private CriaturaMagicaService service;

    // ===================== CRUD =====================

    /**
     * Lista todas as criaturas mágicas cadastradas.
     *
     * @return lista de criaturas mágicas.
     */
    @GetMapping
    public List<CriaturaMagica> listarTodas() {
        return service.listarTodas();
    }

    /**
     * Busca uma criatura mágica pelo seu identificador.
     *
     * @param id identificador da criatura.
     * @return criatura mágica encontrada.
     */
    @GetMapping("/{id}")
    public CriaturaMagica buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Cadastra uma nova criatura mágica.
     *
     * @param criatura objeto contendo os dados da criatura.
     * @return criatura cadastrada.
     */
    @PostMapping
    public CriaturaMagica salvar(@RequestBody CriaturaMagica criatura) {
        return service.salvar(criatura);
    }

    /**
     * Atualiza os dados de uma criatura mágica existente.
     *
     * @param id identificador da criatura.
     * @param criatura novos dados da criatura.
     * @return criatura atualizada.
     */
    @PutMapping("/{id}")
    public CriaturaMagica atualizar(@PathVariable Long id,
                                    @RequestBody CriaturaMagica criatura) {
        return service.atualizar(id, criatura);
    }

    /**
     * Remove uma criatura mágica cadastrada.
     *
     * @param id identificador da criatura.
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    /**
     * Busca criaturas mágicas pela categoria.
     *
     * @param categoria categoria da criatura.
     * @return lista de criaturas encontradas.
     */
    @GetMapping("/categoria/{categoria}")
    public List<CriaturaMagica> buscarPorCategoria(@PathVariable String categoria) {
        return service.buscarPorCategoria(categoria);
    }

    /**
     * Busca criaturas mágicas pelo nível de periculosidade.
     *
     * @param periculosidade nível de periculosidade.
     * @return lista de criaturas encontradas.
     */
    @GetMapping("/periculosidade/{periculosidade}")
    public List<CriaturaMagica> buscarPorPericulosidade(@PathVariable String periculosidade) {
        return service.buscarPorPericulosidade(periculosidade);
    }

    /**
     * Busca criaturas mágicas pelo habitat.
     *
     * @param habitat habitat da criatura.
     * @return lista de criaturas encontradas.
     */
    @GetMapping("/habitat/{habitat}")
    public List<CriaturaMagica> buscarPorHabitat(@PathVariable String habitat) {
        return service.buscarPorHabitat(habitat);
    }

    /**
     * Busca criaturas mágicas pertencentes a uma casa.
     *
     * @param idCasa identificador da casa.
     * @return lista de criaturas da casa.
     */
    @GetMapping("/casa/{idCasa}")
    public List<CriaturaMagica> buscarPorCasa(@PathVariable Long idCasa) {
        return service.buscarPorCasa(idCasa);
    }

}