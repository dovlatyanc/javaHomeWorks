package lesson7.hw.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HwTask1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к первому файлу: ");
        String path1 = scanner.nextLine();

        System.out.print("Введите путь ко второму файлу: ");
        String path2 = scanner.nextLine();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1));
             BufferedReader reader2 = new BufferedReader(new FileReader(path2))) {

            String line1, line2;
            int lineNumber = 1;
            boolean filesMatch = true;

            System.out.println("\nНачало сравнения");

            while (true) {
                line1 = reader1.readLine();
                line2 = reader2.readLine();

                // Оба файла закончились
                if (line1 == null && line2 == null) {
                    break;
                }

                // Файл 1 закончился, файл 2 - нет
                if (line1 == null) {
                    System.out.printf("Файл 2 длиннее. Первая лишняя строка %d: [%s]%n",
                            lineNumber, line2);
                    filesMatch = false;
                    break;
                }

                // Файл 2 закончился, файл 1 - нет
                if (line2 == null) {
                    System.out.printf("Файл 1 длиннее. Первая лишняя строка %d: [%s]%n",
                            lineNumber, line1);
                    filesMatch = false;
                    break;
                }

                System.out.printf("Строка %d: файл1=[%s], файл2=[%s]%n",
                        lineNumber, line1, line2);

                if (!line1.equals(line2)) {
                    System.out.println(" Найдено несовпадение в строке " + lineNumber);
                    filesMatch = false;
                    break;
                }

                lineNumber++;
            }

            System.out.println("Сравнение завершено");

            if (filesMatch) {
                System.out.println(" Все строки совпадают.");
            }

        } finally {
            scanner.close();
        }
    }
}