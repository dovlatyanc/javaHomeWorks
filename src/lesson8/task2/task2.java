package lesson8.task2;

import java.util.Random;
import java.util.concurrent.*;

public class task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();

        int[] array = new int[10];


        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(1000)-500;
        }
        System.out.print("Сгенерированный массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        SumTask sumTask = new SumTask(array);
        AverageTask avgTask = new AverageTask(array);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(sumTask);
        Future<Double>future2 =  executorService.submit(avgTask);

        System.out.println(future.get());
        System.out.println(future2.get());

    }
}
