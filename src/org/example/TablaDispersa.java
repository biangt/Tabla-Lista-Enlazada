package org.example;

public class TablaDispersa {
    private final int tamTabla=101;
    private Tarea [] tabla;
    private int numElementos;
    private double factorCarga;

    public TablaDispersa (){ //inicializamos variables
        tabla=new Tarea[tamTabla];
        for(int i=0;i<tamTabla;i++){
            tabla[i]=null;

            factorCarga=0.0;
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

        //Resuelvo colisión con EXPLORACION CUADRÁTICA
        while (tabla[posicionFinal]!= null && !tabla[posicionFinal].getId().equals(id)){ //si la posicion en la tabla no está vacía y es igual a un valor que ya existe

            i++;
            posicionFinal = posicionFinal + i*i;
            posicionFinal = posicionFinal % tamTabla;  // considera el array como circular
        }

        // Si se recorrió toda la tabla y no hay espacio, devuelve -1
        if (i >= tamTabla) {
            return -1;
        }
        return posicionFinal;
    }

    //INSERTAR TAREA
    public boolean insertar(Tarea tarea){ //tiene que ser booleano porque si no inserta coloca false
        int posicion;
        posicion = direccion(tarea.getId()); //llamo al método para conseguir la posición;

        if (posicion == -1) {
            return false; // no encontró espacio
        }
        tabla[posicion] = tarea; // insertar si encontró posición válida
        System.out.println("posicion: " + posicion);//--------------------------
        numElementos++;
        factorCarga = (double)(numElementos)/tamTabla; //actualizamos el factor de carga cada que insertamos
        if (factorCarga > 0.5) {
            System.out.println("\n¡Factor de carga supera el 50%!" + " Conviene aumentar el tamaño.");
        }
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


