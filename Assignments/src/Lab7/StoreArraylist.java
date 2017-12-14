package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StoreArraylist {

	public static void main(String[] args) {
		
		Scanner scr=new Scanner(System.in);
		String str=null;
		List<String> strArr=new ArrayList<String>();
		System.out.println("Enter the Strings");
		for (int i = 0; i < 5; i++) {
			str=scr.next();
			strArr.add(str);
		}
		Collections.sort(strArr);
		System.out.println("After Sorting");
		for (String string : strArr) {
			System.out.println(string);
		}
		scr.close();

	}

}

