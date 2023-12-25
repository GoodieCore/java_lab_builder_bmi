package com.example.java_lab_builder_bmi.controllers;

import com.example.java_lab_builder_bmi.builder.Director;
import com.example.java_lab_builder_bmi.builder.Indicator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BMIController {
    Indicator ind;
    public Button onClick;
    public TextField txt1,txt2;
    public boolean indOK = false;
    public HBox panel;
    public void calculateBMI() {
        if(indOK) {
            ind.remove(panel);
        }
        indOK = true;
        /*
        !!!
         */
        Director dir = new Director();
        double height = Double.parseDouble(txt1.getText());
        double weight = Double.parseDouble(txt2.getText());
        double result = weight/height/height*10000;
        double curValue = (Math.min((int) result, 40)) * 3;
        String format = String.format("%.1f",result);

        if(result<16.5) {
            ind = dir.Constr(Color.YELLOW,"Худощавость",format, curValue);
            ind.show(panel);
        } else if (result >= 16 && result < 18.5) {
            ind = dir.Constr(Color.ORANGE,"Недостаток веса", format,curValue);
            ind.show(panel);

        } else if (result >= 18.5 && result < 25) {
            ind = dir.Constr(Color.GREEN,"Нормальный вес", format,curValue);
            ind.show(panel);

        } else if (result >= 25 && result < 30) {
            ind = dir.Constr(Color.PINK,"Избыток веса",format, curValue);
            ind.show(panel);

        } else if (result >= 30) {
            ind = dir.Constr(Color.RED,"Ожирение", format, curValue);
            ind.show(panel);

        }
    }

    public void onClick(){
        try {
            calculateBMI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}