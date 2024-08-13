package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;

public class ModelFactoryController {

    CanchaSintetica canchaSintetica;
    CanchaSinteticaMapper mapper = CanchaSinteticaMapper.INSTANCE;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getIntance() {
        return SingletonHolder.eINSTANCE;
    }
}
