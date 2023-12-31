/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import AccesoADatos.PacienteData;
import AccesoADatos.RegistroPesoData;
import entidades.Paciente;
import entidades.PacientesServices;
import entidades.RegistroPeso;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

public class viewAltaPaciente extends javax.swing.JPanel {
    
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) { 
            return false;
        }   
        
    };
    PacientesServices paciS = new PacientesServices();
    PacienteData paciD = new PacienteData();
    ArrayList<Paciente> pacientes = new ArrayList<>();
    RegistroPesoData registroData = new RegistroPesoData();
    
    viewRegistroPacientes vR;
    /**
     * Creates new form viewAltaPacientes
     */
    public viewAltaPaciente() {
        initComponents();
        this.setSize(1280, 630);
        
        Border bordeInferior = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK);
        txtNombre.setBorder(bordeInferior);
        txtDni.setBorder(bordeInferior);
        txtTel.setBorder(bordeInferior);
        txtDomicilio.setBorder(bordeInferior);
        txtPesoA.setBorder(bordeInferior);
        txtPesoD.setBorder(bordeInferior);
        txtModPesoA.setBorder(bordeInferior);
        txtModPesoD.setBorder(bordeInferior);
        btnRegistro.setEnabled(false);
        armarTabla();
        cargarTabla();
        habilitarButton();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        btnAltaPaciente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPesoA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPesoD = new javax.swing.JTextField();
        btnModificarP = new javax.swing.JButton();
        btnEliminarPaciente = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        txtModPesoA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtModPesoD = new javax.swing.JTextField();

        setBackground(new java.awt.Color(89, 116, 146));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Peso Actual");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 120, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtNombre.setBackground(new java.awt.Color(89, 116, 146));
        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, 40));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DNI");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Domicilio");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        txtDomicilio.setBackground(new java.awt.Color(89, 116, 146));
        txtDomicilio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDomicilio.setForeground(new java.awt.Color(0, 0, 0));
        txtDomicilio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });
        add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 260, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 80, -1));

        txtTel.setBackground(new java.awt.Color(89, 116, 146));
        txtTel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTel.setForeground(new java.awt.Color(0, 0, 0));
        txtTel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 260, 40));

        btnAltaPaciente.setBackground(new java.awt.Color(0, 153, 204));
        btnAltaPaciente.setForeground(new java.awt.Color(0, 0, 0));
        btnAltaPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alta.png"))); // NOI18N
        btnAltaPaciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAltaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaPacienteActionPerformed(evt);
            }
        });
        add(btnAltaPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 110, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(626, 2, -1, 630));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Subir nuevo Paciente");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 40));

        tblPacientes.setBackground(new java.awt.Color(134, 176, 215));
        tblPacientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblPacientes.setForeground(new java.awt.Color(0, 102, 0));
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPacientes.getTableHeader().setReorderingAllowed(false);
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 600, 240));

        txtDni.setBackground(new java.awt.Color(89, 116, 146));
        txtDni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDni.setForeground(new java.awt.Color(0, 0, 0));
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 260, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Peso actual");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        txtPesoA.setBackground(new java.awt.Color(89, 116, 146));
        txtPesoA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPesoA.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPesoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoAActionPerformed(evt);
            }
        });
        add(txtPesoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 260, 40));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Peso deseado");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        txtPesoD.setBackground(new java.awt.Color(89, 116, 146));
        txtPesoD.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPesoD.setForeground(new java.awt.Color(0, 0, 0));
        txtPesoD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPesoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoDActionPerformed(evt);
            }
        });
        add(txtPesoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 260, 40));

        btnModificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Modificar Peso button.png"))); // NOI18N
        btnModificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPActionPerformed(evt);
            }
        });
        add(btnModificarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 250, 60));

        btnEliminarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Eliminar Paciente button.png"))); // NOI18N
        btnEliminarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPacienteActionPerformed(evt);
            }
        });
        add(btnEliminarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 520, 290, 60));

        btnRegistro.setBackground(new java.awt.Color(89, 116, 146));
        btnRegistro.setForeground(new java.awt.Color(89, 116, 146));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/checklist.png"))); // NOI18N
        btnRegistro.setBorder(null);
        btnRegistro.setBorderPainted(false);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, 70, 80));

        txtModPesoA.setBackground(new java.awt.Color(89, 116, 146));
        txtModPesoA.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtModPesoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txtModPesoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, 90, 40));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Lista de Pacientes");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 210, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Peso Deseado");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 400, 140, 40));

        txtModPesoD.setBackground(new java.awt.Color(89, 116, 146));
        txtModPesoD.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtModPesoD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(txtModPesoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 400, 90, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void btnAltaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaPacienteActionPerformed
        //Comprueba si contiene numeros.
        if (txtNombre.getText().matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null, "La casilla de NOMBRE no puede contener numeros.");
            txtNombre.setText("");
            
        //Comprueba que solo contenga numeros.
        }else if (!txtDni.getText().matches("\\d+") && !txtDni.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de DNI solo puede contener numeros.");
            txtDni.setText("");
        }else if(!txtTel.getText().matches("\\d+") && !txtTel.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de TELEFONO solo puede contener numeros.");
            txtTel.setText("");
        }else if(!esNumero(txtPesoA.getText()) && !txtPesoA.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de PESO ACTUAL solo puede contener numeros.");
            txtPesoA.setText("");
        }else if(!esNumero(txtPesoD.getText()) && !txtPesoD.getText().equals("")){
            JOptionPane.showMessageDialog(null, "La casilla de PESO DESEADO solo puede contener numeros.");
            txtPesoD.setText("");
        }else if(txtNombre.getText().equals("") || txtDni.getText().equals("") ||
                txtTel.getText().equals("") || txtDomicilio.getText().equals("")
                || txtPesoA.getText().equals("") || txtPesoD.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No pueden quedar casillas vacias.");
        }else{
            String nombre = txtNombre.getText();
            int dni = Integer.parseInt(txtDni.getText());
            String tel = txtTel.getText();
            String domicilio = txtDomicilio.getText();
            double pesoActual = Double.parseDouble(txtPesoA.getText());
            double pesoDeseado = Double.parseDouble(txtPesoD.getText());
            paciS.crearPaciente(nombre, dni, tel, domicilio, pesoActual, pesoDeseado);
            txtDni.setText("");
            txtDomicilio.setText("");
            txtNombre.setText("");
            txtTel.setText("");
            txtPesoA.setText("");
            txtPesoD.setText("");
            cargarTabla();
            txtModPesoA.setText("");
            txtModPesoD.setText("");
        }   
    }//GEN-LAST:event_btnAltaPacienteActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtPesoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoAActionPerformed

    private void txtPesoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoDActionPerformed

    private void btnModificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPActionPerformed
         if (tblPacientes.getSelectedRow() != -1){
            int id = (int) modelo.getValueAt(tblPacientes.getSelectedRow(), 0);
            String nombre = (String) modelo.getValueAt(tblPacientes.getSelectedRow(), 1);
            int dni = (int) modelo.getValueAt(tblPacientes.getSelectedRow(), 2);
            String tel = (String) modelo.getValueAt(tblPacientes.getSelectedRow(), 3);
            String domicilio = (String) modelo.getValueAt(tblPacientes.getSelectedRow(), 4);
            try{
                double pesoActual;
                pesoActual = Double.parseDouble((txtModPesoA.getText()));
                double pesoDeseado = Double.parseDouble(txtModPesoD.getText());
                Paciente p = new Paciente(id, nombre, domicilio, tel, dni, pesoActual, pesoDeseado);
                paciD.modificarPesoPaciente(p);
                txtModPesoA.setText("");
                txtModPesoD.setText("");
                cargarTabla();  
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Solo se permite ingreso de numeros.");
            }     
        }else{
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar una fila");
        }
    }//GEN-LAST:event_btnModificarPActionPerformed

    private void btnEliminarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPacienteActionPerformed
        if (tblPacientes.getSelectedRow() != -1){
            
            // Mostrar un cuadro de diálogo de confirmación
            int respuesta = JOptionPane.showConfirmDialog(null,
            "¿Estás seguro de que quieres eliminar este paciente con sus registros y dietas?", // Mensaje de confirmación
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION // Tipo de opciones (Si/No)
            );
            // Comprobar la respuesta del usuario
            if (respuesta == JOptionPane.YES_OPTION) {
                paciD.eliminarPaciente((int) modelo.getValueAt(tblPacientes.getSelectedRow(), 0));
                
                cargarTabla();
            }     
        }else{
            JOptionPane.showMessageDialog(null, "Tiene que seleccionar una fila");
        }
    }//GEN-LAST:event_btnEliminarPacienteActionPerformed

    private void filaSeleccionada(){
        tblPacientes.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    int i = tblPacientes.getSelectedRow();
                    if (i != -1){
                        String pesoA = tblPacientes.getValueAt(i, 5).toString();
                        String pesoD = tblPacientes.getValueAt(i, 6).toString();
                        cargarTextFields(pesoA, pesoD);
                    }
                }
            } 
        });
    }
    
    private void cargarTextFields(String pesoA, String pesoD){
        txtModPesoA.setText(pesoA);
        txtModPesoD.setText(pesoD);
    }
    
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        vR = new viewRegistroPacientes(cargarRegistro());
        vR.setVisible(true);
        vR.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistroActionPerformed

    public ArrayList<RegistroPeso> cargarRegistro(){
        ArrayList<RegistroPeso> registros = new ArrayList<>();
        int id = (int) tblPacientes.getValueAt(tblPacientes.getSelectedRow(), 0);
        registros.addAll(registroData.listarRegistrosXId(id));
        return registros;
    }
    
    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked

    }//GEN-LAST:event_tblPacientesMouseClicked

    public static boolean esNumero(String texto) {
        String patron = "^\\d+(\\.\\d+)?$"; // Expresión regular para números enteros o decimales
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }
    
    private void armarTabla(){
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Dni");
        modelo.addColumn("Telefono");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Peso actual");
        modelo.addColumn("Peso deseado");
        tblPacientes.setModel(modelo);
        tblPacientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblPacientes.getColumnModel().getColumn(1).setPreferredWidth(60);
        tblPacientes.getColumnModel().getColumn(2).setPreferredWidth(40);
        tblPacientes.getColumnModel().getColumn(3).setPreferredWidth(40);
        tblPacientes.getColumnModel().getColumn(4).setPreferredWidth(60);
        tblPacientes.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblPacientes.getColumnModel().getColumn(6).setPreferredWidth(30);
    }
    
    private void cargarTabla(){
        pacientes.clear();
        pacientes.addAll(paciD.listarPacientes());
        modelo.setRowCount(0);
        for (Paciente p:pacientes){
            modelo.addRow(new Object[]{p.getIdPaciente(), p.getNombrePaciente(), p.getDni(), p.getTelefono(), p.getDomicilio(), p.getPesoActual(), p.getPesoDeseado()});
        }
    }
    
    private void habilitarButton(){
        tblPacientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(!e.getValueIsAdjusting()) {
                        int selectedRow = tblPacientes.getSelectedRow();

                        if(selectedRow != -1) {
                            btnRegistro.setEnabled(true);
                        }else {
                            btnRegistro.setEnabled(false);
                        }
                    }
                }
        });
        
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaPaciente;
    private javax.swing.JButton btnEliminarPaciente;
    private javax.swing.JButton btnModificarP;
    private javax.swing.JButton btnRegistro;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtModPesoA;
    private javax.swing.JTextField txtModPesoD;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPesoA;
    private javax.swing.JTextField txtPesoD;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
