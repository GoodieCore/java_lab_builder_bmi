module com.example.java_lab_builder_bmi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_lab_builder_bmi to javafx.fxml;
    exports com.example.java_lab_builder_bmi;
    exports com.example.java_lab_builder_bmi.controllers;
    opens com.example.java_lab_builder_bmi.controllers to javafx.fxml;
    exports com.example.java_lab_builder_bmi.builder;
    opens com.example.java_lab_builder_bmi.builder to javafx.fxml;
}