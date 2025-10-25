package Hotel;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFactura {

    public static void main(String[] args) {
        FacturaDAO facturaDAO = new FacturaDAOImpl();
        ReservaDAO reservaDAO = new ReservaDAOImpl();
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU DE GESTION DE FACTURAS ---");
            System.out.println("1. Generar Nueva Factura");
            System.out.println("2. Ver Todas las Facturas");
            System.out.println("3. Actualizar una Factura");
            System.out.println("4. Anular una Factura");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- Reservas Registradas ---");
                        reservaDAO.listarTodos().forEach(System.out::println);
                        System.out.print("Seleccione el ID de la Reserva a facturar: ");
                        int idReserva = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("\n--- Empleados Disponibles ---");
                        empleadoDAO.listarTodos().forEach(System.out::println);
                        System.out.print("Seleccione el ID del Empleado que emite la factura: ");
                        int idEmpleado = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Fecha de Emision (AAAA-MM-DD): ");
                        Date fechaEmision = Date.valueOf(scanner.nextLine());

                        System.out.print("Monto Total de la factura: ");
                        BigDecimal total = scanner.nextBigDecimal();
                        scanner.nextLine();
                        
                        facturaDAO.agregar(new Factura(0, idReserva, idEmpleado, fechaEmision, total));
                        System.out.println("Factura generada con exito.");
                        break;
                    case 2:
                        System.out.println("\n--- HISTORIAL DE FACTURAS ---");
                        facturaDAO.listarTodos().forEach(System.out::println);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un dato valido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
