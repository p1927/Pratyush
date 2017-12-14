package Lab3_string;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Lab3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today = LocalDate.now();
		String date;
		System.out.println("Enter Date (dd/MM/yyyy):");
		Scanner sc = new Scanner(System.in);
		date = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate userDate = LocalDate.parse(date, formatter);
		System.out.println("Difference of Days: "
				+ userDate.until(today).getDays());
		System.out.println("Difference of Months: "
				+ userDate.until(today).getMonths());
		System.out.println("Difference of Years: "
				+ userDate.until(today).getYears());
		sc.close();

	}

}
