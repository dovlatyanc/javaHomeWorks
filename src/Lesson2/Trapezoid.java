package Lesson2;

public class Trapezoid extends Figure{


    private int a;
    private int b;

    public Trapezoid(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    private int h;


    @Override
    public double calcArea() {
        if (a > 0 && b > 0 && h > 0) {
            return (a + b) * h / 2;
        }
        else {
            System.out.println("Такой трапеции быть не может");
            return -1;
        }
    }
}