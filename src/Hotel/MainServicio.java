package Hotel;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainServicio {
    
    public static void main(String[] args) {
        ServicioDAO servicioDAO = new ServicioDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU DE GESTION DE SERVICIOS ---");
            System.out.println("1. Anadir Nuevo Servicio");
            System.out.println("2. Ver Todos los Servicios");
            System.out.println("3. Actualizar un Servicio");
            System.out.println("4. Eliminar un Servicio");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del servicio (ej. Desayuno, Lavanderia): ");
                        String nombre = scanner.nextLine();
                        System.out.print("Precio del servicio: ");
                        BigDecimal precio = scanner.nextBigDecimal();
                        scanner.nextLine();
                        servicioDAO.agregar(new Servicio(0, nombre, precio));
                        System.out.println("Servicio anadido con exito.");
                        break;
                    case 2:
                        System.out.println("\n--- LISTA DE SERVICIOS ---");
                        servicioDAO.listarTodos().forEach(System.out::println);
                        break;
                    // Los casos 3 (Actualizar) y 4 (Eliminar) siguen el mismo patron.
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un dato valido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}