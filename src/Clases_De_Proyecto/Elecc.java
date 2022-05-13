/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_De_Proyecto;

import Utiles.Entero;
import Utiles.Tupla;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Joan Manuel
 */
public class Elecc {
    
	private final Stack<Boleta> Boletas_guardadas;
	private final Vector<Candidato> Nombres;
        private final Vector<Tupla<Candidato, Entero> > Nombres_extra;
	private int cantidad_de_boletas_invalidas;
	private int cantidad_de_boletas_en_blanco;
	private final int matricula;
	private final String tipo_de_eleccion;
        private final String anno;
        private final int id;
        private final String universidad;
        private int votos;
        private boolean eleccion_rara;
       public Elecc(String Tipo, String anno, int id, int matricula, String universidad, boolean eleccion_rara){
                Boletas_guardadas = new Stack<>();
                Nombres = new Vector<>();
		cantidad_de_boletas_invalidas=0;
		cantidad_de_boletas_en_blanco=0;
                this.matricula = matricula;
		this.tipo_de_eleccion=Tipo;
                this.anno=anno;
                this.id = id;
                this.universidad = universidad;
                this.eleccion_rara=eleccion_rara;
                Nombres_extra = new Vector<>();
                this.votos=0;
        }

    public void setCantidad_de_boletas_invalidas(int cantidad_de_boletas_invalidas) {
        this.cantidad_de_boletas_invalidas = cantidad_de_boletas_invalidas;
    }

    public void setCantidad_de_boletas_en_blanco(int cantidad_de_boletas_en_blanco) {
        this.cantidad_de_boletas_en_blanco = cantidad_de_boletas_en_blanco;
    }
       

    public Stack<Boleta> getBoletas_guardadas() {
        return Boletas_guardadas;
    }

    public Vector<Candidato> getNombres() {
        return Nombres;
    }

    public int getCantidad_de_boletas_invalidas() {
        return cantidad_de_boletas_invalidas;
    }

    public int getCantidad_de_boletas_en_blanco() {
        return cantidad_de_boletas_en_blanco;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getTipo_de_eleccion() {
        return tipo_de_eleccion;
    }

    public String getAnno() {
        return anno;
    }

    public Vector<Tupla<Candidato, Entero>> getNombres_extra() {
        return Nombres_extra;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    
    public int getId() {
        return id;
    }

    public String getUniversidad() {
        return universidad;
    }
    
    
    
    
       
       
}
