/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;

import java.util.List;
/**
 *
 * @author ranasgalla.niccolo
 */
public class AbilitaGoldShip implements Abilita {

    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        if (posizioneAttuale < 50) return false;

        long cavalliDavanti = 0;
        for (Cavallo c : tuttiCavalli) {
            if (c != seStesso && c.getPosizione() > posizioneAttuale) {
                cavalliDavanti++;
            }
        }

        if (cavalliDavanti >= 2) {
            seStesso.setSleep(5);
            return true;
        }
        return false;
    }
}
