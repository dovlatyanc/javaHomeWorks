package lesson7.hw.task5;

import java.io.*;

public class Employee implements Serializable {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " лет)";
    }
}

