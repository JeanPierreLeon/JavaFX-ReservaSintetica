module co.edu.uniquindio.reservasinteticafx.reservasinteticaapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp;
}