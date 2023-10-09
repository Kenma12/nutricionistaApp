/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Paciente;
import entidades.RegistroPeso;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo-PC
 */
public class RegistroPesoData {
    
    private Connection conexion;
    
    public RegistroPesoData(){
        conexion = Conexion.getConnection();
    }
    
    public void nuevoRegistro(RegistroPeso registro){  
        String sql = "INSERT INTO `registro_peso`(`idPaciente`, `peso`)"
                + " VALUES (?, ?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, registro.getPaciente().getIdPaciente());
            ps.setDouble(2, registro.getPeso());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                registro.setIdRegistroPeso(rs.getInt(1));
            }
            rs.close();
            ps.close();
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void eliminarRegistros(int id){
        
        String sql = "DELETE FROM `registro_peso` WHERE idPaciente = ?";
        
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }  
    }
    
    
}
