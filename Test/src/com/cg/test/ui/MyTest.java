package com.cg.test.ui;

public class MyTest {
	public static void main(String[] args){
		/* show error
		A temp=new B();
		temp.showData();
		*/
		B temp=new B();
		temp.showData();
		
		((B)temp).showData();
	}
}
