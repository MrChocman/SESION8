package Hotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainEmpleado {

    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAOImpl();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- MENU DE GESTION DE EMPLEADOS ---");
            System.out.println("1. Contratar Nuevo Empleado");
            System.out.println("2. Ver Todos los Empleados");
            System.out.println("3. Actualizar Datos de un Empleado");
            System.out.println("4. Eliminar un Empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del empleado: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Cargo (ej. Recepcionista, Gerente): ");
                        String cargo = scanner.nextLine();
                        empleadoDAO.agregar(new Empleado(0, nombre, cargo));
                        System.out.println("Empleado contratado con exito.");
                        break;
                    case 2:
                        System.out.println("\n--- LISTA DE EMPLEADOS ---");
                        empleadoDAO.listarTodos().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del empleado a actualizar: ");
                        int idAct = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nuevo Nombre: ");
                        String nNombre = scanner.nextLine();
                        System.out.print("Nuevo Cargo: ");
                        String nCargo = scanner.nextLine();
                        empleadoDAO.actualizar(new Empleado(idAct, nNombre, nCargo));
                        System.out.println("Empleado actualizado con exito.");
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del empleado a eliminar: ");
                        int idDel = scanner.nextInt();
                        scanner.nextLine();
                        empleadoDAO.eliminar(idDel);
                        System.out.println("Empleado eliminado con exito.");
                        break;
                    case 5:
                        System.out.println("Saliendo del gestor de empleados...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un numero.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}