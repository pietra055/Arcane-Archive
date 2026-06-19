package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.CriaturaMagica;
import com.archivearcane.backend.service.CriaturaMagicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criaturas")
public class CriaturaMagicaController {

    @Autowired
    private CriaturaMagicaService service;

    @GetMapping
    public List<CriaturaMagica> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public CriaturaMagica buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CriaturaMagica salvar(@RequestBody CriaturaMagica criaturaMagica) {
        return service.salvar(criaturaMagica);
    }

    @PutMapping("/{id}")
    public CriaturaMagica atualizar(@PathVariable Long id,
                                    @RequestBody CriaturaMagica criaturaMagica) {
        return service.atualizar(id, criaturaMagica);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}