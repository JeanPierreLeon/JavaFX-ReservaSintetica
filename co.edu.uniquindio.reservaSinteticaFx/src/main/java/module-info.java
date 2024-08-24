module co.edu.uniquindio.reservasinteticafx.reservasinteticaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.mapstruct;
    requires org.mapstruct.processor;
    requires javafx.graphics;



    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController;
    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.viewController to javafx.fxml;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.dto;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.mapping.mappers;
    exports co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.model;
    opens co.edu.uniquindio.reservasinteticafx.reservasinteticaapp.controller to javafx.fxml;

}