package Hotel;

import java.sql.Date;

public class Reserva {
    private int idReserva;
    private int idCliente;
    private int idHabitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;

    public Reserva() {}
    public Reserva(int id, int idC, int idH, Date fi, Date ff, String e) {
        this.idReserva = id; this.idCliente = idC; this.idHabitacion = idH; this.fechaInicio = fi; this.fechaFin = ff; this.estado = e;
    }
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    @Override public String toString() {
        return "Reserva [ID=" + idReserva + ", ID Cli=" + idCliente + ", ID Hab=" + idHabitacion + ", Inicio=" + fechaInicio + ", Fin=" + fechaFin + "]";
    }
}
