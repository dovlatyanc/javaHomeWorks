package Lesson3.HW3;

import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Matrix<T extends Number & Comparable<T>> {
    private T[][] data;
    private int rows;
    private int cols;
    private final Class<T> type; // <-- КЛЮЧ: Class<T>, не Class<?>

    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols, Class<T> type) {
        this.rows = rows;
        this.cols = cols;
        this.type = type;
        this.data = (T[][]) Array.newInstance(type, rows, cols);
    }

    public void fillWithRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Безопасное сравнение с подавлением предупреждения
                if (isInteger()) {
                    data[i][j] = type.cast(random.nextInt(100));
                } else if (isDouble()) {
                    data[i][j] = type.cast(random.nextDouble() * 100);
                } else {
                    System.out.println("Поддерживается только Integer и Double.");
                    return;
                }
            }
        }
    }

    // Вспомогательные методы для безопасного сравнения
    private boolean isInteger() {
        return Objects.equals(type, Integer.class);
    }

    private boolean isDouble() {
        return Objects.equals(type, Double.class);
    }

    public void display() {
        System.out.println("Матрица " + rows + "x" + cols + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f ", data[i][j].doubleValue());
            }
            System.out.println();
        }
    }

    public T findMax() {
        if (rows == 0 || cols == 0) return null;
        T max = data[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j].compareTo(max) > 0) {
                    max = data[i][j];
                }
            }
        }
        return max;
    }

    public T findMin() {
        if (rows == 0 || cols == 0) return null;
        T min = data[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j].compareTo(min) < 0) {
                    min = data[i][j];
                }
            }
        }
        return min;
    }

    public double calculateAverage() {
        if (rows == 0 || cols == 0) return 0.0;
        double sum = 0.0;
        int total = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j].doubleValue();
            }
        }
        return sum / total;
    }

    public Matrix<T> add(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц должны совпадать.");
        }
        Matrix<T> result = new Matrix<>(rows, cols, this.type);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isInteger()) {
                    int val = this.data[i][j].intValue() + other.data[i][j].intValue();
                    result.data[i][j] = type.cast(val);
                } else if (isDouble()) {
                    double val = this.data[i][j].doubleValue() + other.data[i][j].doubleValue();
                    result.data[i][j] = type.cast(val);
                }
            }
        }
        return result;
    }

    public Matrix<T> subtract(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц должны совпадать.");
        }
        Matrix<T> result = new Matrix<>(rows, cols, this.type);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isInteger()) {
                    int val = this.data[i][j].intValue() - other.data[i][j].intValue();
                    result.data[i][j] = type.cast(val);
                } else if (isDouble()) {
                    double val = this.data[i][j].doubleValue() - other.data[i][j].doubleValue();
                    result.data[i][j] = type.cast(val);
                }
            }
        }
        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Несовместимые размеры для умножения.");
        }
        Matrix<T> result = new Matrix<>(this.rows, other.cols, this.type);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k].doubleValue() * other.data[k][j].doubleValue();
                }
                if (isInteger()) {
                    result.data[i][j] = type.cast((int) Math.round(sum));
                } else if (isDouble()) {
                    result.data[i][j] = type.cast(sum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Тесты без деления");

        Matrix<Integer> m1 = new Matrix<>(2, 2, Integer.class);
        m1.fillWithRandomNumbers();
        m1.display();

        System.out.println("Макс: " + m1.findMax());
        System.out.println("Мин: " + m1.findMin());
        System.out.println("Среднее: " + m1.calculateAverage());

        Matrix<Integer> m2 = new Matrix<>(2, 2, Integer.class);
        m2.fillWithRandomNumbers();
        System.out.println("\nВторая матрица:");
        m2.display();

        System.out.println("\nСумма:");
        Matrix<Integer> sum = m1.add(m2);
        sum.display();

        System.out.println("\nПроизведение:");
        Matrix<Integer> prod = m1.multiply(m2);
        prod.display();
    }
}