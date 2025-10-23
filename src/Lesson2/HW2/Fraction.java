package Lesson2.HW2;

import java.util.Objects;

public class Fraction {


    private int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("на ноль делить нельзя!");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.denominator=denominator;
        this.numerator=numerator;

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fraction plus(Fraction other){
        int newNumerator = this.numerator * other.getDenominator() + other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction minus(Fraction other){
        int newNumerator = this.numerator * other.getDenominator() - other.getNumerator() * this.denominator;
        int newDenominator = this.denominator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.getNumerator();
        int newDenominator = this.denominator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }
    public Fraction divide(Fraction other) {
        int newNumerator = this.denominator * other.getNumerator();
        int newDenominator = this.numerator * other.getDenominator();
        return new Fraction(newNumerator, newDenominator);
    }
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString()  {
        return numerator + " / " +denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}