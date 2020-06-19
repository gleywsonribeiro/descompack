/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import exception.NegocioException;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author Gleywson
 */
public class TelaDivideArquivo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaDivideArquivo
     */
    private File file;
    private File diretorio;

    public TelaDivideArquivo() {
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
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        barraStatus = new javax.swing.JProgressBar();
        txtDestino = new javax.swing.JTextField();
        txtOrigem = new javax.swing.JTextField();

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
        setTitle("Divisão de Arquivos");

        jLabel1.setText("Escolher Arquivo:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Escolha a pasta de Destino:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Processar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        barraStatus.setBackground(new java.awt.Color(204, 204, 204));
        barraStatus.setForeground(new java.awt.Color(0, 102, 102));
        barraStatus.setToolTipText("");
        barraStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barraStatus.setStringPainted(true);

        txtDestino.setEditable(false);

        txtOrigem.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrigem, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(txtDestino))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(barraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooserArquivo = new JFileChooser();
        chooserArquivo.setFileFilter(new FileNameExtensionFilter("Arquivo PDF (*.pdf)", "pdf"));
        chooserArquivo.setApproveButtonText("Selecione o arquivo");
        chooserArquivo.setDialogTitle("Seletor de Notas Fiscais");
        //Configura a possíbilidade de selecionar vários arquivos
        chooserArquivo.setAcceptAllFileFilterUsed(false);

        int escolha = chooserArquivo.showOpenDialog(getParent());
        if (escolha == JFileChooser.APPROVE_OPTION) {
            file = chooserArquivo.getSelectedFile();
            String caminho = file.getAbsolutePath();
            txtOrigem.setText(caminho);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooserDiretorio = new JFileChooser();
        chooserDiretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int escolha = chooserDiretorio.showOpenDialog(getParent());
        diretorio = chooserDiretorio.getSelectedFile();
        if (escolha == JFileChooser.APPROVE_OPTION) {
            txtDestino.setText(diretorio.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private String getNumeroNota(PDDocument document) {
        try {
//            PDFTextStripper stripper = new PDFTextStripper();
//            String texto = stripper.getText(document);
//            String nota[] = texto.split("\n");
//            List<String> possiveisNotas = Arrays.asList(nota[57], nota[58], nota[59], nota[60]);
//            String palpite = possiveisNotas.stream().filter(numero -> numero.trim().length() == 5).collect(Collectors.toList()).get(0).trim();
//
//            return palpite; //nota[58];

            Rectangle2D rd = new Rectangle2D.Double(370, 800, 100, 50);
            Rectangle2D rd2 = new Rectangle2D.Double(370, 0, 100, 50);
            PDFTextStripperByArea area = new PDFTextStripperByArea();
            PDPage page = document.getPage(0);
            area.addRegion("nf", rd2);
            area.extractRegions(page);
            return area.getTextForRegion("nf").split("\n")[1].trim();
        } catch (Exception e) {
            throw new NegocioException("Erro ao extrair numero de nota: " + e.getMessage());
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try (PDDocument document = PDDocument.load(file)) {
            int numeroPaginas = document.getNumberOfPages();
            Splitter splitter = new Splitter();

            List<PDDocument> pages = splitter.split(document);

            Iterator<PDDocument> iterator = pages.iterator();
            int i = 0;

            while (iterator.hasNext()) {
                try (PDDocument pdd = iterator.next()) {
                    i++;

                    int status = (100 * i) / numeroPaginas;
                    barraStatus.setValue(status);
                    barraStatus.getUI().update(barraStatus.getGraphics(), barraStatus);

//                PDPage page = pdd.getPage(0);
//                PDPageContentStream stream = new PDPageContentStream(pdd, page, AppendMode.APPEND, false);
//                stream.setNonStrokingColor(Color.RED);
//                stream.addRect(375, 805, 40, 15);
//
//                stream.fill();
//                stream.close();
//                pdd.save(diretorio.getAbsolutePath() + "\\" + getNumeroNota(pdd) + ".pdf");
                    pdd.save(diretorio.getAbsolutePath() + "\\" + getNumeroNota(pdd) + ".pdf");
//                    System.out.println(diretorio.getAbsolutePath() + "\\" + getNumeroNota(pdd) + ".pdf");

                }
            }

            JOptionPane.showMessageDialog(null, "Processo realizado com sucesso!",
                    "Êxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao processar divisão de arquivo",
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
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtOrigem;
    // End of variables declaration//GEN-END:variables
}
