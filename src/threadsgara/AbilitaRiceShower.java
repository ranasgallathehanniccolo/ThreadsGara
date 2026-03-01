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
public class AbilitaRiceShower implements Abilita {

    @Override
    public boolean attiva(Cavallo seStesso, List<Cavallo> tuttiCavalli, int posizioneAttuale) {
        if (posizioneAttuale >= 85) {
            seStesso.setSleep(5);
            return true;
        }
        return false;
    }
}
