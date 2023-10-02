/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Enzo-PC
 */
public class Paciente {

    private String nombrePaciente;
    private int dni;
    private String domicilio;
    private String telefono;
    private int idPaciente;

    public Paciente(){}
    
    //CONSTRUCTOR CON ID
    
    public Paciente(int idPaciente, String nombrePaciente, String domicilio, String telefono, int dni){
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
    }
    
    //CONSTRUCTOR SIN ID
    
    public Paciente(String nombrePaciente, String domicilio, String telefono, int dni){
        this.nombrePaciente = nombrePaciente;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
    }
    
    
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
    
    
    
}
