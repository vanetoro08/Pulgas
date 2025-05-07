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
    public void usarArma(Point click, ArrayList<PulgaNormal> normales, ArrayList<PulgaMutante> mutantes) {
 
        for (int i = 0; i < mutantes.size(); i++) {
            PulgaMutante pm = mutantes.get(i);
            Rectangle bounds = new Rectangle(pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight());
            if (bounds.contains(click)) {
                pm.setEscudo(pm.getEscudo() - 1);
                if (pm.getEscudo() <= 1) {
                    PulgaNormal nueva = new PulgaNormal(pm.getX(), pm.getY(), pm.getWidth(), pm.getHeight(), 1);
                    mutantes.remove(i);
                    normales.add(nueva);
                }
                return;
            }
        }
        for (int i = 0; i < normales.size(); i++) {
            PulgaNormal pn = normales.get(i);
            Rectangle bounds = new Rectangle(pn.getX(), pn.getY(), pn.getWidth(), pn.getHeight());
            if (bounds.contains(click)) {
                normales.remove(i);
                return;
            }
        }
    }
}
