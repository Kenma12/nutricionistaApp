/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Paciente;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
/**
 *
 * @author Enzo-PC
 */
public class PacienteData {
    
    private Connection conexion;
    
    public PacienteData(){
        conexion = Conexion.getConnection();
    }
 
    public void altaPaciente(Paciente paciente){
        String sql = "INSERT INTO `paciente`(`nombrePaciente`, `dni`, `domicilio`, `telefono`) "
                    + "VALUES (?, ?, ?, ?)";
    
        try {  
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, paciente.getNombrePaciente());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys(); 
            
            if (rs.next()){
                paciente.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente agregado.");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void bajaPaciente(int idPaciente){
        String sql = "DELETE FROM `paciente` WHERE idPaciente = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            
            int ex = ps.executeUpdate();
            
            if (ex == 1){
                JOptionPane.showMessageDialog(null, "Paciente eliminado.");
            }else{
                JOptionPane.showMessageDialog(null, "El paciente no existe");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());            
        }
        
        
        
        
    }
    
    
    
    
    
    
    
}
