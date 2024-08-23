package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder;

import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Empleado;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CanchaSinteticaBuilder {
    protected List<Usuario> listaUsuarios = new ArrayList<>();
    protected List<Reserva> listaReservas = new ArrayList<>();
    protected List<Empleado> listaEmpleados = new ArrayList<>();

    public CanchaSinteticaBuilder ListaReservas(List <Reserva> listaReservas) {
        this.listaReservas = listaReservas;
        return this;
    }

    public CanchaSintetica build() {
        return new CanchaSintetica(listaUsuarios,listaReservas,listaEmpleados);
    }
}
