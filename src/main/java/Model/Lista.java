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
public class Lista {
    private int id;
    private String nome;
    
    public Lista(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getId() {
        return this.id;
    }
}
