package gamePulgas.main;

// @author vanes

import gamePulgas.models.CampoPulgas;
import java.io.IOException;
import javax.swing.JFrame;



public class Main {
    public static void main(String[] args) throws IOException{

        JFrame ventana = new JFrame();
        CampoPulgas campoPulgas = new CampoPulgas();
        ventana.setResizable(false);      
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ventana.add( campoPulgas);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Campo de Pulgas");

        ventana.setVisible(true); 

    }
}
