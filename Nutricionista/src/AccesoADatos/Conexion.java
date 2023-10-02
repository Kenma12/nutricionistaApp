/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import org.mariadb.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Enzo-PC
 */
public class Conexion {
    
    public static final String URL = "jdbc:mariadb://localhost:3306/nutricionista";
    public static final String USUARIO = "root";
    public static final String CONTRASEÑA = "";
    private static Connection conexion;
    
    public Conexion(){}
    
    public static Connection getConnection(){
        
     try{
     
        //CARGAR DRIVER
         
        Class.forName("org.mariadb.jdbc.Driver");
         
        //CONEXION A LA BASE DE DATOS
         
        conexion = (Connection) DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
        
     }catch(ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, "Error al cargar driver." + ex.getMessage());
     }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error al cargar driver." + ex.getMessage());
     }
        return conexion;
    }
    
    
}
