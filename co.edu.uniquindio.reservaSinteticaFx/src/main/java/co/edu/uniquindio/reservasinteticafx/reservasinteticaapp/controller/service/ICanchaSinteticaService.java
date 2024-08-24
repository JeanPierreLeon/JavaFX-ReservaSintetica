package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.exceptions.ReservaException;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;

import java.util.ArrayList;

public interface ICanchaSinteticaService {
    public Reserva crearReserva(String idReserva, String idUsuarioAsociado, String fecha, String idCancha, String PrecioReserva) throws ReservaException;
    public Boolean eliminarReserva(String idReserva)throws ReservaException;
    boolean actualizarReserva(String idReservaActual, Reserva reserva) throws ReservaException;
    public boolean  verificarReservaExistente(String cedula) throws ReservaException;
    public Reserva obtenerReservas(String idReserva);
    public ArrayList<Reserva> obtenerReserva();

}
