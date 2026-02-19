/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
/**
 *
 * @author ranasgalla.niccolo
 */
public class ProgressBarGUI extends BasicProgressBarUI {

    private Image gif;

    public ProgressBarGUI() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/threadsgara/cavallo.gif"));
        gif = icon.getImage();
    }

    @Override
    public void paintDeterminate(Graphics g, JComponent c) {
        // Disegna la barra normale
        super.paintDeterminate(g, c);

        // Calcola la posizione X della gif in base al valore della barra
        int larghezza = c.getWidth();
        int altezza = c.getHeight();
        int x = (int)(progressBar.getPercentComplete() * (larghezza - 40));

        // Disegna la gif sopra la barra
        if (gif != null) {
            g.drawImage(gif, x, 0, 40, altezza, null);
        }
    }
}
