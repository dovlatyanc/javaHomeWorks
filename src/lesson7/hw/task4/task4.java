package lesson7.hw.task4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        int[] array = new int[10];
        System.out.print("Сгенерированный массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        try {
            int[] evenNumbers = getEvenNumbers(array);
            int[] oddNumbers = getOddNumbers(array);

            // Записываем в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // 1. Исходный массив
                writer.write(arrayToString(array));
                writer.newLine();

                writer.write(arrayToString(evenNumbers));
                writer.newLine();

                writer.write(arrayToString(oddNumbers));
                writer.newLine();

            }

            System.out.println("\nФайл успешно создан");
            System.out.println("1. Исходный массив: " + arrayToString(array));
            System.out.println("2. Четные числа: " + arrayToString(evenNumbers));
            System.out.println("3. Нечетные числа: " + arrayToString(oddNumbers));
            System.out.println("Файл сохранен: " + filePath);

        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int[] getEvenNumbers(int[] array) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenList.add(num);
            }
        }
        return listToArray(evenList);
    }

    private static int[] getOddNumbers(int[] array) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 != 0) {
                oddList.add(num);
            }
        }
        return listToArray(oddList);
    }


    // Метод для преобразования ArrayList в массив
    private static int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // Метод для преобразования массива в строку
    private static String arrayToString(int[] array) {
        if (array.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}