package Lesson2.HW2;

import java.util.Objects;
import java.util.Scanner;

public class Car {
    private String modelName;
    private String manufacturer;
    private int yearOfManufacture;
    private double engineVolume;

    private static int count = 0;


    public Car() {
        this.modelName = "Неизвестно";
        this.manufacturer = "Неизвестно";
        this.yearOfManufacture = 0;
        this.engineVolume = 0.0;
        count++;
    }

    // Полный конструктор
    public Car(String modelName, String manufacturer, int yearOfManufacture, double engineVolume) {
        this.modelName = modelName != null ? modelName : "Неизвестно";
        this.manufacturer = manufacturer != null ? manufacturer : "Неизвестно";
        this.yearOfManufacture = Math.max(yearOfManufacture, 0);
        this.engineVolume = engineVolume >= 0 ? engineVolume : 0.0;
        count++;
    }

    public Car(String modelName, String manufacturer, int yearOfManufacture) {
        this(modelName, manufacturer, yearOfManufacture, 0.0);
    }


    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название модели автомобиля: ");
        this.modelName = scanner.nextLine();

        System.out.print("Введите название производителя: ");
        this.manufacturer = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        this.yearOfManufacture = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        System.out.print("Введите объём двигателя (в литрах): ");
        this.engineVolume = scanner.nextDouble();
        scanner.nextLine(); // очистка буфера
    }

    public void inputFromConsole(String modelName, String manufacturer) {
        this.modelName = modelName != null ? modelName : "Неизвестно";
        this.manufacturer = manufacturer != null ? manufacturer : "Неизвестно";
        this.yearOfManufacture = 0;
        this.engineVolume = 0.0;
    }

    public void displayInfo() {
        System.out.println("\n=== Информация об автомобиле ===");
        System.out.println("Модель: " + modelName);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Год выпуска: " + yearOfManufacture);
        System.out.println("Объём двигателя: " + engineVolume + " л");
    }

    public void displayInfo(boolean shortVersion) {
        if (shortVersion) {
            System.out.println("Автомобиль: " + modelName +
                    " (" + manufacturer + ", " + yearOfManufacture + ")");
        } else {
            displayInfo();
        }
    }

    // Геттеры
    public String getModelName() {
        return modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    // Сеттеры
    public void setModelName(String modelName) {
        this.modelName = modelName != null ? modelName : "Неизвестно";
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer != null ? manufacturer : "Неизвестно";
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = Math.max(yearOfManufacture, 0);
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume >= 0 ? engineVolume : 0.0;
    }

    // Статический метод получения количества созданных автомобилей
    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", engineVolume=" + engineVolume +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfManufacture == car.yearOfManufacture &&
                Double.compare(engineVolume, car.engineVolume) == 0
                && Objects.equals(modelName, car.modelName) &&
                Objects.equals(manufacturer, car.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, manufacturer, yearOfManufacture, engineVolume);
    }
}
