package Lesson2.HW2;

import java.util.Objects;
import java.util.Scanner;

public class Book {
    private String title;
    private String authorFullName;
    private int yearOfPublication;
    private String publisher;
    private String genre;
    private int pageCount;

    private static int count = 0;

    public Book() {
        this.title = "Неизвестно";
        this.authorFullName = "Неизвестный автор";
        this.yearOfPublication = 0;
        this.publisher = "Неизвестно";
        this.genre = "Неизвестно";
        this.pageCount = 0;
        count++;
    }

    // Полный конструктор
    public Book(String title, String authorFullName, int yearOfPublication,
                String publisher, String genre, int pageCount) {
        this.title = title != null ? title : "Неизвестно";
        this.authorFullName = authorFullName != null ? authorFullName : "Неизвестный автор";
        this.yearOfPublication = Math.max(yearOfPublication, 0);
        this.publisher = publisher != null ? publisher : "Неизвестно";
        this.genre = genre != null ? genre : "Неизвестно";
        this.pageCount = Math.max(pageCount, 0);
        count++;
    }

    public Book(String title, String authorFullName, int yearOfPublication, String publisher) {
        this(title, authorFullName, yearOfPublication, publisher, "Неизвестно", 0);
    }

    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название книги: ");
        this.title = scanner.nextLine();

        System.out.print("Введите ФИО автора: ");
        this.authorFullName = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        this.yearOfPublication = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        System.out.print("Введите название издательства: ");
        this.publisher = scanner.nextLine();

        System.out.print("Введите жанр книги: ");
        this.genre = scanner.nextLine();

        System.out.print("Введите количество страниц: ");
        this.pageCount = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
    }

    public void inputFromConsole(String title, String authorFullName) {
        this.title = title != null ? title : "Неизвестно";
        this.authorFullName = authorFullName != null ? authorFullName : "Неизвестный автор";
        this.yearOfPublication = 0;
        this.publisher = "Неизвестно";
        this.genre = "Неизвестно";
        this.pageCount = 0;
    }

    public void displayInfo() {
        System.out.println("\n=== Информация о книге ===");
        System.out.println("Название: " + title);
        System.out.println("Автор: " + authorFullName);
        System.out.println("Год выпуска: " + yearOfPublication);
        System.out.println("Издательство: " + publisher);
        System.out.println("Жанр: " + genre);
        System.out.println("Количество страниц: " + pageCount);
    }

    public void displayInfo(boolean shortVersion) {
        if (shortVersion) {
            System.out.println("Книга: \"" + title + "\" — автор: " +
                    authorFullName + " (" + yearOfPublication + ")");
        } else {
            displayInfo();
        }
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    // Сеттеры
    public void setTitle(String title) {
        this.title = title != null ? title : "Неизвестно";
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName != null ? authorFullName : "Неизвестный автор";
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = Math.max(yearOfPublication, 0);
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher != null ? publisher : "Неизвестно";
    }

    public void setGenre(String genre) {
        this.genre = genre != null ? genre : "Неизвестно";
    }

    public void setPageCount(int pageCount) {
        this.pageCount = Math.max(pageCount, 0);
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorFullName='" + authorFullName + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublication == book.yearOfPublication &&
                pageCount == book.pageCount && Objects.equals(title, book.title) &&
                Objects.equals(authorFullName, book.authorFullName) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorFullName, yearOfPublication, publisher, genre, pageCount);
    }
}
