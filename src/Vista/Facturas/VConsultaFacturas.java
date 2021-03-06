/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturas;

import Controlador.ControladorFacturas;
import Modelo.FacturasCab;
import Modelo.FacturasLin;
import Modelo.FacturasTot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class VConsultaFacturas extends javax.swing.JDialog {

    DefaultTableModel modeloCabecera, modeloLineas, modeloTotal;
    FacturasCab cabecera = vFacturas.cabecera;
    ControladorFacturas ctrl = new ControladorFacturas();

    /**
     * Creates new form VConsultaFacturas
     */
    public VConsultaFacturas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        modeloCabecera = (DefaultTableModel) tCabecera.getModel();
        modeloLineas = (DefaultTableModel) tLineas.getModel();
        modeloTotal = (DefaultTableModel) tTotal.getModel();
        rellenarCabecera();
        rellenarTotal();
        rellenarLineas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tTotal = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCabecera = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tLineas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        bExportar = new javax.swing.JButton();
        cbFormato = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Factura");

        tTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Base", "Descuento", "Iva", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tTotal.setEnabled(false);
        tTotal.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tTotal);

        jLabel3.setText("Total de la factura:");

        tCabecera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tCabecera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Fecha", "DNI/CIF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tCabecera.setEnabled(false);
        tCabecera.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tCabecera);

        jLabel1.setText("Factura Actual:");

        tLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N??mero", "L??nea", "Referencia", "Cantidad", "Precio", "Descuento", "Iva"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tLineas.setRowSelectionAllowed(false);
        tLineas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tLineas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tLineas);

        jLabel2.setText("L??neas de la factura:");

        bExportar.setText("Exportar");
        bExportar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportarActionPerformed(evt);
            }
        });

        cbFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XML", "JSON" }));
        cbFormato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cbFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExportar)
                    .addComponent(cbFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarActionPerformed
        if (cbFormato.getSelectedIndex() == 1) {
            String json = ctrl.generarJSON(cabecera);
            JOptionPane.showMessageDialog(this, "Selecciona la carpeta donde quieres exportar la factura");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                try {
                    File f = jfc.getSelectedFile();
                    String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre del fichero", JOptionPane.INFORMATION_MESSAGE);
                    FileWriter f1 = new FileWriter(f.getAbsolutePath() + "\\" + nombre + ".json");
                    f1.write(json);
                    f1.flush();
                    f1.close();
                } catch (IOException ex) {
                    Logger.getLogger(VConsultaFacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {

            JOptionPane.showMessageDialog(this, "Selecciona la carpeta donde quieres exportar la factura");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = jfc.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File f = jfc.getSelectedFile();
                String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre del fichero", JOptionPane.INFORMATION_MESSAGE);
                String ruta = f.getAbsolutePath() + "\\" + nombre + ".xml";
                ctrl.generarXML(cabecera, ruta);
            }
        }
    }//GEN-LAST:event_bExportarActionPerformed

    private void rellenarCabecera() {
        modeloCabecera.setRowCount(0);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        modeloCabecera.addRow(new Object[]{cabecera, format.format(cabecera.getFechafac()), cabecera.getClientes().getDnicif()});
    }

    private void rellenarLineas() {
        modeloLineas.setRowCount(0);
        Iterator i = cabecera.getFacturasLins().iterator();
        while (i.hasNext()) {
            FacturasLin fl = (FacturasLin) i.next();
            Object[] datos = new Object[7];
            datos[0] = fl;
            datos[1] = fl.getId().getLineafac();
            datos[2] = fl.getArticulos().getReferencia();
            datos[3] = fl.getCantidad();
            datos[4] = fl.getPrecio();
            datos[5] = fl.getDtolinea();
            datos[6] = fl.getIvalinea();
            modeloLineas.addRow(datos);
        }
    }

    private void rellenarTotal() {
        modeloTotal.setRowCount(0);
        FacturasTot facturaTotal = cabecera.getFacturasTot();
        modeloTotal.addRow(new Object[]{facturaTotal.getFacturasCab().getNumfac(), facturaTotal.getBaseimp(), facturaTotal.getImpDto(), facturaTotal.getImpIva(), facturaTotal.getTotalfac()});
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
            java.util.logging.Logger.getLogger(VConsultaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VConsultaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VConsultaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VConsultaFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VConsultaFacturas dialog = new VConsultaFacturas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bExportar;
    private javax.swing.JComboBox<String> cbFormato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tCabecera;
    private javax.swing.JTable tLineas;
    private javax.swing.JTable tTotal;
    // End of variables declaration//GEN-END:variables
}
