package lesson7;

import java.io.*;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();

        long count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countWordInLine(line.toLowerCase(), searchWord);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Слово '" + searchWord + "' встречается в файле " + count + " раз.");


        scanner.close();
    }

    private static int countWordInLine(String line, String searchWord) {
        int count = 0;
        int index = 0;
        int wordLength = searchWord.length();

        while ((index = line.indexOf(searchWord, index)) != -1) {
            // слово является частью другого слова?
            boolean isWordStart = (index == 0 || !Character.isLetterOrDigit(line.charAt(index - 1)));
            boolean isWordEnd = (index + wordLength == line.length() ||
                    !Character.isLetterOrDigit(line.charAt(index + wordLength)));

            if (isWordStart && isWordEnd) {
                count++;
            }

            index += wordLength;
        }

        return count;
    }
}