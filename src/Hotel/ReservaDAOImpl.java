package Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAOImpl implements ReservaDAO {
    @Override public void agregar(Reserva r) {
        String sql = "INSERT INTO Reserva (id_cliente, id_habitacion, fecha_inicio, fecha_fin, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, r.getIdCliente()); pstmt.setInt(2, r.getIdHabitacion()); pstmt.setDate(3, r.getFechaInicio()); pstmt.setDate(4, r.getFechaFin()); pstmt.setString(5, r.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override public List<Reserva> listarTodos() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";
        try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Reserva(rs.getInt("id_reserva"), rs.getInt("id_cliente"), rs.getInt("id_habitacion"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"), rs.getString("estado")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
    @Override public void actualizar(Reserva r) {
        String sql = "UPDATE Reserva SET id_cliente = ?, id_habitacion = ?, fecha_inicio = ?, fecha_fin = ?, estado = ? WHERE id_reserva = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, r.getIdCliente()); pstmt.setInt(2, r.getIdHabitacion()); pstmt.setDate(3, r.getFechaInicio()); pstmt.setDate(4, r.getFechaFin()); pstmt.setString(5, r.getEstado()); pstmt.setInt(6, r.getIdReserva());
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override public void eliminar(int id) {
        String sql = "DELETE FROM Reserva WHERE id_reserva = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}