/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author Gleywson
 */
public class Conversor {

    private PaginaPDF pagina;
    private List<RetanguloPDF> campos;
    private PDDocument documento;

    public Conversor() {
    }

    public Conversor(PaginaPDF pagina, List<RetanguloPDF> campos, PDDocument documento) {
        this.pagina = pagina;
        this.campos = campos;
        this.documento = documento;
    }

    public List<String> getCamposTexto() throws IOException {
        PDPage page = documento.getPage(0);
        PDRectangle mediaBox = page.getMediaBox();

        List<String> camposTexto = new ArrayList<>();

        for (RetanguloPDF campo : campos) {
            Double x = mediaBox.getWidth() * campo.getX() / pagina.getLargura();
            Double y = mediaBox.getHeight() * campo.getY() / pagina.getAltura();
            Double largura = mediaBox.getWidth() * campo.getLargura() / pagina.getLargura();
            Double altura = mediaBox.getHeight() * campo.getAltura() / pagina.getAltura();

            PDFTextStripperByArea area = new PDFTextStripperByArea();

            area.addRegion(campo.getNome(), new Rectangle2D.Double(x, y, largura, altura));
            area.extractRegions(page);
            camposTexto.add(area.getTextForRegion(campo.getNome()).trim());
        }

        return camposTexto;
    }

 

}
