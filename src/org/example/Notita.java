package org.example;

public class Notita extends Registro{
    private String color;

    public Notita (String nombre, String descripcion, String color) {

        super (nombre, descripcion);
        this.color = color;

    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Notita[\n" +
                "ID: " + getId() + "\n" +
                "Nombre: '" + getNombre() + "'\n" +
                "Descripción: '" + getDescripcion() + "'\n" +
                "Color: " + color + "\n" +
                "EsAlta: " + getEsAlta() + "\n" +
                "]";
    }
}