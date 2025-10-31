package lesson5.hw5;


import lesson5.hw5.models.Boat;
import lesson5.hw5.models.Dock;
import lesson5.hw5.models.Passenger;

import java.util.Random;

public class Simulation {
    private static final Random random = new Random();

    private final Dock dock;
    private final int duration;
    private int totalBoats;
    private long lastBoatTime;

    public Simulation(Dock dock, int durationSeconds) {
        this.dock = dock;
        this.duration = durationSeconds;
        this.totalBoats = 0;
        this.lastBoatTime = -1;
    }

    public void run() {
        for (long time = 0; time < duration; time++) {
            // Прибытие пассажира с вероятностью 20%
            if (random.nextDouble() < 0.2 && dock.canAddPassenger()) {
                dock.addPassenger(new Passenger(time));
            }

            // Прибытие катера с вероятностью 15%
            if (random.nextDouble() < 0.15) {
                boolean isFinalStop = random.nextBoolean();
                Boat boat = new Boat(time, isFinalStop);
                totalBoats++;
                lastBoatTime = time;

                int boarded = dock.processBoat(boat);
                System.out.printf("\nВ " + formatTime(time) +" :" +
                                " прибыл " + boat.toString() +
                                " посадил "+boarded +
                                " пассажиров. " +
                                " На остановке: "+ dock.getCurrentPassengerCount()+" .");

            }
        }
    }

    public double getAverageBoatInterval() {
        return totalBoats > 0 ? (double) duration / totalBoats : 0.0;
    }

    private String formatTime(long total) {
        long hours = total / 3600;
        long minutes = (total % 3600) / 60;
        return hours + ":" + (minutes < 10 ? "0" + minutes : minutes);
    }
    public void  showResults(){

        System.out.println("\nРезультат:");
        System.out.printf("Среднее время ожидания пассажира: %.2f мин.%n", dock.getAverageWaitTime());
        System.out.printf("Средний интервал между катерами: %.2f мин.%n", getAverageBoatInterval());
        System.out.println("Всего катеров: " + totalBoats);
        System.out.println("Всего перевезено пассажиров: " + dock.getTotalBoardedPassengers());
        System.out.println("Осталось на остановке: " + dock.getCurrentPassengerCount());
    }
}
