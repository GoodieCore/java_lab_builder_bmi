# BMI Калькулятор c использованием паттерна Director
----------------
**Описание**: В ходе данной работы был разработан калькулятор индекса массы тела, который определяет ИМТ по данным роста и веса.
- Технологический стек: Java
- Статус: 1.7.2.
- По сравнению с другими подобными продуктами, данная разработка отличается понятным кодом и удобным интерфейсом.
**Скриншот рабочего окна приложения:**
----------------------------------------
 ![image](https://github.com/GoodieCore/java_lab_builder_bmi/blob/master/Director_img_1.JPG)

 **Разбор части кода на примере класса BMIController**
```
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
```
------------------------

## Архитектура
Диаграмма классов:

 ![image](https://github.com/GoodieCore/java_lab_builder_bmi/blob/master/Director_img_2.JPG)


## Завсимости
Для работы данного приложежния необходимы JavaFX и JDK 21.

## Установка
Не требуется. Достаточно запустить проект через любую доступную среду разработки JAVA.

##  Конфигурация
Не требуется


## Применение
Для работы с приложенияем требуется указать некоторые *параметры*:
1. Массу тела в кг
2. Рост в см
С помощью этих значений, формула **bmi = M/H^2** рассчитывает индекс массы тела. 
Полученый результат сверяеться с данными рисунка ниже и на основании этого пишет вывод.
 ![image](https://github.com/GoodieCore/java_lab_builder_bmi/blob/master/Director_img_3.jpg)


## Проверка ПО
Не предусмотрена

## Проблемы
Индекс массы тела может считаться только по одной формуле 

## Получение справочной информации
По всем вопрсам можно обратиться в [ВК](https://vk.com/iayiwer) разработчика  

## Приглашение к сотрудничеству 
В дальнейшем предполагается переработка кода для улучшения имеющийся программы 

## Источники и справочники
- [Что такое индекс массы тела?](https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B4%D0%B5%D0%BA%D1%81_%D0%BC%D0%B0%D1%81%D1%81%D1%8B_%D1%82%D0%B5%D0%BB%D0%B0)
- [Как рисовать фигуры?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-2-%D1%84%D0%B0%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D1%8B%D0%B9-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4)
- [Что такое строитель?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-5-%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D0%B5%D0%BB%D1%8C)
