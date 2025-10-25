package Hotel;

import java.util.List;

public interface FacturaDAO {
    void agregar(Factura factura);
    List<Factura> listarTodos();
    void actualizar(Factura factura);
    void eliminar(int id);
}