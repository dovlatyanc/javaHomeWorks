import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

//первая домашка
public class HomeWork
{
    private Scanner scanner;

    public HomeWork() {
        scanner = new Scanner(System.in);
    }
    public  static void main(String[] args)
    {


        HomeWork hw = new HomeWork();

        System.out.println("Задача 1");
        hw.task1();
        System.out.println("Задача 2");
        hw.task2();
        System.out.println("Задача 3");
        hw.task3();
        System.out.println("Задача 4");
        hw.task4();
        System.out.println("Задача 5");
        hw.task5();
        System.out.println("Задача 6");
        hw.task6();
        System.out.println("Задача 7");
        hw.task7();
        System.out.println("Задача 8");
        hw.task8();
        System.out.println("Задача 9");
        hw.task9();
        System.out.println("Задача 10");
        hw.task10();
        System.out.println("Задача 11");
        hw.drawLine(5, "horizontal", '*');
        hw.drawLine(4, "vertical", '#');
        System.out.println("Задача 12");
        int[] arr = {5, 2, 8, 1, 9};
        hw.sortArray(arr.clone(), "asc");//сортируем копию
        hw.sortArray(arr.clone(), "desc");

        hw.scanner.close();
    }




    public void task1()
    {

        String str1 =
                "\"Your time is limited,\n" +
                "\tso don’t waste it \n" +
                "\t\tliving someone else’s life”\n" +
                "\t\t\tSteve Jobs\"";

        System.out.println(str1);
    }
    public void task2()
    {



        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        System.out.print("Введите процент: ");
        double percent = scanner.nextDouble();

        double result = (number * percent) / 100;
        System.out.println("Результат: " + result);


    }
    public void task3()
    {



        System.out.print("Введите первую цифру: ");
        String a = scanner.next();

        System.out.print("Введите вторую цифру: ");
        String b = scanner.next();

        System.out.print("Введите третью цифру: ");
        String c = scanner.next();

        String resultStr = a + b + c;
        int result = Integer.parseInt(resultStr);

        System.out.println("Сформированное число: " + result);


    }
    public void task4()
    {

        System.out.print("Введите шестизначное число: ");
        int number = scanner.nextInt();

        if (number < 100000 || number > 999999)
        {
            System.out.println("введено не шестизначное число!");
            return;
        }
        int d1 = number / 100000;
        int d2 = (number / 10000) % 10;
        int d3 = (number / 1000) % 10;
        int d4 = (number / 100) % 10;
        int d5 = (number / 10) % 10;
        int d6 = number % 10;
        //swap 1-6 2-5
        int result = d6 * 100000 + d5 * 10000 + d3 * 1000 + d4 * 100 + d2 * 10 + d1;

        System.out.println("Результат: " + result);


    }
    public void task5() {


        System.out.print("Введите  число месяца от 1 до 12: ");
        int number = scanner.nextInt();

        if (number == 12 || number == 1 || number == 2) {
            System.out.println("Winter");
        } else if (number > 2 && number < 6) {
            System.out.println("Spring");
        } else if (number > 5 && number < 9) {
            System.out.println("Summer");
        } else if (number > 8 && number < 12) {
            System.out.println("Autumn");
        } else {
            System.out.println("неверный ввод");
            return;
        }


    }

        public void task6() {
        System.out.print("Введите количество метров: ");
        double meters = scanner.nextDouble();

        System.out.println("Выберите единицу измерения:");
        System.out.println("1 — мили");
        System.out.println("2 — дюймы");
        System.out.println("3 — ярды");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                double miles = meters * 0.000621371;
                System.out.println(meters+" метров = " + miles + " миль");
                break;
            case 2:
                double inches = meters * 39.3701;
                System.out.println(meters+" метров = " + inches + " дюймов");
                break;
            case 3:
                double yards = meters * 1.09361;
                System.out.println(meters+" метров = " + yards + " ярдов");
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
    public void task7() {
        System.out.print("Введите первое число: ");
        int start = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int end = scanner.nextInt();

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
            System.out.println("диапазон от " + start + " до " + end);
        }

        System.out.print("Нечётные числа в диапазоне [" + start + ", " + end + "]: ");
        boolean found = false;

        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print("нет нечётных чисел");
        }

        System.out.println();
    }
    public void task8()
    {
        System.out.print("Введите первое число: ");
        int start = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int end = scanner.nextInt();

        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
            System.out.println("диапазон от " + start + " до " + end);
        }
        System.out.println("\nТаблица умножения:");
        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + "*" + j + " = " + (i * j));
                if (j < 10) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    private void task9() {

        Random random = new Random();
        int size = 15;
        int[] array = new int[size];
        System.out.print("Массив: ");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(21) - 10; //от -10 до 10
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int min = array[0];
        int max = array[0];
        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            } else {
                zeroCount++;
            }

            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество нулей: " + zeroCount);
    }


    public void task10() {
        Random random = new Random();
        int size = 15;
        int[] original = new int[size];

        System.out.print("Исходный массив: ");
        for (int i = 0; i < size; i++) {
            original[i] = random.nextInt(21) - 10;
            System.out.print(original[i] + " ");
        }
        System.out.println();

        //счетчики
        int evenCount = 0;
        int oddCount = 0;
        int negativeCount = 0;
        int positiveCount = 0;

        for (int num : original) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }

            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            }

        }

        int[] evenArray = new int[evenCount];
        int[] oddArray = new int[oddCount];
        int[] negativeArray = new int[negativeCount];
        int[] positiveArray = new int[positiveCount];


        int eIndex = 0, oIndex = 0, nIndex = 0, pIndex = 0;

        for (int num : original) {
            if (num % 2 == 0) {
                evenArray[eIndex++] = num;
            } else {
                oddArray[oIndex++] = num;
            }

            if (num < 0) {
                negativeArray[nIndex++] = num;
            } else if (num > 0) {
                positiveArray[pIndex++] = num;
            }
        }

        System.out.print("Чётные числа: ");
        printArray(evenArray);

        System.out.print("Нечётные числа: ");
        printArray(oddArray);

        System.out.print("Отрицательные числа: ");
        printArray(negativeArray);

        System.out.print("Положительные числа: ");
        printArray(positiveArray);
    }


    public void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("(пусто)");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    public void drawLine(int length, String direction, char symbol) {
        if (length < 0) {
            System.out.println("Длина должна быть больше 0.");
            return;
        }

        switch (direction.toLowerCase()) {
            case "horizontal":
                for (int i = 0; i < length; i++) {
                    System.out.print(symbol);
                }
                System.out.println();
                break;

            case "vertical":
                for (int i = 0; i < length; i++) {
                    System.out.println(symbol);
                }
                break;

            default:
                System.out.println("Неверное направление. Используйте 'horizontal' или 'vertical'.");
        }
    }
    public void sortArray(int[] arr, String order) {
        if (arr == null || arr.length == 0) {
            System.out.println("Массив пуст или null.");
            return;
        }

        switch (order.toLowerCase()) {
            case "asc":
                Arrays.sort(arr);
                System.out.println("Отсортировано по возрастанию:");
                break;

            case "desc":
                Arrays.sort(arr);
                // Разворачиваем массив
                for (int i = 0; i < arr.length / 2; i++) {
                    int temp = arr[i];
                    arr[i] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = temp;
                }
                System.out.println("Отсортировано по убыванию:");
                break;

            default:
                System.out.println("Неверный порядок. Используйте 'asc' или 'desc'.");
                return;
        }


        printArray(arr);
    }
}



