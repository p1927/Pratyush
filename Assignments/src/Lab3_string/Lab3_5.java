package Lab3_string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab3_5 {

	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String purchaseDate;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Product Purchase Date (dd/MM/yyyy):");
			purchaseDate = sc.nextLine();
			System.out.println("Enter Waranty Period (Months-Years):");
			String Str=sc.nextLine();
			int warrantyMonth = Integer.parseInt(Str.split("-")[0]);
			int warrantyYear = Integer.parseInt(Str.split("-")[1]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate PurchaseDate = LocalDate.parse(purchaseDate, formatter);
			PurchaseDate=PurchaseDate.plusMonths(warrantyMonth);
			LocalDate warrantyExpire=PurchaseDate.plusYears(warrantyYear);
			System.out.println("Warranty Expires on :"+warrantyExpire.format(formatter));
			
			sc.close();

		}
	
}
