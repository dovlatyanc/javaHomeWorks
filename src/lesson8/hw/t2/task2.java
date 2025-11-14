package lesson8.hw.t2;


import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class task2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь для файла с числами: ");
        String inputFilePath = scanner.nextLine();

        FileProcessor processor = new FileProcessor(inputFilePath);
        processor.processFile();

        scanner.close();
    }
}
