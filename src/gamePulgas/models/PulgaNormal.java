package gamePulgas.models;

import java.awt.Rectangle;

/**
 * Representa una pulga normal en el juego
 * @author Nicolas Agudelo Grajales
 */
public class PulgaNormal extends Pulga {

    /**
     * Constructor que inicializa una pulga normal con sus atributos basicos
     * 
     * @param x      Coordenada X
     * @param y      Coordenada Y
     * @param height Altura del sprite
     * @param width  Ancho del sprite
     * @param vida   Vida inicial
     * @param puntos Puntos que otorga si es destruida
     */
    public PulgaNormal(int x, int y, int height, int width, int vida, int puntos) {
        super(x, y, height, width, vida, "/imagesPulgas/pulgaNormal.png", puntos);
    }

    @Override
    public void refresh() {}
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
