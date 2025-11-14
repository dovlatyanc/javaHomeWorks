package lesson8.hw.t1;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ArrayProcessor {
    private volatile boolean isArrayFilled = false;
    private int[] array = new int[10];

    public void processArray() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Запускаем поток заполнения
        Future<Void> fillerFuture = executor.submit(new ArrayFiller(array, () -> isArrayFilled = true));

        // Ждем заполнения массива
        while (!isArrayFilled) {
            Thread.sleep(100);
        }


        Future<Long> sumFuture = executor.submit(new SumCalculator(array));
        Future<Double> averageFuture = executor.submit(new AverageCalculator(array));

        // Получаем результаты
        Long sum = sumFuture.get();
        Double average = averageFuture.get();
        fillerFuture.get(); // ждем завершения заполнения

        // Выводим результаты
        System.out.println("\nРезультаты ");
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма элементов: " + sum);
        System.out.println("Среднее арифметическое: " + average);

        executor.shutdown();
    }
}
