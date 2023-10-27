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
    private double pesoActual;
    private double pesoDeseado;

    public Paciente(){}
    
    //CONSTRUCTOR CON ID
    
    public Paciente(int idPaciente, String nombrePaciente, String domicilio, String telefono, int dni, double pesoActual, double pesoDeseado){
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
        this.pesoActual = pesoActual;
        this.pesoDeseado = pesoDeseado;
    }
    
    //CONSTRUCTOR SIN ID
    
    public Paciente(String nombrePaciente, String domicilio, String telefono, int dni, double pesoActual, double pesoDeseado){
        this.nombrePaciente = nombrePaciente;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.dni = dni;
        this.pesoActual = pesoActual;
        this.pesoDeseado = pesoDeseado;
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
    
    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getPesoDeseado() {
        return pesoDeseado;
    }

    public void setPesoDeseado(double pesoDeseado) {
        this.pesoDeseado = pesoDeseado;
    }
    
    @Override
    public String toString() {
        return "Paciente:" + nombrePaciente + ", dni=" + dni ;
    }
    
    
    
    
    
}
