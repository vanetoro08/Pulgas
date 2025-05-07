/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamePulgas.models;

import java.awt.Rectangle;

/**
 *
 * @author Nico
 */
public class PulgaMutante extends Pulga{

    private int escudo; 
    
    
    public PulgaMutante(int x, int y, int height, int width, int vida, int puntos) {
        super(x, y, height, width, vida,"/imagesPulgas/pulgaMutante.png", puntos);
        this.escudo=vida; 
    }

    public int getEscudo() {
        return escudo;
    }

    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    

    @Override public void refresh(){}
    @Override public Rectangle getBoundaries() {
        return null;
    } 
    
}
