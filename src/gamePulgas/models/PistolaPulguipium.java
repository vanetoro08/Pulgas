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

public class PistolaPulguipium{
    public int usarArma(Point click, ArrayList<PulgaNormal> normales, ArrayList<PulgaMutante> mutantes) {
        int puntosConseguidos; 
        for (int i = 0; i < mutantes.size(); i++) {
            PulgaMutante pm = mutantes.get(i);
            Rectangle bounds = new Rectangle(pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight());
            if (bounds.contains(click)) {
                pm.setEscudo(pm.getEscudo() - 1);
                if (pm.getEscudo() <= 1) {
                    PulgaNormal nueva = new PulgaNormal(pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight(), 1, 600);
                    mutantes.remove(i);
                    normales.add(nueva);
                }
                return 0;
            }
        }
        for (int i = 0; i < normales.size(); i++) {
            PulgaNormal pn = normales.get(i);
            Rectangle bounds = new Rectangle(pn.getX(), pn.getY(), pn.getWidth(), pn.getHeight());
            if (bounds.contains(click)) {
                puntosConseguidos= normales.get(i).getPuntos();
                normales.remove(i);
                return puntosConseguidos;
            }
        }
        return 0;
    }
}
