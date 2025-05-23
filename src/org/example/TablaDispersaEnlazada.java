package org.example;

public class TablaDispersaEnlazada {
    private final int tamTabla=101;
    private Nodo [] tabla;
    private int numElementos;
    private double factorCarga;

    public TablaDispersaEnlazada (){ //inicializamos variables
        tabla=new Nodo[tamTabla];
        for(int i=0;i<tamTabla;i++){
            tabla[i]=null;
            numElementos=0;
        }
    }
    //metodo para transformar cadenas a numeros, solo los primeros 10 caracteres utilizando la tabla ASCII
    public long transformaCadena(String id) {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10, id.length()); j++) {
            d = d * 27 + (int) id.charAt(j);
        }
        if (d < 0) //si el valor es negativo, lo transforma en positivo;
            d = -d;
        return d;
    }
    //Metodo de la MULTIPLICACION
    public int direccion (String id){
        double R= 0.6180334;
        long clave = transformaCadena(id);
        int posicionFinal, i=0;
        double posicion = clave*R;
        posicion = posicion - Math.floor(posicion);
        posicionFinal = (int) (posicion * tamTabla);
    }

    //INSERTAR TAREA
    public boolean insertar(Registro reg) { //reg puede ser una notita o una tarea
        int posicion = direccion(reg.getId()); //obtiene la posicion
        Nodo nuevo = new Nodo(reg); //Esto es como poner el objeto r (Tarea o Notita) dentro de un nodo.
        nuevo.setSiguiente(tabla[posicion]); //Esto apunta el nuevo nodo hacia el primero que ya había, si es que había uno.
        tabla[posicion] = nuevo; //ahora el primer nodo en esta posición es el nuevo que acabo de meter
        numElementos++;
        return true;
    }

    //BUSCAR TAREA
    public Tarea buscar(String id) {
        Tarea tarea; //una tarea de Tarea
        int posicion;
        posicion = direccion(id); //obtengo posicion de la tarea
        tarea = tabla[posicion];
        if (tarea != null) { //si la tarea no es null
            if (!tarea.getEsAlta()) { //y si no está dadaa de baja (esAlta=false)
                tarea = null;
            }
        }
        return tarea;
    }

    //ELIMINAR TAREA
    public void eliminar(String id)
    {
        int posicion;
        posicion = direccion(id);
        if (tabla[posicion] != null)
            tabla[posicion].setEsAlta(false);
    }
}
