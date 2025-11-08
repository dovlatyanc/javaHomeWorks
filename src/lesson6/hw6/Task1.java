package lesson6.hw6;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Task1 {

    private final LeapYearChecker isLeapYear = Year::isLeap;
    private final DaysBetweenCalculator daysBetween = (date1, date2) ->
            Math.abs(ChronoUnit.DAYS.between(date1, date2));
    private final FullWeeksCalculator fullWeeks = (date1, date2) ->
            Math.abs(ChronoUnit.WEEKS.between(date1, date2));
    private final DayOfWeekFinder dayOfWeek = date -> date.getDayOfWeek().getDisplayName(
            java.time.format.TextStyle.FULL, java.util.Locale.forLanguageTag("ru"));

    public void runTask() {
        int yearToCheck = 2024;
        LocalDate date1 = LocalDate.of(2025, 1, 1);
        LocalDate date2 = LocalDate.of(2025, 12, 31);
        LocalDate targetDate = LocalDate.of(1996, 7, 27);


        System.out.println("Год " + yearToCheck + " високосный? " + isLeapYear.check(yearToCheck));
        System.out.println("Дней между " + date1 + " и " + date2 + ": " + daysBetween.calculate(date1, date2));
        System.out.println("Полных недель между " + date1 + " и " + date2 + ": " + fullWeeks.calculate(date1, date2));
        System.out.println("День недели " + targetDate + ": " + dayOfWeek.find(targetDate));
        System.out.println();
    }
}

