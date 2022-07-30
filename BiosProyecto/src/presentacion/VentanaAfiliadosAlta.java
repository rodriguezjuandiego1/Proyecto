package presentacion;

import excepciones.ExcepcionInsertarAfiliacion;
import excepciones.ExcepcionInsertarAfiliado;
import javax.swing.JOptionPane;
import logica.Afiliacion;
import logica.Afiliado;
import logica.Logica;
import logica.Negocio;

public class VentanaAfiliadosAlta extends javax.swing.JFrame {

    public VentanaAfiliadosAlta() {
        initComponents();

    }

    public static void cargarCampoNegocio(String nombreNegocio) {
        campoNegocio.setText(nombreNegocio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        campoDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoCedula = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoApellido = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        dateChooserNacimiento = new com.toedter.calendar.JDateChooser();
        campoNacionalidad = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonAgregarNegocio = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        dateChooserFecha = new com.toedter.calendar.JDateChooser();
        dateChooserFecha.setDate(new java.util.Date());
        campoNegocio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        campoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Cédula");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Nacionalidad");

        jLabel6.setText("Dirección");

        jLabel7.setText("Teléfono");

        jLabel8.setText("Email");

        jLabel9.setText("Nacimiento");

        jLabel10.setText("Negocio");

        campoCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCedulaActionPerformed(evt);
            }
        });

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

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Nueva Afiliación");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
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

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRegresar.setText("< Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonAgregarNegocio.setText("Elegir Negocio");
        botonAgregarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarNegocioActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha");

        campoNegocio.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateChooserNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoNegocio)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonAgregarNegocio)
                                        .addGap(21, 21, 21))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(botonAceptar)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(dateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
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
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(dateChooserNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(campoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonAgregarNegocio))
                .addGap(19, 19, 19)
                .addComponent(botonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(botonRegresar)
                .addContainerGap())
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

    private void campoCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCedulaActionPerformed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoApellidoActionPerformed

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelefonoActionPerformed

    private void campoNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNacionalidadActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
        VentanaAfiliados va = new VentanaAfiliados();
        va.setLocationRelativeTo(this);
        va.setVisible(true);

    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonAgregarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarNegocioActionPerformed
        VentanaAfiliadoAltaListaNegocios vnl = new VentanaAfiliadoAltaListaNegocios();
        vnl.setLocationRelativeTo(this);
        vnl.setVisible(true);

    }//GEN-LAST:event_botonAgregarNegocioActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        try {
            Afiliado afiliado = new Afiliado();
            afiliado.setCedula(campoCedula.getText());
            afiliado.setNombre(campoNombre.getText());
            afiliado.setApellido(campoApellido.getText());
            afiliado.setNacionalidad(campoNacionalidad.getText());
            afiliado.setDireccion(campoDireccion.getText());
            afiliado.setTelefono(campoTelefono.getText());
            afiliado.setEmail(campoEmail.getText());
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
            afiliado.setEstado("activo");

            Afiliacion afiliacion = new Afiliacion();
            java.util.Date fecha = dateChooserFecha.getDate();
            long fechaEnMilisegundos = fecha.getTime();
            java.sql.Date fecha2 = new java.sql.Date(fechaEnMilisegundos);
            afiliacion.setFecha(fecha2);
            afiliacion.setCedula(campoCedula.getText());

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma la afiliación?");
            if (respuesta == 0) {
                try {
                    Logica.insertarAfiliado(afiliado);
                    Logica.insertarAfiliacion(afiliacion);
                    JOptionPane.showMessageDialog(null, "Afiliación realizada con éxito");
                    this.dispose();
                    VentanaAfiliados va = new VentanaAfiliados();
                    va.setLocationRelativeTo(this);
                    va.setVisible(true);
                } catch (ExcepcionInsertarAfiliacion | ExcepcionInsertarAfiliado ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos correctamente");
        }


    }//GEN-LAST:event_botonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAfiliadosAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliadosAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAfiliadosAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarNegocio;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNacionalidad;
    private static javax.swing.JTextField campoNegocio;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private com.toedter.calendar.JDateChooser dateChooserFecha;
    private com.toedter.calendar.JDateChooser dateChooserNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
