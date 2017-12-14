package Lab4;

import java.util.Scanner;

public class Lab4_1 {
	long accNum;
	double balance;
	Lab4_3 accHolder;

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Lab4_1(String Name, float Age, double bal) {
		accHolder = new Lab4_3(Name, Age);
		balance = bal;
		accNum = (long) Math.floor(Math.random() * 1000000);
	}

	public Lab4_3 getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String Name, float Age) {
		accHolder.setName(Name);
		accHolder.setAge(Age);

	}

	@Override
	public String toString() {
		return "accNum=" + accNum + "\nbalance=" + balance + ", \naccHolder:\n"
				+ accHolder.toString();
	}

	public void withdraw(double amt) {

		balance -= amt;
		System.out.println("Balance after withdrawal is : " + getBalance());
	}

	public void deposit(double amt) {

		balance += amt;
		System.out.println("Balance after deposit is : " + getBalance());

	}

	public static void main(String[] args) {
		Lab4_1 Account1 = new Lab4_1("smith", 24, 2000.00);
		Lab4_1 Account2 = new Lab4_1("Kathy", 22, 3000.00);
		Scanner sc = new Scanner(System.in);
		System.out.println("\n" + Account1.toString());
		System.out.println("Enter Amount to be deposited:");
		double amt = sc.nextDouble();
		Account1.deposit(amt);
		System.out.println("\n\n\n" + Account2.toString());
		System.out.println("Enter Amount to be withdrawn:");
		amt = sc.nextDouble();
		Account2.withdraw(amt);
		sc.close();

	}

}
