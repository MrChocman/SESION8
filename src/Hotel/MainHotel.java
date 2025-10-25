package Hotel;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainHotel {

    public static void main(String[] args) {
        HabitacionDAO habitacionDAO = new HabitacionDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENÚ DE GESTIÓN DE HABITACIONES ---");
            System.out.println("1. Añadir Nueva Habitación");
            System.out.println("2. Ver Todas las Habitaciones");
            System.out.println("3. Actualizar Datos de una Habitación");
            System.out.println("4. Eliminar una Habitación");
            System.out.println("5. Salir del Programa");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                    case 1:
                        System.out.println("\n-- Añadir Nueva Habitación --");
                        System.out.print("Número de habitación: ");
                        String numero = scanner.nextLine();

                        System.out.print("Tipo (Simple, Doble, Suite): ");
                        String tipo = scanner.nextLine();

                        System.out.print("Precio por noche: ");
                        BigDecimal precio = scanner.nextBigDecimal();
                        scanner.nextLine(); 

                        System.out.print("Estado (disponible, ocupada, mantenimiento): ");
                        String estado = scanner.nextLine();

                        Habitacion nuevaHabitacion = new Habitacion(0, numero, tipo, precio, estado);
                        habitacionDAO.agregar(nuevaHabitacion);
                        System.out.println("¡Habitación añadida con éxito!");
                        break;

                    case 2:
                        System.out.println("\n--- LISTA DE HABITACIONES DISPONIBLES ---");
                        habitacionDAO.listarTodos().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("\n-- Actualizar Habitación --");
                        System.out.print("Ingrese el ID de la habitación a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nuevo Número: ");
                        String nuevoNumero = scanner.nextLine();

                        System.out.print("Nuevo Tipo: ");
                        String nuevoTipo = scanner.nextLine();

                        System.out.print("Nuevo Precio: ");
                        BigDecimal nuevoPrecio = scanner.nextBigDecimal();
                        scanner.nextLine();

                        System.out.print("Nuevo Estado: ");
                        String nuevoEstado = scanner.nextLine();

                        Habitacion habitacionActualizada = new Habitacion(idActualizar, nuevoNumero, nuevoTipo, nuevoPrecio, nuevoEstado);
                        habitacionDAO.actualizar(habitacionActualizada);
                        System.out.println("¡Habitación actualizada con éxito!");
                        break;

                    case 4:
                        System.out.println("\n-- Eliminar Habitación --");
                        System.out.print("Ingrese el ID de la habitación a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine();

                        habitacionDAO.eliminar(idEliminar);
                        System.out.println("¡Habitación eliminada con éxito!");
                        break;

                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un dato válido (ej. un número para el precio o ID).");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}