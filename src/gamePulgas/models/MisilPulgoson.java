package gamePulgas.models;

// @author vanes

import gamePulgas.models.Arma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MisilPulgoson extends Arma{
    
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
