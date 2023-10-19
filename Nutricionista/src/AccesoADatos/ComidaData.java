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
import java.util.ArrayList;
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public Comida buscarComidaXId(int id){
        String sql = "SELECT `nombreComida`, `detalle`, `cantCalorias` FROM `comida` "
                + "WHERE idComida = ?";
        Comida comida = null;
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                comida = new Comida();
                comida.setIdComida(id);
                comida.setNombreComida(rs.getString("nombreComida"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe la comida buscada");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }   
        return comida;
    }
    
    public ArrayList<Comida> listarComidas(){
        ArrayList<Comida> comidas = new ArrayList();
        Comida comida = null;
        String sql = "SELECT `idComida`, `nombreComida`, `detalle`, `cantCalorias` FROM `comida`";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                comida = new Comida();
                comida.setIdComida(rs.getInt("idComida"));
                comida.setNombreComida(rs.getString("nombreComida"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCantCalorias(rs.getInt("cantCalorias"));
                comidas.add(comida);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return comidas;
    }
    
    
    
    
    
}


