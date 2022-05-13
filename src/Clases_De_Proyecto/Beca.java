/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_De_Proyecto;

/**
 *
 * @author Joan Manuel
 */
public class Beca {
    
    private String nombre;
    private int matricula;
    
    public Beca(String nombre, int matricula){
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
}
