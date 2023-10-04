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
import java.util.ArrayList;
import java.util.List;
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
    
    
    public Paciente buscarPacienteXId(int id){
        
        String sql = "SELECT `nombrePaciente`, `dni`, `domicilio`, `telefono` "
                + "FROM `paciente` WHERE idPaciente = ?";
        
        Paciente paci = null;
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                paci = new Paciente();
                
                paci.setIdPaciente(id);
                paci.setDni(rs.getInt("dni"));
                paci.setDomicilio(rs.getString("domicilio"));
                paci.setNombrePaciente(rs.getString("nombrePaciente"));
                paci.setTelefono(rs.getString("telefono"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el paciente buscado");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return paci;
    }
    
    public Paciente buscarPacienteXDni(int dni){
        
        String sql = "SELECT `idPaciente`, `nombrePaciente`, `dni`, `domicilio`, `telefono` "
                + "FROM `paciente` WHERE dni = ?;";
        
        Paciente paci = null;
        try{ 
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                paci = new Paciente();
                paci.setIdPaciente(rs.getInt("idPaciente"));
                paci.setNombrePaciente(rs.getString("nombrePaciente"));
                paci.setDni(rs.getInt("dni"));
                paci.setDomicilio(rs.getString("domicilio"));
                paci.setTelefono(rs.getString("telefono"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el paciente buscado");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return paci;
    }
    
    public List<Paciente> listarPacientes(){
    
        ArrayList<Paciente> pacientes = new ArrayList();
        
        String sql = "SELECT `idPaciente`, `nombrePaciente`, `dni`, `domicilio`, `telefono` "
                + "FROM `paciente`";
        Paciente paci =null;
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                paci = new Paciente();
                
                paci.setIdPaciente(rs.getInt("idPaciente"));
                paci.setNombrePaciente(rs.getString("nombrePaciente"));
                paci.setDni(rs.getInt("dni"));
                paci.setDomicilio(rs.getString("domicilio"));
                paci.setTelefono(rs.getString("telefono"));
                pacientes.add(paci);
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
        
        for (Paciente p:pacientes){
            System.out.println(p.toString());
        }
        
        
        return pacientes;
    }
    
    
    public void eliminarPaciente(int id){
        String sql = "DELETE FROM `paciente` WHERE idPaciente = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int ex = ps.executeUpdate();
            if(ex == 1){
                JOptionPane.showMessageDialog(null, "Paciente eliminado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    } 
        
    
    
    
    
    
    
    
    
}
