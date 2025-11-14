package lesson8.hw.t2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.Callable;

public class FileFiller implements Callable<Boolean> {
    private final String filePath;

    public FileFiller(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Boolean call() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            Random random = new Random();
            System.out.println("Поток " + Thread.currentThread().getName() + " заполняет файл...");

            for (int i = 0; i < 10; i++) {
                int number = random.nextInt(10) + 1;
                writer.println(number);
                System.out.println("Записано число: " + number);
            }

            System.out.println("Файл заполнен: " + filePath);
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return false;
        }
    }
}