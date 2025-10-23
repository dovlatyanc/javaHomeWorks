package Lesson2.HW2;

import java.time.LocalDate;
import java.util.Objects;

public class Country {
    private String name;
    private String capital;
    private long population;
    private double area;
    private String continent;
    private LocalDate independenceDay;
    private static int count = 0;

    public Country() {
    }

    public Country(String name, String capital, long population,
                   double area, String continent,
                   LocalDate independenceDay) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.independenceDay = independenceDay;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public LocalDate getIndependenceDay() {
        return independenceDay;
    }

    public void setIndependenceDay(LocalDate independenceDay) {
        this.independenceDay = independenceDay;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area + " km²" +
                ", continent='" + continent + '\'' +
                ", independenceDay=" + independenceDay +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population && Double.compare(area, country.area) == 0
                && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(independenceDay, country.independenceDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area, continent, independenceDay);
    }
}