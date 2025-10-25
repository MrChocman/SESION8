package Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    @Override public void agregar(Empleado e) {
        String sql = "INSERT INTO Empleado (nombre, cargo) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, e.getNombre()); pstmt.setString(2, e.getCargo());
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    @Override public List<Empleado> listarTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
        try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Empleado(rs.getInt("id_empleado"), rs.getString("nombre"), rs.getString("cargo")));
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return lista;
    }
    @Override public void actualizar(Empleado e) {
        String sql = "UPDATE Empleado SET nombre = ?, cargo = ? WHERE id_empleado = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, e.getNombre()); pstmt.setString(2, e.getCargo()); pstmt.setInt(3, e.getIdEmpleado());
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    @Override public void eliminar(int id) {
        String sql = "DELETE FROM Empleado WHERE id_empleado = ?";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
}
