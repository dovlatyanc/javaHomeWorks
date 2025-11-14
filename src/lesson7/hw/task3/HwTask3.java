package lesson7.hw.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HwTask3 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        ArrayList<int[]> arraysList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int arrayNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] stringNumbers = line.trim().split("\\s+");
                ArrayList<Integer> tempList = new ArrayList<>();

                System.out.print("Строка " + arrayNumber + ": ");

                // Проверяем каждый элемент на корректность
                for (int i = 0; i < stringNumbers.length; i++) {
                    try {
                        int number = Integer.parseInt(stringNumbers[i]);
                        tempList.add(number);
                        System.out.print(number + " ");
                    } catch (NumberFormatException e) {
                        System.out.print("[" + stringNumbers[i] + "?] ");
                    }
                }
                System.out.println();

                // Если в строке есть хотя бы одно число не смешанное с буквами,то создаем массив
                if (!tempList.isEmpty()) {
                    int[] numbers = new int[tempList.size()];
                    for (int i = 0; i < tempList.size(); i++) {
                        numbers[i] = tempList.get(i);
                    }
                    arraysList.add(numbers);
                    arrayNumber++;
                }
            }

            System.out.println("\n Содержимое массивов");

            for (int i = 0; i < arraysList.size(); i++) {
                int[] currentArray = arraysList.get(i);
                System.out.print("Массив " + (i + 1) + ": [");

                for (int j = 0; j < currentArray.length; j++) {
                    System.out.print(currentArray[j]);
                    if (j < currentArray.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }

            System.out.println("\nКоличество массивов: " + arraysList.size());

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}