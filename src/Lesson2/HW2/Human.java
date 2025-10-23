package Lesson2.HW2;
import java.time.LocalDate;
import java.util.Objects;


public class Human {
    private String name;
    private String lastName;
    private String patronymic;



    private LocalDate birthday;
    private String phone;
    private String city;
    private String country;
    private String address;

    private static int count=0;

    public Human(String name, String lastName, String patronymic, LocalDate birthday,
                 String phone, String city, String country, String address) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.address = address;
        count++;
    }
    public Human(){}

    public static int getCount(){
        return count;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && Objects.equals(lastName, human.lastName) &&
                Objects.equals(patronymic, human.patronymic) && Objects.equals(birthday, human.birthday)
                && Objects.equals(phone, human.phone) && Objects.equals(city, human.city)
                && Objects.equals(country, human.country) && Objects.equals(address, human.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, birthday, phone, city, country, address);
    }
}
