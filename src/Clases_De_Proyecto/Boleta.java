package Clases_De_Proyecto;

import Utiles.Tupla;
import java.util.Vector;


public class Boleta {
private Vector<Tupla<Candidato,Tupla<Boolean,Boolean>>> Candidatos;
private Boolean Invalido = false;
private Boolean En_blanco = true;

public Boleta(Vector<Tupla<Candidato,Tupla<Boolean,Boolean>>> Candidatos, int N) {
	this.Candidatos = Candidatos;
        int cont = 0;

	int contador_para_invalidar_por_repeticion_de_presidente = 0;
	for(int i =1; i < Candidatos.size();i++) {
		if(!Candidatos.elementAt(i).getN2().getN1() && Candidatos.elementAt(i).getN2().getN2()) {
			Invalido = true;
			break;
		}
		else if(Candidatos.elementAt(i).getN2().getN1() && Candidatos.elementAt(i).getN2().getN2()) {
			contador_para_invalidar_por_repeticion_de_presidente++;
			if(contador_para_invalidar_por_repeticion_de_presidente>=2) {
				Invalido = true;
				break;
			}
		}
		if(Candidatos.elementAt(i).getN2().getN1()) {
			En_blanco = false;
                        cont++;
		}
	}
        if(cont != N && !En_blanco){
            Invalido = true;
        }
}

public Vector<Tupla<Candidato,Tupla<Boolean, Boolean>>> getCandidatos() {
	return Candidatos;
}

public Boolean getInvalido() {
	return Invalido;
}


public boolean getEn_blanco() {
	return En_blanco;
}




}
