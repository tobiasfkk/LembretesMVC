/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import interfaces.TarefaInterface;
import java.text.DateFormat;
import javax.swing.ImageIcon;

public class ViewInicial extends javax.swing.JFrame {

    /**
     * Creates new form ViewInicial
     */
    public ViewInicial() {
        initComponents();
        insereImagemLabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlImagem = new javax.swing.JLabel();
        btn_iniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(350, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlImagem.setPreferredSize(new java.awt.Dimension(300, 400));
        jPanel1.add(jlImagem);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 310, 410));

        btn_iniciar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_iniciar.setText("INICIAR");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 260, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
       ViewMenu viewMenu = new ViewMenu();
       viewMenu.setVisible(true);
    }//GEN-LAST:event_btn_iniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlImagem;
    // End of variables declaration//GEN-END:variables

    private void insereImagemLabel() {
        ImageIcon imagem = new ImageIcon ("src/main/java/imagens/ImagemTelaInicial.png");
        imagem.setImage(imagem.getImage().getScaledInstance(jlImagem.getWidth(),jlImagem.getHeight(),1));
        jlImagem.setIcon(imagem);
         }
}
