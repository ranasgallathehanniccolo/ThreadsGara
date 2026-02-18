/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import java.util.Random;

public class Cavallo implements Runnable {

    private final TipiCavalli tipo;
    private final JProgressBar progressBar;
    private final Gara gara;
    private int posizione; // 0-100
    private final Random random = new Random();

    public Cavallo(TipiCavalli tipo, JProgressBar progressBar, Gara gara) {
        this.tipo = tipo;
        this.progressBar = progressBar;
        this.gara = gara;
        this.posizione = 0;
        progressBar.setValue(0);
        progressBar.setString(tipo.getNome() + " - In attesa");
        progressBar.setStringPainted(true);
    }

    public TipiCavalli getTipo() {
        return tipo;
    }

    public void reset() {
        posizione = 0;
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(0);
            progressBar.setString(tipo.getNome() + " - In attesa");
        });
    }

    @Override
    public void run() {
        SwingUtilities.invokeLater(() ->
            progressBar.setString(tipo.getNome() + " - In corsa...")
        );

        while (posizione < 100 && !gara.isFinita()) {
            // Avanza di un passo random tra 1 e 5
            int passo = random.nextInt(5) + 1;
            posizione = Math.min(posizione + passo, 100);

            final int pos = posizione;
            SwingUtilities.invokeLater(() -> progressBar.setValue(pos));

            try {
                // Velocità random: ogni cavallo ha ritmi diversi
                Thread.sleep(random.nextInt(150) + 50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Se questo cavallo ha raggiunto 100 e la gara non era già finita
        if (posizione >= 100) {
            gara.segnalaVincitore(this);
        }
    }
}