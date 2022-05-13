/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_De_Proyecto;

import java.util.Vector;

/**
 *
 * @author Joan Manuel
 */
public class Facultad {
    
    private String nombre;
    private int matricula;
    private Vector<Carrera> carreras;
    
    public Facultad(String nombre, int matricula, Vector<Carrera> carreras){
        this.matricula = matricula;
        this.nombre = nombre;
        this.carreras = carreras;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public Vector<Carrera> getCarreras() {
        return carreras;
    }

    public void setMatricula(int M){
        this.matricula = M;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarreras(Vector<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    
}
