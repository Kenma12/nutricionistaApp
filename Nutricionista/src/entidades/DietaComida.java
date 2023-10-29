/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Enzo-PC
 */
public class DietaComida {
    
    private int idDietaComida;
    private Comida comida;
    private Dieta dieta;
    private Horario horario;

    public DietaComida(){}
    
    //CONSTRUCTOR CON ID
    
    public DietaComida(int idDietaComida, Comida comida, Dieta dieta, Horario horario){
        this.comida = comida;
        this.idDietaComida = idDietaComida;
        this.dieta = dieta;
        this.horario = horario;
    }
    
    //CONSTRUCTOR SIN ID
    
    public DietaComida(Comida comida, Dieta dieta, Horario horario){
        this.comida = comida;
        this.dieta = dieta;
        this.horario = horario;
    }

    public int getIdDietaComida() {
        return idDietaComida;
    }

    public void setIdDietaComida(int idDietaComida) {
        this.idDietaComida = idDietaComida;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    
    
}
