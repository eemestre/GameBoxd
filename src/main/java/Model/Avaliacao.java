/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Eduardo
 */
public class Avaliacao {
    private double nota;
    private String comentario;
    private String username;
    private String jogo;
    
    public Avaliacao(double nota, String comentario, String username, String jogo) {
        this.nota = nota;
        this.comentario = comentario;
        this.username = username;
        this.jogo = jogo;
    }
    
    public double getNota() {
        return this.nota;
    }
    
    public String getComentario() {
        return this.comentario;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getJogo() {
        return this.jogo;
    }
}
