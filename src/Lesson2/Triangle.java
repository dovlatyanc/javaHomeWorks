package Lesson2;
public class Triangle extends Figure {

    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcArea() {
        //  полупериметр
        double p = (a + b + c) / 2;

        // Формула Герона: S = √(p(p-a)(p-b)(p-c))
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }
}
