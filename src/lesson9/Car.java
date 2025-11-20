package lesson9;

import java.text.DateFormat;

public class Car {
    private String name;
    private String color;
    private double engine;
    private int year;
    private double price;

    public Car(String name, String color, double engine, int year, double price) {
        this.name = name;
        this.color = color;
        this.engine = engine;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
