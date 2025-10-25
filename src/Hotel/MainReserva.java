package Hotel;

import java.sql.Date;
import java.util.Scanner;

public class MainReserva {

    public static void main(String[] args) {
        ReservaDAO reservaDAO = new ReservaDAOImpl();
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        HabitacionDAO habitacionDAO = new HabitacionDAOImpl();
        
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU DE GESTION DE RESERVAS ---");
            System.out.println("1. Crear Nueva Reserva");
            System.out.println("2. Ver Todas las Reservas");
            System.out.println("3. Actualizar una Reserva");
            System.out.println("4. Cancelar una Reserva");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Clientes Registrados ---");
                        clienteDAO.listarTodos().forEach(System.out::println);
                        System.out.print("Seleccione el ID del Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\n--- Habitaciones Disponibles ---");
                        habitacionDAO.listarTodos().forEach(System.out::println);
                        System.out.print("Seleccione el ID de la Habitacion: ");
                        int idHabitacion = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Fecha de Inicio (AAAA-MM-DD): ");
                        Date fechaInicio = Date.valueOf(scanner.nextLine());
                        System.out.print("Fecha de Fin (AAAA-MM-DD): ");
                        Date fechaFin = Date.valueOf(scanner.nextLine());
                        System.out.print("Estado (confirmada, pendiente, cancelada): ");
                        String estado = scanner.nextLine();
                        
                        reservaDAO.agregar(new Reserva(0, idCliente, idHabitacion, fechaInicio, fechaFin, estado));
                        System.out.println("Reserva creada con exito.");
                        break;
                    case 2:
                        System.out.println("\n--- HISTORIAL DE RESERVAS ---");
                        reservaDAO.listarTodos().forEach(System.out::println);
                        break;
                    // Los casos 3 (Actualizar) y 4 (Eliminar) siguen el mismo patron.
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un dato valido. " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
