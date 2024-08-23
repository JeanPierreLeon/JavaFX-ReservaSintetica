package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;

public class ReservaBuilder <T extends ReservaBuilder<T>> {

    protected String idReserva;
    protected String idUsuarioAsociado;
    protected String fecha;
    protected String idCancha;
    protected String PrecioReserva;

    public T idReserva(String idReserva){
        this.idReserva=idReserva;
        return self();
    }

    public T idUsuarioAsociado(String idUsuarioAsociado){
        this.idUsuarioAsociado=idUsuarioAsociado;
        return self();
    }
    public T fecha(String fecha){
        this.fecha=fecha;
        return self();
    }
    public T idCancha(String idCancha){
        this.idCancha=idCancha;
        return self();
    }
    public T PrecioReserva(String PrecioReserva){
        this.PrecioReserva=PrecioReserva;
        return self();
    }
    public Reserva build(){
        return new Reserva(idReserva,idUsuarioAsociado,fecha,idCancha, PrecioReserva);
    }
    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }
}
