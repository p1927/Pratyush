package com.capgemini.first;

public class BoxUnbox {
	public static void main(String[] args){
		
		int a=10;
		Integer i = new Integer(a); //Boxing
		System.out.println("max=="+Integer.MAX_VALUE);
		System.out.println("min=="+Integer.MIN_VALUE);

		
		System.out.println("a=="+a);
		System.out.println("i=="+i);
		
		int y = i.intValue();   //Unboxing
		System.out.println("y=="+y);

		
		String data="123";
		int z=Integer.parseInt(data);
		
		float f = Float.parseFloat(data);
		
		float ff=12340.56f;
		
		
		Float fy=Float.valueOf(ff); //static method ++ good practice
		
		System.out.println(fy.isNaN());

		System.out.println("float as string " + fy.toString());
		
		double d = Double.parseDouble(data);
		System.out.println("Z value of int "+z);
		System.out.println("f value of int "+f);
		System.out.println("d value of int "+d);
	}
}
