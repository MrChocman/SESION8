package Hotel;

import java.math.BigDecimal;

public class Habitacion {
    private int idHabitacion;
    private String numero;
    private String tipo;
    private BigDecimal precio;
    private String estado;

    public Habitacion() {}

    public Habitacion(int idHabitacion, String numero, String tipo, BigDecimal precio, String estado) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Habitacion [ID=" + idHabitacion + ", Numero='" + numero + "', Tipo='" + tipo + "', Precio=" + precio + ", Estado='" + estado + "']";
    }
}