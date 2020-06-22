/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Conversor;
import modelo.PaginaPDF;
import modelo.RetanguloPDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Gleywson
 */
public class ParaSegurancaView extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDivideArquivo
     */
    private File diretorio;
    private File[] arquivos;

    public ParaSegurancaView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btProcessar = new javax.swing.JButton();
        barraStatus = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setMaximizable(true);
        setTitle("Pará Segurança");

        jLabel1.setText("Selecione os arquivos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btProcessar.setText("Processar");
        btProcessar.setEnabled(false);
        btProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProcessarActionPerformed(evt);
            }
        });

        barraStatus.setBackground(new java.awt.Color(204, 204, 204));
        barraStatus.setForeground(new java.awt.Color(0, 102, 102));
        barraStatus.setToolTipText("");
        barraStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barraStatus.setStringPainted(true);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(barraStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(btProcessar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(btProcessar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(barraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("paraSeguranca");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooserArquivo = new JFileChooser();
        chooserArquivo.setFileFilter(new FileNameExtensionFilter("Arquivo PDF (*.pdf)", "pdf"));
        chooserArquivo.setMultiSelectionEnabled(true);
        chooserArquivo.setApproveButtonText("Selecione os arquivos");
        chooserArquivo.setDialogTitle("Seletor de Notas Fiscais");
        //Configura a possíbilidade de selecionar vários arquivos
        chooserArquivo.setAcceptAllFileFilterUsed(false);

        int escolha = chooserArquivo.showOpenDialog(getParent());
        if (escolha == JFileChooser.APPROVE_OPTION) {
            arquivos = chooserArquivo.getSelectedFiles();
            for (File arquivo : arquivos) {
                textArea.setText(textArea.getText() + arquivo.getAbsolutePath() + "\n");
            }
            btProcessar.setEnabled(true);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProcessarActionPerformed
        PaginaPDF pagina = new PaginaPDF(209.05, 296.79);
        List<RetanguloPDF> campos = Arrays.asList(
                new RetanguloPDF("NF", 121.73, 13.70, 17.86, 4.8),
                new RetanguloPDF("Data", 121.89, 22.96, 17.0, 4.89),
                new RetanguloPDF("Unidade", 0.58, 98.68, 100.00, 2.7),
                new RetanguloPDF("Município", 44.18, 84.05, 51.26, 4.0),
                new RetanguloPDF("CNPJ", 44.55, 75.95, 29.92, 3.65),
                new RetanguloPDF("Descrição", 0.0, 0.0, 0.0, 0.0),
                new RetanguloPDF("Recolhimento", 55.02, 245.52, 63.54, 4.44),
                new RetanguloPDF("Tributação", 55.02, 238.05, 63.54, 4.44),
                new RetanguloPDF("Valor", 179.15, 129.12, 19.76, 6.54),
                new RetanguloPDF("Coluna", 0.0, 0.0, 0.0, 0.0),
                new RetanguloPDF("IR", 125.12, 203.20, 37.04, 5.22),
                new RetanguloPDF("INSS", 87.37, 202.74, 37.04, 4.5),
                new RetanguloPDF("PIS", 10.47, 202.74, 37.04, 4.5),
                new RetanguloPDF("Cofins", 49.51, 202.74, 37.04, 4.5),
                new RetanguloPDF("CSLL", 163.18, 202.74, 37.04, 4.5),
                new RetanguloPDF("ISS", 153.46, 217.52, 44.8, 4.5)
        );

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("NF");

        int linha = 1;
        //---   CABEÇALHO
        List<String> cabecalhos = Arrays.asList(
                "Nº NOTA", "DATA", "UNIDADE", "MUNICÍPIO", "CNPJ", "DESCRIÇÃO", "RECOLHIMENTO", "TRIBUTAÇÃO", "VALOR", "COLUNA",
                "IR", "INSS", "PIS", "COFINS",
                "CSLL", "ISS", "ZONA");

        Row linhaCabecalho = sheet.createRow(linha - 1);
        int colunaCabecalho = 0;
        for (String cabecalho : cabecalhos) {
            Cell celula = linhaCabecalho.createCell(colunaCabecalho++);
            celula.setCellValue(cabecalho);

            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            Font font = sheet.getWorkbook().createFont();
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            cellStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
            cellStyle.setFont(font);
            celula.setCellStyle(cellStyle);
        }

        for (int i = 0; i < arquivos.length; i++) {
            try (PDDocument document = PDDocument.load(arquivos[i])) {
                int status = (100 * (i + 1)) / arquivos.length;
                barraStatus.setValue(status);
                barraStatus.getUI().update(barraStatus.getGraphics(), barraStatus);

                Conversor conversor = new Conversor(pagina, campos, document);

                List<String> dados = conversor.getCamposTexto();

                int coluna = 0;

                Row linhaNota = sheet.createRow(linha++);

                for (int j = 0; j < dados.size(); j++) {
                    Cell celula = linhaNota.createCell(coluna++);
                    try {
                        if (j >= 8 && j != 9) {
                            celula.setCellType(Cell.CELL_TYPE_NUMERIC);
                            Double value = Double.parseDouble(dados.get(j)
                                    .replace(".", "")
                                    .replace(" ", "")
                                    .replace("$", "")
                                    .replace("R", "")
                                    .replace(",", "."));

                            HSSFCellStyle style = workbook.createCellStyle();
                            style.setDataFormat(workbook.createDataFormat().getFormat("0.00"));

                            celula.setCellValue(value);
                            celula.setCellStyle(style);
                        } else if (j == 0) {
                            celula.setCellValue(Integer.parseInt(dados.get(j)));
                        } else if (j == 2) {
                            String agencia = dados.get(j).replace("R$", "#").split("#")[0];
                            celula.setCellValue(agencia);
                        } else {
                            celula.setCellValue(dados.get(j));
                        }
                    } catch (NumberFormatException e) {
                        celula.setCellValue(dados.get(j));
                    }
                }
                Cell cell = linhaNota.createCell(coluna++);
                cell.setCellValue(Conversor.getZona().get(dados.get(4)));

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: " + ex.getMessage(),
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao processar: " + ex.getMessage(),
                        "Erro!", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        autoSizeColumns(workbook);

        try (FileOutputStream stream = new FileOutputStream(new File(arquivos[0].getParent() + "\\" + "Notas Fiscais - Pará Segurança" + ".xls"))) {
            workbook.write(stream);

            stream.flush();
            JOptionPane.showMessageDialog(null, "Processo realizado com sucesso!",
                    "Êxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao processar divisão de arquivo: " + ex.getMessage(),
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo Nulo: " + ex.getMessage(),
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido: " + ex.getMessage(),
                    "Erro!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btProcessarActionPerformed

    private void autoSizeColumns(HSSFWorkbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            HSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraStatus;
    private javax.swing.JButton btProcessar;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
