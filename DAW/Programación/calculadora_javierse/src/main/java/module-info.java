module com.example.calculadora_javierse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculadora_javierse to javafx.fxml;
    exports com.example.calculadora_javierse;
}