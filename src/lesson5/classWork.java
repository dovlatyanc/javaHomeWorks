package lesson5;

import java.util.Scanner;

public class classWork {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить клиента");
            System.out.println("2. Обработать следующий запрос");
            System.out.println("3. Показать статистику");
            System.out.println("4. Показать текущую очередь");
            System.out.println("5. Выход");
            System.out.print("Выберите действие (1-5): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
                scanner.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Введите имя клиента: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите приоритет (число, чем выше — тем важнее): ");
                    int priority = scanner.nextInt();
                    ServerQueueManager.addClient(name, priority);
                }
                case 2 -> ServerQueueManager.processNext();
                case 3 -> ServerQueueManager.showStatistics();
                case 4 -> ServerQueueManager.showQueue();
                case 5 -> {
                    System.out.println("Завершение работы...");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
