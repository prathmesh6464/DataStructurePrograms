package Calender;
import java.text.SimpleDateFormat;
import java.util.Date;


//CALENDER CLASS
public class Calender 
{
	//MAIN CLASS
	public static void main(String[] args)
	{
		//DATA CLASS OF JAVA
		Date date = new Date();
		SimpleDateFormat month = new SimpleDateFormat("M");
		SimpleDateFormat current_year = new SimpleDateFormat("yyyy");

		
		//VARIABLES
		String[] week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		int countYear;
		int countDay = 0;
		int months = 0;
		
		
		try
		{
			months = Integer.parseInt(args[0]);
		}
		catch(Exception e)
		{
			months = Integer.parseInt(month.format(date)); 
		}

		 
		//VARIABLE
		int year = 0;
		int startWeekDay = 0;
		
		
		try 
		{
			year = Integer.parseInt(args[1]);
		}
		catch(Exception e)
		{
			year =  Integer.parseInt(current_year.format(date));
		}
		System.out.println("Calender of"+months+", "+year+"\n");
		
		
		for (int iteratorIndex=0; iteratorIndex<7; iteratorIndex++) 
		{
			System.out.print(week[iteratorIndex]+"  ");
		}
		System.out.println();
		
		
		//VARIABLE
		int weekNumber = 1;
		int	countLeapYear = 0;
		int monthDayCount [] = {31,28,31,30,31,30,31,31,30,31,30,31  };
		
		 
		if(year%4 == 0 && year%100 != 0 || year%400 == 0)
		{
			monthDayCount[1] = 29;
		}
		
		
		if(year<2011)
		{
			countYear = 2011 - year - 1;
			for(int monthNumber=12; monthNumber>=months; monthNumber--)
				countDay += monthDayCount[monthNumber - 1];
		
			
			for(int monthNumber=2010; monthNumber>year; monthNumber++) 
			{
				if(year%4 == 0 && year%100 != 0 || year%400 == 0)
					countLeapYear++;
				countDay += countYear*365 + countLeapYear;
				startWeekDay = 7 - (countDay%7);
			}
		}
		else 
		{
			countYear = year - 2011;
			for(int monthNumber=1; monthNumber<months; monthNumber++)
				countDay += monthDayCount[monthNumber-1];
			
			
			for(int monthNumber=2011; monthNumber<year; monthNumber++)
			{
				if(monthNumber%4 == 0 && year%100 != 0 || year%400 == 0)
					countLeapYear++;
			}
			
			
			countDay += countYear*365 + countLeapYear;
			startWeekDay = countDay%7;
			
			
			if(startWeekDay == 0)
				startWeekDay=7;
		}
		
		
		for(int days=1; days<startWeekDay; days++)
		{
			System.out.println("  ");
			weekNumber = startWeekDay;
		}
		
		
		for(int days=1; days<=monthDayCount[months-1]; days++)
		{
			if((weekNumber%7 == 0))
			{		 
				weekNumber = 0;
				System.out.println("  "+days);
			}
			else
			{
				System.out.print("  "+days+" ");
			}
			weekNumber++;
		}		
	}
}

