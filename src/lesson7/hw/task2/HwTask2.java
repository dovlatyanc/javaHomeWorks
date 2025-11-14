package lesson7.hw.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HwTask2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String longestLine = "";
            int maxLength = 0;
            String currentLine;
            int lineNumber = 0;
            int longestLineNumber = 0;

            System.out.println("\nПоиск самой длинной строки:");

            while ((currentLine = reader.readLine()) != null) {
                lineNumber++;
                int currentLength = currentLine.length();

                System.out.println("Строка " + lineNumber + ": длина="
                        + currentLength + ", текст=[" + currentLine + "]");


                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    longestLine = currentLine;
                    longestLineNumber = lineNumber;
                }
            }

            System.out.println("\nРезультат:");
            if (maxLength > 0) {
                System.out.println("Самая длинная строка найдена , номер строки : " + longestLineNumber);
                System.out.println("Длина : " + maxLength+" символов.");
                System.out.println("Вывод строки: \"" + longestLine + "\"");
            } else {
                System.out.println("Файл пуст или содержит только пустые строки.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}