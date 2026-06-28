package com.archivearcane.backend.service;

import com.archivearcane.backend.model.*;
import com.archivearcane.backend.repository.*;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private CasaRepository casaRepository;

    @Autowired
    private BruxoRepository bruxoRepository;

    @Autowired
    private FeiticoRepository feiticoRepository;

    @Autowired
    private CriaturaMagicaRepository criaturaRepository;

    @Autowired
    private CombinacaoRepository combinacaoRepository;

    public byte[] gerarRelatorioGeral() {

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();

            Document document = new Document(PageSize.A4);

            PdfWriter.getInstance(document, out);

            document.open();

            Font titulo =
                new Font(Font.HELVETICA, 22, Font.BOLD, new Color(40,40,120));

            Paragraph pTitulo =
                new Paragraph("ARCHIVE ARCANE", titulo);

            pTitulo.setAlignment(Element.ALIGN_CENTER);

            document.add(pTitulo);

            Font subtitulo =
                new Font(Font.HELVETICA,16,Font.BOLD);

            Paragraph sub =
                new Paragraph("Relatório Geral da Academia",subtitulo);

            sub.setAlignment(Element.ALIGN_CENTER);

            document.add(sub);

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Data de emissão: "
                            + LocalDate.now()));

            document.add(new Paragraph(" "));

                        document.add(new Paragraph(
                    "===== ESTATÍSTICAS ====="));

            document.add(new Paragraph(
                    "Casas: "
                            + casaRepository.count()));

            document.add(new Paragraph(
                    "Bruxos: "
                            + bruxoRepository.count()));

            document.add(new Paragraph(
                    "Feitiços: "
                            + feiticoRepository.count()));

            document.add(new Paragraph(
                    "Criaturas: "
                            + criaturaRepository.count()));

            document.add(new Paragraph(
                    "Combinações: "
                            + combinacaoRepository.count()));

            document.add(new Paragraph(" "));

                        document.add(
                    new Paragraph("===== RANKING DAS CASAS ====="));

            PdfPTable tabela = new PdfPTable(2);

            tabela.setWidthPercentage(80);

            PdfPCell c1 =
                    new PdfPCell(new Phrase("Casa"));

            PdfPCell c2 =
                    new PdfPCell(new Phrase("Pontuação"));

            tabela.addCell(c1);
            tabela.addCell(c2);

            List<Casa> ranking =
                    casaRepository.findAllByOrderByPontuacaoDesc();

            for(Casa casa : ranking){

                tabela.addCell(casa.getNome());

                tabela.addCell(
                        String.valueOf(casa.getPontuacao()));
            }

            document.add(tabela);

            document.add(new Paragraph(" "));

                        document.add(new Paragraph(" "));
            document.add(new Paragraph("===== CASAS ====="));

            for (Casa casa : casaRepository.findAll()) {

                Font casaFont = new Font(Font.HELVETICA, 16, Font.BOLD, new Color(30, 60, 150));

                Paragraph nomeCasa = new Paragraph(casa.getNome(), casaFont);
                document.add(nomeCasa);

                document.add(new Paragraph("Fundador: " + casa.getFundador()));
                document.add(new Paragraph("Símbolo: " + casa.getSimbolo()));
                document.add(new Paragraph("Pontuação: " + casa.getPontuacao()));

                document.add(new Paragraph(" "));

                document.add(new Paragraph("Bruxos:"));

                if (casa.getBruxos().isEmpty()) {
                    document.add(new Paragraph("   Nenhum bruxo cadastrado."));
                } else {

                    for (Bruxo bruxo : casa.getBruxos()) {

                        document.add(new Paragraph(
                                "   • "
                                        + bruxo.getNome()
                                        + " - "
                                        + bruxo.getNivelAprendizadoMagia()));

                    }

                }

                document.add(new Paragraph(" "));

                document.add(new Paragraph("Criaturas Mágicas:"));

                if (casa.getCriaturasMagicas().isEmpty()) {

                    document.add(new Paragraph("   Nenhuma criatura cadastrada."));

                } else {

                    for (CriaturaMagica criatura : casa.getCriaturasMagicas()) {

                        document.add(new Paragraph(
                                "   • "
                                        + criatura.getNome()
                                        + " ("
                                        + criatura.getCategoria()
                                        + ")"));

                    }

                }

                document.add(new Paragraph(" "));
                document.add(new Paragraph("------------------------------------------------"));
                document.add(new Paragraph(" "));

            }

                        document.add(new Paragraph(" "));
            document.add(new Paragraph("===== FEITIÇOS ====="));

            for (Elemento elemento : Elemento.values()) {

                List<Feitico> lista =
                        feiticoRepository.findByElemento(elemento);

                if (!lista.isEmpty()) {

                    Font elementoFont =
                            new Font(Font.HELVETICA, 14, Font.BOLD);

                    document.add(
                            new Paragraph(elemento.name(), elementoFont));

                    for (Feitico feitico : lista) {

                        document.add(new Paragraph(
                                "   • "
                                        + feitico.getNome()
                                        + " ("
                                        + feitico.getTipo()
                                        + ")"));

                    }

                    document.add(new Paragraph(" "));
                }

            }

                        document.add(new Paragraph(" "));
            document.add(new Paragraph("===== COMBINAÇÕES ====="));

            for (Combinacao combinacao : combinacaoRepository.findAll()) {

                document.add(new Paragraph(

                        combinacao.getElemento1()

                                + " + "

                                + combinacao.getElemento2()

                                + "  →  "

                                + combinacao.getResultado()

                ));

            }

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Relatório gerado automaticamente pelo sistema Archive Arcane."));

                        document.close();

            return out.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException("Erro ao gerar relatório.", e);

        }

    }

}