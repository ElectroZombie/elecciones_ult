/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Joan Manuel
 */
public class Sonido {
    public  Clip clip;
    public   String ruta="/sonido/";
   public  void   sonido(String a){
       try {
           clip= AudioSystem.getClip();
           clip.open(AudioSystem.getAudioInputStream(getClass().getResource(ruta+a+".wav")));
           clip.start();
       } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
       }
   
   }
}
