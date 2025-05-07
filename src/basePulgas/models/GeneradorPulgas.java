package basePulgas.models;

// @author vanes

import gamePulgas.models.CampoPulgas;

public class GeneradorPulgas extends Thread {
    private CampoPulgas campoPulgas;
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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {               
               running = false;
            }
        }
    }
    
    public void detener() {
        running = false;
        this.interrupt();
    }
}
