package Clases_De_Proyecto;

import java.util.Vector;


public class Universidad {
    private final String nombre;
    private final int matricula;
    private final Vector<Beca> becas;
    private final Vector<Facultad> facultades;

	public Universidad(String nombre, int matricula, Vector<Beca> becas, Vector<Facultad> facultades) {
		this.becas = becas;
                this.facultades = facultades;
                this.matricula = matricula;
                this.nombre = nombre;
	}

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public Vector<Beca> getBecas() {
        return becas;
    }

    public Vector<Facultad> getFacultades() {
        return facultades;
    }
        
        
       
}
