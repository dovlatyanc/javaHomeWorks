package lesson8.task3;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.Callable;

public class OddWriter implements Callable<Integer> {
    private List<Integer> numbers;

    public OddWriter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try (PrintWriter writer = new PrintWriter(new FileWriter("odd.txt"))) {
            for (int num : numbers) {
                if (num % 2 != 0) {
                    writer.println(num);
                    count++;
                }
            }
         
        }
        return count; // возвращаем количество neчётных
    }
}
