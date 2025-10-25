package Hotel;

import java.util.List;
public interface ReservaDAO {
    void agregar(Reserva r);
    List<Reserva> listarTodos();
    void actualizar(Reserva r);
    void eliminar(int id);
}
