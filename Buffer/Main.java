package Buffer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferMensajes buffer = new BufferMensajes(60000); // mensajes expiran en 60 segundos

        int opcion;
        do {
            System.out.println("\n--- MENÚ DEL BUFFER DE MENSAJES ---");
            System.out.println("1. Agregar mensaje");
            System.out.println("2. Obtener mensaje (y eliminar)");
            System.out.println("3. Consultar mensaje (sin eliminar)");
            System.out.println("4. Ver tamaño del buffer");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Contenido del mensaje: ");
                    String contenido = sc.nextLine();
                    System.out.print("¿Es urgente? (true/false): ");
                    boolean urgente = sc.nextBoolean();
                    buffer.agregarMensaje(new Mensaje(contenido, urgente));
                    System.out.println("Mensaje agregado.");
                    break;

                case 2:
                    Mensaje m1 = buffer.obtenerMensaje();
                    if (m1 != null) {
                        System.out.println("Mensaje obtenido: " + m1.getContenido());
                    } else {
                        System.out.println("No hay mensajes disponibles.");
                    }
                    break;

                case 3:
                    Mensaje m2 = buffer.consultarMensaje();
                    if (m2 != null) {
                        System.out.println("Mensaje en espera: " + m2.getContenido());
                    } else {
                        System.out.println("No hay mensajes disponibles.");
                    }
                    break;

                case 4:
                    System.out.println("Tamaño del buffer: " + buffer.tamañoTotal());
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
