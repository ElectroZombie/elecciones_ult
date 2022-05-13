/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_De_Proyecto;

/**
 *
 * @author SchWarZer
 */
public class Carrera {
    private String nombre;
    private int matricula;
    private int duracion;
    
    public Carrera(String nombre, int matricula, int duracion){
        this.nombre = nombre;
        this.matricula = matricula;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    
}
