/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Comida;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author Enzo-PC
 */
public class ComidaData {
    
    private Connection conexion;
    private RegistroPesoData registroData = new RegistroPesoData();
    
    public ComidaData(){
        conexion = Conexion.getConnection();
    }
    
    public void altaComida(Comida comida){
        String sql = "INSERT INTO `comida`(`nombreComida`, `detalle`, `cantCalorias`) "
                + "VALUES (?, ?, ?)";
        
        try{
            
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, comida.getNombreComida());
            ps.setString(2, comida.getDetalle());
            ps.setInt(3,comida.getCantCalorias());
            
            
        }catch(SQLException ex){
            
        }
        
        
        
        
        
    }
    
    /*
    public void altaPaciente(Paciente paciente){
        String sql = "INSERT INTO `paciente`(`nombrePaciente`, `dni`, `domicilio`, `telefono`, `pesoActual`, `pesoDeseado`) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
    
        try {  
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, paciente.getNombrePaciente());
            ps.setInt(2, paciente.getDni());
            ps.setString(3, paciente.getDomicilio());
            ps.setString(4, paciente.getTelefono());
            ps.setDouble(5, paciente.getPesoActual());
            ps.setDouble(6, paciente.getPesoDeseado());
            
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
    */
    
    
    
    
}


