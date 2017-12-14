package Lab3_string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date1, date2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Date1 (dd/MM/yyyy):");
		date1 = sc.nextLine();
		System.out.println("Enter Date2 (dd/MM/yyyy):");
		date2 = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate userDate1 = LocalDate.parse(date1, formatter);
		LocalDate userDate2 = LocalDate.parse(date2, formatter);
		System.out.println("Difference of Days: "
				+ userDate1.until(userDate2).getDays());
		System.out.println("Difference of Months: "
				+ userDate1.until(userDate2).getMonths());
		System.out.println("Difference of Years: "
				+ userDate1.until(userDate2).getYears());
		sc.close();

	}
}
