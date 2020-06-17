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
public class RetanguloPDF {

    private final String nome;
    private final Double x;
    private final Double y;
    private final Double largura;
    private final Double altura;

    public RetanguloPDF(String nome, Double x, Double y, Double largura, Double altura) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getAltura() {
        return altura;
    }

}
