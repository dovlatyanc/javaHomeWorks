package lesson9.hw.t2;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Молоко", "Молочка"),
                new Product("Хлеб", "Хлебобулочные"),
                new Product("Яблоко", "Фрукты"),
                new Product("Масло", "Молочка"),
                new Product("Чай", "Напитки"),
                new Product("Йогурт", "Молочка"),
                new Product("Мюсли", "Злаки"),
                new Product("Сыр", "Молочка"),
                new Product("Апельсин", "Фрукты"),
                new Product("Молоко", "Молочка")
        );

        products.forEach(System.out::println);

        System.out.println("\n Продукты с названием меньше 5 символов");
        products.stream()
                .filter(p -> p.name().length() < 5)
                .forEach(System.out::println);


        long count = products.stream()
                .filter(p -> p.name().equalsIgnoreCase("Хлеб"))
                .count();
        System.out.println("Продукт \"" + "Хлеб" + "\" встречается " + count + " раз(а)");


        String firstLetter = "Ч";
        char letter = firstLetter.charAt(0);
        System.out.println("Продукты, начинающиеся на " + letter);
        products.stream()
                .filter(p -> p.name().toUpperCase().startsWith(String.valueOf(letter).toUpperCase()))
                .forEach(System.out::println);

        System.out.println("\nПродукты из категории «Молочка» ");
        products.stream()
                .filter(p -> "Молочка".equalsIgnoreCase(p.category()))
                .forEach(System.out::println);
    }
}
