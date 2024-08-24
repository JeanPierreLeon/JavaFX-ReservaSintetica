package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.utils;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;

public class CanchaSinteticaUtils {

    public static CanchaSintetica inicializarDatos(){

        CanchaSintetica canchaSintetica = new CanchaSintetica();

        Reserva reserva = new Reserva();
        reserva.setIdReserva("01");
        reserva.setIdUsuarioAsociado("01");
        reserva.setFecha("25/08/2024 5:00 pm");
        reserva.setIdCancha("Cancha 01");
        reserva.setPrecioReserva("50K");
        canchaSintetica.getListaReservas().add(reserva);

        reserva = new Reserva();
        reserva.setIdReserva("02");
        reserva.setIdUsuarioAsociado("02");
        reserva.setFecha("29/08/2024 9:00 pm");
        reserva.setIdCancha("Cancha 02");
        reserva.setPrecioReserva("40K");
        canchaSintetica.getListaReservas().add(reserva);
        System.out.println("Información de la Cancha Sintetica creada");

        return canchaSintetica;
    }




}
