
package basePulgas.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class EscritorArchivoTextoPlano implements Escritor{
    

    
    
    private final Charset charset = Charset.forName("UTF-8");
    
    private String filePath;

    public EscritorArchivoTextoPlano(String filePath) {
        this.filePath = filePath;
    }
 

    
    
    @Override
    public void escribir(ArrayList<String> archivo) throws IOException {

        File fichero = new File(this.filePath);
        FileWriter writer = new FileWriter(fichero,false);
        PrintWriter pw = new PrintWriter(writer);
        
        for (String linea : archivo) {
            pw.println(linea);
        }
        
        writer.close();
    }
   

}
