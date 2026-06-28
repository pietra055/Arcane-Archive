package com.archivearcane.backend.controller;

import com.archivearcane.backend.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável pela geração dos relatórios do sistema.
 * Disponibiliza os endpoints para exportação dos dados da aplicação
 * em formato PDF.
 */
@RestController
@RequestMapping("/relatorios")
@CrossOrigin(origins = "*")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    /**
     * Gera um relatório geral da aplicação em formato PDF.
     *
     * @return arquivo PDF contendo as informações do sistema.
     */
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