package Clases_De_Proyecto;

public class Candidato {

private String Nombre;
private final String Carrera;
private final int Año;

public Candidato(String Nombre, String Carrera, int Año) {
	this.Nombre=Nombre;
	this.Carrera=Carrera;
	this.Año=Año;
}

public String getNombre() {
	return Nombre;
}

public String getCarrera() {
	return Carrera;
}

public int getAño() {
	return Año;
}

public void setNombre(String nombre){
    Nombre = nombre;
}

public static boolean comparar(Candidato one, Candidato two){
    if(one == null || two == null){
        return false;
    }
    if(one.getAño() == two.getAño()){
        if(one.getCarrera().equals(two.getCarrera())){
            if(one.getNombre().equals(two.getNombre())){
                return true;
            }
        }
    }
    return false;
}

}
