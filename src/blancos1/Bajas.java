/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blancos1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beeet
 */
public class Bajas extends javax.swing.JFrame {
    int idBaja, idCompra;
    String fechaBaja;
    float totalbaja, precio;
    int baja, existencia, piezas;
    Baja b;
    DetalleBaja db;
    Producto p;
    
    /**
     * Creates new form Bajas
     */
    public Bajas() {
        initComponents();
        precio = 0;
        totalbaja = 0;
        existencia = 0;
        piezas = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        txtFecha.setText(dtf.format(LocalDateTime.now()));
        txtId.setText(String.valueOf(Login.emp.getNextID("Bajas", "idBaja")));
        b = new Baja();
        db = new DetalleBaja();
        p = new Producto();
        txtIdProducto.setText("");
        txtPiezas.setText("");
        txtPiezas.setEnabled(false);
        txtMotivo.setText("");
        txtMotivo.setEnabled(false);
        lblTotalBaja.setText(String.valueOf("Total de baja: "+totalbaja));
        btnAddProducto.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void setProducto(int id){
        txtIdProducto.setText(String.valueOf(id));
        String descripcion;
        ResultSet rs = p.readProducto(txtIdProducto.getText());
        try{
            if(rs.next()){
                descripcion = rs.getString("descripcion");
                existencia = rs.getInt("existencia");

                if(existencia == 0 ){
                    btnAddProducto.setEnabled(false);
                }else{
                    txtPiezas.setEnabled(true);
                    txtMotivo.setEnabled(true);
                }
                lblDescripcion.setText(descripcion+" "+rs.getString("tamanio")+" "+rs.getString("color")+" $"+rs.getFloat("valorventa")+", "+rs.getString("existencia")+" Piezas");
            }else{
                lblDescripcion.setText("Producto no existente");
            }
        }catch(Exception exc){
            System.out.println("Error: "+exc);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdEmpleado = new javax.swing.JLabel();
        lblRegistrarBaja = new javax.swing.JLabel();
        lblTotalBaja = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        btnAddProducto = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        btncancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        txtPiezas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnBuscarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIdEmpleado.setText("Empleado:");

        lblRegistrarBaja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRegistrarBaja.setText("Registrar baja");

        lblTotalBaja.setText("Total:");

        jLabel7.setText("ID Baja:");

        jLabel1.setText("Motivo");

        txtId.setEnabled(false);

        txtMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMotivoKeyReleased(evt);
            }
        });

        btnAddProducto.setText("Añadir producto");
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });

        jLabel12.setText("ID producto");

        btnRegistrar.setText("Registrar Baja");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha de baja:");

        lblDescripcion.setText("Descripcion:");

        jLabel13.setText("Productos:");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Baja", "Producto", "Piezas", "Motivo", "Precio unitario", "subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        btnEliminar.setText("Eliminar producto seleccionado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(btnEliminar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addGap(6, 6, 6))
        );

        txtPiezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPiezasKeyReleased(evt);
            }
        });

        jLabel14.setText("Piezas:");

        btnBuscarProducto.setText("Buscar producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblRegistrarBaja)
                        .addGap(300, 300, 300)
                        .addComponent(lblIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFecha)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar)
                                .addGap(42, 42, 42)
                                .addComponent(btncancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(391, 391, 391)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAddProducto)
                                            .addGap(169, 169, 169))
                                        .addComponent(btnBuscarProducto)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistrarBaja)
                    .addComponent(lblIdEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPiezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarProducto)
                        .addComponent(btnAddProducto)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalBaja)
                    .addComponent(btnRegistrar)
                    .addComponent(btncancelar))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoKeyReleased
        
    }//GEN-LAST:event_txtMotivoKeyReleased

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        if(!lblDescripcion.getText().equals("Producto no existente") || !lblDescripcion.getText().equals("Descripcion")){
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            String motivo = txtMotivo.getText();
            String id = txtIdProducto.getText();
            String dsc = lblDescripcion.getText();
            String pz = txtPiezas.getText();
            float preciou =0;
            ResultSet rs = p.readProducto(id);
            try {
                    if(rs.next())
                    preciou = rs.getFloat("valorVenta");
            } catch (SQLException ex) {
                System.out.println("Error al agregar producto "+ ex);
            }
            String subtotal = String.valueOf(preciou * Float.parseFloat(txtPiezas.getText()));

            modelo.addRow(new Object[]{idBaja,id,pz,motivo,preciou, subtotal});
            totalbaja = totalbaja + Float.parseFloat(modelo.getValueAt(tblProductos.getRowCount()-1, 5).toString());
            txtIdProducto.setText("");
            txtPiezas.setText("");
            txtPiezas.setEnabled(false);
            txtMotivo.setText("");
            txtMotivo.setEnabled(false);
            lblTotalBaja.setText(String.valueOf("Total de baja: "+totalbaja));
            btnAddProducto.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        int i=0, filas = tblProductos.getRowCount();
        if(filas > 0){
            baja = Integer.parseInt(txtId.getText());
            b.createBaja(baja, Login.emp.id , txtFecha.getText());
            DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
            while(i < filas){
                int detalle = Login.emp.getNextID("DetalleBajas","idDetalleBaja");
                db.createDetalleBaja(detalle, baja ,Integer.parseInt(modelo.getValueAt(i, 1).toString()),Integer.parseInt(modelo.getValueAt(i, 2).toString()),modelo.getValueAt(i, 3).toString());
                
                i++;
            }
            JOptionPane.showMessageDialog(null, "Baja "+ baja +" registrada con "+i+" Productos y un total de $"+ totalbaja);
            p.updateInventario();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            txtFecha.setText(dtf.format(LocalDateTime.now()));
            totalbaja = 0;
            lblTotalBaja.setText(String.valueOf("Total: "+totalbaja));

            modelo.setRowCount(0);
        }else{
            JOptionPane.showMessageDialog(null, "La compra no tiene productos");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyReleased
        if(txtIdProducto.getText().isEmpty() == false){
            int idp = Integer.parseInt(txtIdProducto.getText());
            setProducto(idp);
            txtPiezas.setEnabled(true);
            txtMotivo.setEnabled(true);
        }else{
            txtPiezas.setEnabled(false);
            txtMotivo.setEnabled(false);
        }
    }//GEN-LAST:event_txtIdProductoKeyReleased

    private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros){
            evt.consume();
        }
    }//GEN-LAST:event_txtIdProductoKeyTyped

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        totalbaja = totalbaja - Float.parseFloat(tblProductos.getValueAt(tblProductos.getSelectedRow(), 4).toString());
        modelo.removeRow(tblProductos.getSelectedRow());

        lblTotalBaja.setText("Total venta: "+String.valueOf(totalbaja));
        btnEliminar.setEnabled(false);
        if(tblProductos.getRowCount() < 1)
        btnRegistrar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPiezasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPiezasKeyReleased
        if(txtPiezas.getText().isEmpty() == false){
            piezas = Integer.parseInt(txtPiezas.getText());
            if( piezas < 1 && txtMotivo.getText().isEmpty() == false){
                btnAddProducto.setEnabled(false);
            }else{
                btnAddProducto.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtPiezasKeyReleased

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        BuscarProducto bp = new BuscarProducto();
        bp.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(Bajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bajas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bajas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblIdEmpleado;
    private javax.swing.JLabel lblRegistrarBaja;
    private javax.swing.JLabel lblTotalBaja;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtPiezas;
    // End of variables declaration//GEN-END:variables
}