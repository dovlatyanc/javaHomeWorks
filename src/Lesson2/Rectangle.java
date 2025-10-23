package Lesson2;
public class Rectangle extends Figure{

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private int a;
    private int b;

    @Override
    public double calcArea() {
        return a*b;
    }
}
