package Lab4;

import java.util.Scanner;

public class Lab4_4 extends Lab4_1 {

	public Lab4_4(String Name, float Age, double bal) {
		super(Name, Age, bal);
		// TODO Auto-generated constructor stub
	}

	final static double minBalance = 500;

	public void withdraw(double amt) {

		if (balance >= minBalance + amt) {
			balance -= amt;
			System.out.println("Balance after withdrawal is : " + getBalance());
		} else
			System.out.println("Insufficient Balance");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab4_4 Account2 = new Lab4_4("Kathy", 22, 3000.00);
		Scanner sc = new Scanner(System.in);
		double amt;

		System.out.println("\n\n\n" + Account2.toString());
		System.out.println("Enter Amount to be withdrawn:");
		amt = sc.nextDouble();
		Account2.withdraw(amt);
		sc.close();

	}

}
