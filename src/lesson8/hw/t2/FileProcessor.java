package lesson8.hw.t2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileProcessor {
    private final String inputFilePath;

    public FileProcessor(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public void processFile() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Запускаем заполнение файла
        Future<Boolean> fillerFuture = executor.submit(new FileFiller(inputFilePath));

        // Ждем заполнения файла
        Boolean fileFilled = fillerFuture.get();

        if (fileFilled) {
            // Запускаем вычисляющие потоки
            Future<Integer> primeFuture = executor.submit(new PrimeFinder(inputFilePath));
            Future<Integer> factorialFuture = executor.submit(new FactorialCalculator(inputFilePath));

            // Получаем результаты - просто числа
            int primeCount = primeFuture.get();
            int factorialCount = factorialFuture.get();

            // Выводим статистику
            System.out.println("\nСтатистика");
            System.out.println("Найдено простых чисел: " + primeCount);
            System.out.println("Вычислено факториалов: " + factorialCount);
            System.out.println("Файл с простыми числами: primes.txt");
            System.out.println("Файл с факториалами: factorials.txt");
        }

        executor.shutdown();
    }
}