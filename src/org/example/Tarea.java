package org.example;


import java.util.UUID;

public class Tarea {

    private String id;
    private String nombre;
    private String descripcion;
    private String estado;
    private boolean esAlta;

    public Tarea() {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id = UUID.randomUUID().toString();
        this.esAlta = true;
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public boolean getEsAlta() {
        return esAlta;
    }

    public void setEsAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }

    @Override
    public String toString() {
        return "Tarea[\n" +
                "ID: " + id + "\n" +
                "Nombre: '" + nombre + "'\n" +
                "Descripción: '" + descripcion + "'\n" +
                "Estado: " + estado + "\n" +
                "EsAlta: " + esAlta + "\n" +
                "]";
    }



}


