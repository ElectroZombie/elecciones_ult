package Utiles;

public class Entero {
private int X;
public Entero(int X) {
	this.X=X;
}

public int getEntero() {
	return X;
}

public void setEntero(int X) {
	this.X=X;
}

public static int sumar(Entero E1, Entero E2){
	return E1.getEntero()+E2.getEntero();
}

public static int restar(Entero E1, Entero E2) {
	return E1.getEntero()-E2.getEntero();
}
}
