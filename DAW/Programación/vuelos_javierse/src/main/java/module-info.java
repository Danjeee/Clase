module vuelos_javierse {
    requires javafx.controls;
    requires javafx.fxml;

    opens vuelos_javierse to javafx.fxml;
    exports vuelos_javierse;
}
