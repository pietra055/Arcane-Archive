package com.archivearcane.backend.controller;

import com.archivearcane.backend.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin(origins = "*")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/geral")
    public ResponseEntity<byte[]> gerarRelatorio() {

        byte[] pdf = relatorioService.gerarRelatorioGeral();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=relatorio-archive-arcane.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}