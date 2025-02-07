/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.Controller;
import Model.Jogo;
import Model.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class AddAvaliacao extends javax.swing.JFrame {
    private Jogo jogo;
    private User usuario;
    private Controller c;
    
    /**
     * Creates new form AddAvaliacao
     */
    public AddAvaliacao(Jogo jogo, User u) {
        this.jogo = jogo;
        this.usuario = u;
        c = Controller.getController();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jogo_nome = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        nota_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_avaliar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        coment_text = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliar "+jogo.getNome());
        setResizable(false);

        jogo_nome.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jogo_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jogo_nome.setText("Avaliçao de "+jogo.getNome());

        slider.setMaximum(90);
        slider.setValue(0);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        nota_label.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        nota_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nota_label.setText("1.0");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("Comentário (opcional):");

        btn_avaliar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_avaliar.setText("Avaliar");
        btn_avaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avaliarActionPerformed(evt);
            }
        });

        coment_text.setColumns(20);
        coment_text.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        coment_text.setRows(5);
        jScrollPane1.setViewportView(coment_text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nota_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jogo_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 54, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(btn_avaliar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jogo_nome)
                .addGap(35, 35, 35)
                .addComponent(nota_label)
                .addGap(18, 18, 18)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_avaliar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        double d = slider.getValue();
        nota_label.setText(String.valueOf(d/10 + 1));
    }//GEN-LAST:event_sliderStateChanged

    private void btn_avaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avaliarActionPerformed
        double d = slider.getValue();
        c.avaliarJogo(usuario, jogo, d/10 + 1, coment_text.getText());
        JOptionPane.showMessageDialog(
            null,
            "Avaliaçao enviada!",
            "Sucesso!",
            JOptionPane.PLAIN_MESSAGE
        );
        this.dispose();
    }//GEN-LAST:event_btn_avaliarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_avaliar;
    private javax.swing.JTextArea coment_text;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jogo_nome;
    private javax.swing.JLabel nota_label;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
