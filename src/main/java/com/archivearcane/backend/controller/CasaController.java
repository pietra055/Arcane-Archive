package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Casa;
import com.archivearcane.backend.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casas")
@CrossOrigin(origins = "*")
public class CasaController {

    @Autowired
    private CasaService service;

    @GetMapping
    public List<Casa> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Casa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Casa salvar(@RequestBody Casa casa) {
        return service.salvar(casa);
    }

    @PutMapping("/{id}")
    public Casa atualizar(@PathVariable Long id, @RequestBody Casa casa) {
        return service.atualizar(id, casa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}