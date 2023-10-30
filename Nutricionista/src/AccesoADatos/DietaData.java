/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import entidades.Dieta;
import entidades.Paciente;
import java.sql.Date;
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
    private PacienteData pData = new PacienteData();
    public DietaData(){
        conexion = Conexion.getConnection();
    }
    public void altaDieta(Dieta dieta){
        String sql = "INSERT INTO `dieta`(`NombreDieta`, `idPaciente`, `fechaInicial`, `fechaFinal`, `pesoInicial`, `pesoFinal`, `dietaTerminada`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombreDieta());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, Date.valueOf(dieta.getFechaInicial()));
            ps.setDate(4,Date.valueOf(dieta.getFechaFinal()));
            ps.setDouble(5,dieta.getPesoInicial());
            ps.setDouble(6,dieta.getPesoFinal());
            ps.setBoolean(7, dieta.isDietaTerminada());
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
    
    public void eliminarDieta(int id){
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
    
//    public void eliminarDietaXPaciente(int id){
//        String sql = "DELETE FROM `dieta` WHERE idPaciente = ?";
//        try {
//            PreparedStatement ps = conexion.prepareStatement(sql);
//            ps.setInt(1, id);
//            int e = ps.executeUpdate();
//            if (e > 0){
//                JOptionPane.showMessageDialog(null, "Dietas del Paciente Borradas");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//        }
//    }
    
    public void modificarDieta(Dieta dieta){
        String sql = "UPDATE `dieta` "
                + "SET `nombreDieta`= ?,`idPaciente`= ?,`fechaInicial`= ? "
                + "`fechaFinal`= ?,`pesoInicial`= ?,`pesoFinal`= ?"
                + "WHERE idDieta = ?";      
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dieta.getNombreDieta());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
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
    
    public ArrayList<Dieta> listarDietas(){
        ArrayList<Dieta> dietas = new ArrayList<>();
        String sql = "SELECT `idDieta`, `nombreDieta`, `idPaciente`, "
                + "`fechaInicial`, `fechaFinal`, `pesoInicial`, `pesoFinal`, `dietaTerminada` FROM `dieta`";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Dieta dieta = null;
            while(rs.next()){
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombreDieta(rs.getString("nombreDieta"));
                dieta.setPaciente(pData.buscarPacienteXDni(rs.getInt("idPaciente")));
                dieta.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                dieta.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setDietaTerminada(rs.getBoolean("dietaTerminada"));
                if (dieta.getFechaInicial().isEqual(dieta.getFechaFinal()) 
                        || dieta.getFechaInicial().isAfter(dieta.getFechaFinal()) 
                        && !dieta.isDietaTerminada()){
                    
                    Paciente paciente = pData.buscarPacienteXId(rs.getInt("idPaciente"));
                    dieta.setDietaTerminada(true);
                    dieta.setPesoFinal(paciente.getPesoActual());
                    finDieta(paciente.getPesoActual(), dieta.getIdDieta());
                    
                }else if (dieta.isDietaTerminada()){
                    dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                }else{
                    dieta.setPesoFinal(0);
                }
                dietas.add(dieta);
            }
            rs.close();
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return dietas;
    }
    
    private void finDieta(double pesoFinal, int id){
        String sql = "UPDATE `dieta` SET `pesoFinal`=?, `dietaTerminada` = 1  "
                + "WHERE idDieta = ?";
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setDouble(1, pesoFinal);
            ps.setInt(2, id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    
    
    
}

