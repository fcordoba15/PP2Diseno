package vistaGUI;

import controlador.ClienteCt;
import controlador.CuentaBancariaCt;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Depositar extends javax.swing.JFrame {

    public Depositar() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ClienteCt clienteCuentas = new ClienteCt();
        ArrayList<Integer> cuentas = clienteCuentas.numCuentas();
        for (int i = 0; i < cuentas.size(); i++){
            cbNumeroCuenta.addItem(String.valueOf(cuentas.get(i)));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        btDepositar = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        cbDivisa = new javax.swing.JComboBox<>();
        cbNumeroCuenta = new javax.swing.JComboBox<>();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 204, 51));
        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("DEPOSITAR DINERO A CUENTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 510, 90));

        linea.setFont(new java.awt.Font("Snap ITC", 1, 36)); // NOI18N
        linea.setForeground(new java.awt.Color(0, 0, 102));
        linea.setText("_______________________________");
        getContentPane().add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 600, 50));

        btDepositar.setBackground(new java.awt.Color(0, 0, 102));
        btDepositar.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        btDepositar.setForeground(new java.awt.Color(255, 255, 255));
        btDepositar.setText("DEPOSITAR");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });
        getContentPane().add(btDepositar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 160, 40));

        nombre.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        nombre.setText("Monto");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        cbDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Dolares", "Colones" }));
        cbDivisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDivisaActionPerformed(evt);
            }
        });
        getContentPane().add(cbDivisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 220, 30));

        cbNumeroCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        getContentPane().add(cbNumeroCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 470, 30));

        nombre1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        nombre1.setText("Número de Cuenta a depositar");
        getContentPane().add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        nombre2.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        nombre2.setText("Divisa");
        getContentPane().add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 220, 30));

        back.setBackground(new java.awt.Color(0, 102, 51));
        back.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
       ClienteCt cliente = new ClienteCt();
       if(cbDivisa.getSelectedItem().toString().equals("Colones")){
           JOptionPane.showMessageDialog(null,cliente.realizarDepositoColones(cbNumeroCuenta.getSelectedItem().toString(),txtMonto.getText()));   
       }
       if(cbDivisa.getSelectedItem().toString().equals("Dolares")){
           //DEPOSITO DOLARES 
           JOptionPane.showMessageDialog(null,cliente.realizarDepositoDolares(cbNumeroCuenta.getSelectedItem().toString(),txtMonto.getText())); 
       }
    }//GEN-LAST:event_btDepositarActionPerformed

    private void cbDivisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDivisaActionPerformed
        
    }//GEN-LAST:event_cbDivisaActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        MenuOperaciones abrir = new MenuOperaciones();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Depositar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Depositar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btDepositar;
    private javax.swing.JComboBox<String> cbDivisa;
    private javax.swing.JComboBox<String> cbNumeroCuenta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel linea;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre2;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
