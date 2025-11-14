package lesson8.hw.t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

public class PrimeFinder implements Callable<Integer> {
    private final String inputFilePath;

    public PrimeFinder(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public Integer call() throws IOException {
        String outputFile = "primes.txt";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            System.out.println("Поток " + Thread.currentThread().getName() + " ищет простые числа...");
            String line;

            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                if (isPrime(number)) {
                    writer.println(number + " - простое");
                    count++;
                    System.out.println("Найдено простое число: " + number);
                }
            }

            System.out.println("Поиск простых чисел завершен. Найдено: " + count);
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}