package gamePulgas.models;

// @author vanes

import gamePulgas.models.Arma;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;

public class PistolaPulguipium extends Arma{
    private Point click;
    public void setClick(Point click) {
        this.click = click;
    }
    
    @Override
    public int usarArma( ArrayList<Pulga> pulgas) {
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
