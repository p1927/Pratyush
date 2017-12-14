package Lab8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingWriting {

	public static void main(String[] args) {
		FileReader fileRead=null;
		FileWriter outputStream=null;
		// TODO Auto-generated method stub
		try {
			fileRead=new FileReader("D:/Corejava.txt");
			outputStream = new FileWriter("D:/abc.txt");
			int i;
			String str="";
			while((i=fileRead.read())!=-1){
				str=(char)i+str;
			}
			System.out.println(str);
			outputStream.write(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileRead.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
