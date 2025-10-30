package Lesson4.hw4;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class homeWorkMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();


        System.out.println("Введите начальные числа через пробел:");
        String input = scanner.nextLine();
        if (!input.trim().isEmpty()) {
            for (String part : input.trim().split("\\s+"))// один и более проблов регулярка
                 {
                    try {
                        numbers.add(Integer.parseInt(part));
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Пропущено некорректное значение: " + part);
                    }
            }
        }

        // Главное меню циклом
        while (true) {
            NumberListManager.showMenu();
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // поглотить \n
            } catch (Exception e) {
                System.out.println("Ошибка: введите число от 1 до 5.");
                scanner.nextLine();
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> NumberListManager.add(numbers, scanner);
                    case 2 -> NumberListManager.remove(numbers, scanner);
                    case 3 -> NumberListManager.showList(numbers);
                    case 4 -> {
                        System.out.print("Введите число для поиска: ");
                        boolean found = NumberListManager.hasValue(numbers, scanner);
                        System.out.println(found ? "Число найдено." : "Число не найдено.");
                    }
                    case 5 -> NumberListManager.replace(numbers, scanner);
                    case 6 -> {
                        System.out.println("До свидания!");
                        return;
                    }
                    default -> System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (IllegalStateException | NoSuchElementException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неожиданная ошибка: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
