/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_de_Datos;

import Utiles.Trio;
import Utiles.Tupla;
import Utiles.Entero;
import java.util.Vector;
import Clases_De_Proyecto.Beca;
import Clases_De_Proyecto.Boleta;
import Clases_De_Proyecto.Candidato;
import Clases_De_Proyecto.Carrera;
import Clases_De_Proyecto.Elecc;
import Clases_De_Proyecto.Facultad;
import Clases_De_Proyecto.Universidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joan Manuel
 */
public class Gestion {
    private final Conexion C;
    
    public Gestion(){
        C = new Conexion();
    }

    public Vector<String> getVector_universidades() {
        return devolver_universidades();
    }
    
    private Vector<String> devolver_universidades(){
        C.conectar();
         Vector<String> V = new Vector<>();
            String S = "select nombre_univ from universidad where restringido = 0 order by nombre_univ";
 
            try {
                 ResultSet rs = this.C.getConsulta().executeQuery(S);
                 while(rs.next()){
                     V.add(rs.getString("nombre_univ"));
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            C.desconectar();
            return V;
    }
    
    public Vector<String> devolver_facultades(String nombre_univ){
        C.conectar();
        
        Vector<String> V = new Vector<>();
        String S = "select nombre_fact from facultad where id_universidad = (select id_universidad from universidad where nombre_univ = '" + nombre_univ + "' and restringido = 0)";
        try {
                 ResultSet rs = this.C.getConsulta().executeQuery(S);
                 while(rs.next()){
                     V.add(rs.getString("nombre_fact"));
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        C.desconectar();
        return V;
    }
    
    public Vector<String> devolver_residencias(String nombre_univ){
        C.conectar();
        
        Vector<String> V = new Vector<>();
        String S = "select nombre_beca from beca where id_universidad = (select id_universidad from universidad where nombre_univ = '" + nombre_univ + "' and restringido = 0)";
        try {
                 ResultSet rs = this.C.getConsulta().executeQuery(S);
                 while(rs.next()){
                     V.add(rs.getString("nombre_beca"));
                 }
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        C.desconectar();
        return V;
    }
    
    
    public void agregar_universidad(Universidad U, int id){
         C.conectar();
          
            try {
                String Stat = "";
                if(id==-1){
              Stat = "insert into universidad values (null, '" + U.getNombre() + "', null, 0)";
                }
                else{
              Stat = "insert into universidad values (null, '" + U.getNombre() + "', " + id + ", 0)";
                }
               boolean B = C.getConsulta().execute(Stat);
               for(int i = 0; i < U.getFacultades().size();i++){
               B = C.getConsulta().execute("insert into facultad values (null, \'" + U.getFacultades().elementAt(i).getNombre() + "\', (select id_universidad from universidad where nombre_univ = '" + U.getNombre() + "' and restringido = 0), " + U.getFacultades().elementAt(i).getMatricula() + ")");
                    for(int j = 0; j < U.getFacultades().elementAt(i).getCarreras().size();j++){
                        B = C.getConsulta().execute("insert into carrera values (null, (select id_facultad from facultad where nombre_fact = '" + U.getFacultades().elementAt(i).getNombre() + "' and id_universidad = (select id_universidad from universidad where nombre_univ = '" + U.getNombre() + "' and restringido = 0)), '" + U.getFacultades().elementAt(i).getCarreras().elementAt(j).getNombre() + "', " + U.getFacultades().elementAt(i).getCarreras().elementAt(j).getMatricula() + ", " + U.getFacultades().elementAt(i).getCarreras().elementAt(j).getDuracion() + ")");
                    }
               }
               for(int i = 0; i < U.getBecas().size();i++){
                   B = C.getConsulta().execute("insert into beca values (null, (select id_universidad from universidad where nombre_univ = '" + U.getNombre() + "' and restringido = 0), '" + U.getBecas().elementAt(i).getNombre() + "', " + U.getBecas().elementAt(i).getMatricula() + ")");
               }
                 
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        C.desconectar();
    }
    
    public Tupla<Entero,Entero> restringir_universidad_anterior(String U){
        C.conectar();
        int id = -1;
        int id_anterior = -1;
        try{
            
            String stat = "select id_universidad, id_univ_anterior from universidad where nombre_univ = '" + U + "' and restringido = 0";
            ResultSet rs = this.C.getConsulta().executeQuery(stat);
            id = rs.getInt("id_universidad");
            id_anterior = rs.getInt("id_univ_anterior");
            stat = "update universidad set restringido = 1 where id_universidad = " + id;
            this.C.getConsulta().executeUpdate(stat);
        }catch(SQLException e){
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, e);
        }
        C.desconectar();
        return new Tupla<>(new Entero(id),new Entero(id_anterior));
    }
    
    public void habilitar_universidad(int i){
        try {
            C.conectar();
            
            String stat = "select id_univ_anterior from universidad where id_universidad = " + i;
            ResultSet rs = this.C.getConsulta().executeQuery(stat);
            int id = rs.getInt("id_univ_anterior");
            stat = "update universidad set restringido = 0 where id_universidad = " + id;
            this.C.getConsulta().executeUpdate(stat);
            
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public boolean revisar_nombre_universidad(Universidad U){
        C.conectar();
        try {
            String S = "select nombre_univ from universidad where nombre_univ = '" + U.getNombre() + "'";
            ResultSet rs = this.C.getConsulta().executeQuery(S);
            if(rs.next()){
                C.desconectar();
            return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        C.desconectar();
        return false;
    }
    
    public Universidad crear_universidad(String nombre){
       
        C.conectar();
       
        Vector<Tupla<Carrera,Entero>> carrerasT = new Vector<>();
        Vector<Facultad> facultades = new Vector<>();
        Vector<Beca> becas = new Vector<>();
        
        try {
            String UNI = "select * from universidad where nombre_univ = '" + nombre + "' and restringido = 0";
            ResultSet rsU = this.C.getConsulta().executeQuery(UNI);
            if(rsU.next()){
                int idU = rsU.getInt("id_universidad");
                String NU = rsU.getString("nombre_univ");
                
                String CAR = "select * from carrera";
                    ResultSet rsC = this.C.getConsulta().executeQuery(CAR);
                    while(rsC.next()){
                        carrerasT.add(new Tupla(new Carrera(rsC.getString("nombre_carrera"), rsC.getInt("matricula_carrera"), rsC.getInt("annos_carrera")), new Entero(rsC.getInt("id_facultad"))));
                    }
                
                String FAC = "select * from facultad where id_universidad = " + idU;
                ResultSet rsF = this.C.getConsulta().executeQuery(FAC);
                int MatF = 0;
                while(rsF.next()){
                    int idF = rsF.getInt("id_facultad");
                    
                    facultades.add(new Facultad(rsF.getString("nombre_fact"), rsF.getInt("matricula"), new Vector<>()));
                    
                    for(int i = 0; i < carrerasT.size();i++){
                        if(carrerasT.elementAt(i).getN2().getEntero() == idF){
                            facultades.elementAt(facultades.size()-1).getCarreras().add(carrerasT.elementAt(i).getN1());
                        }
                    }
                    
                    MatF += rsF.getInt("matricula"); 
                }
                
                
                
                String BEC = "select * from beca where id_universidad = " + idU;
                ResultSet rsB = this.C.getConsulta().executeQuery(BEC);
                while(rsB.next()){
                    becas.add(new Beca(rsB.getString("nombre_beca"), rsB.getInt("matricula_beca")));
                }
                C.desconectar();
                return new Universidad(NU, MatF, becas, facultades);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public Universidad crear_universidad(int id){
       
        C.conectar();
       
        Vector<Tupla<Carrera,Entero>> carrerasT = new Vector<>();
        Vector<Facultad> facultades = new Vector<>();
        Vector<Beca> becas = new Vector<>();
        
        try {
            String UNI = "select * from universidad where id_universidad = " + id;
            ResultSet rsU = this.C.getConsulta().executeQuery(UNI);
            if(rsU.next()){
                int idU = rsU.getInt("id_universidad");
                String NU = rsU.getString("nombre_univ");
                
                String CAR = "select * from carrera";
                    ResultSet rsC = this.C.getConsulta().executeQuery(CAR);
                    while(rsC.next()){
                        carrerasT.add(new Tupla(new Carrera(rsC.getString("nombre_carrera"), rsC.getInt("matricula_carrera"), rsC.getInt("annos_carrera")), new Entero(rsC.getInt("id_facultad"))));
                    }
                
                String FAC = "select * from facultad where id_universidad = " + idU;
                ResultSet rsF = this.C.getConsulta().executeQuery(FAC);
                int MatF = 0;
                while(rsF.next()){
                    int idF = rsF.getInt("id_facultad");
                    
                    facultades.add(new Facultad(rsF.getString("nombre_fact"), rsF.getInt("matricula"), new Vector<>()));
                    
                    for(int i = 0; i < carrerasT.size();i++){
                        if(carrerasT.elementAt(i).getN2().getEntero() == idF){
                            facultades.elementAt(facultades.size()-1).getCarreras().add(carrerasT.elementAt(i).getN1());
                        }
                    }
                    
                    MatF += rsF.getInt("matricula"); 
                }
                
                
                
                String BEC = "select * from beca where id_universidad = " + idU;
                ResultSet rsB = this.C.getConsulta().executeQuery(BEC);
                while(rsB.next()){
                    becas.add(new Beca(rsB.getString("nombre_beca"), rsB.getInt("matricula_beca")));
                }
                C.desconectar();
                return new Universidad(NU, MatF, becas, facultades);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
      public void crearElecciones(int tpe,String anno){
          C.conectar();
          String consultaAnno="insert into elecciones values (null,'"+ tpe +"', '"+ anno +"')";
          try {
             boolean b = C.getConsulta().execute(consultaAnno);
          } catch (SQLException e) {
          Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, e);
          }
          C.desconectar();
      }

    public int obtenerID(String nombre_universidad, String tipo_eleccion, String nombre_objeto) {
        int sol = 0;
        try {
            C.conectar();
            String stat = "";
            switch (tipo_eleccion) {
                case "Residencia" ->                     {
                        stat = "select id_beca from beca where nombre_beca = '" + nombre_objeto + "' and id_universidad = (select id_universidad from universidad where nombre_univ = '" + nombre_universidad + "' and restringido = 0)";
                        ResultSet rs = C.getConsulta().executeQuery(stat);
                        sol = rs.getInt("id_beca");
                    }
                case "Facultad" ->                     {
                        stat = "select id_facultad from facultad where nombre_fact = '" + nombre_objeto + "' and id_universidad = (select id_universidad from universidad where nombre_univ = '" + nombre_universidad + "' and restringido = 0)";
                        ResultSet rs = C.getConsulta().executeQuery(stat);
                        sol = rs.getInt("id_facultad");
                    }
                case "Universidad" ->                     {
                        stat = "select id_universidad from universidad where id_universidad = (select id_universidad from universidad where nombre_univ = '" + nombre_universidad + "' and restringido = 0)";
                        ResultSet rs = C.getConsulta().executeQuery(stat);
                        sol = rs.getInt("id_universidad");
                    }
                default -> {
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        C.desconectar();
          return sol;
    }
    
    public int obtenerID(String nombre_universidad){
        int sol =0;
        try {
            C.conectar();
            String stat = "select id_universidad from universidad where nombre_univ = '" + nombre_universidad + "' and restringido = 0";
            ResultSet rs = C.getConsulta().executeQuery(stat);
            sol = rs.getInt("id_universidad");
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sol;
    }

    public int getMatricula(int id, String tipo_eleccion) {

         int sol = 0;
        try {
            C.conectar();
            String stat = "";
            if(tipo_eleccion.equals("Residencia")){
                stat = "select matricula_beca from beca where id_beca = " + id;
                   ResultSet rs = C.getConsulta().executeQuery(stat);
            sol = rs.getInt("matricula_beca");
            }
            else if(tipo_eleccion.equals("Facultad")){
                stat = "select matricula from facultad where id_facultad = " + id;
                   ResultSet rs = C.getConsulta().executeQuery(stat);
            sol = rs.getInt("matricula");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        C.desconectar();
          return sol;
        
    }

    public String getFacultad(int id) {
        C.conectar();
        String sol = null;
        try{
            String stat = "select nombre_fact from facultad where id_facultad =" + id;
            ResultSet rs = C.getConsulta().executeQuery(stat);
            sol = rs.getString("nombre_fact");
        }catch(SQLException E){
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, E);
        }
        C.desconectar();
        return sol;
    }
    
    public int getAnno(String carrera, String uni){
        C.conectar();
        int sol = 0;
        try{
            String s = "select id_facultad from facultad where id_universidad = (select id_universidad from universidad where nombre_univ = '" + uni + "' and restringido = 0)";
            ResultSet facs = C.getConsulta().executeQuery(s);
            Vector<Entero> VF = new Vector<>();
            while(facs.next()){
                VF.add(new Entero(facs.getInt("id_facultad")));
            }
            for(int i = 0; i < VF.size();i++){
            String stat = "select * from carrera where nombre_carrera = '" + carrera + "' and id_facultad = " + VF.elementAt(i).getEntero();
            ResultSet rs = C.getConsulta().executeQuery(stat);
            if(rs.next()){
            sol = rs.getInt("annos_carrera");
            break;
            }
            }
        }catch(SQLException E){
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, E);
        }
        C.desconectar();
        return sol;
    }

    /**
     *
     * @param C
     * @param E
     * @param x
     */
    public void agregar_candidato(Candidato C, Elecc E, int x) {
        try {
            this.C.conectar();
            String stat = "select id_candidato from candidato where anno_cand = " + C.getAño() + " and nombre_candidato = '" + C.getNombre() + "' and carrera = '" + C.getCarrera() + "'";
            ResultSet rs = this.C.getConsulta().executeQuery(stat);
            if(!rs.next()){
                stat = "insert into candidato values (null, '" + C.getCarrera() + "', '" + C.getNombre() + "', " + C.getAño() + ")";
                this.C.getConsulta().execute(stat);
            }
            stat = "insert into elecciones_candidato values (null, (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + "), (select id_candidato from candidato where anno_cand = " + C.getAño() + " and nombre_candidato = '" + C.getNombre() + "' and carrera = '" + C.getCarrera() + "'), " + 0 + "," + 0 + ", " +  x + ")";
            this.C.getConsulta().execute(stat);
            this.C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregar_eleccion(String anno, String tipo_eleccion, int id,boolean b,int matricual) {
       int boleano=0;
        if(b){
            boleano=1;
             }
        try {
            this.C.conectar();
            String stat = "insert into elecciones values (null, (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + tipo_eleccion + "'), '" + anno + "', " + id + ", 0, 0, 0, 0,"+boleano+","+matricual+")";
            this.C.getConsulta().execute(stat);
            this.C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void quitar_votos(Boleta B, Elecc E, int votos) {
          C.conectar();
        try{
            int idE=0;
            String Eleccrs = "select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            ResultSet rs = C.getConsulta().executeQuery(Eleccrs);
            idE = rs.getInt("id_elecciones");
        if(B.getEn_blanco()){
            String stat = "update elecciones set boletas_en_blanco = " + E.getCantidad_de_boletas_en_blanco() + " where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            C.getConsulta().execute(stat);
        }
        else if(B.getInvalido()){
            
                String stat = "update elecciones set boletas_invalidas = " + E.getCantidad_de_boletas_invalidas()+ " where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
                C.getConsulta().execute(stat);
        }
        else{
            for(int i = 1; i < B.getCandidatos().size();i++){
                String stat = "select * from candidato where carrera = '" + B.getCandidatos().elementAt(i).getN1().getCarrera() + "' and nombre_candidato = '" + B.getCandidatos().elementAt(i).getN1().getNombre() + "' and anno_cand = " + B.getCandidatos().elementAt(i).getN1().getAño();
                rs = C.getConsulta().executeQuery(stat);
                int id = rs.getInt("id_candidato");
                String S = "select * from elecciones_candidato where id_candidato =" + id + " and id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + ")";
                rs = C.getConsulta().executeQuery(S);
                int voto_p = rs.getInt("voto_pdte");
                int voto_c = rs.getInt("voto_mbro");
                int idC = rs.getInt("id_elecciones_candidato");
                if(B.getCandidatos().elementAt(i).getN2().getN1()){
                    voto_c--;
                    stat = "update elecciones_candidato set voto_mbro = " + voto_c + " where id_elecciones_candidato = " + idC;
                    C.getConsulta().execute(stat);
                }
                if(B.getCandidatos().elementAt(i).getN2().getN2()){
                    voto_p--;
                    stat = "update elecciones_candidato set voto_pdte = " + voto_p + " where id_elecciones_candidato = " + idC;
                    C.getConsulta().execute(stat);
                }
            }
        }
        String stat = "update elecciones set votos = " + votos + " where id_elecciones = " + idE;
        C.getConsulta().execute(stat);
         } catch (SQLException ex) {
                Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        C.desconectar();
    }
    
    public void agregar_boleta(Elecc E, Boleta B, int votos){
        C.conectar();
        try{
            int idE=0;
            String St = "select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            ResultSet RESULT = this.C.getConsulta().executeQuery(St);
            idE = RESULT.getInt("id_elecciones");
            if(B.getInvalido()){
            
                String stat = "update elecciones set boletas_invalidas = " + E.getCantidad_de_boletas_invalidas()+ " where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
                C.getConsulta().execute(stat);
        }
             else if(B.getEn_blanco()){
            String stat = "update elecciones set boletas_en_blanco = " + E.getCantidad_de_boletas_en_blanco() + " where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            C.getConsulta().execute(stat);
        }
       
        else{
            for(int i = 1; i < B.getCandidatos().size();i++){
                String stat = "select * from candidato where carrera = '" + B.getCandidatos().elementAt(i).getN1().getCarrera() + "' and nombre_candidato = '" + B.getCandidatos().elementAt(i).getN1().getNombre() + "' and anno_cand = " + B.getCandidatos().elementAt(i).getN1().getAño();
                ResultSet rs = C.getConsulta().executeQuery(stat);
                int id = rs.getInt("id_candidato");
                String S = "select * from elecciones_candidato where id_candidato =" + id + " and id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + ")";
                rs = C.getConsulta().executeQuery(S);
                int voto_p = rs.getInt("voto_pdte");
                int voto_c = rs.getInt("voto_mbro");
                int idC = rs.getInt("id_elecciones_candidato");
                if(B.getCandidatos().elementAt(i).getN2().getN1()){
                    voto_c++;
                    stat = "update elecciones_candidato set voto_mbro = " + voto_c + " where id_elecciones_candidato = " + idC;
                    C.getConsulta().execute(stat);
                }
                if(B.getCandidatos().elementAt(i).getN2().getN2()){
                    voto_p++;
                    stat = "update elecciones_candidato set voto_pdte = " + voto_p + " where id_elecciones_candidato = " + idC;
                    C.getConsulta().execute(stat);
                }
            }
        }
             String stat = "update elecciones set votos = " + votos + " where id_elecciones = " + idE;
            C.getConsulta().execute(stat);
         } catch (SQLException ex) {
                Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        C.desconectar();
    }

    public Vector<Tupla<Candidato, Tupla<Entero, Entero>>> organizar_candidatos(Elecc E, int S) {
        Vector<Tupla<Candidato, Tupla<Entero, Entero>>> V = new Vector<>();
        try {
            this.C.conectar();
            String stat ="";
            switch (S) {
                case 0 -> stat = "select * from elecciones_candidato where id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + ") order by voto_mbro";
                case 1 -> stat = "select * from elecciones_candidato where id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + ") order by voto_pdte";
                case 2 -> stat = "select * from elecciones_candidato where id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + " and extra = 1)";
                case 3 -> stat = "select * from elecciones_candidato where id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + " and extra = 0)";
                default -> {
                }
            }
            ResultSet rs1 = C.getConsulta().executeQuery(stat);
            Vector<Tupla<Entero, Tupla<Entero,Entero>>> Lista = new Vector<>();
            while(rs1.next()){
                int idC = rs1.getInt("id_candidato");
                int VC = rs1.getInt("voto_mbro");
                int VP = rs1.getInt("voto_pdte");
                Lista.add(new Tupla<>(new Entero(idC), new Tupla<>(new Entero(VC), new Entero(VP))));
            }
                for(int i = 0; i < Lista.size();i++){
                 stat = "select * from candidato where id_candidato = " + Lista.elementAt(i).getN1().getEntero();
                ResultSet rs2 = C.getConsulta().executeQuery(stat);
                String idCar = rs2.getString("carrera");
                String nombre = rs2.getString("nombre_candidato");
                int anno = rs2.getInt("anno_cand");              
                V.add(new Tupla<>(new Candidato(nombre, idCar, anno),new Tupla<>(new Entero(Lista.elementAt(i).getN2().getN1().getEntero()), new Entero(Lista.elementAt(i).getN2().getN2().getEntero()))));
                }
                this.C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return V;
    }

    public void agregar_cantidad_de_votos(Elecc E) {
        try {
            C.conectar();
            
            String stat = "update elecciones set votos = " + E.getVotos() + " where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object =" + E.getId();
            C.getConsulta().execute(stat);
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void agregar_votos(Elecc E, int VC, int VP, int VB, int VI, Candidato C, boolean choice) {
        try {
            this.C.conectar();
            
            String stat = "select * from candidato where carrera = '" + C.getCarrera() + "' and nombre_candidato = '" + C.getNombre() + "' and anno_cand = " + C.getAño();
            ResultSet rs = this.C.getConsulta().executeQuery(stat);
            int id = rs.getInt("id_candidato");
            
            String S = "select * from elecciones_candidato where id_candidato =" + id + " and id_elecciones = (select id_elecciones from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId() + ")";
                rs = this.C.getConsulta().executeQuery(S);
                int voto_p = rs.getInt("voto_pdte");
                int voto_c = rs.getInt("voto_mbro");
                int idC = rs.getInt("id_elecciones_candidato");
                
                if(choice){
                    voto_p+=VP;
                    voto_c+=VC;
                }
                else{
                    voto_p-=VP;
                    voto_c-=VC;
                }
                
                
                stat = "update elecciones_candidato set voto_mbro = " + voto_c + " where id_elecciones_candidato = " + idC;
                    this.C.getConsulta().execute(stat);
                    stat = "update elecciones_candidato set voto_pdte = " + voto_p + " where id_elecciones_candidato = " + idC;
                    this.C.getConsulta().execute(stat);
                    
                   String quest = "select * from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
                    rs = this.C.getConsulta().executeQuery(quest);
                    int voto_b = rs.getInt("boletas_en_blanco");
                    int voto_i = rs.getInt("boletas_invalidas");
                    int id_E = rs.getInt("id_elecciones");
                    if(choice){
                    voto_b+=VB;
                    voto_i+=VI;
                    }
                    else{
                    voto_b-=VB;
                    voto_i-=VI;
                    }
                    quest = "update elecciones set boletas_en_blanco = " + voto_b + " where id_elecciones = " + id_E;
                    this.C.getConsulta().execute(quest);
                    quest = "update elecciones set boletas_invalidas = " + voto_i + " where id_elecciones = " + id_E;
                    this.C.getConsulta().execute(quest);
                    
                    this.C.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String devolver_nombre(Elecc E){
        
        
        String sol = "";
        try {
            C.conectar();
            
            String quest = "select * from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            ResultSet rs = C.getConsulta().executeQuery(quest);
            int id_tipo_eleccion = rs.getInt("id_tipo_eleccion");
            int id_object = rs.getInt("id_object");
            if(id_tipo_eleccion == 1){
                quest = "select nombre_beca from beca where id_beca = " + id_object;
                rs = C.getConsulta().executeQuery(quest);
                sol = rs.getString("nombre_beca");
            }
            else if(id_tipo_eleccion == 2){
                quest = "select nombre_fact from facultad where id_facultad = " + id_object;
                rs = C.getConsulta().executeQuery(quest);
                sol = rs.getString("nombre_fact");
            }
            
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sol;
    }

    public Vector<Tupla<Entero, Trio<String, String, String>>> devolver_elecciones() {
        Vector<Tupla<Entero, Trio<String, String, String>>> V = new Vector<>();
        Vector<Tupla<Entero, Entero>> V2 = new Vector<>();
        Vector<Tupla<Entero, String>> V3 = new Vector<>();
        try {
            C.conectar();
            
            String stat = "select * from elecciones";
            ResultSet rs = C.getConsulta().executeQuery(stat);
            while(rs.next()){
                V3.add(new Tupla<>(new Entero(rs.getInt("id_elecciones")), rs.getString("ano")));
                V2.add(new Tupla<>(new Entero(rs.getInt("id_tipo_eleccion")), new Entero(rs.getInt("id_object"))));
            }
            for(int i = 0; i < V3.size(); i++){
                switch (V2.elementAt(i).getN1().getEntero()) {
                    case 1 -> {
                        stat = "select nombre_beca from beca where id_beca = " + V2.elementAt(i).getN2().getEntero();
                        rs = C.getConsulta().executeQuery(stat);
                        String nombreB = rs.getString("nombre_beca");
                        stat = "select nombre_univ from universidad where id_universidad = (select id_universidad from beca where id_beca = " + V2.elementAt(i).getN2().getEntero() + ")";
                        rs = C.getConsulta().executeQuery(stat);
                        String nombreU = rs.getString("nombre_univ");
                        V.add(new Tupla<>(V3.elementAt(i).getN1(), new Trio<>(V3.elementAt(i).getN2(), nombreU, nombreB)));
                    }
                    case 2 -> {
                        stat = "select nombre_fact from facultad where id_facultad = " + V2.elementAt(i).getN2().getEntero();
                        rs = C.getConsulta().executeQuery(stat);
                        String nombreF = rs.getString("nombre_fact");
                        stat = "select nombre_univ from universidad where id_universidad = (select id_universidad from facultad where id_facultad = " + V2.elementAt(i).getN2().getEntero() + ")";
                        rs = C.getConsulta().executeQuery(stat);
                        String nombreU2 = rs.getString("nombre_univ");
                        V.add(new Tupla<>(V3.elementAt(i).getN1(), new Trio<>(V3.elementAt(i).getN2(), nombreU2, nombreF)));
                    }
                    default -> {
                        stat = "select nombre_univ from universidad where id_universidad = " + V2.elementAt(i).getN2().getEntero();
                        rs = C.getConsulta().executeQuery(stat);
                        V.add(new Tupla<>(V3.elementAt(i).getN1(), new Trio<>(V3.elementAt(i).getN2(), rs.getString("nombre_univ"), rs.getString("nombre_univ"))));
                    }
                }
            }
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return V;
    }
    
    public Tupla<Elecc, Entero> extraer_eleccion(int id){
        try {
            C.conectar();
            
            String stat = "select * from elecciones where id_elecciones = " + id;
            ResultSet rs = C.getConsulta().executeQuery(stat);
            
            String anno = rs.getString("ano");
            int id_tipo_eleccion = rs.getInt("id_tipo_eleccion");
            int id_object = rs.getInt("id_object");
            int boletas_invalidas = rs.getInt("boletas_invalidas");
            int boletas_en_blanco = rs.getInt("boletas_en_blanco");
            int votos = rs.getInt("votos");
            String tipo = "";
            int matricula = 0;
            String universidad = "";
            boolean repre = false;
            int idU = 0;
            
            switch (id_tipo_eleccion) {
                case 1 -> {
                    tipo = "Residencia";
                    stat = "select * from beca where id_beca = " + id_object;
                    rs = C.getConsulta().executeQuery(stat);
                    matricula = rs.getInt("matricula_beca");
                    idU = rs.getInt("id_universidad");
                    String stat2 = "select nombre_univ from universidad where id_universidad = " + idU;
                    rs = C.getConsulta().executeQuery(stat2);
                    universidad = rs.getString("nombre_univ");
                }
                case 2 -> {
                    tipo = "Facultad";
                    stat = "select * from facultad where id_facultad = " + id_object;
                    rs = C.getConsulta().executeQuery(stat);
                    matricula = rs.getInt("matricula");
                    idU = rs.getInt("id_universidad");
                    String SSS = "select nombre_univ from universidad where id_universidad = " + idU;
                    rs = C.getConsulta().executeQuery(SSS);
                    universidad = rs.getString("nombre_univ");
                }
                case 3 -> {
                    tipo = "Universidad";
                    String stat2 = "select * from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + tipo + "') and ano = '" + anno + "' and id_object = " + id_object;
                    rs=C.getConsulta().executeQuery(stat2);
                    if(rs.getBoolean("elecciones_especiales")){
                    matricula=rs.getInt("matricula");
                     stat = "select * from facultad where id_universidad = " + id_object;
                    rs = C.getConsulta().executeQuery(stat);
                   idU=rs.getInt("id_universidad");
                    }
                    else{
                        stat = "select * from facultad where id_universidad = " + id_object;
                    rs = C.getConsulta().executeQuery(stat);
                    while(rs.next()){
                        matricula += rs.getInt("matricula");
                        idU = rs.getInt("id_universidad");
                        
                    }
                    
                    }
                    String SS = "select nombre_univ from universidad where id_universidad = " + idU;
                    rs = C.getConsulta().executeQuery(SS);
                    universidad = rs.getString("nombre_univ");
                }
                default -> {
                }
            }
                
            
                String stat3 = "select * from elecciones_candidato where id_elecciones = " + id;
                rs = C.getConsulta().executeQuery(stat3);
                Vector<Tupla<Entero, Boolean>> V = new Vector<>();
                Vector<Candidato> nombres = new Vector<>();
                Vector<Tupla<Candidato, Entero>> Nombres_extra = new Vector<>();
                while(rs.next()){
                   V.add(new Tupla<>(new Entero(rs.getInt("id_candidato")), rs.getBoolean("extra")));
                }
                
               for(int i = 0; i < V.size(); i++){
                String stat4 = "select * from candidato where id_candidato = " + V.elementAt(i).getN1().getEntero();
                rs = C.getConsulta().executeQuery(stat4);
                String carrera = rs.getString("carrera");
                    String nombre = rs.getString("nombre_candidato");
                    int annos = rs.getInt("anno_cand");
                    Candidato Cand = new Candidato(nombre, carrera, annos);
                    if(V.elementAt(i).getN2()){
                        Nombres_extra.add(new Tupla<>(Cand, new Entero(0)));
                    }
                    else{
                        nombres.add(Cand);
                    }
                            }
               
               Elecc E = new Elecc(tipo, anno, id_object, matricula, universidad, repre);
               E.setCantidad_de_boletas_en_blanco(boletas_en_blanco);
               E.setCantidad_de_boletas_invalidas(boletas_invalidas);
               E.setVotos(votos);
               
               E.getNombres().addAll(nombres);
               E.getNombres_extra().addAll(Nombres_extra);
            
            C.desconectar();
            
                    return new Tupla<>(E, new Entero(idU));
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void actualiar_eleccion(Elecc E) {
        try {
            C.conectar();
            
            String stat = "update elecciones set all_cands = 1 where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            C.getConsulta().execute(stat);
            
            C.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean revisar_eleccion(Elecc E) {
        boolean X = false;
        try {
            C.conectar();
            
            String stat = "select all_cands from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            ResultSet rs = C.getConsulta().executeQuery(stat);
            X = rs.getBoolean("all_cands");
            
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        C.desconectar();
        return X;

    }

    public boolean revisar_eleccion_repetida(Elecc E) {
         boolean X = false;
        try {
            C.conectar();
            
            String stat = "select * from elecciones where id_tipo_eleccion = (select id_tipo_eleccion from tipo_eleccion where tipo_eleccion = '" + E.getTipo_de_eleccion() + "') and ano = '" + E.getAnno() + "' and id_object = " + E.getId();
            ResultSet rs = C.getConsulta().executeQuery(stat);
            X = rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        C.desconectar();
        return X;
    }
    
}
