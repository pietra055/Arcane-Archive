package com.archivearcane.backend.controller;

import com.archivearcane.backend.model.Elemento;
import com.archivearcane.backend.model.Feitico;
import com.archivearcane.backend.model.NivelDificuldade;
import com.archivearcane.backend.model.TipoFeitico;
import com.archivearcane.backend.service.FeiticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feiticos")
@CrossOrigin(origins = "*")
public class FeiticoController {

    @Autowired
    private FeiticoService service;

    // ===================== CRUD =====================

    @GetMapping
    public List<Feitico> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Feitico buscarPorId(@PathVariable Long id) {
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

    // ===================== CONSULTAS =====================

    @GetMapping("/elemento/{elemento}")
    public List<Feitico> buscarPorElemento(@PathVariable Elemento elemento) {
        return service.buscarPorElemento(elemento);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Feitico> buscarPorTipo(@PathVariable TipoFeitico tipo) {
        return service.buscarPorTipo(tipo);
    }

    @GetMapping("/dificuldade/{nivel}")
    public List<Feitico> buscarPorNivelDificuldade(@PathVariable NivelDificuldade nivel) {
        return service.buscarPorNivelDificuldade(nivel);
    }

}