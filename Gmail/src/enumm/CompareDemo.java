package enumm;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CompareDemo {
	public static void main(String[] args){
		   Set set = new TreeSet();
		   set.add("2");
		   set.add(3);
		   set.add("1");
		   Iterator it = set.iterator();
		     while (it.hasNext())
		           System.out.print(it.next() + " ");

	}
}
