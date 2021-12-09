/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturas;

import Controlador.ControladorFacturas;
import Modelo.FacturasCab;
import Vista.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class vFacturas extends javax.swing.JDialog {

    ControladorFacturas ctrl = new ControladorFacturas();
    DefaultTableModel modelo;

    public static FacturasCab cabecera;

    /**
     * Creates new form vFacturas
     */
    public vFacturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tFacturas.getModel();
        rellenarTabla(Principal.listaFacturas);
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
        bCrear = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        bBorrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        bConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFacturas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        etFiltroFacturas = new javax.swing.JTextField();
        cbFiltroFacturas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Facturas");
        setResizable(false);

        jToolBar1.setFloatable(false);

        bCrear.setText("Crear");
        bCrear.setFocusable(false);
        bCrear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bCrear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });
        jToolBar1.add(bCrear);
        jToolBar1.add(jSeparator1);

        bBorrar.setText("Borrar");
        bBorrar.setFocusable(false);
        bBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });
        jToolBar1.add(bBorrar);
        jToolBar1.add(jSeparator2);

        bConsultar.setText("Consultar");
        bConsultar.setFocusable(false);
        bConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });
        jToolBar1.add(bConsultar);

        tFacturas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha", "DNI/CIF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tFacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tFacturas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tFacturas);
        if (tFacturas.getColumnModel().getColumnCount() > 0) {
            tFacturas.getColumnModel().getColumn(0).setResizable(false);
            tFacturas.getColumnModel().getColumn(1).setResizable(false);
            tFacturas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FACTURAS");

        etFiltroFacturas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                etFiltroFacturasFocusGained(evt);
            }
        });
        etFiltroFacturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etFiltroFacturasKeyTyped(evt);
            }
        });

        cbFiltroFacturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Número", "Cliente" }));
        cbFiltroFacturas.setToolTipText("");
        cbFiltroFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroFacturasActionPerformed(evt);
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
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(341, 341, 341))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        vCrearFacturas v = new vCrearFacturas(null, true);
        this.setVisible(false);
        v.setVisible(true);
        rellenarTabla(Principal.listaFacturas);
        this.setVisible(true);
    }//GEN-LAST:event_bCrearActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        if (tFacturas.getSelectedRow() != -1) {
            FacturasCab a = (FacturasCab) tFacturas.getValueAt(tFacturas.getSelectedRow(), 0);
            if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea borrar la factura?", "Confirme la operación", JOptionPane.OK_CANCEL_OPTION) == 0) {
                if (ctrl.borrarCabecera(a)) {
                    for (FacturasCab a1 : Principal.listaFacturas) {
                        if (a1.getNumfac() == a.getNumfac()) {
                            Principal.listaFacturas.remove(a1);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al borrar la factura", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            rellenarTabla(Principal.listaFacturas);
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Selecciona una factura para borrar");
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    private void etFiltroFacturasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etFiltroFacturasFocusGained
        if (etFiltroFacturas.getText().isEmpty()) {
            rellenarTabla(Principal.listaFacturas);
        } else {
            rellenarTabla(ctrl.filtrarFacturas(Principal.listaFacturas, cbFiltroFacturas.getSelectedIndex(), etFiltroFacturas.getText()));
        }
    }//GEN-LAST:event_etFiltroFacturasFocusGained

    private void etFiltroFacturasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etFiltroFacturasKeyTyped
        cbFiltroFacturas.requestFocus();
        etFiltroFacturas.requestFocus();
    }//GEN-LAST:event_etFiltroFacturasKeyTyped

    private void cbFiltroFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroFacturasActionPerformed
        if (!etFiltroFacturas.getText().isEmpty()) {
            rellenarTabla(ctrl.filtrarFacturas(Principal.listaFacturas, cbFiltroFacturas.getSelectedIndex(), etFiltroFacturas.getText()));
        }
    }//GEN-LAST:event_cbFiltroFacturasActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        if (tFacturas.getSelectedRow() != -1) {
            cabecera = (FacturasCab) tFacturas.getValueAt(tFacturas.getSelectedRow(), 0);
            VConsultaFacturas v = new VConsultaFacturas(null, true);
            this.setVisible(false);
            v.setVisible(true);
            this.setVisible(true);
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Selecciona una factura para consultar");
        }
    }//GEN-LAST:event_bConsultarActionPerformed

    private void rellenarTabla(List<FacturasCab> lista) {
        modelo.setRowCount(0);
        for (FacturasCab a : lista) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            modelo.addRow(new Object[]{a, format.format(a.getFechafac()), a.getClientes().getDnicif()});
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
            java.util.logging.Logger.getLogger(vFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vFacturas dialog = new vFacturas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bCrear;
    private javax.swing.JComboBox<String> cbFiltroFacturas;
    private javax.swing.JTextField etFiltroFacturas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tFacturas;
    // End of variables declaration//GEN-END:variables
}
