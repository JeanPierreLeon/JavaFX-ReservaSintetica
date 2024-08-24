package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service.ICanchaSinteticaService;

public class CanchaSinteticaController  {
    ModelFactoryController modelFactoryController;

    public CanchaSinteticaController() {
        System.out.println("Llamando al singleton desde CanchaSinteticaServiceController");
        modelFactoryController = ModelFactoryController.getInstance();

    }
}
