package Hotel;

import java.math.BigDecimal;
import java.sql.Date;

public class Factura {
    private int idFactura;
    private int idReserva;
    private int idEmpleado;
    private Date fechaEmision;
    private BigDecimal total;

    public Factura() {}
    public Factura(int id, int idR, int idE, Date fe, BigDecimal t) {
        this.idFactura = id; this.idReserva = idR; this.idEmpleado = idE; this.fechaEmision = fe; this.total = t;
    }
    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    @Override public String toString() {
        return "Factura [ID=" + idFactura + ", ID Reserva=" + idReserva + ", ID Emp=" + idEmpleado + ", Emision=" + fechaEmision + ", Total=" + total + "]";
    }
}
