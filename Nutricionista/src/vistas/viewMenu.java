/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author Enzo-PC
 */
public class viewMenu extends javax.swing.JFrame {

    /**
     * Creates new form viewMenu
     */
    public viewMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnViewAltaAlum = new javax.swing.JButton();
        Content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewAltaAlum.setBackground(new java.awt.Color(255, 255, 255));
        btnViewAltaAlum.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAltaAlum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Pacientes.png"))); // NOI18N
        btnViewAltaAlum.setBorder(null);
        btnViewAltaAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAltaAlumActionPerformed(evt);
            }
        });
        jPanel2.add(btnViewAltaAlum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 220, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 90));

        Content.setBackground(new java.awt.Color(89, 116, 146));
        Content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1280, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewAltaAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAltaAlumActionPerformed
        viewAltaPaciente viewAlta = new viewAltaPaciente();
        viewAlta.setVisible(true);
        viewAlta.setLocationRelativeTo(null);
        this.dispose();      
    }//GEN-LAST:event_btnViewAltaAlumActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JButton btnViewAltaAlum;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}