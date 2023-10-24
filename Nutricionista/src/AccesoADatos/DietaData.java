/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.dieta;
import java.sql.Date;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
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
            //ps.setPaciente(2, dieta.getPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(4,Date.valueOf(dieta.getFechaFinal()));
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
    public void modificarDietaData(dieta dieta){
        String sql = "UPDATE `dieta` "
                + "SET `nombreDieta`=?,`idPaciente`=?,`fechaInicial`=? "
                + "`fechaFinal`= ?,`pesoInicial`=?,`pesoFinal`=?"
                + "WHERE idDieta = ?;";
         /*  WHERE 1*/      
        try {
            /*no sirve aca 
            //Guarda su peso anterior en un registroPeso
            Paciente aux = buscarPacienteXId(paciente.getIdPaciente());
            RegistroPeso registro = new RegistroPeso(aux, aux.getPesoActual()); 
            registroData.nuevoRegistro(registro);*/
            
            //ejecuta el cambio de peso
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombreDieta());
           // ps.setPaciente(2, dieta.getPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(4, Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setInt(7, dieta.getIdDieta());
            int ex = ps.executeUpdate();
            if(ex == 1){
                JOptionPane.showMessageDialog(null, "La dieta se ha modificado.");
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    } 
}

