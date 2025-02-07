/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eduardo
 */
public class ConexaoBD {
    private static ConexaoBD bd;
    private static String USUARIO;
    private static String SENHA;
    private static String URL;
    private static String DRIVER;
    
    private ConexaoBD() {
        USUARIO = "root";
        SENHA = "302532";
        URL = "jdbc:mysql://127.0.0.1:3306/gameboxd";
        DRIVER = "com.mysql.jdbc.Driver";
    }
    
    public static ConexaoBD getConexaoBD() {
        if(bd == null) {
            bd = new ConexaoBD();
        }
        
        return bd;
    }
    
    public static Connection open() throws Exception {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }
    
    public List<User> getLogin(String username, String senha) {
        try {
            String sql = "SELECT Nome, Username FROM usuarios WHERE Username='"+username+"' AND senha='"+senha+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<User> usuarios = new ArrayList<User>();
            
            while(resultado.next()) {
                String username_resultado = resultado.getString("Username");
                String nome_resultado = resultado.getString("Nome");
                User u = new User(username_resultado, nome_resultado);
                usuarios.add(u);
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return usuarios;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<User>();
        }
    }
    
    public void cadastrarUser(String username, String nome, String senha, String email) {
        try {
            String sql = "INSERT INTO Usuarios (Nome, Username, Email, Senha)"
                    + "VALUES ('"+nome+"','"+username+"','"+email+"','"+senha+"')";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            
            comando.close();
            conn.close();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean checkEmail(String email) {
        try {
            String sql = "SELECT Nome FROM usuarios WHERE Email='"+email+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<String> usuarios = new ArrayList<String>();
            
            while(resultado.next()) {
                usuarios.add(resultado.getString("Nome"));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return !usuarios.isEmpty();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    
    public boolean checkUsername(String username) {
        try {
            String sql = "SELECT Nome FROM usuarios WHERE Username='"+username+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<String> usuarios = new ArrayList<String>();
            
            while(resultado.next()) {
                usuarios.add(resultado.getString("Nome"));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return !usuarios.isEmpty();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
    
    public List<Jogo> getJogos() {
        try {
            String sql = "SELECT * FROM jogos LIMIT 10";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Jogo> jogos = new ArrayList<Jogo>();
            
            while(resultado.next()) {
                Jogo j = new Jogo(resultado.getString("Nome"), resultado.getString("Descr"), resultado.getString("img"), resultado.getDouble("Nota"));
                jogos.add(j);
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return jogos;
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Jogo>();
        }
    }
    
    public void addAvaliacao(User u, Jogo j, double nota, String coment) {
        try {
            String sql = "INSERT INTO avaliacoes (FK_usuario_username, FK_jogo_nome, Comentario, Nota)"
                    + "VALUES ('"+u.getUsername()+"','"+j.getNome()+"','"+coment+"','"+String.valueOf(nota)+"')";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            
            comando.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Avaliacao> getAvaliacoes(Jogo j) {
        try {
            String sql = "SELECT * FROM avaliacoes WHERE FK_jogo_nome = '"+j.getNome()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
            
            while(resultado.next()) {
                Avaliacao a = new Avaliacao(resultado.getDouble("Nota"), resultado.getString("Comentario"), resultado.getString("FK_usuario_username"), resultado.getString("FK_jogo_nome"));
                avaliacoes.add(a);
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return avaliacoes;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Avaliacao>();
        }
    }
    
    public void atualizarNota(Jogo jogo) {
        try {
            String sql = "SELECT AVG(Nota) FROM avaliacoes WHERE FK_jogo_nome = '"+jogo.getNome()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            double media;
            while(resultado.next()) {
                media = resultado.getDouble("AVG(Nota)");
                jogo.setNota(media);
            }
            
            
            resultado.close();
            comando.close();
            
            sql = "UPDATE jogos SET Nota = '"+jogo.getNota()+"' WHERE Nome = '"+jogo.getNome()+"'";
            comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            
            comando.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Jogo> buscaJogos(String nome) throws BuscaException {
        try {
            String sql = "SELECT * FROM jogos WHERE Nome LIKE '%"+nome+"%'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Jogo> jogos = new ArrayList<Jogo>();
            
            while(resultado.next()) {
                jogos.add(new Jogo(resultado.getString("Nome"), resultado.getString("Descr"), resultado.getString("img"), resultado.getDouble("Nota")));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return jogos;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new BuscaException("Algo deu errado.");
        }
    }
    
    public List<Lista> getListas(User u) {
        try {
            String sql = "SELECT * FROM listas WHERE FK_usuario_username = '"+u.getUsername()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Lista> listas = new ArrayList<Lista>();
            
            while(resultado.next()) {
                listas.add(new Lista(resultado.getInt("id"), resultado.getString("Nome")));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return listas;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Lista>();
        }
    }
    
    public void criarLista(String nome, User u, List<String> jogos) {
        try {
            String sql = "INSERT INTO listas (Nome, FK_usuario_username)"
                    + "VALUES ('"+nome+"','"+u.getUsername()+"')";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultado = comando.getGeneratedKeys();
            
            int listaId = 0;
            if(resultado.next()){
               listaId = resultado.getInt(1);
            }
            
            comando.close();
            
            for(String j : jogos) {
                sql = "INSERT INTO lista_jogo (FK_id_lista, FK_jogo_nome)"
                    +"VALUES ('"+listaId+"','"+j+"')";
                comando = conn.prepareStatement(sql);
                comando.executeUpdate();
                comando.close();
            }
            
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteLista(Lista lista) {
        try {
            String sql = "DELETE FROM listas WHERE id = '"+lista.getId()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();            
            comando.close();
            
            sql = "DELETE FROM lista_jogo WHERE FK_id_lista = '"+lista.getId()+"'";
            comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Jogo> getJogos(Lista lista) {
        try {
            String sql = "SELECT jogos.Nome, jogos.Descr, jogos.img, jogos.Nota FROM jogos INNER JOIN lista_jogo ON jogos.nome = lista_jogo.FK_jogo_nome WHERE FK_id_lista = '"+lista.getId()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Jogo> jogos = new ArrayList<Jogo>();
            
            while(resultado.next()) {
                jogos.add(new Jogo(resultado.getString("Nome"), resultado.getString("Descr"), resultado.getString("img"), resultado.getDouble("Nota")));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return jogos;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Jogo>();
        }
    }
    
    public void deleteFromLista(Jogo j, int listaId) {
        try {
            String sql = "DELETE FROM lista_jogo WHERE FK_id_lista = '"+listaId+"' AND FK_jogo_nome = '"+j.getNome()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();            
            comando.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addJogoToLista(Jogo j, Lista l) throws Exception {
        try {
            String sql = "INSERT INTO lista_jogo (FK_id_lista, FK_jogo_nome) "
                    + "VALUES ('"+l.getId()+"','"+j.getNome()+"')";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public User getUser(String username) {
        try {
            String sql = "SELECT * FROM usuarios WHERE Username='"+username+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<User> usuarios = new ArrayList<User>();
            
            while(resultado.next()) {
                String username_resultado = resultado.getString("Username");
                String nome_resultado = resultado.getString("Nome");
                String email_resultado = resultado.getString("Email");
                String senha_resultado = resultado.getString("Senha");
                User u = new User(nome_resultado, username_resultado);
                u.setEmail(email_resultado);
                u.setSenha(senha_resultado);
                usuarios.add(u);
            }
            
            resultado.close();
            comando.close();
            conn.close();            
            return usuarios.getFirst();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Avaliacao> getAvaliacoes(User u) {
        try {
            String sql = "SELECT * FROM avaliacoes WHERE FK_usuario_username = '"+u.getUsername()+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
            
            while(resultado.next()) {
                Avaliacao a = new Avaliacao(resultado.getDouble("Nota"), resultado.getString("Comentario"), resultado.getString("FK_usuario_username"), resultado.getString("FK_jogo_nome"));
                avaliacoes.add(a);
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return avaliacoes;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<Avaliacao>();
        }
    }
    
    public Jogo getJogo(String nome) {
        try {
            String sql = "SELECT * FROM jogos WHERE Nome = '"+nome+"'";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            Jogo jogo = null;
            
            if(resultado.next()) {
                jogo = new Jogo(resultado.getString("Nome"), resultado.getString("Descr"), resultado.getString("img"), resultado.getDouble("Nota"));
            }
            
            resultado.close();
            comando.close();
            conn.close();
            
            return jogo;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void addNewJogo(String nome, String descr, String img) throws Exception {
        try {
            String out = new Scanner(new URL("https://digest.med.br/wp-content/uploads/2024/07/no-image.jpg").openStream(), "UTF-8").useDelimiter("\\A").next();
            String sql = "INSERT INTO jogos (Nome, Descr, img, Nota) "
                    + "VALUES ('"+nome+"','"+descr+"','"+(img.equals("") ? out : img)+"', '0')";
            Connection conn = ConexaoBD.open();
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public void removerJogo(String nome, String senha) throws Exception {
        try {
            Connection conn = ConexaoBD.open();
            
            String sql = "Select Nome FROM jogos WHERE Nome = '"+nome+"'";
            PreparedStatement comando = conn.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            
            String jogo = null;
            if(resultado.next()) {
                jogo = resultado.getString("Nome");
            }
            
            comando.close();
            
            if(jogo == null) {
                throw new Exception("Jogo não cadastrado!");
            }
            
            sql = "SELECT Senha FROM usuarios WHERE Username = 'adm'";
            comando = conn.prepareStatement(sql);
            resultado = comando.executeQuery();
            
            String senhaAdm = "";
            
            if(resultado.next()) {
                senhaAdm = resultado.getString("Senha");
            }
            
            comando.close();
            
            if(!senhaAdm.equals(senha)) {
                throw new Exception("Senha incorreta!");
            }
            
            sql = "DELETE FROM jogos WHERE Nome = '"+nome+"'";
            comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            
            sql = "DELETE FROM lista_jogo WHERE FK_jogo_nome = '"+nome+"'";
            comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            
            sql = "DELETE FROM avaliacoes WHERE FK_jogo_nome = '"+nome+"'";
            comando = conn.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            
            conn.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
