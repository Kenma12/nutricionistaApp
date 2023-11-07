/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Comida;
import entidades.DietaComida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private ComidaData comidaData = new ComidaData();
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
    
    public void eliminarDietaComida(int idDieta){
        String sql = "DELETE FROM `dietacomida` WHERE idDieta = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDieta);
            int e = ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public ArrayList<String> getComidas(int id){
        ArrayList<String> comidas = new ArrayList<>();
        String sql = "SELECT `idComida` FROM `dietacomida` WHERE idDieta = ?";
        String comida;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               comida = comidaData.buscarComidaXId(rs.getInt("idComida")).getNombreComida();
                comidas.add(comida);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return comidas;
    }
    
}
