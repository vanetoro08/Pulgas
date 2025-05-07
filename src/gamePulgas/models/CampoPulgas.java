package gamePulgas.models;

// @author vanes

import basePulgas.models.EscritorArchivoTextoPlano;
import basePulgas.models.GeneradorPulgas;
import basePulgas.models.GraphicContainer;
import basePulgas.models.Lector;
import basePulgas.models.LectorArchivoTextoPlano;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el campo de batalla donde se desarrolla el juego de las pulgas.
 * Maneja la lógica de aparición, movimiento, interacción y puntuación de las pulgas.
 * @author Vanessa Toro Sepulveda
 */
public class CampoPulgas extends JPanel implements GraphicContainer, MouseListener,KeyListener{
    
    private ArrayList<Pulga> pulgas; 
    private GeneradorPulgas generadorPulgas;
    private int puntajeTotal = 0; 
    private int puntajeMaximo = 0;
    private LectorArchivoTextoPlano lector; 
    private JLabel labelPuntajeActual; 
    private JLabel labelPuntajeMaximo;

    /**
     * Constructor que inicializa el campo, los elementos visuales y logicos del juego
     * @throws IOException Si ocurre un error al leer los archivos de puntaje
     */    
    public CampoPulgas() throws IOException {
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        
        lector = new LectorArchivoTextoPlano(); 

        pulgas = new ArrayList<>();
        
        generadorPulgas = new GeneradorPulgas(this);
        generadorPulgas.start();       
        
        addMouseListener(this);
        addKeyListener(this);
        requestFocusInWindow();
        
        labelPuntajeActual = new JLabel("Puntaje: " + puntajeTotal);
        labelPuntajeActual.setForeground(Color.WHITE);
        labelPuntajeActual.setFont(new Font("Arial", Font.BOLD, 16));
        labelPuntajeActual.setBounds(10, 10, 150, 30);
        this.add(labelPuntajeActual);
        
        labelPuntajeMaximo = new JLabel("Récord: " + puntajeMaximo);
        labelPuntajeMaximo.setForeground(Color.WHITE);
        labelPuntajeMaximo.setFont(new Font("Arial", Font.BOLD, 16));
        labelPuntajeMaximo.setBounds(650, 10, 150, 30);
        this.add(labelPuntajeMaximo);
    }
    
    /**
     * Agrega una pulga normal en una posicion aleatoria del campo, sin superposicion
     */    
    public void agregarPulgaNormal() {
       int x;
       int y;
       PulgaNormal pulga;
       do{
           x = (int) (Math.random() * (getWidth() - 40));
           y = (int) (Math.random() * (getHeight() - 40));
           pulga = new PulgaNormal(x, y, 40, 40, 1, 200);
       }while(checkPosition(pulga));
       
       pulgas.add(pulga);
       repaint();
   }
    /**
     * Agrega una pulga mutante en una posición aleatoria del campo, sin superposicion
     */
    public void agregarPulgaMutante() {
       int x;
       int y;
       PulgaMutante pulga;
        do{
            x = (int) (Math.random() * (getWidth() - 40));
            y = (int) (Math.random() * (getHeight() - 40));
            pulga = new PulgaMutante(x, y, 40, 40, 2, 600);
        }while(checkPosition(pulga));
       
       
       pulgas.add(pulga);
       repaint();
        
    }
    /**
     * Hace que todas las pulgas salten a nuevas posiciones aleatorias
     */    
    public void saltarPulgas(){
        
        for(int i=0; i<pulgas.size(); i++){
            Pulga pulguita = pulgas.get(i);
            do{
                pulguita.setX((int) (Math.random() * (getWidth() - 40))); 
                pulguita.setY((int) (Math.random() * (getHeight() - 40)));
            }while(checkPosition(pulguita));
            pulgas.set(i , pulguita);
        }
        repaint();
    }
    
    /**
     * Maneja los clics del mouse. Dispara el arma si se hace clic izquierdo
     */    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            PistolaPulguipium pistola = new PistolaPulguipium();           
            pistola.setClick(new Point(e.getX(), e.getY()));
             
            puntajeTotal += pistola.usarArma(pulgas);                  
            labelPuntajeActual.setText("Puntaje: " + puntajeTotal);
            verificarFinDelJuego();
            repaint();
        }
    }
    
    /**
     * Maneja las teclas presionadas por el usuario
     * P - agrega pulga normal
     * M - agrega pulga mutante
     * S - hace saltar a las pulgas
     * Q - guarda puntaje y cierra el juego
     * Espacio - dispara misil
     */    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P -> agregarPulgaNormal();
            case KeyEvent.VK_M -> agregarPulgaMutante();
            case KeyEvent.VK_S -> saltarPulgas();
            case KeyEvent.VK_Q -> { 
            try {
                anotarPuntuacion();
            } catch (IOException ex) {
                Logger.getLogger(CampoPulgas.class.getName()).log(Level.SEVERE, null, ex);
            }
                generadorPulgas.detener();
                System.exit(0);
                generadorPulgas.detener();
                System.exit(0);
            }
            case KeyEvent.VK_SPACE -> {
                MisilPulgoson misil = new MisilPulgoson();
                
                puntajeTotal+= misil.usarArma(pulgas);
                labelPuntajeActual.setText("Puntaje: " + puntajeTotal);               
                verificarFinDelJuego();
                repaint();              
            }
            
        }
    }
    
    /**
     * Verifica si el juego ha terminado (todas las pulgas han sido eliminadas) y gestiona el reinicio o cierre
     */    
    private void verificarFinDelJuego() {
        if (pulgas.isEmpty()) {
            generadorPulgas.detener();

            if (puntajeTotal > puntajeMaximo) {
                puntajeMaximo = puntajeTotal;
                labelPuntajeMaximo.setText("Récord: " + puntajeMaximo);
                try {
                    anotarPuntuacion();
                } catch (IOException ex) {
                    System.out.println("Error al guardar el puntaje: " + ex.getMessage());
                }
            }

            int respuesta = JOptionPane.showConfirmDialog(this,
                "Todas las pulgas han sido destruidas\n" +
                "Puntaje total: " + puntajeTotal + "\n" +
                "¿Desea reiniciar la partida?",
                "Juego terminado",
                JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                puntajeTotal = 0;
                labelPuntajeActual.setText("Puntaje: " + puntajeTotal);
                pulgas.clear();
                generadorPulgas = new GeneradorPulgas(this);
                generadorPulgas.start();
                repaint();
                
            } else {
                System.exit(0);
            }
        }
    }
    
    /**
     * Dibuja las pulgas en el campo
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pulga pulga : pulgas) {
            pulga.paint(g);
        }
    }
    
    /**
     * Verifica si una pulga se superpone con otra en el campo
     * @param pulga La pulga a verificar
     * @return true si hay superposicion, false si no
     */       
   public boolean checkPosition(Pulga pulga){
       if(pulgas.size()== 1){
           return false; 
       }
       for(Pulga pulgaComp : pulgas){
           if(pulga== pulgaComp){
               continue;
           }
           
           if(pulga.getX() + pulga.getWidth() >= pulgaComp.getX() && pulga.getX() < pulgaComp.getX() + pulgaComp.getWidth()){
               return true; 
           }else if(pulga.getY() + pulga.getHeight() >= pulgaComp.getY() && pulga.getY() < pulgaComp.getY() + pulgaComp.getHeight()){
               return true; 
           }
       }
       
       return false; 
   }
    /**
     * Guarda el puntaje si supera el puntaje máximo anterior en el archivo correspondiente
     * @throws IOException Si hay un error escribiendo el archivo
     */   
   public void anotarPuntuacion() throws IOException{
       
       ArrayList<String> puntajes = lector.leer("puntajes.txt");
       int puntajeMaximoArchivo=0; 
       for(int i=0; i< puntajes.size(); i++){
           String s= puntajes.get(i);
           try {
                int puntaje = Integer.parseInt(s);
                if (puntaje > puntajeMaximoArchivo) {
                    puntajeMaximoArchivo = puntaje;
                }
           } catch (NumberFormatException e) {
                System.err.println("Formato invalido" + e.getMessage());
            }
       }
       if(puntajeMaximoArchivo <puntajeTotal){
           EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("puntajes.txt"); 
           ArrayList<String> nuevoPuntaje = new ArrayList<String>();
           nuevoPuntaje.add("" + puntajeTotal);
           escritor.escribir(nuevoPuntaje);
       }
       
   }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {} 
    
    @Override public void refresh(){}
    @Override public Rectangle getBoundaries() {
        return null;
    }   
}
