package lesson5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ServerQueueManager {
    private static PriorityQueue<Request> queue = new PriorityQueue<>();
    private static List<Request> statistics = new ArrayList<>();

    public static void addClient(String userName, int priority) {
        Request request = new Request(userName, priority);
        queue.add(request);
        System.out.println(" Запрос от " + userName + " (приоритет: " + priority + ") добавлен в очередь.");
    }
    public static void processNext() {
        if (queue.isEmpty()) {
            System.out.println(" Очередь пуста. Нет запросов.");
            return;
        }
        Request request = queue.poll(); // извлекаем и удаляем самый приоритетный
        statistics.add(request);
        System.out.println("Обработан запрос: " + request);
    }
    public static void showStatistics() {
        if (statistics.isEmpty()) {
            System.out.println("Статистика пуста.");
            return;
        }

        System.out.println("\nСтатистика:");
        for (int i = 0; i < statistics.size(); i++) {
            System.out.println((i + 1) + ". " + statistics.get(i));
        }
        System.out.println();
    }
    public static void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        System.out.println("\nТекущая очередь (по приоритету):");

        List<Request> temp = new ArrayList<>(queue);
        temp.sort(Comparator.naturalOrder()); // сортируем по приоритету

        for (int i = 0; i < temp.size(); i++) {
            System.out.println((i + 1) + ". " + temp.get(i));
        }
        System.out.println();
    }
}
