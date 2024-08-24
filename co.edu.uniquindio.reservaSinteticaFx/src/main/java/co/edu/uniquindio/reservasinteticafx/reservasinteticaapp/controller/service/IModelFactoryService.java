package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;

import java.util.List;

public interface IModelFactoryService {

    List<ReservaDto> obtenerReservas();

    boolean agregarReserva(ReservaDto reservaDto);

    boolean eliminarReserva(String idReserva);

    boolean actualizarReserva(String idReservaActual, ReservaDto reservaDto);

}
