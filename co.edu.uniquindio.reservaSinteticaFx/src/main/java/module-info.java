module co.edu.uniquindio.reservasinteticafx.reservasinteticaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.mapstruct;


    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp;
}