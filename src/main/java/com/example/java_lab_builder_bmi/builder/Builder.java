package com.example.java_lab_builder_bmi.builder;

import javafx.scene.paint.Color;

public interface Builder {
    public void createRectangle(int width, int height, Color color);
    public void createText(String text);
    public void createTriangle(double base, double height, double signX);
    public void createTextField(String initialText);
    public Indicator Build();
}
