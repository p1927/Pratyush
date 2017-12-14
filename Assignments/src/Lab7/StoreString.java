package Lab7;

import java.util.Arrays;
import java.util.Scanner;

public class StoreString {

	public static void main(String[] args) {
		
		Scanner scr=new Scanner(System.in);
		String[] strArr=new String[5];
		System.out.println("Enter the Strings");
		for (int i = 0; i < strArr.length; i++) {
			strArr[i]=scr.next();
		}
		Arrays.sort(strArr);
		System.out.println("After Sorting");
		for (String string : strArr) {
			System.out.println(string);
		}
		scr.close();

	}

}
