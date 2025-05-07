package basePulgas.models;

// @author vanes

import gamePulgas.models.CampoPulgas;

public class GeneradorPulgas extends Thread {
    private final CampoPulgas campoPulgas;
    private boolean running = true;
    
    public GeneradorPulgas(CampoPulgas campoPulgas) {
        this.campoPulgas = campoPulgas;
    }

    @Override
    public void run() {
        long tiempoInicial = System.currentTimeMillis();
        long ultimaPulgaNormal = 0;
        long ultimaPulgaMutante = 0;
        
        while (running) {
            long tiempoActual = System.currentTimeMillis();
            long tiempoTranscurrido = tiempoActual - tiempoInicial;
            
            if (tiempoTranscurrido - ultimaPulgaNormal >= 5000) {
                campoPulgas.agregarPulgaNormal();
                ultimaPulgaNormal = tiempoTranscurrido;
            }
            
            if (tiempoTranscurrido - ultimaPulgaMutante >= 10000) {
                campoPulgas.agregarPulgaMutante();
                ultimaPulgaMutante = tiempoTranscurrido;
            }           
        }
    }
    
    public void detener() {
        running = false;
        this.interrupt();
    }
}
