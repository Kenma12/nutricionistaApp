/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Enzo-PC
 */
public class Comida {
    
    private int idComida;    
    private String nombreComida;
    private String detalle;
    private int cantCalorias;
    
    public Comida(){}
    
    //CONSTRUCTOR CON ID
    
    public Comida(int idComida, String nombreComida, String detalle, int cantCalorias){
        this.idComida = idComida;
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.nombreComida = nombreComida;
    }
    
    //CONSTRUCTOR SIN ID
    
    public Comida(String nombreComida, String detalle, int cantCalorias){
        this.detalle = detalle;
        this.cantCalorias = cantCalorias;
        this.nombreComida = nombreComida;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantCalorias() {
        return cantCalorias;
    }

    public void setCantCalorias(int cantCalorias) {
        this.cantCalorias = cantCalorias;
    }
    
    
    
    
}
