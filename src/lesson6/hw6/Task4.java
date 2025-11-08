package lesson6.hw6;

import java.util.function.Predicate;

public class Task4 {

    private final int a;
    private final int A;
    private final int B;

    Predicate<Integer> equalsA;
    Predicate<Integer> isPositive = x -> x > 0;
    Predicate<Integer> isNegative = x -> x < 0;

    public Predicate<Integer> getNotInRangePredicate() {
        return x -> x < A || x > B;
    }
    public Task4(int a, int A, int B) {
        this.a = a;
        this.A = A;
        this.B = B;
        this.equalsA = x -> x == a;
    }

    public void runTask(){

        int[] numbers = { -5, -2, 2, 3, 5, 7, 10 };


        System.out.println("Сумма чисел, равных " + a + ": " + sumIf(numbers, equalsA));
        System.out.println("Сумма чисел вне [" + A + "," + B + "]: " + sumIf(numbers, getNotInRangePredicate()));
        System.out.println("Сумма положительных чисел: " + sumIf(numbers, isPositive));
        System.out.println("Сумма отрицательных чисел: " + sumIf(numbers, isNegative));
        System.out.println();
    }
    public int sumIf(int[] arr, Predicate<Integer> condition) {
        int sum = 0;
        for (int num : arr) {
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }
}
