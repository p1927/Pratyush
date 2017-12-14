package Lab8;

import java.io.FileReader;
import java.io.IOException;

public class Numbers {
	public static void main(String ...args){
		String str="";
		try {
			FileReader fileRead=new FileReader("D:/Number.txt");
			int i;
			while((i=fileRead.read())!=-1){
				str=str+(char)i;
				}
			String arr[]=str.split(",");
			for (String string : arr) {
				if(Integer.parseInt(string)%2==0)
					System.out.println(string);
			}
			}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
