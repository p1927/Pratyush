package com.oracle.second;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(args[0]);
		System.out.println(args[1]);
			
		Calculator cal = new Calculator();
		int res = cal.addition(10, 30);
		if(res == 30 )
			System.out.println("success");
		else
			System.out.println("fail");
		
		
	}

}
