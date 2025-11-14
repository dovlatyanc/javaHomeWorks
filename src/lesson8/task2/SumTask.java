package lesson8.task2;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {
    private int[] array;

    public SumTask(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
