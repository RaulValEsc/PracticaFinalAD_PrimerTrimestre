/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Articulos;

import Controlador.ControladorArticulos;
import Modelo.Articulos;
import Vista.Principal;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class vAnadirArticulos extends javax.swing.JDialog {
    DefaultTableModel modelo;

    ControladorArticulos ctrl = new ControladorArticulos();
    
    /**
     * Creates new form vAnadirArticulos
     */
    public vAnadirArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) tAnadirArticulos.getModel();
        rellenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tAnadirArticulos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        etReferencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        etDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        etPrecio = new javax.swing.JFormattedTextField();
        etIva = new javax.swing.JFormattedTextField();
        etStock = new javax.swing.JFormattedTextField();
        bCrear = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Artículo");
        setResizable(false);

        tAnadirArticulos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tAnadirArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Referencia", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tAnadirArticulos.setRowSelectionAllowed(false);
        tAnadirArticulos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tAnadirArticulos);
        if (tAnadirArticulos.getColumnModel().getColumnCount() > 0) {
            tAnadirArticulos.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setText("Referencia");

        etReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etReferenciaKeyTyped(evt);
            }
        });

        jLabel2.setText("Descripción");

        etDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                etDescripcionKeyTyped(evt);
            }
        });

        jLabel3.setText("Precio");

        jLabel4.setText("Iva (%)");

        jLabel5.setText("Stock");

        etPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        etIva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        etStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        bCrear.setText("Añadir");
        bCrear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etReferencia)
                            .addComponent(etDescripcion)
                            .addComponent(etPrecio)
                            .addComponent(etIva)
                            .addComponent(etStock, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(etReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(etDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(etIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(etStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCrear)
                    .addComponent(bCancelar))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void etReferenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etReferenciaKeyTyped
        char car = evt.getKeyChar();
        if (etReferencia.getText().length() == 13) {
            evt.consume();
            getToolkit().beep();
        } else {
            if (!Character.isDigit(car) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && !Character.isAlphabetic(car)) {
                evt.consume();
                getToolkit().beep();
            }
        }
    }//GEN-LAST:event_etReferenciaKeyTyped

    private void etDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etDescripcionKeyTyped
        char car = evt.getKeyChar();
        if (etDescripcion.getText().length() == 255) {
            evt.consume();
            getToolkit().beep();
        } else {
            if (!Character.isDigit(car) && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && !Character.isAlphabetic(car) && evt.getKeyCode() != KeyEvent.VK_SPACE) {
                evt.consume();
                getToolkit().beep();
            }
        }
    }//GEN-LAST:event_etDescripcionKeyTyped

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        if(!etReferencia.getText().isEmpty()||!etDescripcion.getText().isEmpty()||!etPrecio.getText().isEmpty()||!etIva.getText().isEmpty()||!etStock.getText().isEmpty()){
            String referencia = etReferencia.getText();
            String descripcion = etDescripcion.getText();
            BigDecimal precio = new BigDecimal(etPrecio.getText().replace(",", "."));
            BigDecimal iva = new BigDecimal(etIva.getText());
            BigDecimal stock = new BigDecimal(etStock.getText());
            Articulos a = new Articulos(referencia,descripcion,precio,iva,stock);
            if(ctrl.anadirArticulos(a)){
                Principal.listaArticulos.add(a);
                rellenarTabla();
            }else{
                getToolkit().beep();
                JOptionPane.showMessageDialog(this, "Error al añadir el artículo, comprueba que la referencia y la descripción sean únicas","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "No puede haber ningun campo vacío","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bCrearActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    public void rellenarTabla() {
        modelo.setRowCount(0);
        for (Articulos a : Principal.listaArticulos) {
            modelo.addRow(new Object[]{a.getReferencia(), a.getDescripcion()});
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
            java.util.logging.Logger.getLogger(vAnadirArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAnadirArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAnadirArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAnadirArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vAnadirArticulos dialog = new vAnadirArticulos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bCrear;
    private javax.swing.JTextField etDescripcion;
    private javax.swing.JFormattedTextField etIva;
    private javax.swing.JFormattedTextField etPrecio;
    private javax.swing.JTextField etReferencia;
    private javax.swing.JFormattedTextField etStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tAnadirArticulos;
    // End of variables declaration//GEN-END:variables
}