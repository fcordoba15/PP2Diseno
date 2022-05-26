
package vistaGUI;

import controlador.CuentaBancariaCt;
import controlador.ClienteCt;
import javax.swing.JOptionPane;
public class AbrirCuentaBancaria extends javax.swing.JFrame {

    
    public AbrirCuentaBancaria() {
        initComponents();
        this.setLocationRelativeTo(null);
         ClienteCt cliente = new ClienteCt();
         for (int i = 0; i < cliente.cedulaClientes().size(); i++){
            cbCedula.addItem(String.valueOf(cliente.cedulaClientes().get(i)));
          }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        apellido2 = new javax.swing.JLabel();
        btAbrir = new javax.swing.JButton();
        back = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        cbCedula = new javax.swing.JComboBox<>();
        txtMonto = new javax.swing.JTextField();
        tel = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 204, 51));
        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("ABRIR UNA CUENTA BANCARIA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, -10, 520, 90));

        linea.setFont(new java.awt.Font("Snap ITC", 1, 36)); // NOI18N
        linea.setForeground(new java.awt.Color(0, 0, 102));
        linea.setText("____________________________________");
        getContentPane().add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 710, 50));

        apellido2.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        apellido2.setText("PIN");
        getContentPane().add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        btAbrir.setBackground(new java.awt.Color(0, 0, 102));
        btAbrir.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btAbrir.setForeground(new java.awt.Color(255, 255, 255));
        btAbrir.setText("ABRIR");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(btAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 160, 40));

        back.setBackground(new java.awt.Color(0, 102, 51));
        back.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 30));

        nombre.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        nombre.setText("Cédula del dueño de la cuenta");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        cbCedula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        cbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(cbCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 30));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 250, 30));

        tel.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        tel.setText("Monto a depositar");
        getContentPane().add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        txtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActionPerformed(evt);
            }
        });
        getContentPane().add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 260, 30));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 30)); // NOI18N
        jLabel1.setText("¢ ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        CuentaBancariaCt cuenta = new CuentaBancariaCt();
        JOptionPane.showMessageDialog(null,cuenta.resgistrarCuentaBancaria (txtMonto.getText(),txtPin.getText(),cbCedula.getSelectedItem().toString()));
        PaginaPrincipal ventana = new PaginaPrincipal();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btAbrirActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MenuPrincipal abrir = new MenuPrincipal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinActionPerformed

    private void cbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCedulaActionPerformed
       
    }//GEN-LAST:event_cbCedulaActionPerformed

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
            java.util.logging.Logger.getLogger(AbrirCuentaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbrirCuentaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbrirCuentaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbrirCuentaBancaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbrirCuentaBancaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido2;
    private javax.swing.JButton back;
    private javax.swing.JButton btAbrir;
    private javax.swing.JComboBox<String> cbCedula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel linea;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel tel;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
