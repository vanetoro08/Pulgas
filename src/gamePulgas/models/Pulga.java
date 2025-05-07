package gamePulgas.models;

import basePulgas.models.SpritesContainer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
 * Clase abstracta que representa una pulga dentro del juego.
 * Hereda de {@code SpritesContainer}, y provee funcionalidades básicas comunes
 * como renderizado, puntos, vida y estado de la pulga.
 * 
 * Las clases concretas como {@code PulgaNormal} o {@code PulgaMutante}
 * deben extender esta clase para implementar comportamientos específicos.
 * 
 * @author Nicolas Agudelo Grajales
 */
public abstract class Pulga extends SpritesContainer {
    private boolean viva = true;
    private int vida;
    private int puntos;
    private ImageObserver imageObserver;
    private ImageIcon image;

    /**
     * Constructor base para una pulga
     * 
     * @param x         Coordenada X de la pulga
     * @param y         Coordenada Y de la pulga
     * @param height    Alto del sprite
     * @param width     Ancho del sprite
     * @param vida      Vida inicial de la pulga
     * @param imagePath Ruta del recurso de imagen (debe estar en el classpath)
     * @param puntos    Puntos que otorga al ser eliminada
     */
    public Pulga(int x, int y, int height, int width, int vida, String imagePath, int puntos) {
        super(x, y, height, width);
        this.vida = vida;
        this.image = new ImageIcon(getClass().getResource(imagePath));
        this.puntos = puntos;
    }

    /**
     * Renderiza la imagen de la pulga en el componente grafico
     * 
     * @param g Objeto {@code Graphics} usado para dibujar la imagen
     */
    @Override
    public void paint(Graphics g) {
        Image image = this.image.getImage();
        g.setColor(color);
        g.drawImage(image, x, y, width, height, color, imageObserver);
    }

    /**
     * Verifica si la pulga sigue viva.
     * 
     * @return {@code true} si está viva, {@code false} en caso contrario
     */
    public boolean isViva() {
        return viva;
    }

    /**
     * Establece el estado de vida de la pulga.
     * 
     * @param viva {@code true} si está viva, {@code false} si ha sido eliminada
     */
    public void setViva(boolean viva) {
        this.viva = viva;
    }

    /**
     * Obtiene la vida actual de la pulga
     * 
     * @return Vida restante
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece un nuevo valor de vida para la pulga
     * 
     * @param vida Nueva cantidad de vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Devuelve los puntos que otorga la pulga al eliminarla
     * 
     * @return Valor en puntos
     */
    public int getPuntos() {
        return puntos;
    }
}
