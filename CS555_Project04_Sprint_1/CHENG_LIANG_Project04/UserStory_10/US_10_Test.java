/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_10_Test extends TestCase{

	
	public US_10_Test(String testMethod){
		super(testMethod);
	}

	
	List<Integer> testDateList1 = new ArrayList<Integer>();
	List<Integer> testDateList2 = new ArrayList<Integer>();
	String testDate1 = "", testDate2 = "";

	protected void setUp(){
		
		testDateList1 = new ArrayList<Integer>( Arrays.asList(2018, 10, 12));
		testDateList2 = new ArrayList<Integer>( Arrays.asList(2049, 3, 15));
		testDate1 = "2018-10-12";
		testDate2 = "2049-03-15";
		
	}


	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new US_10_Test("testDateStringToList"));
		suite.addTest(new US_10_Test("testDateListToString"));
		return suite;
	}


	public void testDateStringToList(){
		
		System.out.println("Test method 'dateStringToList' ...");
		assertEquals(testDateList1, UserStory_10.dateStringToList(testDate1));
		assertFalse(testDateList1.get(0) == UserStory_10.dateStringToList(testDate2).get(0));
		assertFalse(testDateList1.get(1) == UserStory_10.dateStringToList(testDate2).get(1));
		assertFalse(testDateList1.get(2) == UserStory_10.dateStringToList(testDate2).get(2));
		System.out.println("Done.");
	}




	public void testDateListToString(){
		
		System.out.println("Test method 'dateListToString' ...");
		assertEquals(testDate1, UserStory_10.dateListToString(testDateList1));
		assertFalse(testDate1.equals(UserStory_10.dateListToString(testDateList2)));
		System.out.println("Done.");
	}

	
	public static void main(String[] args){
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(suite());
		System.out.println("Start testing: ");
		TestRunner.run(testSuite);
		System.out.println("All tests done.");
	}
	
}