/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;
import java.util.*;
/**
 *
 * @author ranasgalla.niccolo
 */
public interface Abilita {
    //Boolena che permette di attivare l'attivita una singola volta a partita
    boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale);
}
