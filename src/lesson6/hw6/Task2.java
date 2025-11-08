package lesson6.hw6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Task2 {
    //  суммf дробей
   private final FractionOperation sum = (a, b)
            -> a.add(b).setScale(2, RoundingMode.HALF_UP);
    //разность дробей
   private final FractionOperation subtract = (a, b)
            -> a.subtract(b).setScale(2, RoundingMode.HALF_UP);
    //х
    private final FractionOperation multiply = (a, b)
            -> a.multiply(b).setScale(2, RoundingMode.HALF_UP);
    //:
    private final FractionOperation divide = (a, b)
            -> a.divide(b, 2, RoundingMode.HALF_UP);

   public void runTask(){
       BigDecimal frac1 = new BigDecimal("5.5");
       BigDecimal frac2 = new BigDecimal("2.25");


       System.out.println("Сумма: " + frac1 + " + " + frac2 + " = " + sum.operate(frac1, frac2));
       System.out.println("Разность: " + frac1 + " - " + frac2 + " = " + subtract.operate(frac1, frac2));
       System.out.println("Произведение: " + frac1 + " * " + frac2 + " = " + multiply.operate(frac1, frac2));
       System.out.println("Деление: " + frac1 + " / " + frac2 + " = " + divide.operate(frac1, frac2));
       System.out.println();
   }
}
