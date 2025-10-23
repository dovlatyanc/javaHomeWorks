package Lesson3;

import java.util.Arrays;

public class ClassWork{

    public static <T extends Comparable<T>> T maxOfThree(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
    public static <T extends Comparable<T>> T minOfFive(T a, T b, T c, T d, T f) {
        T min = a;
        if (b.compareTo(min) < 0) {
            min = b;
        }
        if (c.compareTo(min) < 0) {
            min = c;
        }
        if (d.compareTo(min) < 0) {
            min = d;
        }
        if (f.compareTo(min) < 0) {
            min = f;
        }
        return min;
    }
    public static <T extends Number> double average(T[] array) {
        double sum = 0.0;
        for (T element : array) {
            sum += element.doubleValue();
        }
        return sum / array.length;
    }

    public static <T extends Number & Comparable<T>> T maxInArray(T[] array) {

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0)  {
                max = element;
            }
        }
        return max;
    }

    public static <T extends Number & Comparable<T>> T minInArray(T[] array) {

        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0)  {
                min = element;
            }
        }
        return min;
    }

    public static <T extends Number & Comparable<T>> T[] sortArray(T[] array) {

        T[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);

        return copy;
    }





}
