module com.mycompany.datasiswa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.datasiswa to javafx.fxml;
    exports com.mycompany.datasiswa;
}
