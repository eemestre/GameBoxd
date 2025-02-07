/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Avaliacao;
import Model.BuscaException;
import Model.LoginException;
import Model.CadastroException;
import Model.User;
import Model.ConexaoBD;
import Model.Jogo;
import Model.Lista;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Controller {
    private static Controller controllerUnic;
    private static ConexaoBD bd;
    
    private Controller() {
        bd = ConexaoBD.getConexaoBD();
    }
    
    public static Controller getController() {
        if(controllerUnic == null) {
            controllerUnic = new Controller();
        }
        
        return controllerUnic;
    }
    
    public User tryLogin(String username, String senha) throws LoginException {
        List<User> usuarios = bd.getLogin(username, senha);
        
        // return new User("Dra.Roar69", "Dra. Deolane Tigrinho roar");
        
        if(usuarios.isEmpty()) {
            throw new LoginException("Usuário ou senha não cadastrados.");
        } else {
            return usuarios.getFirst();
        }
    }
    
    public void tryCadastro(String username, String nome, String senha, String email) throws CadastroException {
        boolean emailUsado = bd.checkEmail(email);
        if(emailUsado) {
            throw new CadastroException("Esse email já está cadastrado.");
        }
        
        boolean usernameUsado = bd.checkUsername(username);
        if(usernameUsado) {
            throw new CadastroException("Esse nome de usuário já está cadastrado.");
        }
        
        bd.cadastrarUser(username, nome, senha, email);
    }
    
    public List<Jogo> getJogos() {
        return bd.getJogos();
    }
    
    public List<Avaliacao> getAvaliacoes(Jogo jogo) {
        return bd.getAvaliacoes(jogo);
    }
    
    public List<Avaliacao> getAvaliacoes(User u) {
        return bd.getAvaliacoes(u);
    }
    
    public List<Lista> getListas(User u) {
        return bd.getListas(u);
    }
    
    public List<Jogo> getJogosDaLista(Lista l) {
        return bd.getJogos(l);
    }
    
    public void avaliarJogo(User usuario, Jogo jogo, double nota, String comentario) {
        bd.addAvaliacao(usuario, jogo, nota, comentario);
        bd.atualizarNota(jogo);
    }
    
    public List<Jogo> buscaJogos(String nome) throws BuscaException {
        return bd.buscaJogos(nome);
    }
    
    public void criarLista(String nome, User u, List<String> jogos) {
        bd.criarLista(nome, u, jogos);
    }
    
    public void deleteLista(Lista lista) {
        bd.deleteLista(lista);
    }
    
    public void deleteFromLista(Jogo j, int listaId) {
        bd.deleteFromLista(j, listaId);
    }
    
    public void addJogoToLista(Jogo j, Lista l) throws Exception {
        bd.addJogoToLista(j, l);
    }
    
    public User getUser(String username) {
        System.out.println(username);
        return bd.getUser(username);
    }
    
    public Jogo getJogo(String nome) {
        return bd.getJogo(nome);
    }
    
    public void addNewJogo(String nome, String descr, String img) throws Exception {
        bd.addNewJogo(nome, descr, img);
    }
    
    public void removerJogo(String nome, String senha) throws Exception {
        bd.removerJogo(nome, senha);
    }
}
