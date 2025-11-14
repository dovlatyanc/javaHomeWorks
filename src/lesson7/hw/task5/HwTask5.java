package lesson7.hw.task5;


import java.io.*;
import java.util.ArrayList;

public class HwTask5{
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Корпорация\n");

        // Добавляем тестовые данные
        employees.add(new Employee("Иванов", 25));
        employees.add(new Employee("Петров", 30));

        System.out.println("Исходные данные:");
        employees.forEach(System.out::println);

        // Сохраняем  и создаем файл с нечитаемыми данными
        saveData("corporation.txt");

        // Загружаем через десериализацию
        loadData("corporation.txt");

        System.out.println("\nДанные после загрузки:");
        employees.forEach(System.out::println);
    }

    private static void saveData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("\nДанные сохранены");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    private static void loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("Данные загружены");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки: " + e.getMessage());
        }
    }
}