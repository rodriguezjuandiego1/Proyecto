package presentacion;

import excepciones.ExcepcionAfiliado;
import excepciones.ExcepcionInsertarAfiliacion;
import excepciones.ExcepcionInsertarAfiliado;
import excepciones.ExcepcionNegocio;
import javax.swing.JOptionPane;
import logica.Afiliacion;
import logica.Afiliado;
import logica.Logica;
import logica.Negocio;

public class VentanaAfiliadosEditar extends javax.swing.JFrame {
    
    public VentanaAfiliadosEditar() {
        initComponents();
    }
    
    public static void cargarCampoNegocio(String nombreNegocio) {
        campoNegocio.setText(nombreNegocio);
    }
    
    public void rellenarCampos(Afiliado afiliado) {
        campoCedula.setText(afiliado.getCedula());
        campoNombre.setText(afiliado.getNombre());
        campoApellido.setText(afiliado.getApellido());
        campoNacionalidad.setText(afiliado.getNacionalidad());
        campoDireccion.setText(afiliado.getDireccion());
        campoTelefono.setText(afiliado.getTelefono());
        campoMail.setText(afiliado.getEmail());
        dateChooserNacimiento.setDate(afiliado.getNacimiento());
        Negocio negocioBuscado = new Negocio();
        negocioBuscado.setId(afiliado.getNegocio());
        Negocio negocioEncontrado = new Negocio();
        try {
            negocioEncontrado = Logica.consultarNegocioPorId(negocioBuscado);
        } catch (ExcepcionNegocio ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        campoNegocio.setText(negocioEncontrado.getNombre());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoDireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        campoApellido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoMail = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        dateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        campoNacionalidad = new javax.swing.JTextField();
        campoNegocio = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        campoCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonCambiarNegocio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        campoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Nacionalidad");

        jLabel6.setText("Dirección");

        jLabel7.setText("Teléfono");

        jLabel8.setText("Email");

        jLabel9.setText("Nacimiento");

        jLabel10.setText("Negocio");

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });

        campoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoApellidoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Editar Afiliado");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        campoMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMailActionPerformed(evt);
            }
        });

        campoTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefonoActionPerformed(evt);
            }
        });

        campoNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNacionalidadActionPerformed(evt);
            }
        });

        campoNegocio.setEditable(false);
        campoNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNegocioActionPerformed(evt);
            }
        });

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        campoCedula.setEditable(false);
        campoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCedulaActionPerformed(evt);
            }
        });

        jLabel2.setText("Cédula");

        botonRegresar.setText("< Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonCambiarNegocio.setText("Cambiar Negocio");
        botonCambiarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarNegocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateChooserNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoNegocio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addComponent(botonCambiarNegocio))
                            .addComponent(campoMail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(botonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(campoMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(dateChooserNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(botonCambiarNegocio))
                .addGap(28, 28, 28)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(botonRegresar)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidoActionPerformed

    private void campoMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMailActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void campoNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNacionalidadActionPerformed

    private void campoNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNegocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNegocioActionPerformed

    private void campoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
        VentanaAfiliados va = new VentanaAfiliados();
        va.setLocationRelativeTo(this);
        va.setVisible(true);
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        try {
            Afiliado afiliado = new Afiliado();
            afiliado.setCedula(campoCedula.getText());
            afiliado.setNombre(campoNombre.getText());
            afiliado.setApellido(campoApellido.getText());
            afiliado.setNacionalidad(campoNacionalidad.getText());
            afiliado.setDireccion(campoDireccion.getText());
            afiliado.setTelefono(campoTelefono.getText());
            afiliado.setEmail(campoMail.getText());
            java.util.Date nacimiento = dateChooserNacimiento.getDate();
            //try {
            long milisegundos = nacimiento.getTime();
            java.sql.Date nacimiento2 = new java.sql.Date(milisegundos);
            afiliado.setNacimiento(nacimiento2);
//        } catch (NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "Seleccione una fecha de nacimiento");
//        }
            Negocio negocio = new Negocio();
            negocio.setNombre(campoNegocio.getText());
            Negocio negocioEncontrado = new Negocio();
            //try {
            negocioEncontrado = Logica.consultarNegocioPorNombre(negocio);
//        } catch (ExcepcionNegocio ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
            afiliado.setNegocio(negocioEncontrado.getId());
            //afiliado.setEstado("activo");

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma modificaciones?");
            if (respuesta == 0) {
                try {
                    Logica.editarAfiliado(afiliado);
                    JOptionPane.showMessageDialog(this, "Modificación realizada con éxito");
                } catch (ExcepcionAfiliado e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Verifique que todos los campos están completos correctamente");
        }
        

    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCambiarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarNegocioActionPerformed
        VentanaAfiliadoEditarListaNegocios v = new VentanaAfiliadoEditarListaNegocios();
        v.setLocationRelativeTo(this);
        v.setVisible(true);
    }//GEN-LAST:event_botonCambiarNegocioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAfiliadosEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAfiliadosEditar().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCambiarNegocio;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoMail;
    private javax.swing.JTextField campoNacionalidad;
    private static javax.swing.JTextField campoNegocio;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private com.toedter.calendar.JDateChooser dateChooserNacimiento;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
