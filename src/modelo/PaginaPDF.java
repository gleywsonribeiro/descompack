/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gleyw
 */
public class PaginaPDF {
    private final Double largura;
    private final Double altura;

    public PaginaPDF(Double largura, Double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getAltura() {
        return altura;
    }
    
    
}
