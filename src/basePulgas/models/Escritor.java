/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package basePulgas.models;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vanes
 */
public interface Escritor {

    void escribir(ArrayList<String> archivo) throws IOException;

}
