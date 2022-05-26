
package vistaGUI;

import controlador.ActualizacionDatos;
import controlador.ClienteCt;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validaciones.ValidacionFormato;
public class RegistrarCliente extends javax.swing.JFrame {
    
    public RegistrarCliente() {
        initComponents();
        ActualizacionDatos.refrescarPrograma();
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        apellido2 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        home = new javax.swing.JButton();
        txtApellido2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        nombre = new javax.swing.JLabel();
        apellido1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        cbAnio = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        tel = new javax.swing.JLabel();
        ced = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 204, 51));
        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("REGISTRO DE CLIENTES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -10, 400, 90));

        linea.setFont(new java.awt.Font("Snap ITC", 1, 36)); // NOI18N
        linea.setForeground(new java.awt.Color(0, 0, 102));
        linea.setText("____________________________________");
        getContentPane().add(linea, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 30, 710, 50));

        apellido2.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        apellido2.setText("Segundo Apellido");
        getContentPane().add(apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        registrar.setBackground(new java.awt.Color(0, 0, 102));
        registrar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setText("REGISTRAR");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 160, 40));

        home.setBackground(new java.awt.Color(0, 102, 51));
        home.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 30));

        txtApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 170, 30));

        txtApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellido1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 170, 30));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 270, 30));

        nombre.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        nombre.setText("Nombre");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        apellido1.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        apellido1.setText("Primer Apellido");
        getContentPane().add(apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 170, 30));

        correo.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        correo.setText("Correo Electrónico");
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, -1, -1));

        fecha.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        fecha.setText("Fecha de Nacimiento:");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        cbAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AAAA", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005" }));
        getContentPane().add(cbAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 90, 30));

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(cbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 90, 30));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        getContentPane().add(cbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 90, 30));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 290, 30));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, 30));

        tel.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        tel.setText("Número de Teléfono");
        getContentPane().add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        ced.setFont(new java.awt.Font("Nirmala UI", 1, 15)); // NOI18N
        ced.setText("Número de Cédula");
        getContentPane().add(ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
       String pDia = cbDia.getSelectedItem().toString();
       String pMes = cbMes.getSelectedItem().toString();
       String pAnio = cbAnio.getSelectedItem().toString();
       String nombre = txtNombre.getText();
       String apellido1 = txtApellido1.getText();
       String apellido2 = txtApellido2.getText();
       String identificacion = txtCedula.getText();
       String numTelefonico = txtTelefono.getText();
       String correo = txtCorreo.getText();
       ClienteCt cliente = new ClienteCt();
        try {
            JOptionPane.showMessageDialog(null,cliente.registrarCliente(apellido1, apellido2, nombre, identificacion,pDia,pMes,pAnio,numTelefonico,correo));
        } catch (ParseException ex) {
            Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        PaginaPrincipal ventana = new PaginaPrincipal();
        ventana.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_registrarActionPerformed

    private void txtApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2ActionPerformed

    private void txtApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1ActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        PaginaPrincipal abrir = new PaginaPrincipal();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido1;
    private javax.swing.JLabel apellido2;
    private javax.swing.JComboBox<String> cbAnio;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel ced;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel linea;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton registrar;
    private javax.swing.JLabel tel;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
