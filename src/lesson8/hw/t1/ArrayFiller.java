package lesson8.hw.t1;

import java.util.Random;
import java.util.concurrent.Callable;

class ArrayFiller implements Callable<Void> {
    private final int[] array;
    private final Runnable onComplete;

    public ArrayFiller(int[] array, Runnable onComplete) {
        this.array = array;
        this.onComplete = onComplete;
    }

    @Override
    public Void call() {
        Random random = new Random();
        System.out.println("Поток " + Thread.currentThread().getName() + " заполняет массив...");

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        onComplete.run();
        System.out.println("Массив заполнен!");
        return null;
    }
}