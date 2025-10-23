
package Lesson2;
import Lesson2.HW2.Fraction;
import Lesson2.HW2.Human;

import java.time.LocalDate;

public class Lesson2 {
    public  static void main(String[] args)
    {


        Fraction fr1 = new Fraction(1,2);
        Fraction fr2 = new Fraction(3,4);

        System.out.println(fr1.minus(fr2).toString());
        System.out.println(fr1.divide(fr2).toString());
        System.out.println(fr1.multiply(fr2).toString());
        System.out.println(fr1.plus(fr2).toString());




                Human human1 = new Human(
                        "Иван",
                        "Иванов",
                        "Иванович",
                        LocalDate.of(1990, 5, 15),
                        "+7-912-345-67-89",
                        "Москва",
                        "Россия",
                        "ул. Ленина, д. 10, кв. 25"
                );


                Human human2 = new Human(
                        "Мария",
                        "Петрова",
                        "Сергеевна",
                        LocalDate.of(1985, 12, 3),
                        "+7-923-456-78-90",
                        "Санкт-Петербург",
                        "Россия",
                        "Невский пр., д. 45, кв. 12"
                );

                Human human3 = new Human(
                        "John",
                        "Smith",
                        "",
                        LocalDate.of(1978, 8, 22),
                        "+1-234-567-8900",
                        "New York",
                        "USA",
                        "123 Main St, Apt 5B"
                );


                Human human4 = new Human(
                        "Алексей",
                        "Сидоров",
                        "Дмитриевич",
                        LocalDate.of(2000, 3, 10),
                        "+7-934-567-89-01",
                        "Екатеринбург",
                        "Россия",
                        "ул. Мира, д. 8, кв. 17"
                );


                System.out.println("Создано экземпляров Human: " + Human.getCount());

                Figure[] figures =
                     {new Triangle(10,10,10),
                    new Circle(10),
                    new Rectangle(10,20), new Trapezoid(10,20,7)};

                for(Figure figure:figures){
                    System.out.println(figure.calcArea()); 
                }
            }
        }


