/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basePulgas.models;

import java.util.ArrayList;


/**
 * Clase abstracta que representa un contenedor de sprites.
 * permitiendo gestionar una colección de sprites hijos dentro de un área determinada.
 * 
 * Se utiliza para agrupar y administrar múltiples objetos gráficos (sprites) 
 * en un solo contenedor, como podría ser una escena o panel de juego.
 * 
 * @author Nicolas Agudelo
 */
public abstract class SpritesContainer extends Sprite implements GraphicContainer{
    /** Lista de sprites contenidos en este contenedor. 
     */
    protected ArrayList<Sprite> sprites;   
    /**
     * Constructor para inicializar un contenedor de sprites con posición y tamaño dados.
     *
     * @param x Coordenada X del contenedor.
     * @param y Coordenada Y del contenedor.
     * @param height Altura del contenedor.
     * @param width Anchura del contenedor.
     */
    public SpritesContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }   
    
    /**
     * Agrega un sprite al contenedor.
     *
     * @param sprite El sprite a agregar.
     * @return true si el sprite fue agregado exitosamente.
     */
    public boolean add(Sprite sprite)
    {
        return sprites.add(sprite);
    }
    /**
     * Elimina el sprite ubicado en el índice especificado de la lista.
     *
     * @param index Índice del sprite a eliminar.
     */
    public void remove(int index)
    {
        sprites.remove(index);
    }
    /**
     * Elimina una instancia específica de sprite del contenedor.
     *
     * @param sprite El sprite que se desea eliminar.
     */
    public void remove(Sprite sprite)
    {
        sprites.remove(sprite);
    }
    /*
    @return devuelve el tamaño de los sprites
    */
    public int size()
    {
        return sprites.size();
    }
}