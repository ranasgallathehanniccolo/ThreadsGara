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
    FULMINE("Fulmine"),
    VENTO("Vento"),
    TEMPESTA("Tempesta"),
    SAETTA("Saetta");

    private final String nome;

    TipiCavalli(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
