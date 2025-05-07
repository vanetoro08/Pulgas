/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basePulgas.models;

import java.awt.Rectangle;

/**
 *
 * @author Nicolas Agudelo 
 * Interfaz que contiene la grafica
 */

public interface GraphicContainer {
    public void refresh();
    public Rectangle getBoundaries();
}