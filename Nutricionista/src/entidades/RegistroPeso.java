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
    private double peso;

    public RegistroPeso() {
    }

    public RegistroPeso(int idRegistroPeso, Paciente paciente, double peso) {
        this.idRegistroPeso = idRegistroPeso;
        this.paciente = paciente;
        this.peso = peso;
    }

    public RegistroPeso(Paciente paciente, double peso) {
        this.paciente = paciente;
        this.peso = peso;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }  
    
}
