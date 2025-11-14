package lesson8.task2;

import java.util.concurrent.Callable;

public class AverageTask implements Callable <Double>{

    private int[] array;
    public AverageTask(int[] array) {
        this.array = array;
    }

    @Override
    public Double call() throws Exception {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
}
