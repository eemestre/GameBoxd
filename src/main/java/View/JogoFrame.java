/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Avaliacao;
import Model.AvaliacaoPanel;
import Model.Jogo;
import Model.User;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author Eduardo
 */
public class JogoFrame extends javax.swing.JFrame {
    private Jogo jogo;
    private User usuario;
    private Controller c;
    private List<Avaliacao> avaliacoes;
    private javax.swing.JPanel view;
    
    /**
     * Creates new form JogoFrame
     */
    public JogoFrame(Jogo jogo, User u) {
        this.c = Controller.getController();
        this.usuario = u;
        this.jogo = jogo;
        this.view = new javax.swing.JPanel();
        this.view.setLayout(new BoxLayout(this.view, BoxLayout.Y_AXIS));
        this.view.setBackground(new Color(244,244,244));
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void showAvaliacoes() {
        avaliacoes = c.getAvaliacoes(jogo);
        view.removeAll();
        view.revalidate();
        view.repaint();
        for(Avaliacao a : avaliacoes) {
            view.add(new AvaliacaoPanel(a));
        }
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jogo_icon = new javax.swing.JLabel();
        jogo_tittle = new javax.swing.JLabel();
        jogo_nota = new javax.swing.JLabel();
        jScrollPane_avaliacoes = new javax.swing.JScrollPane(this.view);
        jogo_descr = new javax.swing.JLabel();
        btn_avaliar = new javax.swing.JButton();
        btn_addLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(jogo.getNome());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        try {
            URL url = new URL(jogo.getImg());
            Image image = ImageIO.read(url);
            Image newImage = image.getScaledInstance(180, 180, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(newImage);
            jogo_icon.setIcon(icon);
        } catch(Exception e) {}

        jogo_tittle.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jogo_tittle.setText(jogo.getNome());

        jogo_nota.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jogo_nota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jogo_nota.setText(String.format("%.1f/10", jogo.getNota()));
        jogo_nota.setToolTipText("");

        jogo_descr.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jogo_descr.setText("<html><p style=\"width:370px\">"+jogo.getDescr()+"</p></html>");
        jogo_descr.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btn_avaliar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_avaliar.setText("Avaliar Jogo");
        btn_avaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avaliarActionPerformed(evt);
            }
        });

        btn_addLista.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_addLista.setText("Adicionar em lista");
        btn_addLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane_avaliacoes)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jogo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jogo_tittle, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jogo_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jogo_descr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btn_avaliar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_addLista)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jogo_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jogo_tittle, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jogo_nota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jogo_descr, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_avaliar)
                    .addComponent(btn_addLista))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_avaliacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_avaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avaliarActionPerformed
        new AddAvaliacao(jogo, usuario);
    }//GEN-LAST:event_btn_avaliarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        showAvaliacoes();
        jogo_nota.setText(String.format("%.1f/10", jogo.getNota()));
    }//GEN-LAST:event_formWindowActivated

    private void btn_addListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addListaActionPerformed
        new AddToListFrame(jogo, usuario);
    }//GEN-LAST:event_btn_addListaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addLista;
    private javax.swing.JButton btn_avaliar;
    private javax.swing.JScrollPane jScrollPane_avaliacoes;
    private javax.swing.JLabel jogo_descr;
    private javax.swing.JLabel jogo_icon;
    private javax.swing.JLabel jogo_nota;
    private javax.swing.JLabel jogo_tittle;
    // End of variables declaration//GEN-END:variables
}
