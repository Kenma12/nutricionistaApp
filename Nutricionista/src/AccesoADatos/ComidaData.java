/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Comida;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enzo-PC
 */
public class ComidaData {
    
    private Connection conexion;
 
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
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                comida.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "COMIDA AGREGADA");
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void bajaComida(int id){
        
        String sql = "DELETE FROM `comida` WHERE idComida = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int e = ps.executeUpdate();
            
            if (e == 1){
                JOptionPane.showMessageDialog(null, "Comida borrada.");
            }else{
                JOptionPane.showMessageDialog(null, "Comida no encontrada.");
            }
          
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        
        
        
    }
    
    
    
    
}


