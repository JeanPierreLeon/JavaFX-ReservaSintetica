module co.edu.uniquindio.reservasinteticafx.reservasinteticaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mapstruct;
    requires org.mapstruct.processor;


    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp;
    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController;
}