package Operaciones;

import Base_de_Datos.Gestion;
import Clases_De_Proyecto.*;

public class Operaciones_de_boletas{

    private static final Gestion G = new Gestion();
	
	
	public static void guardar_boleta(Boleta B, Elecc E) {
		if(B.getInvalido()) {
			E.setCantidad_de_boletas_invalidas(E.getCantidad_de_boletas_invalidas()+1);
		}
		else if(B.getEn_blanco()) {
			E.setCantidad_de_boletas_en_blanco(E.getCantidad_de_boletas_en_blanco()+1);
		}
		
                G.agregar_boleta(E, B, E.getVotos());
		
		E.getBoletas_guardadas().push(B);
	}

	public static void Cancelar_ultima_boleta(Elecc E){
	Boleta B = E.getBoletas_guardadas().peek();
	if(B.getInvalido()) {
		E.setCantidad_de_boletas_invalidas(E.getCantidad_de_boletas_invalidas()-1);
	}
	else if(B.getEn_blanco()) {
		E.setCantidad_de_boletas_en_blanco(E.getCantidad_de_boletas_en_blanco()-1);
	}
	
        G.quitar_votos(B, E, E.getVotos());
	
	E.getBoletas_guardadas().pop();
	}

    public static void limpiar_candidatos_extras(Elecc E) {
        for(int i = 0; i < E.getNombres_extra().size();i++){
            E.getNombres_extra().elementAt(i).getN2().setEntero(0);
        }
    }
	
}
