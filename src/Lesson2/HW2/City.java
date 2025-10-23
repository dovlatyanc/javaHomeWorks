package Lesson2.HW2;

import java.time.LocalDate;
import java.util.Objects;

public class City {
    private String name;
    private String country;
    private long population;
    private LocalDate foundationDate;
    private String capitalOf;

    private static int count = 0;

    public City() {
    }

    public City(String name, String country, long population,
                LocalDate foundationDate, String capitalOf) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.foundationDate = foundationDate;
        this.capitalOf = capitalOf;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCapitalOf() {
        return capitalOf;
    }

    public void setCapitalOf(String capitalOf) {
        this.capitalOf = capitalOf;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", foundationDate=" + foundationDate +
                ", capitalOf='" + capitalOf + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population &&
                Objects.equals(name, city.name) &&
                Objects.equals(country, city.country) &&
                Objects.equals(foundationDate, city.foundationDate) &&
                Objects.equals(capitalOf, city.capitalOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, population, foundationDate, capitalOf);
    }
}
