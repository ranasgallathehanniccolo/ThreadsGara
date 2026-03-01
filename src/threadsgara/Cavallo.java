/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.util.*;
/**
 *
 * @author ranasgalla.niccolo
 */
public class Cavallo implements Runnable {

    private JProgressBar pb;
    private javax.swing.JTextArea ta;
    private String nome;
    private Abilita abilita;

    private int posizione = 0;
    private boolean bloccato = false;
    private int sleepOverride = -1;

    private static int posizioneArrivo = 0;
    private static final List<Cavallo> tuttiCavalli = Collections.synchronizedList(new ArrayList<>());

    public Cavallo(JProgressBar pb, javax.swing.JTextArea ta, String nome, Abilita abilita) {
        this.pb = pb;
        this.ta = ta;
        this.nome = nome;
        this.abilita = abilita;
        tuttiCavalli.add(this);
    }

    public static void resetPosizione() {
        posizioneArrivo = 0;
        tuttiCavalli.clear();
    }

    public synchronized int getPosizione() { return posizione; }
    public String getNome() { return nome; }

    public synchronized void setBloccato(boolean b) {
        bloccato = b;
        if (!b) {
            notifyAll(); // sveglia il thread che era in wait
        }
    }
    public synchronized void setSleep(int ms) { sleepOverride = ms; }

    @Override
    public void run() {
        boolean abilitaUsata = false;

        for (int i = 0; i <= 100; i++) {

            // Aspetta se bloccata
            synchronized (this) {
                while (bloccato) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                posizione = i;
            }

            final int pos = i;
            SwingUtilities.invokeLater(() -> pb.setValue(pos));

            // Controlla abilità
            if (!abilitaUsata && abilita != null) {
                abilitaUsata = abilita.attiva(this, tuttiCavalli, posizione);
            }

            // Sleep con eventuale boost
            try {
                int sleepAttuale;
                synchronized (this) {
                    sleepAttuale = (sleepOverride != -1) ? sleepOverride : (int)(Math.random() * 100) + 20;
                    sleepOverride = -1;
                }
                Thread.sleep(sleepAttuale);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Posizione di arrivo
        synchronized (Cavallo.class) {
            posizioneArrivo++;
            final int arr = posizioneArrivo;
            SwingUtilities.invokeLater(() -> ta.append(arr + "° - " + nome + "\n"));
        }
    }
}