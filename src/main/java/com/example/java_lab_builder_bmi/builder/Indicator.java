package com.example.java_lab_builder_bmi.builder;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Indicator {
    private final HBox panel = new HBox();
    public void add(Pane pane){
        panel.getChildren().add(pane);
    }
    public void remove(Pane pane){
        pane.getChildren().remove(panel);
    }
    public void show(Pane pane){
        pane.getChildren().add(panel);
    }
}
