/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int firstSundays = 0;

	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
		// get the selected year from the user.
		int Selectedyear = Integer.parseInt(args[0]);
		
		while (year <= Selectedyear)  {
            //advance the year until reaching the selected year.
				advance();
			// print the selected year calender + sunday.
			if (year == Selectedyear)
			{
			if (dayOfWeek != 1)
            System.out.println(dayOfMonth + "/" + month + "/" + year);
		if (dayOfWeek == 1)
            System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
		}
		}
    }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	
private static void advance() {
	// defined nDaysInMonth according to the class.
    nDaysInMonth = nDaysInMonth(month, year);
	//advance the days.
    dayOfWeek++;
    dayOfMonth++;
	// return to sunday after the week end
    if (dayOfWeek > 7) {
        dayOfWeek = 1;
    }
	// return to first day of the month after the month end
    if (dayOfMonth > nDaysInMonth) {
        dayOfMonth = 1;
        month++;
	
	// return to first month of the after the year end.
        if (month > 12) {
            month = 1;
            year++;

        }
    }
	// check if the first day of the month is sunday.
    if (dayOfWeek == 1 && dayOfMonth == 1) {
        firstSundays++;
    }
}

		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    
		boolean isLeapYear;
// Checks if the year is divisible by 400
		isLeapYear = ((year % 400) == 0);
// Then checks if the year is divisible by 4 but not by 100
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int nDaysInMonth = -1;
		//check the month number and matches the number of days to the month.	
		if (month == 4||month == 6||month == 9||month == 11){
			nDaysInMonth = 30;
		} else if (month == 1||month ==3||month ==5||month ==7||month ==8||month ==10||month ==12) {
			nDaysInMonth = 31;
		}else if (month == 2) {
			if (isLeapYear(year))
				nDaysInMonth = 29;
			else 
				nDaysInMonth = 28;
		}
		return nDaysInMonth;
	}
}
