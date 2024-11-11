import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DobPrint {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide your birthdate in the format yyyy-MM-dd.");
            return;
        }

        String birthdateStr = args[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthdateStr, formatter);
        LocalDate currentDate = LocalDate.now();

        if (birthdate.isAfter(currentDate)) {
            System.out.println("Birthdate cannot be in the future.");
            return;
        }

        Period age = Period.between(birthdate, currentDate);
        System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");

        System.out.println("Your birthday on each year since you were born:");
        for (int year = birthdate.getYear(); year <= currentDate.getYear(); year++) {
            LocalDate birthdayThisYear = birthdate.withYear(year);
            System.out.println(year + ": " + birthdayThisYear.getDayOfWeek());
        }
    }
}