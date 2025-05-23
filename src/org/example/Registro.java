package org.example;
import java.util.UUID;

public class Registro {
    private String id;
    private String nombre;
    private String descripcion;
    private boolean esAlta;

    public Registro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    public boolean getEsAlta() {
        return esAlta;
    }

    public void setEsAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }
}