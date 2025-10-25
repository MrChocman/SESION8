package Hotel;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String cargo;

    public Empleado() {}
    public Empleado(int id, String n, String c) {
        this.idEmpleado = id; this.nombre = n; this.cargo = c;
    }
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    @Override public String toString() {
        return "Empleado [ID=" + idEmpleado + ", Nombre='" + nombre + "', Cargo='" + cargo + "']";
    }
}
