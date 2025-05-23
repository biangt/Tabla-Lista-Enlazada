//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        String clave;
        boolean salir = false;
        TablaDispersaEnlazada tabla = new TablaDispersaEnlazada();
        while (!salir) {
            System.out.println("-------------------------------");
            System.out.println("             REGISTROS            ");
            System.out.println("-------------------------------");
            System.out.println(" 1. Cargar una Tarea ");
            System.out.println(" 2. Cargar una Notita");
            System.out.println(" 3. Buscar un Registro");
            System.out.println(" 4. Eliminar un Registro");
            System.out.println(" 5. Salir");
            System.out.println("-------------------------------");
            System.out.println(" Ingrese una opcion:");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    leer.nextLine();
                    String estado="";
                    String nombre="";
                    String descripcion="";

                    try {
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese el nombre de la tarea:\n");
                        System.out.println("----------------------------------\n");
                        nombre=leer.nextLine();
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese el descripcion de la tarea:\n");
                        System.out.println("----------------------------------\n");
                        descripcion=leer.nextLine();
                        while (!estado.equals("1") && !estado.equals("2") && !estado.equals("3")) { //compara si el contenido de lo que tiene estado es lo mismo que 1, 2 0 3;
                            System.out.println("----------------------------------\n");
                            System.out.println("Ingrese el estado de la tarea:\n1) Pendiente\n2) En Proceso\n3) Finalizada");
                            estado = leer.nextLine();

                            if (!estado.equals("1") && !estado.equals("2") && !estado.equals("3")) {
                                System.out.println("Opción inválida. Debe ser 1, 2 o 3.\n");
                            }
                        }
                        Tarea tarea = new Tarea(nombre, descripcion, estado);
                    } catch (Exception e) {
                        System.out.println("Excepcion en la entrada de datos" + e.getMessage() + ".No se puede dar de alta :(");

                    }
                    Tarea tarea = new Tarea(nombre, descripcion, estado);
                    tabla.insertar(tarea); //llamo al método insertar
                    System.out.println(tarea);

                    break;
                case 2:
                    leer.nextLine();
                    String color="";
                    String nombreN="";
                    String descripcionN="";

                    try {
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese el nombre de la Notita:\n");
                        System.out.println("----------------------------------\n");
                        nombreN=leer.nextLine();
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese el descripcion de la Notita:\n");
                        System.out.println("----------------------------------\n");
                        descripcionN=leer.nextLine();
                        Notita notita = new Notita(nombreN, descripcionN, color);
                    } catch (Exception e) {
                        System.out.println("Excepcion en la entrada de datos" + e.getMessage() + ".No se puede dar de alta :(");

                    }
                    Notita notita = new Notita (nombreN, descripcionN, color);
                    tabla.insertar(notita); //llamo al método insertar
                    System.out.println(notita);

                    break;
                case 3:
                    leer.nextLine();
                    System.out.println("----------------------------------\n");
                    System.out.println("Ingrese el id de la tarea o notita:\n");
                    System.out.println("----------------------------------\n");
                    clave = leer.nextLine();

                    String mostrarestado;
                    tarea = tabla.buscar(clave); //llamo método buscar
                    if (tarea != null) {
                        System.out.println("---------------------------------\n");
                        System.out.println("Nombre de la tarea: " + tarea.getNombre());
                        System.out.println("ID: " + tarea.getId());
                        System.out.println("Descripcion de la tarea: " + tarea.getDescripcion());
                        switch (tarea.getEstado()) {
                            case "1":
                                mostrarestado = "Pendiente";
                                break;
                            case "2":
                                mostrarestado = "En Proceso";
                                break;
                            case "3":
                                mostrarestado = "Finalizada";
                                break;
                            default:
                                mostrarestado = "Desconocido";
                        }

                        System.out.println("Estado de la tarea: " + mostrarestado);
                        System.out.println("---------------------------------\n");
                    } else {
                        System.out.println("No se encontró la tarea");
                    }
                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("----------------------------------\n");
                    System.out.println("Ingrese el id de la tarea:\n");
                    System.out.println("----------------------------------\n");
                    clave = leer.nextLine();

                    String mostrareliminado;
                    tarea = tabla.buscar(clave);
                    if (tarea != null) {
                        System.out.println("---------------------------------\n");
                        System.out.println("La tarea a eliminar es la siguiente\n");
                        System.out.println("---------------------------------\n");
                        System.out.println("Nombre de la tarea: " + tarea.getNombre());
                        System.out.println("ID: " + tarea.getId());
                        System.out.println("Descripcion de la tarea: " + tarea.getDescripcion());
                        switch (tarea.getEstado()) {
                            case "1":
                                mostrareliminado = "Pendiente";
                                break;
                            case "2":
                                mostrareliminado = "En Proceso";
                                break;
                            case "3":
                                mostrareliminado = "Finalizada";
                                break;
                            default:
                                mostrareliminado = "Desconocido";
                        }

                        System.out.println("Estado de la tarea: " + mostrareliminado);
                        System.out.println("---------------------------------\n");
                        tabla.eliminar(clave);
                        System.out.println("---Tarea eliminada----\n");
                    } else {
                        System.out.println("No se encontró la tarea");
                    }
                    break;

                case 5:
                    System.out.println("---------------------------------\n");
                    System.out.println("Saliendo...\n");
                    System.out.println("---------------------------------\n");
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }
    }
}
