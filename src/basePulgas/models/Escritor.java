
package basePulgas.models;

import java.io.IOException;
import java.util.ArrayList;

public interface Escritor {
    
    
    public abstract void escribir(ArrayList<String> archivo) throws IOException ;
    
}
