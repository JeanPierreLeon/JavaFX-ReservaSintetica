package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder.CanchaSinteticaBuilder;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder.ReservaBuilder;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import org.mapstruct.ap.shaded.freemarker.ext.util.ModelFactory;

import java.util.List;

public class ModelFactoryController {
    private static ModelFactoryController modelFactoryController;
    private CanchaSintetica canchaSintetica = CanchaSintetica.builder().build();

    private ModelFactoryController(){
        inicializarDatos();
    }

    public static ModelFactoryController getInstance() {
        if (modelFactoryController == null){
            modelFactoryController = new ModelFactoryController();
        }
        return modelFactoryController;
    }



    private void inicializarDatos() {
        /*Creacion de Reservas*/

        Reserva reserva1 = Reserva.builder()
                .idReserva("1")
                .idUsuarioAsociado("1")
                .fecha("24/08/2024 7:00 PM")
                .idCancha("Cancha 1")
                .PrecioReserva("50.000")
                .build();


        canchaSintetica.getListaReservas().add(reserva1);

    }


    public List<Reserva> obtenerReservas() {
        return canchaSintetica.getListaReservas();
    }

    public boolean eliminarReservas(Reserva reserva) {
        return canchaSintetica.eliminarReservas(reserva);
    }

    public boolean crearReservas(Reserva reserva) {
        return canchaSintetica.crearReserva(reserva);
    }

    public boolean actualizarReserva(Reserva reserva) {
        return canchaSintetica.actualizarReserva(reserva);
    }
    // CanchaSinteticaMapper mapper = CanchaSinteticaMapper.INSTANCE;



}
