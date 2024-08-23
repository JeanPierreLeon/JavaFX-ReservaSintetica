package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import org.mapstruct.ap.shaded.freemarker.ext.util.ModelFactory;

import java.util.List;

public class ReservaController {

    ModelFactoryController modelFactoryController;

    public  ReservaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<Reserva> obtenerReservas() {
        return modelFactoryController.obtenerReservas();
    }

    public boolean eliminarReserva(Reserva reserva) {
        return modelFactoryController.eliminarReservas(reserva);
    }
}
