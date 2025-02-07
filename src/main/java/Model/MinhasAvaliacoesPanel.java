/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Model;

import Controller.Controller;
import View.JogoFrame;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Eduardo
 */
public class MinhasAvaliacoesPanel extends javax.swing.JPanel {
    private Avaliacao avaliacao;
    private User usuario;
    private Jogo jogo;
    
    /**
     * Creates new form JogoPanel
     */
    public MinhasAvaliacoesPanel(Avaliacao avaliacao, User usuario) {
        this.avaliacao = avaliacao;
        jogo = Controller.getController().getJogo(avaliacao.getJogo());
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

        avaliacao_icon = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        avaliacao_comentario = new javax.swing.JLabel();
        avaliacao_nota = new javax.swing.JLabel();
        jogo_icon = new javax.swing.JLabel();
        jogo_tittle = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 244, 244), 6));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(660, 178));
        setMinimumSize(new java.awt.Dimension(660, 178));
        setPreferredSize(new java.awt.Dimension(660, 178));

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/default_pfp.jpg"));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        icon = new ImageIcon(newImage);
        avaliacao_icon.setIcon(icon);

        avaliacao_icon.setMaximumSize(new java.awt.Dimension(80, 80));
        avaliacao_icon.setMinimumSize(new java.awt.Dimension(80, 80));
        avaliacao_icon.setPreferredSize(new java.awt.Dimension(80, 80));

        username.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        username.setText(avaliacao.getUsername());
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        avaliacao_comentario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        avaliacao_comentario.setText("<html><p style=\"width:450px\">"+(avaliacao.getComentario() == "" ? "..." : avaliacao.getComentario())+"</p></html>");
        avaliacao_comentario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        avaliacao_comentario.setMaximumSize(new java.awt.Dimension(557, 47));
        avaliacao_comentario.setMinimumSize(new java.awt.Dimension(557, 47));
        avaliacao_comentario.setPreferredSize(new java.awt.Dimension(557, 47));

        avaliacao_nota.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        avaliacao_nota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        avaliacao_nota.setText(String.valueOf(avaliacao.getNota()) + "/10");
        avaliacao_nota.setMaximumSize(new java.awt.Dimension(660, 110));
        avaliacao_nota.setMinimumSize(new java.awt.Dimension(660, 110));
        avaliacao_nota.setName(""); // NOI18N
        avaliacao_nota.setPreferredSize(new java.awt.Dimension(660, 110));

        try {
            URL url = new URL(jogo.getImg());
            Image image2 = ImageIO.read(url);
            Image newImage2 = image2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            ImageIcon icon2 = new ImageIcon(newImage2);
            jogo_icon.setIcon(icon2);
        } catch(Exception e) {}
        jogo_icon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jogo_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jogo_iconMouseReleased(evt);
            }
        });

        jogo_tittle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jogo_tittle.setText("Avaliação de "+jogo.getNome());
        jogo_tittle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jogo_tittle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jogo_tittleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jogo_tittleMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jogo_tittleMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avaliacao_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avaliacao_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(avaliacao_comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 544, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jogo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jogo_tittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jogo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jogo_tittle)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username)
                            .addComponent(avaliacao_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avaliacao_comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(avaliacao_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jogo_tittleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogo_tittleMouseEntered
        jogo_tittle.setText("<HTML><U>Avaliação de "+jogo.getNome()+"</U></HTML>");
    }//GEN-LAST:event_jogo_tittleMouseEntered

    private void jogo_tittleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogo_tittleMouseExited
        jogo_tittle.setText("Avaliação de "+jogo.getNome());
    }//GEN-LAST:event_jogo_tittleMouseExited

    private void jogo_iconMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogo_iconMouseReleased
        new JogoFrame(jogo, usuario);
    }//GEN-LAST:event_jogo_iconMouseReleased

    private void jogo_tittleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogo_tittleMouseReleased
        new JogoFrame(jogo, usuario);
    }//GEN-LAST:event_jogo_tittleMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avaliacao_comentario;
    private javax.swing.JLabel avaliacao_icon;
    private javax.swing.JLabel avaliacao_nota;
    private javax.swing.JLabel jogo_icon;
    private javax.swing.JLabel jogo_tittle;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
