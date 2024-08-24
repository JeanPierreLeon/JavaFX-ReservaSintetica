package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;


import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service.IModelFactoryService;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.exceptions.ReservaException;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.mappers.CanchaSinteticaMapper;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.utils.CanchaSinteticaUtils;

import java.util.List;

public class ModelFactoryController implements IModelFactoryService {
    CanchaSintetica canchaSintetica;
    CanchaSinteticaMapper mapper = CanchaSinteticaMapper.INSTANCE;



    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        canchaSintetica = CanchaSinteticaUtils.inicializarDatos();
    }

    public CanchaSintetica getCanchaSintetica() {
        return canchaSintetica;
    }

    public void setCanchaSintetica(CanchaSintetica canchaSintetica) {
        this.canchaSintetica = canchaSintetica;
    }


    @Override
    public List<ReservaDto> obtenerReservas() {
        return  mapper.getEmpleadosDto(canchaSintetica.getListaReservas());
    }



    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        try{
            if(!canchaSintetica.verificarReservaExistente(reservaDto.idReserva())) {
                Reserva reserva = mapper.empleadoDtoToEmpleado(reservaDto);
                getCanchaSintetica().agregarReserva(reserva);
            }
            return true;
        }catch (ReservaException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarReserva(String idReserva) {
        boolean flagExiste = false;
        try {
            flagExiste = getCanchaSintetica().eliminarReserva(idReserva);
        } catch (ReservaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarReserva(String idReservaActual, ReservaDto reservaDto) {
        try {
            Reserva reserva = mapper.empleadoDtoToEmpleado(reservaDto);
            getCanchaSintetica().actualizarReserva(idReservaActual, reserva);
            return true;
        } catch (ReservaException e) {
            e.printStackTrace();
            return false;
        }
    }







}
