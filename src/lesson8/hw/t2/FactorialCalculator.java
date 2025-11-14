package lesson8.hw.t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {
    private final String inputFilePath;

    public FactorialCalculator(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public Integer call() throws IOException {
        String outputFile = "factorials.txt";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            System.out.println("Поток " + Thread.currentThread().getName() + " вычисляет факториалы...");
            String line;

            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                long factorial = calculateFactorial(number);
                writer.println(number + "! = " + factorial);
                count++;
                System.out.println("Вычислен факториал: " + number + "! = " + factorial);
            }

            System.out.println("Вычисление факториалов завершено. Вычислено: " + count);
        }

        return count;
    }

    private long calculateFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}