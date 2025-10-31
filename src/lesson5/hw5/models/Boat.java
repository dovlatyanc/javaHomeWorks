package lesson5.hw5.models;

import java.util.Random;

public class Boat {
    private static Random random = new Random();
    private  long arrivalTime;
    private  boolean isFinalStop;
    private  int capacity;

    public Boat(long arrivalTime, boolean isFinalStop) {
        this.arrivalTime = arrivalTime;
        this.isFinalStop = isFinalStop;
        this.capacity = random.nextInt(5)+1;//1-5
    }

    public static Random getRandom() {
        return random;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public boolean isFinalStop() {
        return isFinalStop;
    }

    public int getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        return "Катер{" +
                "время=" + arrivalTime +
                ", тип=" + (isFinalStop ? "конечная" : "промежуточная") +
                ", мест=" + capacity +
                "}\n";
    }
}
