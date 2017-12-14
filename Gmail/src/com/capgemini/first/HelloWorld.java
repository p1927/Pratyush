package com.capgemini.first;


/** 
 * java doc comments for hello world
 */
public class HelloWorld {
	/**
	 * java comments for main()
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id=1234;
		char ch='m';
		long age=21;
		boolean statusAge= age>=18;
		
		int val1=5; //0010
		int val2=3; //0011
		System.out.println("XORing of bits " + (val1 ^ val2));

		System.out.println("Anding of bits " + (val1 & val2));
		System.out.println("Oring of bits " + (val1 | val2));
		System.out.println("Left shift of bits " + (val1<<1));
		System.out.println("Right shift of bits " + (val1>>>1)); //shifting + filling with zeroes
		
		System.out.println(statusAge);
		
		byte bvalue=10;
		byte cvalue=20;
		
		byte sum =(byte) (bvalue+cvalue);
		System.out.println("sum " +sum);
		
		if(statusAge){
			System.out.println("Person can vote");
		}
		else{
			System.out.println("Not able to vote");
		}			
		
		float salary = 12345.56f;
		int sal = (int) salary;
		System.out.println(sal);
		
		
		short a = 0b1010; //binary
		int z= 0x12abc; //hexadecimal
		int x=0123; //octal
		
		
		int one= 1_00_000;
		
		int shift = 11;
		int ab=  shift >> 2;
		int bc=  shift << 2 ;
		int cs= shift >>> 2;
		System.out.println( ab+" + "+ bc+" + "+  cs);
		

	}

}
