/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaGUI;
import controlador.ActualizacionDatos;
import controlador.ClienteCt;
/**
 *
 * @author fabih
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        ActualizacionDatos .refrescarPrograma();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        btCuentaBancaria = new javax.swing.JButton();
        home = new javax.swing.JButton();
        btContrasenia = new javax.swing.JButton();
        btConsulta = new javax.swing.JButton();
        btOperacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 204, 51));
        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("MENÚ PRINCIPAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -10, 310, 90));

        linea.setFont(new java.awt.Font("Snap ITC", 1, 36)); // NOI18N
        linea.setForeground(new java.awt.Color(0, 0, 102));
        linea.setText("_______________________________________");
        getContentPane().add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 750, 50));

        btCuentaBancaria.setBackground(new java.awt.Color(0, 0, 102));
        btCuentaBancaria.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btCuentaBancaria.setForeground(new java.awt.Color(255, 255, 255));
        btCuentaBancaria.setText("ABRIR CUENTA BANCARIA");
        btCuentaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCuentaBancariaActionPerformed(evt);
            }
        });
        getContentPane().add(btCuentaBancaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 300, 50));

        home.setBackground(new java.awt.Color(0, 102, 51));
        home.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 90, 30));

        btContrasenia.setBackground(new java.awt.Color(0, 0, 102));
        btContrasenia.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        btContrasenia.setText("CAMBIAR PIN");
        btContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContraseniaActionPerformed(evt);
            }
        });
        getContentPane().add(btContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 300, 50));

        btConsulta.setBackground(new java.awt.Color(0, 0, 102));
        btConsulta.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btConsulta.setText("REALIZAR CONSULTA");
        btConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, 50));

        btOperacion.setBackground(new java.awt.Color(0, 0, 102));
        btOperacion.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btOperacion.setForeground(new java.awt.Color(255, 255, 255));
        btOperacion.setText("REALIZAR OPERACIÓN");
        btOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOperacionActionPerformed(evt);
            }
        });
        getContentPane().add(btOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 300, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCuentaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCuentaBancariaActionPerformed
        AbrirCuentaBancaria abrir = new AbrirCuentaBancaria();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btCuentaBancariaActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        PaginaPrincipal abrir = new PaginaPrincipal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void btContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContraseniaActionPerformed
        CambiarPin abrir = new CambiarPin();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btContraseniaActionPerformed

    private void btConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaActionPerformed
        MenuConsultas abrir = new MenuConsultas();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btConsultaActionPerformed

    private void btOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOperacionActionPerformed
        MenuOperaciones abrir = new MenuOperaciones();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsulta;
    private javax.swing.JButton btContrasenia;
    private javax.swing.JButton btCuentaBancaria;
    private javax.swing.JButton btOperacion;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel linea;
    // End of variables declaration//GEN-END:variables
}
