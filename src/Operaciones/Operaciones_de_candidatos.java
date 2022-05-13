package Operaciones;

import Base_de_Datos.Gestion;
import Utiles.Tupla;
import Utiles.Entero;
import java.util.Vector;

import Clases_De_Proyecto.*;

public class Operaciones_de_candidatos {
	private static final Gestion G = new Gestion();
	
	public static Vector<Tupla<Candidato, Tupla<Entero, Entero>>> organizar_candidatos_por_votos(Elecc E, int S) {
                Vector<Tupla<Candidato, Tupla<Entero, Entero>>> V = G.organizar_candidatos(E, S);
                return V;
        }
	
	
    public static void organizar_candidatos_por_nombre(Vector<Candidato> V) {
    	for(int j = 0;j < V.size()-1;j++)
    		for(int i = 0; i < V.size()-1;i++) {
    			Tupla<Candidato,Candidato> T = organizar_por_nombre(V.elementAt(i),V.elementAt(i+1));
				V.set(i, T.getN1());
				V.set(i+1, T.getN2());
	}
    }
    
    private static Tupla<Candidato,Candidato> organizar_por_nombre(Candidato A, Candidato B){
    	String a = A.getNombre();
    	String b = B.getNombre();
    	int longitud = Math.min(a.length(), b.length());
    	for(int i = 0; i < longitud;i++) {
    		if(a.charAt(i) < b.charAt(i)) {
    			return new Tupla<>(A,B);
    		}
    		else if(a.charAt(i) > b.charAt(i)){
    			return new Tupla<>(B,A);
    		}
    	}
    	return new Tupla<>(A,B);
    }
	
}
