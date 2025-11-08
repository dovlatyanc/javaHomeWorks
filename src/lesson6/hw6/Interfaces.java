package lesson6.hw6;

import java.math.BigDecimal;
import java.time.LocalDate;

@FunctionalInterface
interface LeapYearChecker {
    boolean check(int year);
}

@FunctionalInterface
interface DaysBetweenCalculator {
    long calculate(LocalDate date1, LocalDate date2);
}

@FunctionalInterface
interface FullWeeksCalculator {
    long calculate(LocalDate date1, LocalDate date2);
}

@FunctionalInterface
interface DayOfWeekFinder {
    String find(LocalDate date);
}

@FunctionalInterface
interface FractionOperation {
    BigDecimal operate(BigDecimal a, BigDecimal b);
}

@FunctionalInterface
interface MaxOfFour<T extends Comparable<T>> {
    T findMax(T a, T b, T c, T d);
}

@FunctionalInterface
interface MinOfFour<T extends Comparable<T>> {
    T findMin(T a, T b, T c, T d);
}
