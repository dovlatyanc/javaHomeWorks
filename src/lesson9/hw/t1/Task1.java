package lesson9.hw.t1;

import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = random.ints(10, -500, 501)
                .boxed()
                .toList();

        numbers.forEach(System.out::println);


        long nullCount = numbers.stream()
                .filter(n -> n == 0)
                .count();

        System.out.println("Количество нулей: " + nullCount);

        long positiveCount = numbers.stream()
                .filter(n -> n > 0)
                .count();

        System.out.println("Количество положительных: " + positiveCount);

        long negativeCount = numbers.stream()
                .filter(n -> n < 0)
                .count();

        System.out.println("Количество отрицательных: " + positiveCount);

        long twoDigitCount = numbers.stream()
                .filter(n -> (n >= 10 && n <= 99) || (n <= -10 && n >= -99))
                .count();
        System.out.println("Количество двузначных: " + twoDigitCount);

        long palindromeCount = numbers.stream()
                .filter(Task1::isPalindrome)
                .count();
        System.out.println("Количество зеркальных чисел: " + palindromeCount);
    }

    private static boolean isPalindrome(int number) {
        String str = String.valueOf(Math.abs(number)); //модуль, чтобы обработать отрицательные
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
