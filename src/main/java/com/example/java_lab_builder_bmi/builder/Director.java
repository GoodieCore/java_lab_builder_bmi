package com.example.java_lab_builder_bmi.builder;

import javafx.scene.paint.Color;

public class Director {
    BuildThroughInd builder = new BuildThroughInd();
    public Indicator Constr(Color color, String text1, String text2, double signX){
        builder.createRectangle(25, 150, color);
        builder.createTriangle(25, 30, signX);
        builder.createText(text1);
        builder.createTextField(text2);
        return builder.Build();
    }
}
