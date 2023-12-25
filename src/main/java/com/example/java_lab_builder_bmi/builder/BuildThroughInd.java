package com.example.java_lab_builder_bmi.builder;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class BuildThroughInd implements Builder {
    Indicator indicator = new Indicator();
    @Override
    public void createRectangle(int w, int h, Color color) {
        Rectangle rect = new Rectangle(w,h);
        Pane pane = new Pane();
        rect.setFill(color);
        rect.setStroke(Color.BLACK);

        rect.setX(5);
        rect.setY(5);
        pane.getChildren().add(rect);
        indicator.add(pane);
    }
    @Override
    public void createText(String textCore) {
        Text text = new Text("RESULT: " + textCore);
        Pane pane = new Pane();
        text.setX(200);
        text.setY(70);
        text.setFont(Font.font("Arial", 16));
        pane.getChildren().add(text);
        indicator.add(pane);
    }
    public void createTextField(String initialText) {
        TextField textField = new TextField(initialText);
        Pane pane = new Pane();
        textField.setLayoutY(80);
        textField.setFont(Font.font("Arial", 14));
        textField.setAlignment(Pos.CENTER_LEFT);
        pane.getChildren().add(textField);
        indicator.add(pane);
    }
    @Override
    public void createTriangle(double base, double height, double signX) {
        Polygon triangle = new Polygon();
        Pane pane = new Pane();
        triangle.getPoints().addAll(
                0.0, height,
                base / 2, 0.0,
                base, height
        );
        Rotate rotation = new Rotate(-90, base, height);
        triangle.getTransforms().add(rotation);
        triangle.setFill(Color.TRANSPARENT);
        triangle.setStroke(Color.BLACK);
        triangle.setStrokeWidth(1.0);

        triangle.setLayoutX(50);
        triangle.setLayoutY(5 + signX - height);
        pane.getChildren().add(triangle);
        indicator.add(pane);
    }

    @Override
    public Indicator Build() {
        return indicator;
    }
}
