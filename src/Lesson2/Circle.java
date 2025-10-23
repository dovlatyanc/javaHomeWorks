package Lesson2;
public class Circle extends Figure {


    public Circle(int r) {
        this.r = r;
    }

    private int r;

    @Override
    public double calcArea() {
        return Math.PI * r * r;
    }
}
