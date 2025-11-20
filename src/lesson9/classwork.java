package lesson9;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class classwork {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 100).boxed().toList();

//        System.out.println("Число четных: " + list.stream().filter(i -> i % 2 == 0).count());
//        System.out.println("Число нечетных: " + list.stream().filter(i -> i % 2 != 0).count());
//        System.out.println("Количество 0-х: " + list.stream().filter(i -> i == 0).count());

        Optional<Integer> opt = list.stream().filter(i -> i == 145645).findFirst();

        String str = opt
                .map(String::valueOf)
                .map(s -> s + "qwe")
                .orElse("DEFAULT");

//        System.out.println("Строка: " + str);

        List<String> cities = Arrays.asList("Москва", "Санкт-Петербург", "Казань", "Москва", "Новосибирск");
        cities
                .forEach(System.out::println);

        System.out.println();
        System.out.println();

        cities.stream()
                .filter(city -> city.length() > 6)
                .forEach(System.out::println);

        String targetCity = "Москва";

        System.out.println();
        System.out.println();

        long count = cities.stream()
                .filter(city -> city.equals(targetCity))
                .count();

        System.out.println("Город '" + targetCity + "' встречается " + count + " раз(а)");

        System.out.println();
        System.out.println();

        cities.stream()
                .filter(city -> city.startsWith("М"))
                .forEach(System.out::println);

        List<Car> cars = Arrays.asList(
                new Car("Toyota Camry", "Red", 2.5, 2021, 25000.0),
                new Car("Honda Civic", "Blue", 1.8, 2019, 22000.0),
                new Car("BMW X5", "Black", 3.0, 2021, 55000.0),
                new Car("Ford Focus", "Red", 2.0, 2012, 18000.0),
                new Car("Audi A4", "Black", 2.0, 2022, 45000.0),
                new Car("Toyota Corolla", "Red", 1.6, 2020, 20000.0)
        );

        cars.forEach(System.out::println);

        System.out.println();

        String targetColor="Black";

        cars.stream()
                .filter(car -> car.getColor().equals(targetColor))
                .forEach(System.out::println);

        System.out.println();
        System.out.println();

        double targetEngine = 2.0;
        cars.stream()
                .filter(car -> car.getEngine() == targetEngine)
                .forEach(System.out::println);

        System.out.println();
        System.out.println();

        cars.stream()
                .filter(car -> car.getPrice() > 25000.0)
                .forEach(System.out::println);
        System.out.println();
        System.out.println();


        cars.stream()
                .filter(car -> car.getYear() >= 2010 && car.getYear() <= 2020)
                .forEach(System.out::println);
    }
}
