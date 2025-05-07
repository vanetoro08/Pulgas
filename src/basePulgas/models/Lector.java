/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basePulgas.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase para leer y procesar archivos de texto plano
 * @author Nicolas Agudelo Grajales
 */
public interface Lector {
    
<<<<<<< HEAD
    public void anotarPuntaje(int puntaje) throws IOException{
        
        String strPuntajeMaxActual= "0";
        String linea;
        int puntajeMaxActual=100000;
        while((linea=buffer.readLine())!=null){
            strPuntajeMaxActual= linea; 
        }
        System.out.println(strPuntajeMaxActual);
        if(strPuntajeMaxActual == null){
            String texto = "" + puntaje;
            pw.println(texto);
        }else{
            puntajeMaxActual = Integer.parseInt(strPuntajeMaxActual); 
            if(puntaje> puntajeMaxActual){
                String texto = "" + puntaje;
                pw.println(texto);
            }
        }       
        
        pw.close();
    }
=======
    
    public abstract ArrayList<String> leer(String localizacionArchivo)throws IOException;
>>>>>>> 19d8f891578d4323dbc160c5fb2ac0aaca3dda57
    
}
