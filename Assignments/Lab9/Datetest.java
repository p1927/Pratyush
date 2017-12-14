package Lab9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Datetest {
	Date dt=null;
	@Before
	public void beforeTest(){
		dt=new Date(21,11,2017);
	}

	@Test
	public void test() {
		assertEquals(21, dt.getDay());
		assertEquals(11, dt.getMonth());
		assertEquals(2017, dt.getYear());
		assertEquals("Date is 21/11/2017", dt.toString());

	}

}
