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
    //attiva l'abilità quando si trova a metà gara, controlla che c'è qualcuno nelle 10 posizioni vicino a lei
    //e in caso ci fossero lo bloccca per 200 ms
    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        if (posizioneAttuale < 50) {
            return false;
        }

        boolean qualcunoVicino = false;
        for (Cavallo c : tuttiCavalli) {
            if (c != seStesso && Math.abs(c.getPosizione() - posizioneAttuale) <= 10) {
                c.setRallentamento(300, 3); // 300ms per 3 step
                qualcunoVicino = true;
            }
        }
        return qualcunoVicino;
    }
}
