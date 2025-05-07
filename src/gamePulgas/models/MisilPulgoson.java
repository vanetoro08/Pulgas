package gamePulgas.models;

// @author vanes

import gamePulgas.models.Arma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa el arma especial MisilPulgoson
 * Este arma elimina aleatoriamente la mitad de las pulgas activas en el campo
 * y suma sus puntos al puntaje total del jugador
 * 
 * Hereda de la clase abstracta {@code Arma}
 * 
 * @author Vanessa Toro Sepulveda
 */
public class MisilPulgoson extends Arma{
    /**
     * Usa el arma MisilPulgoson para eliminar aleatoriamente la mitad de las pulgas
     * 
     * @param pulgas Lista de pulgas activas en el campo
     * @return La cantidad total de puntos obtenidos por eliminar las pulgas
     */
    
    @Override
    public int usarArma(ArrayList<Pulga> pulgas) {
        int puntosTotales = 0; 
        int totalPulgas = pulgas.size();
        int eliminarCantidad = totalPulgas / 2;
        Random random = new Random();
        for (int i = 0; i < eliminarCantidad; i++) {
            if (pulgas.isEmpty()) {
                break;
            }
            int index = random.nextInt(pulgas.size());
            Pulga pulga = pulgas.get(index);
            puntosTotales += pulga.getPuntos();
            pulgas.remove(index);
        }
        return puntosTotales;
    }

}
