package co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController;


import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.Builder.ReservaBuilder;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller.ReservaController;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.CanchaSintetica;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Empleado;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Reserva;
import co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReservasViewController {
    ReservaController reservaController;
    Reserva reservaSeleccionada;
    ObservableList<Reserva> listaReserva = FXCollections.observableArrayList();

    @FXML
    private TableView<Reserva> TableReserva;

    @FXML
    private Button btnActualizarReserva;

    @FXML
    private Button btnAgregarReserva;

    @FXML
    private Button btnEliminarReserva;

    @FXML
    private TableColumn<Reserva,String> colFechaReserva;

    @FXML
    private TableColumn<Reserva,String> colIDCancha;

    @FXML
    private TableColumn<Reserva,String> colIDRerserva;

    @FXML
    private TableColumn<Reserva,String> colIDUsuarioAsociado;

    @FXML
    private TableColumn<Reserva,String> colPrecioReserva;

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
        TableReserva.setItems(listaReserva);
        listenerSelectionReserva();
    }


    private void listenerSelectionReserva() {
        TableReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionada = newSelection;
            mostrarInformacionReserva(reservaSeleccionada);
        });
    }

    private void mostrarInformacionReserva(Reserva reservaSeleccionada) {
        if(reservaSeleccionada != null){

            txtIDReserva.setText(reservaSeleccionada.getIdReserva());
            txtIDUsuarioAsociado.setText(reservaSeleccionada.getIdUsuarioAsociado());
            txtFechaReserva.setText(reservaSeleccionada.getFecha());
            txtIDCancha.setText(String.valueOf(reservaSeleccionada.getIdCancha()));
            txtPrecioReserva.setText(reservaSeleccionada.getPrecioReserva());
    }
    }

    private void initDataBindingReservas() {
        colIDRerserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdReserva()));
        colIDUsuarioAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdUsuarioAsociado()));
        colFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha()));
        colIDCancha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCancha()));
        colPrecioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrecioReserva()));
    }

    @FXML
    void onActualizarReserva(ActionEvent event) {

    }

    @FXML
    void onAgregarReserva(ActionEvent event) {

    }

    @FXML
    void onEliminarReserva(ActionEvent event) {
        if(validarFormularioReserva()){
            Reserva reserva = construirDatosReserva();
            if(reservaController.eliminarReserva(reserva)){
                obtenerReserva();
                mostrarMensaje("Notificación Reserva", "Reserva eliminada", "La Reserva se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposReservas();
            }else{
                mostrarMensaje("Notificación Reserva", "Reserva no eliminada", "La Reserva no se ha eliminado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Reserva", "Reserva no eliminada", "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }

    private Reserva construirDatosReserva() {
        return Reserva.builder()
                .idReserva(txtIDReserva.getText())
                .idUsuarioAsociado(txtIDUsuarioAsociado.getText())
                .fecha(txtFechaReserva.getText())
                .idCancha(txtIDCancha.getText())
                .PrecioReserva(txtPrecioReserva.getText())
                .build();

    }
        private boolean validarFormularioReserva() {
        if(txtIDReserva.getText().isEmpty()
                || txtIDUsuarioAsociado.getText().isEmpty()
                || txtFechaReserva.getText().isEmpty()
                || txtIDCancha.getText().isEmpty()
                || txtPrecioReserva.getText().isEmpty()){
            return false;
        }

        return true;
    }

    private void obtenerReserva(){
        listaReserva.clear();
        listaReserva.addAll(reservaController.obtenerReservas());
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
}


