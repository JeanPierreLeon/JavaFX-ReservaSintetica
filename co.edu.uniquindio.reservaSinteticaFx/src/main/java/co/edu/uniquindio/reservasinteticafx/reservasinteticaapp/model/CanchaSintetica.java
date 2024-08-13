package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;

import java.util.ArrayList;

public class CanchaSintetica {
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Reserva> listaReservas = new ArrayList<>();
    ArrayList<Empleados> listaEmpleados = new ArrayList<>();

    public CanchaSintetica() {
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public ArrayList<Empleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
}
