/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private static final Map<String, String> zona = new HashMap<>();

    static {

        zona.put("04.913.711/0020-70", "A");
        zona.put("04.913.711/0011-80", "A");
        zona.put("04.913.711/0021-51", "A");
        zona.put("04.913.711/0024-02", "A");
        zona.put("04.913.711/0026-66", "A");
        zona.put("04.913.711/0025-85", "A");
        zona.put("04.913.711/0015-03", "A");
        zona.put("04.913.711/0014-22", "A");
        zona.put("04.913.711/0044-48", "A");
        zona.put("04.913.711/0047-90", "A");
        zona.put("04.913.711/0001-08", "A");
        zona.put("04.913.711/0049-52", "A");
        zona.put("04.913.711/0053-39", "A");
        zona.put("04.913.711/0045-29", "A");
        zona.put("04.913.711/0027-47", "A");
        zona.put("04.913.711/0083-54", "A");

        zona.put("04.913.711/0056-81", "B");
        zona.put("04.913.711/0030-42", "B");
        zona.put("04.913.711/0032-04", "B");
        zona.put("04.913.711/0007-01", "B");
        zona.put("04.913.711/0002-99", "B");
        zona.put("04.913.711/0041-03", "B");
        zona.put("04.913.711/0046-00", "B");
        zona.put("04.913.711/0042-86", "B");
        zona.put("04.913.711/0005-31", "B");
        zona.put("04.913.711/0031-23", "B");
        zona.put("04.913.711/0003-70", "B");
        zona.put("04.913.711/0016-94", "B");
        zona.put("04.913.711/0108-47", "B");
        zona.put("04.913.711/0048-71", "B");
        zona.put("04.913.711/0098-30", "B");
        zona.put("04.913.711/0103-32", "B");
        zona.put("04.913.711/0106-85", "B");
        zona.put("04.913.711/0074-63", "B");
        zona.put("04.913.711/0109-28", "B");
        zona.put("04.913.711/0073-82", "B");
        zona.put("04.913.711/0075-44", "B");
        zona.put("04.913.711/0076-25", "B");
        zona.put("04.913.711/0078-97", "B");
        zona.put("04.913.711/0062-20", "B");
        zona.put("04.913.711/0061-49", "B");
        zona.put("04.913.711/0077-06", "B");
        zona.put("04.913.711/0059-24", "B");
        zona.put("04.913.711/0060-68", "B");
        zona.put("04.913.711/0022-32", "B");
        zona.put("04.913.711/0051-77", "B");
        zona.put("04.913.711/0035-57", "B");
        zona.put("04.913.711/0028-28", "B");
        zona.put("04.913.711/0054-10", "B");
        zona.put("04.913.711/0063-00", "B");
        zona.put("04.913.711/0065-72", "B");
        zona.put("04.913.711/0071-10", "B");
        zona.put("04.913.711/0070-30", "B");
        zona.put("04.913.711/0081-92", "B");
        zona.put("04.913.711/0067-34", "B");
        zona.put("04.913.711/0055-09", "B");
        zona.put("04.913.711/0029-09", "B");
        zona.put("04.913.711/0064-91", "B");
        zona.put("04.913.711/0085-16", "B");
        zona.put("04.913.711/0088-69", "B");
        zona.put("04.913.711/0072-00", "B");
        zona.put("04.913.711/0068-15", "B");
        zona.put("04.913.711/0080-01", "B");
        zona.put("04.913.711/0043-67", "B");
        zona.put("04.913.711/0082-73", "B");
        zona.put("04.913.711/0087-88", "B");
        zona.put("04.913.711/0086-05", "B");
        zona.put("04.913.711/0058-43", "B");
        zona.put("04.913.711/0089-40", "B");
        zona.put("04.913.711/0084-35", "B");
        zona.put("04.913.711/0092-45", "B");
        zona.put("04.913.711/0094-07", "B");
        zona.put("04.913.711/0114-95", "B");
        zona.put("04.913.711/0095-98", "B");
        zona.put("04.913.711/0121-14", "B");
        zona.put("04.913.711/0091-64", "B");
        zona.put("04.913.711/0117-38", "B");
        zona.put("04.913.711/0097-50", "B");
        zona.put("04.913.711/0113-04", "B");
        zona.put("04.913.711/0096-79", "B");
        zona.put("04.913.711/0119-08", "B");
        zona.put("04.913.711/0018-56", "B");
        zona.put("04.913.711/0122-03", "B");
        zona.put("04.913.711/0118-19", "B");
        zona.put("04.913.711/0107-66", "B");
        zona.put("04.913.711/0099-11", "B");
        zona.put("04.913.711/0009-65", "B");
        zona.put("04.913.711/0116-57", "B");
        zona.put("04.913.711/0034-76", "B");
        zona.put("04.913.711/0120-33", "B");
        zona.put("04.913.711/0115-76", "B");
        zona.put("04.913.711/0110-61", "B");
        zona.put("04.913.711/0102-51", "B");
        zona.put("04.913.711/0008-84", "B");
        zona.put("04.913.711/0090-83", "B");
        zona.put("04.913.711/0036-38", "B");
        zona.put("04.913.711/0105-02", "B");
        zona.put("04.913.711/0123-86", "B");
        zona.put("04.913.711/0066-53", "B");
        zona.put("04.913.711/0126-29", "B");
        zona.put("04.913.711/0125-48", "B");
        zona.put("04.913.711/0093-26", "B");
        zona.put("04.913.711/0112-23", "B");
        zona.put("04.913.711/0111-42", "B");
        zona.put("04.913.711/0019-37", "B");
        zona.put("04.913.711/0124-67", "B");
        zona.put("04.913.711/0129-71", "B");
        zona.put("04.913.711/0013-41", "B");
        zona.put("04.913.711/0012-60", "B");
        zona.put("04.913.711/0033-95", "B");
        zona.put("04.913.711/0130-05", "B");
        zona.put("04.913.711/0128-90", "B");
        zona.put("04.913.711/0131-96", "B");
        zona.put("04.913.711/0133-58", "B");
        zona.put("04.913.711/0132-77", "B");
        zona.put("04.913.711/0127-00", "B");
        zona.put("04.913.711/0038-08", "B");

        zona.put("04.913.711/0069-04", "C");
        zona.put("04.913.711/0104-13", "C");
        zona.put("04.913.711/0040-14", "C");

        zona.put("04.913.711/0039-80", "D");
        zona.put("04.913.711/0079-78", "D");
        zona.put("04.913.711/0057-62", "D");
        zona.put("04.913.711/0006-12", "D");
        zona.put("04.913.711/0037-19", "D");

        zona.put("04.913.711/0052-58", "E");

    }

    public static Map<String, String> getZona() {
        return zona;
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
