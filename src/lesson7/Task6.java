package lesson7;

import java.io.*;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пути к четырём файлам (по одному на строку):");
        String file1 = scanner.nextLine().trim();
        String file2 = scanner.nextLine().trim();
        String file3 = scanner.nextLine().trim();
        String file4 = scanner.nextLine().trim();

        long totalBytes = 0;

        try (FileOutputStream fos = new FileOutputStream(file4)) {
            totalBytes += copyFile(file1, fos);
            totalBytes += copyFile(file2, fos);
            totalBytes += copyFile(file3, fos);

            System.out.println(" Успешно скопировано " + totalBytes + " байт в файл: " + file4);
        } catch (IOException e) {
            System.err.println(" Ошибка при работе с файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static long copyFile(String sourcePath, OutputStream outputStream) throws IOException {
        long bytesCopied = 0;
        try (FileInputStream fis = new FileInputStream(sourcePath)) {
            byte[] buffer = new byte[8192]; // 8 КБ буфер
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + sourcePath);
        }
        return bytesCopied;
    }
}