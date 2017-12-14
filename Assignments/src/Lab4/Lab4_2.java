package Lab4;

import java.util.Scanner;

public class Lab4_2 extends Lab4_1 {

	public Lab4_2(String Name, float Age, double bal) {
		super(Name, Age, bal);
		// TODO Auto-generated constructor stub
	}

	double overDraft = balance * 10;

	boolean isOverDraft(double amt) {
		if (amt > overDraft)
			return false;
		else
			return true;
	}

	@Override
	public String toString() {

		return super.toString() + "\noverDraftLimit = " + overDraft;
	}

	public void withdraw(double amt) {

		if (isOverDraft(amt)) {
			balance -= amt;
			overDraft -= amt;
			System.out.println("Balance after withdrawal is : " + getBalance());
		} else
			System.out.println("Insufficient Balance");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lab4_2 Account2 = new Lab4_2("Kathy", 22, 3000.00);
		Scanner sc = new Scanner(System.in);
		double amt;
		
		System.out.println("\n\n\n" + Account2.toString());
		System.out.println("Enter Amount to be withdrawn:");
		amt = sc.nextDouble();
		Account2.withdraw(amt);
		sc.close();

	}

}
