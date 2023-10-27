/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.RegistroPeso;
import java.sql.Date;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo-PC
 */
public class RegistroPesoData {
    
    private final Connection conexion;
    //private PacienteData pData = new PacienteData();
    
    public RegistroPesoData(){
        conexion = Conexion.getConnection();
    }
    
    public void nuevoRegistro(RegistroPeso registro){  
        String sql = "INSERT INTO `registro_peso`(`idPaciente`, `pesoA`, `pesoD`, `fecha`)"
                + " VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, registro.getPaciente().getIdPaciente());
            ps.setDouble(2, registro.getPesoA());
            ps.setDouble(3, registro.getPesoD());
            ps.setDate(4, Date.valueOf(LocalDate.now()));
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
 
        String sql = "SELECT `idRegistro_peso`, `pesoA`, `pesoD`, `fecha` FROM `registro_peso` "
                + "WHERE idPaciente = ?";
 
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            RegistroPeso registro = null;
            while (rs.next()){
                registro = new RegistroPeso();
                registro.setIdRegistroPeso(rs.getInt("idRegistro_peso"));
                registro.setPesoA(rs.getDouble("pesoA"));
                registro.setPesoD(rs.getDouble("pesoD"));
        //        registro.setPaciente(pData.buscarPacienteXId(id));
                registro.setFecha(LocalDate.now());
                registros.add(registro);
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } 
        
        return registros;
    }
    
}
