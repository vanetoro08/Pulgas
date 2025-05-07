package gamePulgas.models;

import java.awt.Rectangle;

/**
 * Representa una pulga mutante en el juego.
 * 
 * Pulga mutante tiene un escudo adicional que actúa como protección extra
 * 
 * El escudo inicialmente tiene el mismo valor que la vida y se reduce cuando recibe daño
 * Cuando el escudo llega a 1 o menos, puede transformarse en una Pulga normal
 * 
 * @author Nicolas Agudelo Grajales
 */
public class PulgaMutante extends Pulga {

    /** Escudo protector adicional de la pulga mutante */
    private int escudo;

    /**
     * Constructor que inicializa una pulga mutante con posicion, tamaño, vida y puntos
     * 
     * @param x      Coordenada X
     * @param y      Coordenada Y
     * @param height Altura del sprite
     * @param width  Ancho del sprite
     * @param vida   Vida inicial (también se usa para inicializar el escudo)
     * @param puntos Puntos que otorga si es destruida
     */
    public PulgaMutante(int x, int y, int height, int width, int vida, int puntos) {
        super(x, y, height, width, vida, "/imagesPulgas/pulgaMutante.png", puntos);
        this.escudo = vida;
    }

    /**
     * Obtiene el valor actual del escudo
     * 
     * @return Valor del escudo
     */
    public int getEscudo() {
        return escudo;
    }

    /**
     * Establece un nuevo valor para el escudo
     * 
     * @param escudo Nuevo valor de escudo
     */
    public void setEscudo(int escudo) {
        this.escudo = escudo;
    }

    @Override
    public void refresh() {}
    @Override
    public Rectangle getBoundaries() {
        return null;
    }
}
