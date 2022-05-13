/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import javax.swing.JFrame;

/**
 *
 * @author SchWarZer
 */
public class Bloqueo {
    
    JFrame A;
    public Bloqueo(JFrame A){
        this.A = A;        
    }
    
    public void bloquear_A(){
        A.setEnabled(false);
    }
    
    public void desbloquear_A(){
        A.setEnabled(true);
    }
}
