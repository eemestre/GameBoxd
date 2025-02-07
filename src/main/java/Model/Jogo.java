/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author Eduardo
 */
public class Jogo {
    private String nome;
    private String descr;
    private String img;
    private double nota;
    
    public Jogo(String nome, String descr, String img, double nota) {
        this.nome = nome;
        this.descr = descr;
        this.img = img;
        this.nota = nota;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getDescr() {
        return this.descr;
    }
    
    public String getImg() {
        return this.img;
    }
    
    public double getNota() {
        return this.nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
}
