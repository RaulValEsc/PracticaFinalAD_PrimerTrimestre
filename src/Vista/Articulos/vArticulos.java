/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Articulos;

import Controlador.ControladorArticulos;
import Modelo.Articulos;
import Vista.Principal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raulv
 */
public class vArticulos extends javax.swing.JDialog {

    ControladorArticulos ctrlA = new ControladorArticulos();

    DefaultTableModel modelo;

    public static String referencia, descripcion, precio, iva, stock;

    /**
     * Creates new form vArticulos
     */
    public vArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tArticulos.getModel();
        rellenarTabla(Principal.listaArticulos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        bAnadirArticulos = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bBorrarArticulos = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bModificarArticulos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tArticulos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        etFiltroArticulos = new javax.swing.JTextField();
        cbFiltroArticulos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de Artículos");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jToolBar1.setFloatable(false);

        bAnadirArticulos.setText("Añadir");
        bAnadirArticulos.setFocusable(false);
        bAnadirArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAnadirArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bAnadirArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirArticulosActionPerformed(evt);
            }
        });
        jToolBar1.add(bAnadirArticulos);
        jToolBar1.add(jSeparator2);

        bBorrarArticulos.setText("Borrar");
        bBorrarArticulos.setFocusable(false);
        bBorrarArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBorrarArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bBorrarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarArticulosActionPerformed(evt);
            }
        });
        jToolBar1.add(bBorrarArticulos);
        jToolBar1.add(jSeparator1);

        bModificarArticulos.setText("Modificar");
        bModificarArticulos.setFocusable(false);
        bModificarArticulos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bModificarArticulos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bModificarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarArticulosActionPerformed(evt);
            }
        });
        jToolBar1.add(bModificarArticulos);

        tArticulos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Descripción", "Precio", "Iva", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tArticulos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tArticulos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tArticulos);
        if (tArticulos.getColumnModel().getColumnCount() > 0) {
            tArticulos.getColumnModel().getColumn(0).setResizable(false);
            tArticulos.getColumnModel().getColumn(1).setResizable(false);
            tArticulos.getColumnModel().getColumn(2).setResizable(false);
            tArticulos.getColumnModel().getColumn(3).setResizable(false);
            tArticulos.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ARTICULOS");

        etFiltroArticulos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                etFiltroArticulosFocusGained(evt);
            }
        });
        etFiltroArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etFiltroArticulosKeyTyped(evt);
            }
        });

        cbFiltroArticulos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Referencia", "Descripción" }));
        cbFiltroArticulos.setToolTipText("");
        cbFiltroArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroArticulosActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Filtro : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cbFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnadirArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirArticulosActionPerformed
        vAnadirArticulos v = new vAnadirArticulos(null, true);
        this.setVisible(false);
        v.setVisible(true);
        this.setVisible(true);
        rellenarTabla(Principal.listaArticulos);
    }//GEN-LAST:event_bAnadirArticulosActionPerformed

    private void bBorrarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarArticulosActionPerformed
        if (tArticulos.getSelectedRow() != -1) {
            Articulos a = (Articulos) tArticulos.getValueAt(tArticulos.getSelectedRow(), 0);
            if (JOptionPane.showConfirmDialog(this, "Está seguro que desea borrar el artículo: " + a.getReferencia(), "Confirme la operación", JOptionPane.OK_CANCEL_OPTION) == 0) {
                if (ctrlA.borrarArticulos(a)) {
                    for (Articulos a1 : Principal.listaArticulos) {
                        if (a1.getReferencia() == a.getReferencia()) {
                            Principal.listaArticulos.remove(a1);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al borrar el artículo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            rellenarTabla(Principal.listaArticulos);
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Selecciona un artículo para borrar");
        }
    }//GEN-LAST:event_bBorrarArticulosActionPerformed

    private void bModificarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarArticulosActionPerformed
        if (tArticulos.getSelectedRow() != -1) {
            Articulos a = (Articulos) tArticulos.getValueAt(tArticulos.getSelectedRow(), 0);
            referencia = a.getReferencia();
            descripcion = a.getDescripcion();
            precio = a.getPrecio().toString();
            iva = a.getPorciva().toString();
            stock = a.getStock().toString();
            vModificarArticulos v = new vModificarArticulos(null, true);
            this.setVisible(false);
            v.setVisible(true);
            this.setVisible(true);
            rellenarTabla(Principal.listaArticulos);
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Selecciona un artículo para modificar");
        }
    }//GEN-LAST:event_bModificarArticulosActionPerformed

    private void cbFiltroArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroArticulosActionPerformed
        if (!etFiltroArticulos.getText().isEmpty()) {
            rellenarTabla(ctrlA.filtrarArticulos(Principal.listaArticulos, cbFiltroArticulos.getSelectedIndex(), etFiltroArticulos.getText()));
        }
    }//GEN-LAST:event_cbFiltroArticulosActionPerformed

    private void etFiltroArticulosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etFiltroArticulosKeyTyped
        cbFiltroArticulos.requestFocus();
        etFiltroArticulos.requestFocus();
    }//GEN-LAST:event_etFiltroArticulosKeyTyped

    private void etFiltroArticulosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etFiltroArticulosFocusGained
        if (etFiltroArticulos.getText().isEmpty()) {
            rellenarTabla(Principal.listaArticulos);
        } else {
            rellenarTabla(ctrlA.filtrarArticulos(Principal.listaArticulos, cbFiltroArticulos.getSelectedIndex(), etFiltroArticulos.getText()));
        }
    }//GEN-LAST:event_etFiltroArticulosFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        rellenarTabla(Principal.listaArticulos);
    }//GEN-LAST:event_formWindowGainedFocus

    private void rellenarTabla(List<Articulos> lista) {
        modelo.setRowCount(0);
        for (Articulos a : lista) {
            modelo.addRow(new Object[]{a, a.getDescripcion(), a.getPrecio(), a.getPorciva(), a.getStock()});
        }
    }

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
            java.util.logging.Logger.getLogger(vArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vArticulos dialog = new vArticulos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnadirArticulos;
    private javax.swing.JButton bBorrarArticulos;
    private javax.swing.JButton bModificarArticulos;
    private javax.swing.JComboBox<String> cbFiltroArticulos;
    private javax.swing.JTextField etFiltroArticulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tArticulos;
    // End of variables declaration//GEN-END:variables
}
