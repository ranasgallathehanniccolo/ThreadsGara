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

    public ProgressBarGUI(TipiCavalli tipo) {
        ImageIcon icon = new ImageIcon(getClass().getResource(tipo.getPathGif()));
        gif = icon.getImage();
    }

    @Override
    public void paintDeterminate(Graphics g, JComponent c) {
        super.paintDeterminate(g, c);

        int larghezza = c.getWidth();
        int altezza = c.getHeight();
        int x = (int) (progressBar.getPercentComplete() * (larghezza - 40));

        if (gif != null) {
            g.drawImage(gif, x, 0, 40, altezza, null);
        }
    }
}