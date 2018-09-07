import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import static java.time.temporal.ChronoUnit.WEEKS;

public class SolutionClass {

    public static long solution(int Y, String A, String B, String W){

        Month startMonth = Month.valueOf(A.toUpperCase());
        Month endMonth = Month.valueOf(B.toUpperCase());

        LocalDate startDate = LocalDate.of(Y, startMonth, 1);
        LocalDate endDate = LocalDate.of(Y, endMonth, endMonth.maxLength());

        while(startDate.getDayOfWeek()!= DayOfWeek.MONDAY){
            startDate = startDate.plus(Period.ofDays(1));
        }

        while(endDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
            endDate = endDate.minus(Period.ofDays(1));
        }

        //Because last date is exclusive
        endDate = endDate.plus(Period.ofDays(1));

        return startDate.until(endDate, WEEKS);


    }
}
