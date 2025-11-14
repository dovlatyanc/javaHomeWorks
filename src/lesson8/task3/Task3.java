package lesson8.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.print("Введите путь к первому файлу: ");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        List<Integer> numbers = readNumbersFromFile(path);

        EvenWriter evenTask = new EvenWriter(numbers);
        OddWriter oddTask = new OddWriter(numbers);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> evenCountFuture = executor.submit(evenTask);
        Future<Integer> oddCountFuture = executor.submit(oddTask);

        System.out.println("Чётных чисел: " + evenCountFuture.get());
        System.out.println("Нечётных чисел: " + oddCountFuture.get());

        executor.shutdown();

        scanner.close();
    }

    private static List<Integer> readNumbersFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }
        return numbers;
    }
}
