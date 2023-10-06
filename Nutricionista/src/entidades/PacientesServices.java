/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import AccesoADatos.PacienteData;

/**
 *
 * @author Enzo-PC
 */
public class PacientesServices {
    public PacientesServices(){}
    private PacienteData data = new PacienteData();
    
    public void crearPaciente(String nombre, int dni, String telefono, String domicilio, double pesoActual, double pesoDeseado){
        Paciente paci = new Paciente(nombre, domicilio, telefono, dni, pesoActual, pesoDeseado);
        data.altaPaciente(paci);
    }
    
    
}
