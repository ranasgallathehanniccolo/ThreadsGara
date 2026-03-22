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
public class AbilitaOguriCap implements Abilita {

    //attiva l'abilita quando gli pare e vede se c'è qualcuno davanti a se, quello più vicino
    //si bloccherà per 300 ms e poi si da un boost
    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        Cavallo primodavanti = null;
        for (Cavallo c : tuttiCavalli) {
            if (c != seStesso && c.getPosizione() > posizioneAttuale) {
                if (primodavanti == null || c.getPosizione() < primodavanti.getPosizione()) {
                    primodavanti = c;
                }
            }
        }
        if (primodavanti != null && Math.random() < 0.6) {
            primodavanti.setRallentamento(400, 4);
            seStesso.setSleep(5);
            return true;
        }
        return false;
    }
}
