package Lab3_string;

import java.util.Scanner;

public class Lab3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;

		int choice, flag = 1;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Enter the string");
			str = sc.next();
			System.out.println("Is Entered String Positive : ");
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.toLowerCase().charAt(i) > str.toLowerCase().charAt(
						i + 1)) {
					flag = 0;
					System.out.print("False");
				}
			}
			if (flag == 1) {
				System.out.print("True");

			}
			System.out.println("Press 1 to Continue else press any key");
			choice = sc.nextInt();

		} while (choice == 1);
		sc.close();

	}

}
