package Lab3_string;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab3_6 {

public static void main(String[] args) {
	String zoneId;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Zone Id:");
	zoneId = sc.nextLine();
		ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(zoneId));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Current Date in "+zoneId+" = "+ currentTime.format(formatter));
		System.out.println("Current Time in "+zoneId+" = "+currentTime.toLocalTime());

	sc.close();	
	}

}
