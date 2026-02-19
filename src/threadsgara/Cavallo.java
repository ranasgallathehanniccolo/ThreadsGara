/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.util.Random;

public class Cavallo implements Runnable {

    private JProgressBar pb;
    private javax.swing.JTextArea ta;
    private String nome;
    private static int posizioneArrivo = 0;

    public Cavallo(JProgressBar pb, javax.swing.JTextArea ta, String nome) {
        this.pb = pb;
        this.ta = ta;
        this.nome = nome;
    }

    public static void resetPosizione() {
        posizioneArrivo = 0;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            final int pos = i;
            SwingUtilities.invokeLater(() -> pb.setValue(pos));
            
            try {
                Thread.sleep((int)(Math.random() * 100) + 20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        synchronized (Cavallo.class) {
            posizioneArrivo++;
            final int pos = posizioneArrivo;
            SwingUtilities.invokeLater(() -> ta.append(pos + "° - " + nome + "\n"));
        }
    }
}