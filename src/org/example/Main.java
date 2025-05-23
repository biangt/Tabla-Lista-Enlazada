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
                    Tarea tarea = null;

                    try {
                        System.out.println("----------------------------------");
                        System.out.println("Ingrese el nombre de la tarea:\n");
                        System.out.println("----------------------------------");
                        nombre=leer.nextLine();
                        System.out.println("----------------------------------");
                        System.out.println("Ingrese la descripcion de la tarea:\n");
                        System.out.println("----------------------------------");
                        descripcion=leer.nextLine();
                        while (!estado.equals("1") && !estado.equals("2") && !estado.equals("3")) { //compara si el contenido de lo que tiene estado es lo mismo que 1, 2 0 3;
                            System.out.println("----------------------------------");
                            System.out.println("Ingrese el estado de la tarea:\n1) Pendiente\n2) En Proceso\n3) Finalizada");
                            estado = leer.nextLine();

                            if (!estado.equals("1") && !estado.equals("2") && !estado.equals("3")) {
                                System.out.println("Opción inválida. Debe ser 1, 2 o 3.\n");
                            }
                        }
                        tarea = new Tarea(nombre, descripcion, estado);
                    } catch (Exception e) {
                        System.out.println("Excepcion en la entrada de datos" + e.getMessage() + ".No se puede dar de alta :(");

                    }
                    if (tarea != null) {
                        tabla.insertar(tarea); //llamo al método insertar
                        System.out.println(tarea);
                    }
                    System.out.println(tarea);

                    break;
                case 2:
                    leer.nextLine();
                    String color="";
                    String nombreN="";
                    String descripcionN="";
                    Notita notita = null; //la declaro;

                    try {
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese el nombre de la Notita:\n");
                        System.out.println("----------------------------------\n");
                        nombreN=leer.nextLine();
                        System.out.println("----------------------------------\n");
                        System.out.println("Ingrese la descripcion de la Notita:\n");
                        System.out.println("----------------------------------\n");
                        descripcionN=leer.nextLine();
                        System.out.println("Ingrese el color de la Notita:\n");
                        color = leer.nextLine();
                        System.out.println("----------------------------------\n");
                        notita = new Notita(nombreN, descripcionN, color);
                    } catch (Exception e) {
                        System.out.println("Excepcion en la entrada de datos" + e.getMessage() + ".No se puede dar de alta :(");

                    }
                    if (notita != null) {
                        tabla.insertar(notita); //llamo al metodo insertar
                        System.out.println(notita);
                    }

                    break;
                case 3:
                    leer.nextLine();
                    System.out.println("----------------------------------");
                    System.out.println("Ingrese el id de la tarea o notita a buscar:\n");
                    System.out.println("----------------------------------");
                    clave = leer.nextLine();

                    Registro reg = tabla.buscar(clave);
                    String mostrarestado;
                    if (reg != null) {
                        if (reg instanceof Tarea) {
                            tarea = (Tarea) reg;

                                System.out.println("---------------------------------");
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

                        } else if (reg instanceof Notita) {
                            Notita nota = (Notita) reg;
                                System.out.println("---------------------------------\n");
                                System.out.println("Nombre de la notita: " + nota.getNombre());
                                System.out.println("ID: " + nota.getId());
                                System.out.println("Descripcion de la nota: " + nota.getDescripcion());
                                System.out.println("Color de la notita: " + nota.getColor());
                                System.out.println("---------------------------------\n");
                        }
                    }
                    else {
                        System.out.println("No se encontró la tarea o notita");
                    }
                    break;
                case 4:
                    leer.nextLine();
                    String mostrareliminado;
                    System.out.println("----------------------------------");
                    System.out.println("Ingrese el id de la tarea o notita a eliminar:\n");
                    System.out.println("----------------------------------");
                    clave = leer.nextLine();

                    Registro registroEliminar = tabla.buscar(clave);
                    if (registroEliminar != null) {
                        if (registroEliminar instanceof Tarea) {
                            tarea = (Tarea) registroEliminar;
                            System.out.println("---------------------------------");
                            System.out.println("La tarea a eliminar es la siguiente:\n");
                            System.out.println("---------------------------------");
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
                            System.out.println("--------------------------------");
                            tabla.eliminar(clave);
                            System.out.println("---Tarea eliminada----\n");

                        } else if (registroEliminar instanceof Notita) {
                            Notita nota = (Notita) registroEliminar;
                            System.out.println("---------------------------------");
                            System.out.println("La notita a eliminar es la siguiente:\n");
                            System.out.println("---------------------------------");
                            System.out.println("---------------------------------");
                            System.out.println("Nombre de la notita: " + nota.getNombre());
                            System.out.println("ID: " + nota.getId());
                            System.out.println("Descripcion de la nota: " + nota.getDescripcion());
                            System.out.println("Color de la notita: " + nota.getColor());
                            tabla.eliminar(clave);
                            System.out.println("---Notita eliminada----\n");
                        }
                    }
                    else {
                        System.out.println("No se encontró la tarea o notita");
                    }

                    break;

                case 5:
                    System.out.println("---------------------------------");
                    System.out.println("Saliendo...\n");
                    System.out.println("---------------------------------");
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }
    }
}
