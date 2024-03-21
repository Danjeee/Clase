module com.example.ejercicios1fx_javierse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicios1fx_javierse to javafx.fxml;
    exports com.example.ejercicios1fx_javierse;
}