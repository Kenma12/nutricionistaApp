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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo-PC
 */
public class RegistroPesoData {
    
    private Connection conexion;
    private PacienteData pData;
    
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
    
    public ArrayList<RegistroPeso> listarRegistrosXId(int id){
        ArrayList<RegistroPeso> registros = new ArrayList<>();
 
        String sql = "SELECT `idRegistro_peso`, `idPaciente`, `peso` FROM `registro_peso` "
                + "WHERE";
 
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                RegistroPeso registro = new RegistroPeso();
                registro.setIdRegistroPeso(rs.getInt("idRegistro_peso"));
                registro.setPeso(rs.getDouble("peso"));
                registro.setPaciente(pData.buscarPacienteXId(id));
                registros.add(registro);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
        return registros;
    }
    
}
