package lesson5.hw5.models;

import java.util.LinkedList;
import java.util.Queue;

public class Dock {
    private final int maxCapacity;
    private final Queue<Passenger> passengerQueue;
    private int currentPassengerCount;
    private double totalWaitTime;
    private int boardedPassengers;

    public Dock(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengerQueue = new LinkedList<>();
        this.currentPassengerCount = 0;
        this.totalWaitTime = 0.0;
        this.boardedPassengers = 0;
    }
    public boolean canAddPassenger() {
        return currentPassengerCount < maxCapacity;
    }
    public void addPassenger(Passenger passenger) {
        if (canAddPassenger()) {
            passengerQueue.offer(passenger);
            currentPassengerCount++;
        } else {
            System.out.println("Остановка переполнена.");
        }
    }
    public int getCurrentPassengerCount() {
        return currentPassengerCount;
    }
    public int processBoat(Boat boat) {
        int boarded = 0;
        while (!passengerQueue.isEmpty() && boarded < boat.getCapacity()) {
            Passenger p = passengerQueue.poll();
            long waitTime = boat.getArrivalTime() - p.getArrivalTime();
            totalWaitTime += waitTime;
            boarded++;
            currentPassengerCount--;
            boardedPassengers++;
        }
        return boarded;
    }
    public double getAverageWaitTime() {
        return boardedPassengers > 0 ? totalWaitTime / boardedPassengers : 0.0;
    }
    public int getTotalBoardedPassengers() {
        return boardedPassengers;
    }

}
