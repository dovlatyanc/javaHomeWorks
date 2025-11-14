package lesson8.task3;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Callable;

public class EvenWriter implements Callable<Integer> {
    private List<Integer> numbers;

    public EvenWriter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("even.txt"))) {
            for (int num : numbers) {
                if (num % 2 == 0) {
                    writer.println(num);
                    count++;
                }
            }
        }
        return count; // возвращаем количество чётных
    }
}

