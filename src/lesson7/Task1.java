package lesson7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter filename:");
        String path = scanner.nextLine();

        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("File not found " + file.getPath());
        }

        byte[] buffer;
        try (InputStream in = new FileInputStream(file)) {
            buffer = new byte[in.available()];
            in.read(buffer);

            System.out.write(buffer);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
