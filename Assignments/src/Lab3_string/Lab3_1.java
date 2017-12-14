package Lab3_string;

import java.util.Scanner;

public class Lab3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str, ans = "";
		char ch;
		int choice;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Enter the string");
			str = sc.next();
			System.out.println("Options:");
			System.out.println("1. Add the String to itself");
			System.out.println("2. Replace odd positions with #");
			System.out.println("3. Remove duplicate characters in the String");
			System.out.println("4. Change odd characters to upper case");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			if (choice == 1) {
				str = str.concat(str);
				System.out
						.println("String after adding a duplicate to itself : "
								+ str);

			} else if (choice == 2) {
				for (int i = 0; i < str.length(); i++) {
					if (i % 2 == 0) {
						str = str.substring(0, i ) + "#"
								+ str.substring(i+1, str.length());
					}
				}
				System.out
						.println("String after  replacing odd characters with # : "
								+ str);
			}

			else if (choice == 3) {
				for (int i = 0; i < str.length(); i++) {
					ch = str.charAt(i);
					if (ch != ' ')
						ans = ans + ch;
					str = str.replace(ch, ' '); // Replacing all occurrence of
												// the current character by a
												// space
				}

				System.out
						.println("String after removing duplicate characters : "
								+ ans);

			} else if (choice == 4) {
				for (int i = 0; i < str.length(); i++) {
					if (i % 2 != 0) {
						ans = "";
						ans += str.charAt(i - 1);
						System.out.println(ans);
						str = str.substring(0, i - 1) + ans.toUpperCase()
								+ str.substring(i, str.length());
						System.out
								.println("String after setting odd characters to uppercase : "
										+ str);

					}
				}
				System.out
						.println("String afcter setting odd characters to uppercase : "
								+ str);

			} else if (choice == 5) {
				System.out.println("Thank You");
			} else {
				System.out.println("Invalid Choice");
			}
		} while (choice != 5);
		sc.close();

	}

}
