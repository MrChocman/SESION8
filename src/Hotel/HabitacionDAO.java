package Hotel;

import java.util.List;
public interface HabitacionDAO {
    void agregar(Habitacion habitacion);
    List<Habitacion> listarTodos();
    void actualizar(Habitacion habitacion);
    void eliminar(int id);
}