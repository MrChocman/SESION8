package Hotel;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    void agregar(Cliente cliente);
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorId(int id);
    void actualizar(Cliente cliente);
    void eliminar(int id);
}