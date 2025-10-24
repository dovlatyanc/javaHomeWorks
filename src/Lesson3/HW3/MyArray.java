package Lesson3.HW3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray<T extends Comparable<T>> {
    private T[] data;
    private int size;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    public MyArray(int capacity, Class<T> type) {
        this.type = type;
        this.data = (T[]) java.lang.reflect.Array.newInstance(type, capacity);
        this.size = 0;
    }

    public void fillFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите " + data.length + " элементов:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            if (type == Integer.class) {
                data[i] = type.cast(Integer.valueOf(scanner.nextInt()));
            } else if (type == Double.class) {
                data[i] = type.cast(Double.valueOf(scanner.nextDouble()));
            } else {
                System.out.println("Поддерживается только Integer и Double для ввода.");
                return;
            }
        }
        this.size = data.length;
    }

    public void fillWithRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            if (type == Integer.class) {
                data[i] = type.cast(random.nextInt(100));
            } else if (type == Double.class) {
                data[i] = type.cast(random.nextDouble() * 100);
            } else {
                System.out.println("Случайные значения поддерживаются только для Integer и Double.");
                return;
            }
        }
        this.size = data.length;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Массив пуст.");
            return;
        }
        System.out.print("Массив: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public T findMax() {
        if (size == 0) return null;
        T max = data[0];
        for (int i = 1; i < size; i++) {
            if (data[i].compareTo(max) > 0) {
                max = data[i];
            }
        }
        return max;
    }

    public T findMin() {
        if (size == 0) return null;
        T min = data[0];
        for (int i = 1; i < size; i++) {
            if (data[i].compareTo(min) < 0) {
                min = data[i];
            }
        }
        return min;
    }

    public double calculateAverage() {
        if (size == 0) return 0.0;
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            if (data[i] instanceof Number) {
                sum += ((Number) data[i]).doubleValue();
            } else {
                System.out.println("Среднее арифметическое доступно только для числовых типов.");
                return 0.0;
            }
        }
        return sum / size;
    }

    public void sortAscending() {
        if (size == 0) return;
        Arrays.sort(data, 0, size);
    }

    public void sortDescending() {
        if (size == 0) return;
        Arrays.sort(data, 0, size, (a, b) -> b.compareTo(a));
    }

    public int replaceValue(T oldValue, T newValue) {
        if (oldValue == null) return 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (data[i] != null && data[i].equals(oldValue)) {
                data[i] = newValue;
                count++;
            }
        }
        return count;
    }

    public int getSize() {
        return size;
    }

    public T[] getData() {
        return data;
    }

    public static void main(String[] args) {
        System.out.println("Tests:");


        MyArray<Integer> intArray = new MyArray<>(5, Integer.class);

        System.out.println("\n1. Заполнение случайными числами:");
        intArray.fillWithRandomNumbers();
        intArray.display();

        System.out.println("\n2. Максимальное значение: " + intArray.findMax());
        System.out.println("3. Минимальное значение: " + intArray.findMin());
        System.out.println("4. Среднее арифметическое: " + intArray.calculateAverage());

        System.out.println("\n5. Сортировка по возрастанию:");
        intArray.sortAscending();
        intArray.display();

        System.out.println("\n7. Замена значения (например, 50 на 999):");
        int replaced = intArray.replaceValue(50, 999);
        System.out.println("Заменено элементов: " + replaced);
        intArray.display();

        System.out.println("\n8. Сортировка по убыванию:");
        intArray.sortDescending();
        intArray.display();
    }
}