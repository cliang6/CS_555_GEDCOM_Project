/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_11_Test extends TestCase{

	
	public US_11_Test(String testMethod){
		super(testMethod);
	}

	
	List<Integer> testDateList1 = new ArrayList<Integer>();
	List<Integer> testDateList2 = new ArrayList<Integer>();
	String testDate1 = "", testDate2 = "";
	
	List<Integer> marriageDate1 = new ArrayList<Integer>();
	List<Integer> marriageDate2 = new ArrayList<Integer>();
	List<Integer> divorceDate1 = new ArrayList<Integer>();
	List<Integer> divorceDate2 = new ArrayList<Integer>();

	protected void setUp(){
		
		testDateList1 = new ArrayList<Integer>( Arrays.asList(2018, 10, 12));
		testDateList2 = new ArrayList<Integer>( Arrays.asList(2049, 3, 15));
		testDate1 = "2018-10-12";
		testDate2 = "2049-03-15";
		
		marriageDate1 = new ArrayList<Integer>( Arrays.asList(2000, 1, 12));
		marriageDate2 = new ArrayList<Integer>( Arrays.asList(2010, 2, 24));
		divorceDate1 = new ArrayList<Integer>( Arrays.asList(2009, 10, 12));
		divorceDate2 = new ArrayList<Integer>( Arrays.asList(2018, 10, 12));
		
	}


	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new US_11_Test("testDateStringToList"));
		suite.addTest(new US_11_Test("testMarriageOverlap"));
		return suite;
	}


	public void testDateStringToList(){
		
		System.out.println("Test method 'dateStringToList' ...");
		assertEquals(testDateList1, DateFunc.dateStringToList(testDate1));
		assertFalse(testDateList1.get(0) == DateFunc.dateStringToList(testDate2).get(0));
		assertFalse(testDateList1.get(1) == DateFunc.dateStringToList(testDate2).get(1));
		assertFalse(testDateList1.get(2) == DateFunc.dateStringToList(testDate2).get(2));
		System.out.println("Done.");
	}

	
	public void testMarriageOverlap(){
		
		System.out.println("Test method 'marriageOverlap' ...");
		assertFalse(DateFunc.marriageOverlap(marriageDate1, divorceDate1, marriageDate2, divorceDate2));
		assertFalse(DateFunc.marriageOverlap(marriageDate2, divorceDate2, marriageDate1, divorceDate1));
		marriageDate2.set(0, 2008);
		assertTrue(DateFunc.marriageOverlap(marriageDate1, divorceDate1, marriageDate2, divorceDate2));
		assertTrue(DateFunc.marriageOverlap(marriageDate2, divorceDate2, marriageDate1, divorceDate1));
		marriageDate2.set(0, 1998);
		assertTrue(DateFunc.marriageOverlap(marriageDate1, divorceDate1, marriageDate2, divorceDate2));
		assertTrue(DateFunc.marriageOverlap(marriageDate2, divorceDate2, marriageDate1, divorceDate1));
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