package lesson8.hw.t1;

import java.util.concurrent.Callable;

class SumCalculator implements Callable<Long> {
    private final int[] array;

    public SumCalculator(int[] array) {
        this.array = array;
    }

    @Override
    public Long call() {
        System.out.println("Поток " + Thread.currentThread().getName() + " вычисляет сумму...");

        long total = 0;
        for (int num : array) {
            total += num;
        }

        System.out.println("Сумма вычислена: " + total);
        return total;
    }
}
