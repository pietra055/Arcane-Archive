package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.service.CriaturaMagicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criaturas")
@CrossOrigin(origins = "*")
public class CriaturaMagicaController {

    @Autowired
    private CriaturaMagicaService service;

    // ===================== CRUD =====================

    @GetMapping
    public List<CriaturaMagica> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public CriaturaMagica buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Criatura não encontrada."));
    }

    @PostMapping
    public CriaturaMagica salvar(@RequestBody CriaturaMagica criatura) {
        return service.salvar(criatura);
    }

    @PutMapping("/{id}")
    public CriaturaMagica atualizar(@PathVariable Long id,
                                    @RequestBody CriaturaMagica criatura) {
        return service.atualizar(id, criatura);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ===================== CONSULTAS =====================

    @GetMapping("/categoria/{categoria}")
    public List<CriaturaMagica> buscarPorCategoria(@PathVariable String categoria) {
        return service.buscarPorCategoria(categoria);
    }

    @GetMapping("/periculosidade/{periculosidade}")
    public List<CriaturaMagica> buscarPorPericulosidade(@PathVariable String periculosidade) {
        return service.buscarPorPericulosidade(periculosidade);
    }

    @GetMapping("/habitat/{habitat}")
    public List<CriaturaMagica> buscarPorHabitat(@PathVariable String habitat) {
        return service.buscarPorHabitat(habitat);
    }

    @GetMapping("/casa/{idCasa}")
    public List<CriaturaMagica> buscarPorCasa(@PathVariable Long idCasa) {
        return service.buscarPorCasa(idCasa);
    }
}