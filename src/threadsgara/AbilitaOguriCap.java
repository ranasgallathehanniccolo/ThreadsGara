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

    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        // Trova cavalli davanti
        Cavallo primodavanti = null;
        for (Cavallo c : tuttiCavalli) {
            if (c != seStesso && c.getPosizione() > posizioneAttuale) {
                if (primodavanti == null || c.getPosizione() < primodavanti.getPosizione()) {
                    primodavanti = c;
                }
            }
        }

        if (primodavanti != null && Math.random() < 0.6) {
            final Cavallo target = primodavanti;
            // Blocca il cavallo davanti per 2 secondi
            new Thread(() -> {
                target.setBloccato(true);
                try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                target.setBloccato(false);
            }).start();

            // Boost a se stessa
            seStesso.setSleep(5);
            return true; // abilità usata
        }
        return false;
    }
}
