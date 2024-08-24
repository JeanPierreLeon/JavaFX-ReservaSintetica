package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service.IReservaControllerService;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import org.mapstruct.ap.shaded.freemarker.ext.util.ModelFactory;

import java.util.List;

public class ReservaController implements IReservaControllerService {
    ModelFactoryController modelFactoryController;

    public  ReservaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<ReservaDto> obtenerReservas() {
        return modelFactoryController.obtenerReservas();
    }

    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        return modelFactoryController.agregarReserva(reservaDto);
    }

    @Override
    public boolean eliminarReserva(String idReserva) {
        return modelFactoryController.eliminarReserva(idReserva);
    }

    @Override
    public boolean actualizarReserva(String idReservaActual, ReservaDto reservaDto) {
        return modelFactoryController.actualizarReserva(idReservaActual, reservaDto);
    }


}
