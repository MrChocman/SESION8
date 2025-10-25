package Hotel;

import java.util.List;

public interface ServicioDAO {

    void agregar(Servicio servicio);
    List<Servicio> listarTodos();
    void actualizar(Servicio servicio);
    void eliminar(int id);
}