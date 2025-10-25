package Hotel;

import java.math.BigDecimal;

public class Servicio {
    private int idServicio;
    private String nombre;
    private BigDecimal precio;

    public Servicio() {}
    public Servicio(int id, String n, BigDecimal p) {
        this.idServicio = id; this.nombre = n; this.precio = p;
    }
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    @Override public String toString() {
        return "Servicio [ID=" + idServicio + ", Nombre='" + nombre + "', Precio=" + precio + "]";
    }
}
