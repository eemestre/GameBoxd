/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Eduardo
 */
public class User {
    private String nome;
    private String username;
    private String email;
    private String senha;
    
    public User(String username, String nome) {
        this.username = username;
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getSenha() {
        return this.senha;
    }
}
