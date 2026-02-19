/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadsgara;

/**
 *
 * @author ranasgalla.niccolo
 */
public enum TipiCavalli {
    OGURI_CAP("Oguri Cap", "/threadsgara/gifs/oguricap.gif"),
    RICE_SHOWER("Rice Shower", "/threadsgara/gifs/riceshower.gif"),
    GOLD_SHIP("Gold Ship", "/threadsgara/gifs/goldship.gif"),
    MEJIRO_MCQUEEN("Mejiro McQueen", "/threadsgara/gifs/mejiro.gif");

    private final String nome;
    private final String pathGif;

    TipiCavalli(String nome, String pathGif) {
        this.nome = nome;
        this.pathGif = pathGif;
    }

    public String getNome() {
        return nome;
    }

    public String getPathGif() {
        return pathGif;
    }
}
