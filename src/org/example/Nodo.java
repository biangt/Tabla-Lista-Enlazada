package org.example;
/**
 * La clase Nodo es un nodo de la lista.
 * El nodo está formado por dos partes:
 *   - una Tarea para contener los datos de una tarea,
 *   - un "apuntador" al Elemento siguiente.
 */
public class Nodo {
    public Registro dato;
    public Nodo sgte;

    //Constructor de la Clase.
    //@param Registro que se almacenará en el nodo de la clase.

    public Nodo (Registro dato) {
        //Almacenamos la tarea recibido por parámetro en el espacio reservado.
        this.dato= dato;
        //Por defecto, el elemento no está conectado con un nodo siguiente.
        sgte = null;
    }
    public Registro getDato() {
        return dato;
    }
    public Nodo getSiguiente() {
        return sgte;
    }

    public void setSiguiente(Nodo siguiente) {
        this.sgte = siguiente;
    }
    /**
     * Getter para el atributo tarea.
     * @return  registro almacenada en el nodo
     */

}