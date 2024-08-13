package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service.ICanchaSinteticaService;

public class CanchaSinteticaController implements ICanchaSinteticaService {
    ModelFactoryController modelFactoryController;

    public CanchaSinteticaController(){
        System.out.println("CanchaSinteticaController");
        modelFactoryController = ModelFactoryController.getIntance();
    }
}
