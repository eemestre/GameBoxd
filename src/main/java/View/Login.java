/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JOptionPane;
import Controller.Controller;
import Model.LoginException;
import Model.User;

/**
 *
 * @author Eduardo
 */
public class Login extends javax.swing.JFrame {
    private static Login loginUnic;
    private static Controller c;
    private Home h;
    
    /**
     * Creates new form NewJFrame
     */
    private Login() {
        c = Controller.getController();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static Login getLogin() {
        if(loginUnic == null) {
            loginUnic = new Login();
        }
        
        return loginUnic;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_tittle = new javax.swing.JLabel();
        username_textfield = new javax.swing.JTextField();
        username_label = new javax.swing.JLabel();
        senha_label = new javax.swing.JLabel();
        btn_logar = new javax.swing.JButton();
        senha_textfield = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(700, 480));
        setMinimumSize(new java.awt.Dimension(700, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        login_tittle.setFont(new java.awt.Font("Monospaced", 1, 72)); // NOI18N
        login_tittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_tittle.setText("Login");

        username_textfield.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        username_label.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        username_label.setText("Nome de usuário:");

        senha_label.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        senha_label.setText("Senha:");

        btn_logar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_logar.setText("Logar");
        btn_logar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logarActionPerformed(evt);
            }
        });

        senha_textfield.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(login_tittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senha_label)
                            .addComponent(username_label)
                            .addComponent(senha_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(username_textfield)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btn_logar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(login_tittle)
                .addGap(18, 18, 18)
                .addComponent(username_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(senha_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_logar)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        GameBoxd.getGameBoxd().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btn_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logarActionPerformed
        if(username_textfield.getText().equals("") || String.valueOf(senha_textfield.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(
                        null,
                        "Preencha todos os campos.",
                        "Aviso!",
                        JOptionPane.WARNING_MESSAGE
                );
        } else {
            try {
                User u = c.tryLogin(username_textfield.getText(), String.valueOf(senha_textfield.getPassword()));
                h = new Home(u);
                username_textfield.setText("");
                senha_textfield.setText("");
                this.dispose();
                h.setVisible(true);
            } catch(LoginException e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Erro!",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_btn_logarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logar;
    private javax.swing.JLabel login_tittle;
    private javax.swing.JLabel senha_label;
    private javax.swing.JPasswordField senha_textfield;
    private javax.swing.JLabel username_label;
    private javax.swing.JTextField username_textfield;
    // End of variables declaration//GEN-END:variables
}
