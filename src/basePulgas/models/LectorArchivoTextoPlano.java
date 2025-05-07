package basePulgas.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
/*
*@author Nicolas Agudlelo 
*clase encargada de leer los archivos de texto plano
*/

public class LectorArchivoTextoPlano implements Lector{
    /*
    atributos 
    */
    //arraylist que contiene las lineas de informacion del archivo
    private ArrayList<String> archivo;
    //Set de caracteres
    private Charset charset = Charset.forName("UTF-8");
    
    /*
    constructor encargado de inicializar el arraylist del archivo
    */
    public LectorArchivoTextoPlano() {
        this.archivo = new ArrayList<>();
    }
    /*
    metodo encargado de leer y conseguir la información del archivo seleccionado
    @param String localizacionArchivo ruta/nombre del archivo a leer
    */
   
    @Override
    public ArrayList<String> leer(String localizacionArchivo) throws IOException {
        archivo.clear();
        File file =  null;
        FileReader reader = null;
        BufferedReader buffer = null;
        
        file = new File(localizacionArchivo);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        
        String linea;
        while ((linea= buffer.readLine())!=null ) { 
            agregarLinea(linea);
        }
        
        reader.close();
        return this.archivo;
    }
    /*
    agrega una linea de texto al archivo
    @param String linea la linea a agregar al arhcivo
    */
    public void agregarLinea(String linea) {
        archivo.add(linea);
    }
    /*
    metodo encargado de limpiar las lineas vacias de una lista de texto 
    @param ArrayList<String> texto lista de texto que se quiere depurar
   
    */
    public void limpiarTexto(ArrayList<String> texto)
    {
        for (int i = 0; i < texto.size(); i++) {
            
            if(texto.get(i).length()==0)
            {
                texto.remove(i);
            }
            
        }
        
    }
    
   


}