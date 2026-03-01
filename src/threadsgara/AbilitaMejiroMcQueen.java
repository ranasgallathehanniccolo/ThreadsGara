/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;
import java.util.List;
/**
 *
 * @author Windows
 */
public class AbilitaMejiroMcQueen implements Abilita {

    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        if (posizioneAttuale < 50) return false;

        boolean qualcunoVicino = false;
        for (Cavallo c : tuttiCavalli) {
            if (c != seStesso && Math.abs(c.getPosizione() - posizioneAttuale) <= 10) {
                c.setSleep(200);
                qualcunoVicino = true;
            }
        }

        if (qualcunoVicino) {
            seStesso.setSleep(80);
            return true;
        }
        return false;
    }
}
