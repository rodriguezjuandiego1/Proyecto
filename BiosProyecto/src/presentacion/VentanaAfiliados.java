package presentacion;

import excepciones.ExcepcionCedulaNoEncontrada;
import excepciones.ExcepcionConsultaCedula;
import excepciones.ExcepcionInactivarAfiliado;
import excepciones.ExcepcionListarAfiliados;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Afiliado;
import logica.Afiliados;
import logica.Logica;

public class VentanaAfiliados extends javax.swing.JFrame {

    public VentanaAfiliados() {
        initComponents();

    }

    public void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

        
    public void cargarTabla() {

        model.setColumnCount(0);
        columnasTabla();
        limpiarTabla();
        try {
            Afiliados afiliados;
            afiliados = Logica.listadoAfiliadosActivos();
            String[] datosFilaTabla = new String[3];
            for (Afiliado afiliado : afiliados.getListaAfiliados()) {
                datosFilaTabla[0] = afiliado.getCedula();
                datosFilaTabla[1] = afiliado.getNombre();
                datosFilaTabla[2] = afiliado.getApellido();
                model.addRow(datosFilaTabla);
            }

        } catch ( ExcepcionListarAfiliados ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private DefaultTableModel columnasTabla() {
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonNuevo = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonDesafiliar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();
        botonTerminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        botonListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        botonNuevo.setBackground(new java.awt.Color(204, 255, 204));
        botonNuevo.setText("Nuevo Afiliado");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonEditar.setBackground(new java.awt.Color(255, 255, 204));
        botonEditar.setText("Editar Afiliado");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonDesafiliar.setBackground(new java.awt.Color(255, 204, 204));
        botonDesafiliar.setText("Desafiliar Afiliado");
        botonDesafiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesafiliarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar Cédula");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonRegresar.setText("< Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonTerminar.setText("X Terminar");
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        tabla.setModel(columnasTabla());
        cargarTabla();
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("AFILIADOS");

        jButton1.setText("Estado de Cuenta");

        jButton2.setText("Pagos");

        botonListar.setText("Listar Todos");
        botonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(botonNuevo)
                        .addGap(10, 10, 10)
                        .addComponent(botonEditar)
                        .addGap(6, 6, 6)
                        .addComponent(botonDesafiliar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)
                        .addComponent(jButton2)
                        .addGap(119, 119, 119)
                        .addComponent(botonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(botonTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonListar)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(botonNuevo))
                    .addComponent(botonEditar)
                    .addComponent(botonDesafiliar))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(botonListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(botonRegresar)
                    .addComponent(botonTerminar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "¿Cerrar aplicación?");
        if (x == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_botonTerminarActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
        VentanaPrincipal p = new VentanaPrincipal();
        p.setLocationRelativeTo(this);
        p.setVisible(true);

    }//GEN-LAST:event_botonRegresarActionPerformed


    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed

        if (campoBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un número de cédula");
        } else {

            Afiliado afiliadoBuscado = new Afiliado();
            Afiliado afiliadoEncontrado;
            String cedulaIngresada = campoBuscar.getText();
            afiliadoBuscado.setCedula(cedulaIngresada);
            try {
                afiliadoEncontrado = Logica.consultaAfiliadoPorCedula(afiliadoBuscado);
                limpiarTabla();
                String[] datos = new String[3];
                datos[0] = afiliadoEncontrado.getCedula();
                datos[1] = afiliadoEncontrado.getNombre();
                datos[2] = afiliadoEncontrado.getApellido();
                model.addRow(datos);
            } catch (ExcepcionConsultaCedula | ExcepcionCedulaNoEncontrada ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            campoBuscar.setText("");
        }


    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed

        VentanaAfiliadosAlta v = new VentanaAfiliadosAlta();
        v.setVisible(true);
        v.setLocationRelativeTo(this);
        v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed

        int registroSeleccionado = tabla.getSelectedRow();
        if (registroSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un afiliado para modificar sus datos");
        } else {
            String cedulaDelRegistroSeleccionado = (String) (model.getValueAt(registroSeleccionado, 0));
            Afiliado afiliadoBuscado = new Afiliado();
            afiliadoBuscado.setCedula(cedulaDelRegistroSeleccionado);
            Afiliado afiliadoEncontrado = null;
            try {
                afiliadoEncontrado = Logica.consultaAfiliadoPorCedula(afiliadoBuscado);
            } catch ( ExcepcionConsultaCedula | ExcepcionCedulaNoEncontrada ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            this.dispose();
            VentanaAfiliadosEditar ventanaEditar = new VentanaAfiliadosEditar();
            ventanaEditar.rellenarCampos(afiliadoEncontrado);
            ventanaEditar.setVisible(true);
            ventanaEditar.setLocationRelativeTo(this);
            ventanaEditar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonDesafiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesafiliarActionPerformed
        Afiliado afiliado = new Afiliado();
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un Afiliado de la lista");
        } else {
            String cedula = (String) model.getValueAt(fila, 0);
            String nombre = (String) model.getValueAt(fila, 1);
            String apellido = (String) model.getValueAt(fila, 2);
            afiliado.setCedula(cedula);

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma DESAFILIAR al siguiente afiliado?:\n "
                    + "CI = " + cedula + "\n"
                    + "Nombre = " + nombre + " " + apellido);
            String mensaje;
            if (respuesta == 0) {
                try {
                    mensaje = Logica.inactivarAfiliado(afiliado);
                    JOptionPane.showMessageDialog(null, mensaje);
                    limpiarTabla();
                    cargarTabla();
                } catch (ExcepcionInactivarAfiliado  ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_botonDesafiliarActionPerformed

    private void botonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_botonListarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAfiliados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAfiliados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAfiliados().setVisible(true);
            }
        });
    }

    static DefaultTableModel model = new DefaultTableModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonDesafiliar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonListar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
