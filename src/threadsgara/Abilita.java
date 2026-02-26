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
    // Ritorna true se l'abilità si è attivata (così non si riattiva)
    boolean attiva(Cavallo seSstesso, List<Cavallo> tuttiCavalli, int posizioneAttuale);
}
