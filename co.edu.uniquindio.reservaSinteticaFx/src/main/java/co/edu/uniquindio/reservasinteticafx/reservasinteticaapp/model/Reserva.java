package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;



import java.util.ArrayList;

public class Reserva {
    private String idReserva;
    private String idUsuarioAsociado;
    private String fecha;
    private String idCancha;
    private String PrecioReserva;
    ArrayList<Usuario> listaUsuariosAsociados = new ArrayList<Usuario>();


    public Reserva(String idReserva, String idUsuarioAsociado, String fecha, String idCancha,  String PrecioReserva) {
        this.idReserva = idReserva;
        this.idUsuarioAsociado = idUsuarioAsociado;
        this.fecha = fecha;
        this.idCancha = idCancha;
        this.PrecioReserva = PrecioReserva;
    }

    public Reserva() {

    }



    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdUsuarioAsociado() {
        return idUsuarioAsociado;
    }

    public void setIdUsuarioAsociado(String idUsuarioAsociado) {
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

    public String getPrecioReserva() {
        return PrecioReserva;
    }

    public void setPrecioReserva(String PrecioReserva) {
        this.PrecioReserva = PrecioReserva;
    }

    public ArrayList<Usuario> getListaUsuariosAsociados() {
        return listaUsuariosAsociados;
    }

    public void setListaUsuariosAsociados(ArrayList<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados = listaUsuariosAsociados;
    }
    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva='" + idReserva + '\'' +
                ", idUsuarioAsociado='" + idUsuarioAsociado + '\'' +
                ", fecha='" + fecha + '\'' +
                ", idCancha='" + idCancha + '\'' +
                ", PrecioReserva='" + PrecioReserva + '\'' +
                '}';
    }


}
