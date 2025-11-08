package lesson6.hw6;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class HW6 {

    public static void main(String[] args) {

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4(2,10,25);

        //test
        task1.runTask();
        task2.runTask();
        task3.runTask();
        task4.runTask();


    }
}
