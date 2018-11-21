/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_14_Test extends TestCase{

	
	public US_14_Test(String testMethod){
		super(testMethod);
	}

	List<List<String>> testIdList = new ArrayList<List<String>>();
	List<String> tempid = new ArrayList<String>();
	List<Integer> birth = new ArrayList<Integer>();
	List<Integer> death = new ArrayList<Integer>();

	
	List<Integer> testDateList1 = new ArrayList<Integer>();
	List<Integer> testDateList2 = new ArrayList<Integer>();
	String testDate1 = "", testDate2 = "";
	
	List<Integer> marriageDate1 = new ArrayList<Integer>();
	List<Integer> marriageDate2 = new ArrayList<Integer>();
	List<Integer> divorceDate1 = new ArrayList<Integer>();
	List<Integer> divorceDate2 = new ArrayList<Integer>();

	protected void setUp(){
		
		tempid = new ArrayList<String>( Arrays.asList("ID", "Name", "Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I01", "Jack /Ma/", "M", "1993-03-02", "18", "True", "2090-01-02", "None", "{F01}"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I02", "Pony /Ma/", "M", "1996-08-04", "24", "True", "2084-08-12", "None", "{F02}"));
		testIdList.add(tempid);
		
		birth = new ArrayList<Integer>( Arrays.asList(1993, 03, 02));
		death = new ArrayList<Integer>( Arrays.asList(2090, 01, 02));
		
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
		suite.addTest(new US_14_Test("testFetchDay"));
		return suite;
	}

	public void testFetchDay(){
		
		System.out.println("Test method 'fetchDay' ...");
		
		assertEquals(birth, DateFunc.fetchDay("I01", testIdList, "Birthday"));
		assertFalse(birth.get(0) == DateFunc.fetchDay("I02", testIdList, "Birthday").get(0));
		assertFalse(birth.get(1) == DateFunc.fetchDay("I02", testIdList, "Birthday").get(1));
		assertFalse(birth.get(2) == DateFunc.fetchDay("I02", testIdList, "Birthday").get(2));
		
		assertEquals(death, DateFunc.fetchDay("I01", testIdList, "Deathday"));
		assertFalse(death.get(0) == DateFunc.fetchDay("I02", testIdList, "Deathday").get(0));
		assertFalse(death.get(1) == DateFunc.fetchDay("I02", testIdList, "Deathday").get(1));
		assertFalse(death.get(2) == DateFunc.fetchDay("I02", testIdList, "Deathday").get(2));
		
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