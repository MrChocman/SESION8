package Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAOImpl implements ServicioDAO {

    @Override
    public void agregar(Servicio servicio) {
        String sql = "INSERT INTO Servicio (nombre, precio) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, servicio.getNombre());
            pstmt.setBigDecimal(2, servicio.getPrecio());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Servicio> listarTodos() {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM Servicio";
        try (Connection conn = ConexionDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("id_servicio"));
                servicio.setNombre(rs.getString("nombre"));
                servicio.setPrecio(rs.getBigDecimal("precio"));
                lista.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Servicio servicio) {
        String sql = "UPDATE Servicio SET nombre = ?, precio = ? WHERE id_servicio = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, servicio.getNombre());
            pstmt.setBigDecimal(2, servicio.getPrecio());
            pstmt.setInt(3, servicio.getIdServicio());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Servicio WHERE id_servicio = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
