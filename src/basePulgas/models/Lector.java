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

/**
 * Clase para leer y procesar archivos de texto plano
 * @author Nicolas Agudelo Grajales
 */
public class Lector {
    File archivo; 
    FileReader lector; 
    FileWriter escritor; 
    BufferedReader buffer; 
    PrintWriter pw ;

    public Lector() throws FileNotFoundException, IOException {
        
        String ruta = "/docsPulgas/puntajes.txt";
        this.archivo = new File(ruta);
        escritor = new FileWriter(archivo);
        pw = new PrintWriter(escritor);
        
    }
    
    public void anotarPuntaje(int puntaje) throws IOException{
        pw.println(puntaje);
    }
    
}
