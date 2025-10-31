package lesson5.hw5;

import lesson5.hw5.models.Dock;

import java.util.Random;

public class homeWorkMain {

    public static void main(String[] args) {

        Dock dock = new Dock(config.MAX_DOCK_CAPACITY);
        Simulation simulation = new Simulation(dock, config.SIMULATION_DURATION);

        simulation.run();

        simulation.showResults();

    }
}
