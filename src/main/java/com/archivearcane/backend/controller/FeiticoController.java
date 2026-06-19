package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.service.FeiticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feiticos")
@CrossOrigin(origins = "*")
public class FeiticoController {

    @Autowired
    private FeiticoService service;

    @GetMapping
    public List<Feitico> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Feitico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Feitico salvar(@RequestBody Feitico feitico) {
        return service.salvar(feitico);
    }

    @PutMapping("/{id}")
    public Feitico atualizar(@PathVariable Long id,
                             @RequestBody Feitico feitico) {
        return service.atualizar(id, feitico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}