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
public class Dieta{
    
    private int idDieta;
    private String NombreDieta;
    private Paciente paciente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private double pesoInicial;
    private double pesoFinal;
    private boolean dietaTerminada;

    public Dieta(){}
    
    //CONTRUCTOR CON ID
    
    public Dieta(int idDieta, String NombreDieta, Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal, double pesoInicial, double pesoFinal, boolean dietaTerminada) {
        this.idDieta = idDieta;
        this.NombreDieta = NombreDieta;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.dietaTerminada = dietaTerminada;
    }
    
    //CONTRUCTOR SIN ID
    
    public Dieta(String NombreDieta, Paciente paciente, LocalDate fechaInicial, LocalDate fechaFinal, double pesoInicial, double pesoFinal, boolean dietaTerminada) {
        this.NombreDieta = NombreDieta;
        this.paciente = paciente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.dietaTerminada = dietaTerminada;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return NombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.NombreDieta = nombreDieta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public boolean isDietaTerminada() {
        return dietaTerminada;
    }

    public void setDietaTerminada(boolean dietaTerminada) {
        this.dietaTerminada = dietaTerminada;
    }
    
}
