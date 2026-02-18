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
public class Gara {
    private List<Cavallo> cavalli = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();
    private boolean finita = false;
    private Cavallo vincitore = null;

    // Listener per notificare la UI quando c'è un vincitore
    private VincitoreListener vincitoreListener;

    public interface VincitoreListener {
        void onVincitore(Cavallo vincitore);
    }

    public void setVincitoreListener(VincitoreListener listener) {
        this.vincitoreListener = listener;
    }

    public void aggiungiCavallo(Cavallo cavallo) {
        cavalli.add(cavallo);
    }

    public boolean isFinita() {
        return finita;
    }

    public synchronized void segnalaVincitore(Cavallo cavallo) {
        if (!finita) {
            finita = true;
            this.vincitore = cavallo;
            if (vincitoreListener != null) {
                vincitoreListener.onVincitore(cavallo);
            }
        }
    }

    public Cavallo getVincitore() {
        return vincitore;
    }

    public void avvia() {
        finita = false;
        vincitore = null;
        threads.clear();

        for (Cavallo c : cavalli) {
            Thread t = new Thread(c);
            t.setDaemon(true);
            threads.add(t);
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    public void reset() {
        finita = true; // Ferma i thread in corso
        for (Cavallo c : cavalli) {
            c.reset();
        }
        finita = false;
        vincitore = null;
    }
}
