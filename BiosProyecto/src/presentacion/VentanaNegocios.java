package presentacion;

import excepciones.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Logica;
import logica.Negocio;
import logica.Negocios;

public class VentanaNegocios extends javax.swing.JFrame {

    public VentanaNegocios() {
        initComponents();
        cargarTabla();
    }

    private void limpiarTabla() {
        while (tabla.getRowCount() > 0) {
            model.removeRow(0);
        }

    }

    private DefaultTableModel columnasTabla() {
        model.addColumn("Código");
        model.addColumn("Nombre");
        return model;
    }

    private void cargarTabla() {
        model.setColumnCount(2);
        limpiarTabla();
        Negocios negocios;
        try {
            Logica logica = new Logica();
            negocios = logica.listaNegocios();
            String[] datosFilaTabla = new String[2];
            for (Negocio negocio : negocios.getNegocios()) {
                datosFilaTabla[0] = negocio.getId();
                datosFilaTabla[1] = negocio.getNombre();
                model.addRow(datosFilaTabla);
            }
        } catch (ExcepcionNegocio | ExcepcionCerrarConexion | ExcepcionConectar ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonNuevoNegocio = new javax.swing.JButton();
        botonModificarNegocio = new javax.swing.JButton();
        botonBorrarNegocio = new javax.swing.JButton();
        botonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NEGOCIOS");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("NEGOCIOS");

        tabla.setModel(columnasTabla());
        jScrollPane1.setViewportView(tabla);

        botonNuevoNegocio.setBackground(new java.awt.Color(204, 255, 204));
        botonNuevoNegocio.setText("Nuevo");
        botonNuevoNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoNegocioActionPerformed(evt);
            }
        });

        botonModificarNegocio.setBackground(new java.awt.Color(255, 255, 204));
        botonModificarNegocio.setText("Modificar");
        botonModificarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarNegocioActionPerformed(evt);
            }
        });

        botonBorrarNegocio.setBackground(new java.awt.Color(255, 204, 204));
        botonBorrarNegocio.setText("Borrar");
        botonBorrarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarNegocioActionPerformed(evt);
            }
        });

        botonRegresar.setText("< Regresar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonRegresar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(botonNuevoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(botonModificarNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonBorrarNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevoNegocio)
                    .addComponent(botonModificarNegocio)
                    .addComponent(botonBorrarNegocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonRegresar)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoNegocioActionPerformed
        VentanaNegocioAlta v = new VentanaNegocioAlta();
        v.setVisible(true);
        v.setLocationRelativeTo(this);
        v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.dispose();

    }//GEN-LAST:event_botonNuevoNegocioActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        this.dispose();
        VentanaPrincipal p = new VentanaPrincipal();
        p.setLocationRelativeTo(this);
        p.setVisible(true);

    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonModificarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarNegocioActionPerformed
        Negocio negocio = new Negocio();
        int registroSeleccionado = tabla.getSelectedRow();
        if (registroSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un negocio para modificar su nombre");
        } else {
            negocio.setId((String) model.getValueAt(registroSeleccionado, 0));
            negocio.setNombre((String) model.getValueAt(registroSeleccionado, 1));
            VentanaNegocioEditar vne = new VentanaNegocioEditar();
            vne.cargaCampoTextoNombre(negocio);
            vne.setLocationRelativeTo(this);
            vne.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_botonModificarNegocioActionPerformed

    private void botonBorrarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarNegocioActionPerformed
        Negocio negocio = new Negocio();
        int registroSeleccionado = tabla.getSelectedRow();
        if (registroSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un negocio");
        } else {
            negocio.setId((String) model.getValueAt(registroSeleccionado, 0));
            negocio.setNombre((String) model.getValueAt(registroSeleccionado, 1));
            Logica logica = new Logica();
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma borrar el negocio seleccionado?");
            if (respuesta == 0) {
                try {
                    logica.borrarNegocio(negocio);
                    JOptionPane.showMessageDialog(null, "Negocio borrado exitosamente");
                    cargarTabla();
                } catch (ExcepcionConectar | ExcepcionCerrarConexion | ExcepcionBorrarNegocio ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_botonBorrarNegocioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaNegocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaNegocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaNegocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaNegocios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaNegocios().setVisible(true);
            }
        });
    }

    static DefaultTableModel model = new DefaultTableModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrarNegocio;
    private javax.swing.JButton botonModificarNegocio;
    private javax.swing.JButton botonNuevoNegocio;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
