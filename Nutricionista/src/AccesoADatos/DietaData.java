/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.dieta;
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
public class DietaData {
    private Connection conexion;
    public DietaData(){
        conexion = Conexion.getConnection();
    }
    public void altaDietaData(dieta dieta){
        String sql = "INSERT INTO `dieta`(`NombreDieta`, `idPaciente`, `fechaInicial`, `fechaFinal`, `pesoInicial`, `pesoFinal`) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try{
            /* Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal, double pesoInicial, double pesoFinal)*/
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombreDieta());
           // ps.setInt(2, dieta.getPaciente());
            //ps.setInt(3,dieta.getFechaInicial());
           // ps.setInt(4,dieta.getFechaFinal());
            ps.setDouble(5,dieta.getPesoInicial());
            ps.setDouble(6,dieta.getPesoFinal());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                dieta.setIdDieta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "DIETA AGREGADA");
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void eliminarDietaData(int id){
        String sql = "DELETE FROM `dieta` WHERE idDieta = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int e = ps.executeUpdate();
            if (e == 1){
                JOptionPane.showMessageDialog(null, "Dieta borrada.");
            }else{
                JOptionPane.showMessageDialog(null, "Dieta no encontrada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
