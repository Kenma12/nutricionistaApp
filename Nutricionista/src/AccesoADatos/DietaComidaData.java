/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Dieta;
import entidades.DietaComida;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author Enzo-PC
 */
public class DietaComidaData {
    
    private Connection conexion;
    private PacienteData pData = new PacienteData();
    public DietaComidaData(){
        conexion = Conexion.getConnection();
    }
    
    public void altaDietaComida(DietaComida dietaComida){
        String sql = "INSERT INTO `dietacomida`(`idComida`, `idDieta`, `horario`) "
                + "VALUES (?,?,?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dietaComida.getComida().getIdComida());
            ps.setInt(2, dietaComida.getDieta().getIdDieta());
            ps.setString(3, dietaComida.getHorario().toString());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                dietaComida.setIdDietaComida(rs.getInt(1));
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
//    public void eliminarDietasComidasXPaciente(int id){
//        String sql = "DELETE FROM `dietacomida` WHERE idPaciente"
//        
//    }
    /*
    public void eliminarDietasXPaciente(int id){
        String sql = "DELETE FROM `dieta` WHERE idPaciente = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            int e = ps.executeUpdate();
            if (e > 0){
                JOptionPane.showMessageDialog(null, "Dietas del Paciente Borradas");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    */
    
}
