package lesson6.hw6;

public class Task3 {

    private final MaxOfFour<Integer> maxInt = (a, b, c, d) ->
            Math.max(Math.max(a, b), Math.max(c, d));

    private final MaxOfFour<Double> maxDouble = (a, b, c, d) ->
            Math.max(Math.max(a, b), Math.max(c, d));

    private final MinOfFour<Integer> minInt = (a, b, c, d) ->
           Math.min(Math.min(a, b), Math.min(c, d));

    private final MinOfFour<Double> minDouble = (a, b, c, d) ->
            Math.min(Math.min(a, b), Math.min(c, d));

    public void runTask(){
       int a = 12, b = 9, c = 21, d = 19;
       double x = 2.5, y = 7.1, z = 1.8, w = 9.0;


       System.out.println("Максимум из " + a + ", " + b + ", " + c + ", " + d + ": " + maxInt.findMax(a, b, c, d));
       System.out.println("Минимум из " + a + ", " + b + ", " + c + ", " + d + ": " + minInt.findMin(a, b, c, d));
       System.out.println("Максимум из " + x + ", " + y + ", " + z + ", " + w + ": " + maxDouble.findMax(x, y, z, w));
       System.out.println("Минимум из " + x + ", " + y + ", " + z + ", " + w + ": " + minDouble.findMin(x, y, z, w));
       System.out.println();
   }
}
