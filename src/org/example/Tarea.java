package org.example;


import java.util.UUID;

public class Tarea extends Registro {

    private String estado;

    public Tarea(String nombre, String descripcion, String estado) {

        super (nombre, descripcion);
        this.estado = estado;

    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Tarea[\n" +
                "ID: " + getId() + "\n" +
                "Nombre: '" + getNombre() + "'\n" +
                "Descripción: '" + getDescripcion() + "'\n" +
                "Estado: " + estado + "\n" +
                "EsAlta: " + getEsAlta() + "\n" +
                "]";
    }



}

