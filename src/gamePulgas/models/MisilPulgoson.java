package gamePulgas.models;

// @author vanes

import gamePulgas.models.Arma;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MisilPulgoson{
    
    public void usarArma(ArrayList<PulgaNormal> normales, ArrayList<PulgaMutante> mutantes) {
        int eliminarNormales = normales.size() / 2;
        int eliminarMutantes = mutantes.size() / 2; 

        for (int i = 0; i < eliminarNormales; i++) {
            if (!normales.isEmpty()) {
                normales.remove(0);
            }
        }

        for (int i = 0; i < eliminarMutantes; i++) {
            if (!mutantes.isEmpty()) {
                mutantes.remove(0);
            }
        }
        
    }

}
