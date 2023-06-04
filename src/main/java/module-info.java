module com.example.railway_reservation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;
    requires pdfbox.app;
    requires javafx.swing;
    requires junit;


    opens Railway_reservation to javafx.fxml;
    exports Railway_reservation;

    //opens com.example.zmrs_project to javafx.fxml;

//    opens Railway_reservation.myapp to javafx.fxml;
//    exports Railway_reservation.myapp;
}