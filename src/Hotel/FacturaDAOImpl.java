package Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAOImpl implements FacturaDAO {

    @Override
    public void agregar(Factura factura) {
        String sql = "INSERT INTO Factura (id_reserva, id_empleado, fecha_emision, total) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, factura.getIdReserva());
            pstmt.setInt(2, factura.getIdEmpleado());
            pstmt.setDate(3, factura.getFechaEmision());
            pstmt.setBigDecimal(4, factura.getTotal());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Factura> listarTodos() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT * FROM Factura";
        try (Connection conn = ConexionDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura factura = new Factura(
                    rs.getInt("id_factura"),
                    rs.getInt("id_reserva"),
                    rs.getInt("id_empleado"),
                    rs.getDate("fecha_emision"),
                    rs.getBigDecimal("total")
                );
                lista.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Factura factura) {
        String sql = "UPDATE Factura SET id_reserva = ?, id_empleado = ?, fecha_emision = ?, total = ? WHERE id_factura = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, factura.getIdReserva());
            pstmt.setInt(2, factura.getIdEmpleado());
            pstmt.setDate(3, factura.getFechaEmision());
            pstmt.setBigDecimal(4, factura.getTotal());
            pstmt.setInt(5, factura.getIdFactura());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Factura WHERE id_factura = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
