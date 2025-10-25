package Hotel;

import java.util.List;
public interface EmpleadoDAO {
    void agregar(Empleado e);
    List<Empleado> listarTodos();
    void actualizar(Empleado e);
    void eliminar(int id);
}
