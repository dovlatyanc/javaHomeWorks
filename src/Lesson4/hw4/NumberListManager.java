package Lesson4.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NumberListManager {


    public static void showMenu() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Поток был прерван");
            Thread.currentThread().interrupt();
        }
        System.out.println("\nМеню:");
        System.out.println("1. Добавить элемент в список");
        System.out.println("2. Удалить элемент из списка");
        System.out.println("3. Показать содержимое списка");
        System.out.println("4. Проверить, есть ли значение в списке");
        System.out.println("5. Заменить значение в списке");
        System.out.println("6. Выход");
        System.out.print("Выберите действие (1–6): ");
    }

    public static void add(ArrayList<Integer> list, Scanner scanner) {
        System.out.print("Введите число для добавления: ");
        int num = scanner.nextInt();
        list.add(num);
        System.out.println("Число " + num + " добавлено.");
    }

    public static void remove(List<Integer> list, Scanner s) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Список пуст");
        }
        System.out.print("Введите число, которое нужно удалить: ");
        int num = s.nextInt();
        if (!list.remove(Integer.valueOf(num))) {
            throw new NoSuchElementException("Число " + num + " не найдено");
        }
        System.out.println("Удалено: " + num);
    }

    public static void showList(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Список пуст");
        }
        System.out.println("Список: " + list);
    }
    public static boolean hasValue(List<Integer> list, Scanner s) {
        int num = s.nextInt();
        return list.contains(num);
    }

    public static void replace(List<Integer> list, Scanner s) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Список пуст");
        }
        System.out.print("Введите число, которое нужно заменить: ");
        int oldVal = s.nextInt();
        System.out.print("Введите новое число: ");
        int newVal = s.nextInt();

        int index = list.indexOf(oldVal);
        if (index == -1) {
            throw new NoSuchElementException("Число " + oldVal + " не найдено для замены");
        }
        list.set(index, newVal);
        System.out.println(oldVal+ " заменено на "+ newVal);
    }


}
