module com.example.notepad_javi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.notepad_javi to javafx.fxml;
    exports com.example.notepad_javi;
}