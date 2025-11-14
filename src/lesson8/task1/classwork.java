package lesson8.task1;

import java.util.Random;

public class classwork {

    public static void main(String[] args) {

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


        ResultContainer result = new ResultContainer();


        Thread threadMax = new Thread(new MaxFinder(array, result));
        Thread threadMin = new Thread(new MinFinder(array, result));

        threadMax.start();
        threadMin.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("\nРезультаты:");
        System.out.println("Максимум: " + result.getMax());
        System.out.println("Минимум: " + result.getMin());



    }


}
