/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import AccesoADatos.RegistroPesoData;
import entidades.RegistroPeso;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo-PC
 */
public class viewRegistroPacientes extends javax.swing.JFrame {
    DefaultTableModel modelo =  new DefaultTableModel();
    RegistroPesoData registroData = new RegistroPesoData();
    private ArrayList<RegistroPeso> registros;
    //viewAltaPaciente vAlta = new viewAltaPaciente();
    
    /**
     * Creates new form viewRegistroPacientes
     * @param registros
     */
    public viewRegistroPacientes(ArrayList<RegistroPeso> registros) {
        initComponents();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        armarTabla();
        this.registros = registros;
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void armarTabla(){
        modelo.addColumn("Peso actual");
        modelo.addColumn("Peso deseado");
        modelo.addColumn("Fecha");
        tblRegistros.setModel(modelo);
    }    
    
    public void cargarTabla(){
        modelo.setRowCount(0);
        for (RegistroPeso r:registros){
            modelo.addRow(new Object[]{r.getPesoA(), r.getPesoD(), r.getFecha()});
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
