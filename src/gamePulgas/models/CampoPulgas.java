package gamePulgas.models;

// @author vanes

import basePulgas.models.GraphicContainer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CampoPulgas extends JPanel implements GraphicContainer, MouseListener,KeyListener  {
    private ArrayList<PulgaNormal> pulgasNormales;
    private ArrayList<PulgaMutante> pulgasMutantes;
    
    public CampoPulgas() {
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        
        pulgasNormales = new ArrayList<>();
        pulgasMutantes = new ArrayList<>();
        
        addMouseListener(this);
        addKeyListener(this);
        requestFocusInWindow();
    }
    
    private void agregarPulgaNormal() {
       int x = (int) (Math.random() * (getWidth() - 40));
       int y = (int) (Math.random() * (getHeight() - 40));
       PulgaNormal pulga = new PulgaNormal(x, y, 40, 40, 1);
       pulgasNormales.add(pulga);
       repaint();
   }

    private void agregarPulgaMutante() {
       int x = (int) (Math.random() * (getWidth() - 40));
       int y = (int) (Math.random() * (getHeight() - 40));
       PulgaMutante pulga = new PulgaMutante(x, y, 40, 40, 2);
       pulgasMutantes.add(pulga);
       repaint();
        
    }
    
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            PistolaPulguipium pistola = new PistolaPulguipium();
            Point click = new Point(e.getX(), e.getY());
            pistola.usarArma(click, pulgasNormales, pulgasMutantes);
            repaint();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P -> agregarPulgaNormal();
            case KeyEvent.VK_M -> agregarPulgaMutante();
            //case KeyEvent.VK_S -> saltarPulgas();
            case KeyEvent.VK_Q -> System.exit(0);
            case KeyEvent.VK_SPACE -> {
                MisilPulgoson misil = new MisilPulgoson();
                misil.usarArma(pulgasNormales, pulgasMutantes);
                repaint();
            }
        }
    }
    
   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       for (PulgaNormal pulga : pulgasNormales) {
           pulga.paint(g);
       }
       for (PulgaMutante pulga : pulgasMutantes) {
           pulga.paint(g);
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
