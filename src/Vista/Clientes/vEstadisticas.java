/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Clientes;

import Controlador.ControladorClientes;
import Modelo.EstadisticasClientes;
import Vista.Principal;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class vEstadisticas extends javax.swing.JDialog {

    ControladorClientes ctrlC = new ControladorClientes();
    
    DefaultTableModel modelo;
    
    /**
     * Creates new form vEstadisticas
     */
    public vEstadisticas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tEstadisticas.getModel();
        rellenarTabla(Principal.listaEstadisticas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbFiltroEstadisticas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEstadisticas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        etFiltroEstadisticas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bGenerarEstadisticas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Estadísticas");

        cbFiltroEstadisticas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "DNI/CIF" }));
        cbFiltroEstadisticas.setToolTipText("");
        cbFiltroEstadisticas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbFiltroEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltroEstadisticasActionPerformed(evt);
            }
        });

        tEstadisticas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tEstadisticas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Año", "Número Mes", "Mes", "DNI/CIF", "Nombre", "Suma base", "Suma Descuentos", "Suma Iva", "Suma Totales"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tEstadisticas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tEstadisticas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tEstadisticas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ESTADISTICAS");

        etFiltroEstadisticas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        etFiltroEstadisticas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                etFiltroEstadisticasFocusGained(evt);
            }
        });
        etFiltroEstadisticas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etFiltroEstadisticasKeyTyped(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Filtro : ");

        bGenerarEstadisticas.setText("Generar Estadísticas nuevas");
        bGenerarEstadisticas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bGenerarEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarEstadisticasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bGenerarEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(etFiltroEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cbFiltroEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel1)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etFiltroEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltroEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(bGenerarEstadisticas)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbFiltroEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltroEstadisticasActionPerformed
        if (!etFiltroEstadisticas.getText().isEmpty()) {
            rellenarTabla(ctrlC.filtrarEstadisticas(Principal.listaEstadisticas, cbFiltroEstadisticas.getSelectedIndex(), etFiltroEstadisticas.getText()));
        }
    }//GEN-LAST:event_cbFiltroEstadisticasActionPerformed

    private void etFiltroEstadisticasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_etFiltroEstadisticasFocusGained
        if (etFiltroEstadisticas.getText().isEmpty()) {
            rellenarTabla(Principal.listaEstadisticas);
        } else {
            rellenarTabla(ctrlC.filtrarEstadisticas(Principal.listaEstadisticas, cbFiltroEstadisticas.getSelectedIndex(), etFiltroEstadisticas.getText()));
        }
    }//GEN-LAST:event_etFiltroEstadisticasFocusGained

    private void etFiltroEstadisticasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etFiltroEstadisticasKeyTyped
        cbFiltroEstadisticas.requestFocus();
        etFiltroEstadisticas.requestFocus();
    }//GEN-LAST:event_etFiltroEstadisticasKeyTyped

    private void bGenerarEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarEstadisticasActionPerformed
        vGenerarEstadisticas v = new vGenerarEstadisticas(null, true);
        this.setVisible(false);
        v.setVisible(true);
        this.setVisible(true);
    }//GEN-LAST:event_bGenerarEstadisticasActionPerformed

    private void rellenarTabla(List<EstadisticasClientes> lista) {
        modelo.setRowCount(0);
        for (EstadisticasClientes c : lista) {
            modelo.addRow(new Object[]{c, c.getId().getMesNum(),c.getMesNom(),c.getId().getDnicif(),c.getNombrecli(),c.getSumaBase(),c.getSumaDtos(),c.getSumaIva(),c.getSumaTotales()});
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
            java.util.logging.Logger.getLogger(vEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vEstadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vEstadisticas dialog = new vEstadisticas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bGenerarEstadisticas;
    private javax.swing.JComboBox<String> cbFiltroEstadisticas;
    private javax.swing.JTextField etFiltroEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tEstadisticas;
    // End of variables declaration//GEN-END:variables
}
