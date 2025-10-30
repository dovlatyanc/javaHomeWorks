package Lesson4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;

public class Programm {

    public static void processReaders(XmlReader[] readers) throws IOException {
        for (XmlReader reader : readers) {
            try {
                reader.read();
            } catch (FileSystemAlreadyExistsException e) {
                throw new FileNotFoundException();
            } catch (IOException e) {
                throw e;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Runner runner = new Runner();

//        try {
//            runner.halt();
//        } catch (RuntimeException e) {
//            System.out.println("halt");
//        } catch (IOException e) {
//            throw e;
//        }

        XmlReader[] readers = new XmlReader[] {
                new XmlReader(),
                new XmlReader(),
                new XmlReader()
        };
        try {
            processReaders(readers);
        } catch (FileNotFoundException e) {
            System.out.println("Пойман FileNotFoundException");
        } catch (IOException e) {
            System.out.println("Пойман другой Exception " + e.getMessage());
        }
    }
}
