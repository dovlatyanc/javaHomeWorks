package lesson8.task1;

public class MinFinder implements Runnable {
    private final int[] array;
    private final ResultContainer result;

    public MinFinder(int[] array, ResultContainer result) {
        this.array = array;
        this.result = result;
    }

    @Override
    public void run() {
        int min = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        result.setMin(min);
        System.out.println("Минимум найден: " + min);
    }
}

