/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import AccesoADatos.ComidaData;
import entidades.Comida;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo-PC
 */
public class viewAltaComida extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    ComidaData comidaData = new ComidaData();
    
    /**
     * Creates new form viewAltaComida
     */
    public viewAltaComida() {
        initComponents();
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        txtCantCalorias.setBorder(bordeInferior);
        txtNombreComida.setBorder(bordeInferior);
        txtModNombre.setBorder(bordeInferior);
        txtModCal.setBorder(bordeInferior);
        txtMaxCal.setBorder(bordeInferior);
        armarTabla();
        cargarTabla();
        filaSeleccionada();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreComida = new javax.swing.JTextField();
        txtCantCalorias = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAltaComida = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComidas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnEliminarComida = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtModNombre = new javax.swing.JTextField();
        txtModCal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnModificarComida = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtModDetalle = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtMaxCal = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(89, 116, 146));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Detalle");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad de Calorias");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txtNombreComida.setBackground(new java.awt.Color(89, 116, 146));
        txtNombreComida.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtNombreComida.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreComida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombreComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreComidaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 220, 40));

        txtCantCalorias.setBackground(new java.awt.Color(89, 116, 146));
        txtCantCalorias.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCantCalorias.setForeground(new java.awt.Color(0, 0, 0));
        txtCantCalorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtCantCalorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 2, 0, 630));

        btnAltaComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        btnAltaComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaComidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAltaComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 110, 60));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("gr.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 2, -1, 630));

        tblComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Calorias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblComidas);
        if (tblComidas.getColumnModel().getColumnCount() > 0) {
            tblComidas.getColumnModel().getColumn(0).setResizable(false);
            tblComidas.getColumnModel().getColumn(1).setResizable(false);
            tblComidas.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 280, 340));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Tabla de Comidas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 210, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 2, 0, 630));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 2, 10, 630));

        btnEliminarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Eliminar Comida.png"))); // NOI18N
        btnEliminarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 280, 60));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Cantidad de Calorias");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("gr.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 260, -1, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Detalle");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 330, -1, -1));

        txtModNombre.setBackground(new java.awt.Color(89, 116, 146));
        txtModNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtModNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtModNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtModNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, 190, 40));

        txtModCal.setBackground(new java.awt.Color(89, 116, 146));
        txtModCal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtModCal.setForeground(new java.awt.Color(0, 0, 0));
        txtModCal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtModCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 60, 40));

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Modificacion de Comidas");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, -1));

        btnModificarComida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modificar Comida.png"))); // NOI18N
        btnModificarComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarComidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 550, 310, 60));

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Alta de Comidas");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        txtDetalle.setColumns(18);
        txtDetalle.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtDetalle.setForeground(new java.awt.Color(0, 0, 0));
        txtDetalle.setRows(5);
        jScrollPane2.setViewportView(txtDetalle);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 310, 140));

        txtModDetalle.setColumns(18);
        txtModDetalle.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtModDetalle.setForeground(new java.awt.Color(0, 0, 0));
        txtModDetalle.setRows(5);
        jScrollPane3.setViewportView(txtModDetalle);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, 340, 140));

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Maximo de Calorias: ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        txtMaxCal.setBackground(new java.awt.Color(89, 116, 146));
        txtMaxCal.setForeground(new java.awt.Color(0, 0, 0));
        txtMaxCal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaxCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxCalActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaxCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 80, 40));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 90, 40));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 84, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filaSeleccionada(){
        tblComidas.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    int i = tblComidas.getSelectedRow();
                    if (i != -1){
                        String nombre = tblComidas.getValueAt(i, 1).toString();
                        String calorias = tblComidas.getValueAt(i, 2).toString();
                        String detalle = tblComidas.getValueAt(i, 3).toString();
                        cargarTexFields(nombre, calorias, detalle);
                    }
                }
            }
        });
    }
    
    private void txtNombreComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreComidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreComidaActionPerformed

    private void txtModNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModNombreActionPerformed

    private void btnAltaComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaComidaActionPerformed
        //Comprueba si contiene numeros.
        if (txtNombreComida.getText().matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null, "La casilla de NOMBRE no puede contener numeros.");
            txtNombreComida.setText("");
        
        
        }else if(txtNombreComida.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de NOMBRE no puede estar vacia.");
        
        //Comprueba que solo contenga numeros.
        }else if(!txtCantCalorias.getText().matches("\\d+") && !txtCantCalorias.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de Cant. de Calorias solo puede contener numeros enteros.");
            txtCantCalorias.setText("");
        }else{
            String nombre = txtNombreComida.getText();
            int calorias = Integer.parseInt(txtCantCalorias.getText());
            String detalle = txtDetalle.getText();
            Comida comida = new Comida(nombre, detalle, calorias);
            comidaData.altaComida(comida);
            txtNombreComida.setText("");
            txtDetalle.setText("");
            txtCantCalorias.setText("");
            cargarTabla();
            vaciarTextFields();
       }
    }//GEN-LAST:event_btnAltaComidaActionPerformed

    private void btnEliminarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarComidaActionPerformed
        if (tblComidas.getSelectedRow() != -1){
            comidaData.eliminarComida((int) modelo.getValueAt(tblComidas.getSelectedRow(), 0));
            cargarTabla();
            vaciarTextFields();
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una comida de la tabla");
        }
    }//GEN-LAST:event_btnEliminarComidaActionPerformed

    private void btnModificarComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarComidaActionPerformed
       Comida comida = new Comida(); 
       
       if (tblComidas.getSelectedRow() != -1){
           
           String nombre = txtModNombre.getText();
           String detalle = txtModDetalle.getText();
           int cal = Integer.parseInt(txtModCal.getText());
           int id = (int) tblComidas.getValueAt(tblComidas.getSelectedRow(), 0);
           comida.setIdComida(id);
           comida.setNombreComida(nombre);
           comida.setDetalle(detalle);
           comida.setCantCalorias(cal);
           comidaData.modificarComida(comida);
           cargarTabla();
           vaciarTextFields();
      }
    }//GEN-LAST:event_btnModificarComidaActionPerformed

    private void txtMaxCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxCalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxCalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtMaxCal.getText().matches("\\d+")){
            int cal = Integer.parseInt(txtMaxCal.getText());
            cargarTablaXCal(cal);
        }else{
            JOptionPane.showMessageDialog(null, "Ingreso no valido.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtMaxCal.setText("");
        cargarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cargarTablaXCal(int cal){
        ArrayList<Comida> comidas = new ArrayList<>();
        comidas.clear();
        comidas.addAll(comidaData.listarComidas());
        modelo.setRowCount(0);
        for (Comida c:comidas){
            if (c.getCantCalorias() <= cal){
                modelo.addRow(new Object[]{c.getIdComida(), c.getNombreComida(), c.getCantCalorias(), c.getDetalle()});
            }
        }  
    }
    
    private void armarTabla(){
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Calorias");
        modelo.addColumn("Detalle");
        tblComidas.setModel(modelo);
        tblComidas.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblComidas.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblComidas.getColumnModel().getColumn(2).setPreferredWidth(20);
        tblComidas.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    private void cargarTabla(){
        ArrayList<Comida> comidas = new ArrayList<>();
        comidas.clear();
        comidas.addAll(comidaData.listarComidas());
        modelo.setRowCount(0);
        for (Comida c:comidas){
            modelo.addRow(new Object[]{c.getIdComida(), c.getNombreComida(), c.getCantCalorias(), c.getDetalle()});
        }  
    }
    
    private void cargarTexFields(String nombre, String calorias, String detalle){
      txtModNombre.setText(nombre);
      txtModDetalle.setText(detalle);
      txtModCal.setText(calorias); 
    }
    
    private void vaciarTextFields(){
        txtModCal.setText("");
        txtModDetalle.setText("");
        txtModNombre.setText("");
        txtMaxCal.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaComida;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarComida;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarComida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tblComidas;
    private javax.swing.JTextField txtCantCalorias;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtMaxCal;
    private javax.swing.JTextField txtModCal;
    private javax.swing.JTextArea txtModDetalle;
    private javax.swing.JTextField txtModNombre;
    private javax.swing.JTextField txtNombreComida;
    // End of variables declaration//GEN-END:variables
}
