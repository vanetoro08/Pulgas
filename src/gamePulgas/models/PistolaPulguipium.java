package gamePulgas.models;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Clase que representa el arma PistolaPulguipium
 * Esta arma permite eliminar una pulga si el jugador hace clic sobre ella
 * Si se trata de una {@code PulgaMutante}, se le reduce el escudo hasta transformarse
 * en una {@code PulgaNormal}; si es una {@code PulgaNormal}, se elimina directamente
 * 
 * Hereda de la clase abstracta {@code Arma}
 * 
 * @author Vanessa Toro Sepluveda
 */
public class PistolaPulguipium extends Arma {

    private Point click;

    /**
     * Establece la posición del clic donde el jugador ha disparado
     * 
     * @param click Punto del clic del mouse.
     */
    public void setClick(Point click) {
        this.click = click;
    }

    /**
     * Usa el arma PistolaPulguipium para disparar a una pulga en la posición clickeada
     * 
     * @param pulgas Lista de pulgas activas en el campo.
     * @return La cantidad de puntos obtenidos al eliminar una pulga. Devuelve 0 si no se impacta ninguna
     */
    @Override
    public int usarArma(ArrayList<Pulga> pulgas) {
        int puntosConseguidos = 0;

        for (int i = 0; i < pulgas.size(); i++) {
            Pulga pulga = pulgas.get(i);
            Rectangle bounds = new Rectangle(pulga.getX(), pulga.getY(), pulga.getWidth(), pulga.getHeight());

            if (bounds.contains(click)) {
                if (pulga instanceof PulgaMutante) {
                    PulgaMutante pm = (PulgaMutante) pulga;
                    pm.setEscudo(pm.getEscudo() - 1);
                    if (pm.getEscudo() <= 1) {
                        PulgaNormal nueva = new PulgaNormal(pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight(), 1, 600);
                        pulgas.remove(i);
                        pulgas.add(nueva);
                    }
                } else if (pulga instanceof PulgaNormal) {
                    puntosConseguidos = pulga.getPuntos();
                    pulgas.remove(i);
                }
                return puntosConseguidos;
            }
        }

        return 0;
    }
}
