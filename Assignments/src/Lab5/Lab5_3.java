package Lab5;


import java.util.Scanner;

import Lab4.Lab4_3;

abstract class Account5_3 {
	long accNum;
	double balance;
	Lab4_3 accHolder;
	
	public abstract void withdraw(double amt);

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

	public Account5_3(String Name, float Age, double bal) {
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

	

	public void deposit(double amt) {

		balance += amt;
		System.out.println("Balance after deposit is : " + getBalance());

	}

	
}
public class Lab5_3 extends Account5_3{
	public void withdraw(double amt){
		balance-=amt;
		System.out.println("Your updated balance is : "+balance);
	}
	public Lab5_3(String Name, float Age, double bal) {
		super(Name,Age,bal);
	}
	public static void main(String[] args) {
		Lab5_3 Account1 = new Lab5_3("smith", 24, 2000.00);
		Lab5_3 Account2 = new Lab5_3("Kathy", 22, 3000.00);
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
