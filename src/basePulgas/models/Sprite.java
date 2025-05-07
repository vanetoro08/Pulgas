/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basePulgas.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


/**
 * Clase abstracta que representa un sprite dentro del juego.
 * Proporciona propiedades básicas como posición, tamaño, color e imagen
 * 
 * 
 * Esta clase debe ser extendida por cualquier entidad gráfica que desee
 * ser dibujada y actualizada dentro de un contenedor gráfico.
 * 
 * @author Nicolas Agudelo
 */
public abstract class Sprite {
    // cordenadas horizontales
    protected int x;
   // cordenadas verticales
    protected int y;
    // Alto del sprite
    protected int height;
    // Ancho del sprite
    protected int width;
    // Color de sprite 
    protected Color color;
    // imagen del Sprite
    protected ImageIcon image;
    // contenedor grafico del sprite
    protected GraphicContainer gameContainer;
    /**
     * Constructor para crear un nuevo sprite con posición y tamaño inicial.
     * 
     * @param x Coordenada X inicial.
     * @param y Coordenada Y inicial.
     * @param height Altura del sprite.
     * @param width Anchura del sprite.
     */
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    /**
     * Verifica si el sprite actual se encuentra fuera de los límites del contenedor gráfico.
     * 
     * @return true si el sprite está fuera de los límites, false en caso contrario.
     */
    public boolean isOutOfGraphicContainer()
    {
        return isOutOfGraphicContainer(x, y, width, height);
    }
     /**
     * Verifica si un rectángulo definido por posición y tamaño está fuera de los límites del contenedor gráfico.
     * 
     * @param x Coordenada X del rectángulo.
     * @param y Coordenada Y del rectángulo.
     * @param width Ancho del rectángulo.
     * @param height Alto del rectángulo.
     * @return true si está fuera del contenedor, false si está dentro.
     */
    public boolean isOutOfGraphicContainer(int x, int y, int width, int height)
    {
        if(gameContainer == null)
            return false;
        
        Rectangle bounds = gameContainer.getBoundaries();
        
        return !(x >= bounds.getX() &
                 y >= bounds.getY() &
                 x + width  <= bounds.getX() + bounds.getWidth() &
                 y + height <= bounds.getY() + bounds.getHeight());
    }
     /**
     * Verifica si hay una colisión entre este sprite y otro sprite dado.
     * 
     * @param other El otro sprite con el cual se comprueba la colisión.
     * @return true si hay colisión, false en caso contrario.
     */
    public boolean checkCollision(Sprite other)
    {
        // Collision x-axis?
        boolean collisionX = this.getX() + this.getWidth() >= other.getX() &&
            this.getX() < other.getX() + other.getWidth();

        // Collision y-axis?
        boolean collisionY = this.getY() + this.getHeight() >= other.getY() &&
            this.getY() < other.getY() + other.getHeight();

        // Collision only if on both axes
        return collisionX && collisionY;        
    }
    /**
     * Método abstracto para pintar el sprite.
     * Cada subclase debe implementar su propia lógica de renderizado.
     * 
     * @param g Contexto gráfico sobre el cual dibujar.
     */
    public abstract void paint(Graphics g);
    // Getters y setters estándar para los atributos del sprite
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public void setGraphicContainer(GraphicContainer gContainer) {
        this.gameContainer = gContainer;
    }
}