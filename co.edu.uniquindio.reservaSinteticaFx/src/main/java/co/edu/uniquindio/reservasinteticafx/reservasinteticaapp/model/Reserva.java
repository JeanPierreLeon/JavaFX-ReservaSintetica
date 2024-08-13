package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;

public class Reserva {
    private int idReserva;
    private int idUsuarioAsociado;
    private String fecha;
    private String idCancha;
    private String idFechaReserva;
    private int PrecioReserva;


    public Reserva(int idReserva, int idUsuarioAsociado, String fecha, String idCancha, String idFechaReserva, int precioReserva) {
        this.idReserva = idReserva;
        this.idUsuarioAsociado = idUsuarioAsociado;
        this.fecha = fecha;
        this.idCancha = idCancha;
        this.idFechaReserva = idFechaReserva;
        PrecioReserva = precioReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuarioAsociado() {
        return idUsuarioAsociado;
    }

    public void setIdUsuarioAsociado(int idUsuarioAsociado) {
        this.idUsuarioAsociado = idUsuarioAsociado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(String idCancha) {
        this.idCancha = idCancha;
    }

    public String getIdFechaReserva() {
        return idFechaReserva;
    }

    public void setIdFechaReserva(String idFechaReserva) {
        this.idFechaReserva = idFechaReserva;
    }

    public int getPrecioReserva() {
        return PrecioReserva;
    }

    public void setPrecioReserva(int precioReserva) {
        PrecioReserva = precioReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", idUsuarioAsociado=" + idUsuarioAsociado +
                ", fecha='" + fecha + '\'' +
                ", idCancha='" + idCancha + '\'' +
                ", idFechaReserva='" + idFechaReserva + '\'' +
                ", PrecioReserva=" + PrecioReserva +
                '}';
    }
}
