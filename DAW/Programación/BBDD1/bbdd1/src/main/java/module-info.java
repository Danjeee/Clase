module jav.se {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens jav.se to javafx.fxml;
    exports jav.se;
}
