package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController;



import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.ReservaController;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto.ReservaDto;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ReservasViewController {
    ReservaController reservaController;
    ObservableList<ReservaDto> listaReservaDto = FXCollections.observableArrayList();
    ReservaDto reservaSeleccionado;

    @FXML
    private TableView<ReservaDto> TableReserva;

    @FXML
    private Button btnActualizarReserva;

    @FXML
    private Button btnAgregarReserva;

    @FXML
    private Button btnEliminarReserva;

    @FXML
    private TableColumn<ReservaDto,String> colFechaReserva;

    @FXML
    private TableColumn<ReservaDto,String> colIDCancha;

    @FXML
    private TableColumn<ReservaDto,String> colIDRerserva;

    @FXML
    private TableColumn<ReservaDto,String> colIDUsuarioAsociado;

    @FXML
    private TableColumn<ReservaDto,String> colPrecioReserva;

    @FXML
    private TextField txtFechaReserva;

    @FXML
    private TextField txtIDCancha;

    @FXML
    private TextField txtIDReserva;

    @FXML
    private TextField txtIDUsuarioAsociado;

    @FXML
    private TextField txtPrecioReserva;

    @FXML
    void initialize() {
        reservaController = new ReservaController();
        initTableReservas();

    }

    private void initTableReservas() {
        initDataBindingReservas();
        obtenerReserva();
        TableReserva.getItems().clear();
        TableReserva.setItems(listaReservaDto);
        listenerSelectionReserva();
    }

    private void initDataBindingReservas() {
        colIDRerserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idReserva()));
        colIDUsuarioAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idUsuarioAsociado()));
        colFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        colIDCancha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idCancha()));
        colPrecioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().PrecioReserva()));
    }

    private void obtenerReserva(){
        listaReservaDto.addAll(reservaController.obtenerReservas());
    }


    private void listenerSelectionReserva() {
        TableReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionado = newSelection;
            mostrarInformacionReserva(reservaSeleccionado);
        });
    }

    private void mostrarInformacionReserva(ReservaDto reservaSeleccionado) {
        if(reservaSeleccionado != null){

            txtIDReserva.setText(reservaSeleccionado.idReserva());
            txtIDUsuarioAsociado.setText(reservaSeleccionado.idUsuarioAsociado());
            txtFechaReserva.setText(reservaSeleccionado.fecha());
            txtIDCancha.setText(String.valueOf(reservaSeleccionado.idCancha()));
            txtPrecioReserva.setText(reservaSeleccionado.PrecioReserva());
    }
    }

    @FXML
    void onNuevoReserva(ActionEvent event) {
            txtIDReserva.setText("Ingrese el ID de la reserva");
    }



    @FXML
    void onActualizarReserva(ActionEvent event) {
        boolean reservaActualizada = false;
        //1. Capturar los datos
        String idReserva = reservaSeleccionado.idReserva();
        ReservaDto reservaDto = construirDatosReserva();
        //2. verificar el empleado seleccionado
        if(reservaSeleccionado != null){
            //3. Validar la información
            if(datosValidos(reservaSeleccionado)){
                reservaActualizada = reservaController.actualizarReserva(idReserva,reservaDto);
                if(reservaActualizada){
                    listaReservaDto.remove(reservaSeleccionado);
                    listaReservaDto.add(reservaDto);
                    TableReserva.refresh();
                    mostrarMensaje("Notificación reserva", "reserva actualizada", "La reserva se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposReservas();
                }else{
                    mostrarMensaje("Notificación reserva", "reserva no actualizada", "La reserva no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación reserva", "reserva no creada", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    @FXML
    void onAgregarReserva(ActionEvent event) {
        //1. Capturar los datos
        ReservaDto reservaDto = construirDatosReserva();
        //2. Validar la información
        if(datosValidos(reservaDto)){
            if(reservaController.agregarReserva(reservaDto)){
                listaReservaDto.add(reservaDto);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposReservas();
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onEliminarReserva(ActionEvent event) {
        boolean empleadoEliminado = false;
        if(reservaSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar al empleado?")){
                empleadoEliminado = reservaController.eliminarReserva(reservaSeleccionado.idReserva());
                if(empleadoEliminado){
                    listaReservaDto.remove(reservaSeleccionado);
                    reservaSeleccionado = null;
                    TableReserva.getSelectionModel().clearSelection();
                    limpiarCamposReservas();
                    mostrarMensaje("Notificación empleado", "Empleado eliminado", "El empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación empleado", "Empleado no eliminado", "El empleado no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no seleccionado", "Seleccionado un empleado de la lista", Alert.AlertType.WARNING);
        }
    }

    private ReservaDto construirDatosReserva() {
        return new ReservaDto(
                txtIDReserva.getText(),
                txtIDUsuarioAsociado.getText(),
                txtFechaReserva.getText(),
                txtIDCancha.getText(),
                txtPrecioReserva.getText()
        );

    }




    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void limpiarCamposReservas() {
        txtIDReserva.setText("");
        txtIDUsuarioAsociado.setText("");
        txtFechaReserva.setText("");
        txtIDCancha.setText("");
        txtPrecioReserva.setText("");
    }

    private boolean datosValidos(ReservaDto reservaDto) {
        String mensaje = "";
        if(reservaDto.idReserva() == null || reservaDto.idReserva().equals(""))
            mensaje += "El ID es invalido \n" ;
        if(reservaDto.idUsuarioAsociado() == null || reservaDto.idUsuarioAsociado() .equals(""))
            mensaje += "El ID es invalido \n" ;
        if(reservaDto.fecha() == null || reservaDto.fecha().equals(""))
            mensaje += "La fecha es invalida \n" ;
        if(reservaDto.idCancha() == null || reservaDto.idCancha().equals(""))
            mensaje += "La cancha es invalida \n" ;
        if(reservaDto.PrecioReserva() == null || reservaDto.PrecioReserva().equals(""))
            mensaje += "El precio es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación Reserva","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}


