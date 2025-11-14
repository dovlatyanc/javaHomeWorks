package lesson8.hw.t1;

import java.util.concurrent.Callable;

class AverageCalculator implements Callable<Double> {
    private final int[] array;

    public AverageCalculator(int[] array) {
        this.array = array;
    }

    @Override
    public Double call() {
        System.out.println("Поток " + Thread.currentThread().getName() + " вычисляет среднее...");

        long total = 0;
        for (int num : array) {
            total += num;
        }
        double avg = (double) total / array.length;

        System.out.println("Среднее вычислено: " + avg);
        return avg;
    }
}