package org.example;
/**
 * Un elemento es un nodo de la lista.
 * El elemento está formado por dos partes:
 *   - una Tarea para contener los datos de una tarea,
 *   - un "apuntador" al Elemento siguiente.
 */
public class Nodo {
    public Tarea tarea;
    public Nodo sgte;
    /**
     * Constructor de la Clase.
     * @param   nuevatarea la tarea que se almacenará en el nodo de la clase.
     */
    public Nodo (Tarea nuevatarea) {
        //Almacenamos la tarea recibido por parámetro en el espacio reservado.
        tarea = nuevatarea;
        //Por defecto, el elemento no está conectado con un nodo siguiente.
        sgte = null;
    }

    /**
     * Getter para el atributo tarea.
     * @return   tarea almacenada en el nodo
     */
    public Tarea getTarea() {
        return tarea;
    }
}
