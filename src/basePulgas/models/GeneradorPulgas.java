package basePulgas.models;

/*
@author Vanessa Toro
Clase que se encarga de generar las pulgas
*/

import gamePulgas.models.CampoPulgas;

public class GeneradorPulgas extends Thread {
    /*
    atributos
    */
    //variable que contiene el metodo para generar las pulgas
    private CampoPulgas campoPulgas;
    //booleano que demuestra que se estÃ¡ ejecutando
    private boolean running = true;
    /*
    Constructor que inicializa el campo de pulgas
    @param CampoPulgas campoPulgas
    */
    public GeneradorPulgas(CampoPulgas campoPulgas) {
        this.campoPulgas = campoPulgas;
    }
    /*
    Hilo encargado de generar pulgas cada 5 segundos y mutantes cada 10 segundos
    */
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
    /*
    metodo que para la generaciÃ³n de pulgas
    */
    public void detener() {
        running = false;
        this.interrupt();
    }
}