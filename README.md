# BMI Калькулятор c использованием паттерна Director
----------------
**Описание**: В ходе данной работы был разработан калькулятор индекса массы тела, который определяет ИМТ по данным роста и веса.
- Технологический стек: Java
- Статус: 1.7.2.
- По сравнению с другими подобными продуктами, данная разработка отличается понятным кодом и удобным интерфейсом.
**Скриншот рабочего окна приложения:**
----------------------------------------
 ![image](https://github.com/StephanKomov/java_task01/blob/master/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202023-12-26%20115829.jpg)

 **Разбор части кода на примере класса BMI**
```
public class HelloController {
    @FXML
    public Label labelIMT;
    private final Imt_class bmi = new Imt_class();
    public TextField massa;
    public TextField rost;
    public Label imt;
    public Button butto;
    public Indicator indicator;
    public boolean indOk = false;
    public HBox colorbox;


    public void onHelloButtonClick(ActionEvent actionEvent) {
        if (indOk) indicator.remove(colorbox);
        indOk = true;
        Director director = new Director();
        bmi.setMass_p(massa.getText());
        bmi.setRost_p(rost.getText());
        Color color;
        if (bmi.getImt() < 16) color = Color.RED;
        else if (bmi.getImt() <= 18.5) color = Color.YELLOW;
        else if (bmi.getImt() <= 25) color = Color.GREEN;
        else if (bmi.getImt() <= 30) color = Color.YELLOW;
        else color = Color.RED;
        indicator = new Indicator();
        double flag = (int) bmi.getImt() * 10.4;
        if (flag > 530) {
            flag = 525;
        }

        indicator = director.construct(color, flag, getMessageBasedOnIMT(bmi.getImt()));
        indicator.show(colorbox);

        imt.setText(String.valueOf(bmi.getImt()));

        String message = getMessageBasedOnIMT(bmi.getImt());
        labelIMT.setText(message);
    }

    private String getMessageBasedOnIMT(double imt) {
        String message = "";
        if (imt < 16) message = "Значительный дефицит массы тела";
        else if (imt <= 18.5) message = "Дефицит массы тела";
        else if (imt <= 25) message = "Норма";
        else if (imt <= 30) message = "Лишний вес";
        else message = "Ожирение";
        return message;
    }
}
```
------------------------

## Архитектура
Диаграмма классов:

 ![image](https://github.com/StephanKomov/java_task01/blob/master/2.jpg)


## Завсимости
Для работы данного приложежния необходимы JavaFX и JDK 20.

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
 ![image](https://rgb6.medgis.ru/uploads/3c/bf/d1/dd/3cbfd1dd909dae37fa3d1b6248c2b520de7a46e9.jpg)


## Проверка ПО
Не предусмотрена

## Проблемы
Индекс массы тела может считаться только по одной формуле 

## Получение справочной информации
По всем вопрсам можно обратиться в [ВК](https://vk.com/id484742584) разработчика  

## Приглашение к сотрудничеству 
В дальнейшем предполагается переработка кода для улучшения имеющийся программы 

## Источники и справочники
- [Что такое индекс массы тела?](https://ru.wikipedia.org/wiki/%D0%98%D0%BD%D0%B4%D0%B5%D0%BA%D1%81_%D0%BC%D0%B0%D1%81%D1%81%D1%8B_%D1%82%D0%B5%D0%BB%D0%B0)
- [Как рисовать фигуры?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-2-%D1%84%D0%B0%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D1%8B%D0%B9-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4)
- [Что такое строитель?](https://sites.google.com/view/study-pattern/%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F/%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8/task-5-%D1%81%D1%82%D1%80%D0%BE%D0%B8%D1%82%D0%B5%D0%BB%D1%8C)
