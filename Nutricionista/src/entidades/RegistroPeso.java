/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Enzo-PC
 */
public class RegistroPeso {
    
    private int idRegistroPeso;
    private Paciente paciente;
    private double pesoA;
    private double pesoD;
    private LocalDate fecha;

    
    //CONSTRUCTOR VACIO
    
    public RegistroPeso() {
    }

    //CONSTRUCTOR CON ID
    
    public RegistroPeso(int idRegistroPeso, Paciente paciente, double pesoA, double pesoD) {
        this.idRegistroPeso = idRegistroPeso;
        this.paciente = paciente;
        this.pesoA = pesoA;
        this.pesoD = pesoD;
    }
    
    //CONSTRUCTOR SIN ID

    public RegistroPeso(Paciente paciente, double pesoA, double pesoD) {
        this.paciente = paciente;
        this.pesoA = pesoA;
        this.pesoD = pesoD;    
    }

    public double getPesoA() {
        return pesoA;
    }

    public void setPesoA(double pesoA) {
        this.pesoA = pesoA;
    }

    public double getPesoD() {
        return pesoD;
    }

    public void setPesoD(double pesoD) {
        this.pesoD = pesoD;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdRegistroPeso() {
        return idRegistroPeso;
    }

    public void setIdRegistroPeso(int idRegistroPeso) {
        this.idRegistroPeso = idRegistroPeso;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
