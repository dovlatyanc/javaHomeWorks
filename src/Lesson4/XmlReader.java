package Lesson4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Random;


public class XmlReader {
    private static final Random rnd = new Random();

    public void read() throws IOException {
        switch (rnd.nextInt(4)) {
            case 0:
                throw new NullPointerException();
            case 1:
                throw new Error();
            case 2:
                throw new FileNotFoundException();
            default:
                throw new FileSystemAlreadyExistsException();
        }
    }
}