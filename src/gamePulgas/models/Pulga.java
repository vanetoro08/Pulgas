/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamePulgas.models;

import basePulgas.models.SpritesContainer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 *
 * @author Nico
 */
public abstract class Pulga extends SpritesContainer{
    
    private boolean viva= true;
    private int vida; 
    private int puntos; 
    private ImageObserver imageObserver; 
    private ImageIcon image;    
    
    public Pulga(int x, int y, int height, int width, int vida,String imagePath, int puntos) {
        super(x, y, height, width);
        this.vida= vida;
        this.image = new ImageIcon(getClass().getResource(imagePath));
        this.puntos = puntos; 
    }
    
    @Override   
    public void paint(Graphics g){
        Image image = this.image.getImage();
        g.setColor(color);
        g.drawImage(image, x, y, width, height, color, imageObserver);
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPuntos() {
        return puntos;
    }
    
    
}
