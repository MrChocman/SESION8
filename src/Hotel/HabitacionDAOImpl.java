package Hotel;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAOImpl implements HabitacionDAO {
    @Override
    public void agregar(Habitacion h) {
        String sql = "INSERT INTO Habitacion (numero, tipo, precio, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, h.getNumero());
            pstmt.setString(2, h.getTipo());
            pstmt.setBigDecimal(3, h.getPrecio());
            pstmt.setString(4, h.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public List<Habitacion> listarTodos() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT * FROM Habitacion";
        try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                habitaciones.add(new Habitacion(rs.getInt("id_habitacion"), rs.getString("numero"), rs.getString("tipo"), rs.getBigDecimal("precio"), rs.getString("estado")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return habitaciones;
    }

    @Override
    public void actualizar(Habitacion h) {
        String sql = "UPDATE Habitacion SET numero = ?, tipo = ?, precio = ?, estado = ? WHERE id_habitacion = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, h.getNumero());
            pstmt.setString(2, h.getTipo());
            pstmt.setBigDecimal(3, h.getPrecio());
            pstmt.setString(4, h.getEstado());
            pstmt.setInt(5, h.getIdHabitacion());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM Habitacion WHERE id_habitacion = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}