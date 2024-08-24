package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.service.ICanchaSinteticaService;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.exceptions.ReservaException;

import java.util.ArrayList;
import java.util.List;

public class CanchaSintetica implements ICanchaSinteticaService {
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Empleado> listaEmpleados = new ArrayList<>();

    public CanchaSintetica() {

    }


    public CanchaSintetica(List<Usuario> listaUsuarios, List<Reserva> listaReservas, List<Empleado> listaEmpleados) {
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.listaEmpleados = listaEmpleados;
    }



    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }


    @Override
    public Reserva crearReserva(String idReserva, String idUsuarioAsociado, String fecha, String idCancha, String PrecioReserva) throws ReservaException {
        Reserva nuevaReserva = null;
        boolean reservaExiste = verificarReservaExistente(idReserva);
        if(reservaExiste){
            throw new ReservaException("El empleado con cedula: "+idReserva+" ya existe");
        }else{
            nuevaReserva = new Reserva();
            nuevaReserva.setIdReserva(idReserva);
            nuevaReserva.setIdUsuarioAsociado(idUsuarioAsociado);
            nuevaReserva.setFecha(fecha);
            nuevaReserva.setIdCancha(idCancha);
            nuevaReserva.setPrecioReserva(PrecioReserva);

            getListaReservas().add(nuevaReserva);
        }
        return nuevaReserva;
    }

    public void agregarReserva(Reserva nuevoReserva) throws ReservaException {
        getListaReservas().add(nuevoReserva);

    }

    @Override
    public boolean actualizarReserva(String idReservaActual, Reserva reserva) throws ReservaException {
        Reserva reservaActual = obtenerReservas(idReservaActual);
        if(reservaActual == null)
            throw new ReservaException("El empleado a actualizar no existe");
        else{
            reservaActual.setIdReserva(reserva.getIdReserva());
            reservaActual.setIdUsuarioAsociado(reserva.getIdUsuarioAsociado());
            reservaActual.setFecha(reserva.getFecha());
            reservaActual.setIdCancha(reserva.getIdCancha());
            reservaActual.setPrecioReserva(reserva.getPrecioReserva());
            return true;
        }
    }

    @Override
    public Boolean eliminarReserva(String idReserva) throws ReservaException {
        Reserva reserva = null;
        boolean flagExiste = false;
        reserva = obtenerReservas(idReserva);
        if(reserva == null)
            throw new ReservaException("El empleado a eliminar no existe");
        else{
            getListaEmpleados().remove(reserva);
            flagExiste = true;
        }
        return flagExiste;
    }





    @Override
    public boolean verificarReservaExistente(String idReserva)throws ReservaException {
        if(reservaExiste(idReserva)){
            throw new ReservaException("La reserva con IdReserva: "+idReserva+" ya existe");
        }else{
            return false;
        }
    }

    @Override
    public Reserva obtenerReservas(String idReserva) {
        Reserva reservaEncontrada = null;
        for (Reserva reserva : getListaReservas()) {
            if(reserva.getIdReserva().equalsIgnoreCase(idReserva)){
                reservaEncontrada = reserva;
                break;
            }
        }
        return reservaEncontrada;
    }

    @Override
    public ArrayList<Reserva> obtenerReserva() {
        // TODO Auto-generated method stub
        return (ArrayList<Reserva>) getListaReservas();
    }

    private boolean reservaExiste(String idReserva) {
        boolean reservaEncontrada = false;
        for (Reserva reserva : getListaReservas()) {
            if(reserva.getIdReserva().equalsIgnoreCase(idReserva)){
                reservaEncontrada = true;
                break;
            }
        }
        return reservaEncontrada;
    }


}



