import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import static java.time.temporal.ChronoUnit.WEEKS;

public class SolutionClass {

    public static long solution(int Y, String A, String B, String W){

	//convert start and end months passed as a string to a java.time.Month object

        Month startMonth = Month.valueOf(A.toUpperCase());
        Month endMonth = Month.valueOf(B.toUpperCase());
	
	
	//create LocalDate objects corresponding to the start and end dates. 
	//Start date is first date of start month
	//End date is last date of ending month

        LocalDate startDate = LocalDate.of(Y, startMonth, 1);
        LocalDate endDate = LocalDate.of(Y, endMonth, endMonth.maxLength());

	//Since John can only leave on a monday the first date is the first monday of the month
	//advance startDate by one until day of week becomes monday

        while(startDate.getDayOfWeek()!= DayOfWeek.MONDAY){
            startDate = startDate.plus(Period.ofDays(1));
        }

	//John can only return on a sunday
	//reduce endDate by 1 until the endDate becomes a Sunday

        while(endDate.getDayOfWeek()!= DayOfWeek.SUNDAY){
            endDate = endDate.minus(Period.ofDays(1));
        }

        //until method counts the last day as exclusive and to include it, must add 1 to actual endDate
        endDate = endDate.plus(Period.ofDays(1));

	//return number of whole weeks between start and end date

        return startDate.until(endDate, WEEKS);


    }
}
