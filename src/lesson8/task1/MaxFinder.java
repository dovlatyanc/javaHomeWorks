package lesson8.task1;

public class MaxFinder implements Runnable{
    private final int[] array;
    private final ResultContainer result;

    public MaxFinder(int[] array, ResultContainer result) {
        this.array = array;
        this.result = result;
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        result.setMax(max); // записываем результат \
        System.out.println("Максимум найден: " + max);
    }
}

