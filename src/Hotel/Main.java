package Hotel;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENÚ GESTIÓN DE CLIENTES ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Ver todos los Clientes");
            System.out.println("3. Actualizar datos de Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n-- Registro de Nuevo Cliente --");
                        System.out.print("Nombre completo: ");
                        String nombre = scanner.nextLine();
                        System.out.print("DNI: ");
                        String dni = scanner.nextLine();
                        System.out.print("Teléfono: ");
                        String telefono = scanner.nextLine();
                        System.out.print("Correo electrónico: ");
                        String correo = scanner.nextLine();
                        clienteDAO.agregar(new Cliente(0, nombre, dni, telefono, correo));
                        System.out.println("¡Cliente registrado con éxito!");
                        break;
                    case 2:
                        System.out.println("\n-- Listado de Clientes --");
                        List<Cliente> clientes = clienteDAO.listarTodos();
                        if (clientes.isEmpty()) {
                            System.out.println("No hay clientes registrados.");
                        } else {
                            clientes.forEach(System.out::println);
                        }
                        break;
                    case 3:
                        System.out.println("\n-- Actualizar Cliente --");
                        System.out.print("Ingrese el ID del cliente a modificar: ");
                        int idAct = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nuevo Nombre: ");
                        String nNombre = scanner.nextLine();
                        System.out.print("Nuevo DNI: ");
                        String nDni = scanner.nextLine();

                        Cliente clienteAct = new Cliente(idAct, nNombre, nDni, "...", "...");
                        clienteDAO.actualizar(clienteAct);
                        System.out.println("¡Cliente actualizado con éxito!");
                        break;
                    case 4:
                        System.out.println("\n-- Eliminar Cliente --");
                        System.out.print("Ingrese el ID del cliente a eliminar: ");
                        int idDel = scanner.nextInt();
                        scanner.nextLine();
                        clienteDAO.eliminar(idDel);
                        System.out.println("¡Cliente eliminado con éxito!");
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un valor válido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}