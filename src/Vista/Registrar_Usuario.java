/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author José Luis López
 */
public class Registrar_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_Usuario
     */
    public Registrar_Usuario() {
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

        Regresar = new javax.swing.JButton();
        Continuar = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        Confirmar_Correo = new javax.swing.JTextField();
        contraseña = new javax.swing.JTextField();
        confirmar_contraseña = new javax.swing.JTextField();
        Numero_Credito = new javax.swing.JTextField();
        Tipo_Membresia = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Membresia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        costo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 770));
        setPreferredSize(new java.awt.Dimension(1370, 770));
        getContentPane().setLayout(null);

        Regresar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Regresar.setText("Regresar");
        getContentPane().add(Regresar);
        Regresar.setBounds(150, 560, 150, 35);

        Continuar.setBackground(new java.awt.Color(102, 255, 102));
        Continuar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Continuar.setText("Registrar");
        getContentPane().add(Continuar);
        Continuar.setBounds(340, 560, 150, 35);

        usuario.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(usuario);
        usuario.setBounds(310, 180, 220, 30);

        correo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(correo);
        correo.setBounds(70, 250, 230, 30);

        Confirmar_Correo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Confirmar_Correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(Confirmar_Correo);
        Confirmar_Correo.setBounds(340, 250, 230, 30);

        contraseña.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        contraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(contraseña);
        contraseña.setBounds(70, 310, 230, 30);

        confirmar_contraseña.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        confirmar_contraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar_contraseña);
        confirmar_contraseña.setBounds(340, 310, 230, 30);

        Numero_Credito.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Numero_Credito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(Numero_Credito);
        Numero_Credito.setBounds(70, 440, 230, 30);

        Tipo_Membresia.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Tipo_Membresia.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Free", "Gold", "Premium", "Vip" }));
        Tipo_Membresia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tipo_Membresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tipo_MembresiaActionPerformed(evt);
                Precio_Costo(evt);
            }
        });
        getContentPane().add(Tipo_Membresia);
        Tipo_Membresia.setBounds(340, 440, 230, 30);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de usuario*");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 180, 130, 20);

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo electronico*");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 230, 130, 16);

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirmar correo electronico*");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 230, 200, 16);

        jLabel4.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña* ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 290, 90, 16);

        jLabel5.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirmar contraseña*");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(390, 290, 150, 16);

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Información del usuario");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(220, 120, 190, 30);

        Membresia.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        Membresia.setForeground(new java.awt.Color(255, 255, 255));
        Membresia.setText("Membresia ");
        getContentPane().add(Membresia);
        Membresia.setBounds(280, 370, 90, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Número de tarjeta de credito*");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(90, 410, 190, 20);

        jLabel10.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(430, 410, 40, 16);

        Precio.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        Precio.setForeground(new java.awt.Color(255, 255, 255));
        Precio.setText("Precio");
        getContentPane().add(Precio);
        Precio.setBounds(240, 500, 48, 22);

        costo.setBackground(new java.awt.Color(255, 0, 0));
        costo.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        costo.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(costo);
        costo.setBounds(340, 500, 80, 22);

        jLabel8.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registrar Usuario");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(240, 80, 140, 30);

        jLabel7.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Registrase.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmar_contraseñaActionPerformed

    private void Tipo_MembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tipo_MembresiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tipo_MembresiaActionPerformed

    private void Precio_Costo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Precio_Costo
        // TODO add your handling code here:
        String opcionSeleccionada = (String) Tipo_Membresia.getSelectedItem();
        switch (opcionSeleccionada) {
            case "Free":
                costo.setText("0.00");
                break;
            case "Gold":
                costo.setText("4.99");
                break;
            case "Premium":
                costo.setText("9.99");
                break;
            case "Vip":
                costo.setText("14.99");
                break;    
            default:
                break;
        }
    }//GEN-LAST:event_Precio_Costo

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
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Confirmar_Correo;
    public javax.swing.JButton Continuar;
    private javax.swing.JLabel Membresia;
    public javax.swing.JTextField Numero_Credito;
    private javax.swing.JLabel Precio;
    public javax.swing.JButton Regresar;
    public javax.swing.JComboBox<String> Tipo_Membresia;
    public javax.swing.JTextField confirmar_contraseña;
    public javax.swing.JTextField contraseña;
    public javax.swing.JTextField correo;
    public javax.swing.JLabel costo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
