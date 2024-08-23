package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder.CanchaSinteticaBuilder;

import java.util.ArrayList;
import java.util.List;

public class CanchaSintetica {
   private List<Usuario> listaUsuarios = new ArrayList<>();
   private List<Reserva> listaReservas = new ArrayList<>();
   private List<Empleado> listaEmpleados = new ArrayList<>();

    public static CanchaSinteticaBuilder builder(){
        return new CanchaSinteticaBuilder();
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

    public boolean eliminarReservas(Reserva reservaEliminar) {
        Reserva reservaEncontrado = obtenerReserva(reservaEliminar.getIdReserva());
        if(reservaEncontrado != null){
            getListaReservas().remove(reservaEncontrado);
            return true;
        }else{
            return  false;
        }
    }

    private Reserva obtenerReserva(String idReserva) {
        Reserva reserva = null;
        for (Reserva reserva1: getListaReservas()) {
            if(reserva1.getIdReserva().equalsIgnoreCase(idReserva)){
                reserva = reserva1;
                break;
            }
        }

        return reserva;
    }

    public boolean crearReserva(Reserva reserva) {
        Reserva reservaEncontrada = obtenerReserva(reserva.getIdReserva());
        if(reservaEncontrada == null){
            getListaReservas().add(reserva);
            return true;
        }else{
            return  false;
        }
    }

    public boolean actualizarReserva(Reserva reserva) {
        Reserva reservaEncontrada = obtenerReserva(reserva.getIdReserva());
        if(reservaEncontrada != null){
            getListaReservas().remove(reservaEncontrada);
            getListaReservas().add(reserva);
            return true;
        }else{
            return  false;
        }
    }
}
