/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_09_Test extends TestCase{

	
	public US_09_Test(String testMethod){
		super(testMethod);
	}

	
	List<List<String>> testIdList = new ArrayList<List<String>>();
	List<String> tempid = new ArrayList<String>();
	List<Integer> birth = new ArrayList<Integer>();
	List<Integer> death = new ArrayList<Integer>();

	protected void setUp(){
		
		tempid = new ArrayList<String>( Arrays.asList("ID", "Name", "Gender", "Birthday", "Age", "Alive", "Death", "Child", "Spouse"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I01", "Jack /Ma/", "M", "1993-03-02", "18", "True", "2090-01-02", "None", "{F01}"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I02", "Pony /Ma/", "M", "1996-08-04", "24", "True", "2084-08-12", "None", "{F02}"));
		testIdList.add(tempid);
		
		birth = new ArrayList<Integer>( Arrays.asList(1993, 03, 02));
		death = new ArrayList<Integer>( Arrays.asList(2090, 01, 02));
	}


	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new US_09_Test("testFetchBirthday"));
		suite.addTest(new US_09_Test("testFetchDeathday"));
		suite.addTest(new US_09_Test("testDateCompare"));
		suite.addTest(new US_09_Test("testMonthChange"));
		return suite;
	}


	public void testFetchBirthday(){
		
		System.out.println("Test method 'fetchBirthday' ...");
		assertEquals(birth, UserStory_09.fetchBirthday("I01", testIdList));
		assertFalse(birth.get(0) == UserStory_09.fetchBirthday("I02", testIdList).get(0));
		assertFalse(birth.get(1) == UserStory_09.fetchBirthday("I02", testIdList).get(1));
		assertFalse(birth.get(2) == UserStory_09.fetchBirthday("I02", testIdList).get(2));
		System.out.println("Done.");
	}




	public void testFetchDeathday(){
		
		System.out.println("Test method 'fetchDeathday' ...");
		assertEquals(death, UserStory_09.fetchDeathday("I01", testIdList));
		assertFalse(death.get(0) == UserStory_09.fetchDeathday("I02", testIdList).get(0));
		assertFalse(death.get(1) == UserStory_09.fetchDeathday("I02", testIdList).get(1));
		assertFalse(death.get(2) == UserStory_09.fetchDeathday("I02", testIdList).get(2));
		System.out.println("Done.");
	}


	public void testDateCompare(){
		
		System.out.println("Test method 'dateCompare' ...");
		assertTrue(UserStory_09.dateCompare(birth, death).equals("<"));
		assertTrue(UserStory_09.dateCompare(death, birth).equals(">"));
		assertTrue(UserStory_09.dateCompare(birth, birth).equals("="));
		assertFalse(UserStory_09.dateCompare(birth, death).equals(">"));
		assertFalse(UserStory_09.dateCompare(death, death).equals("<"));
		assertFalse(UserStory_09.dateCompare(death, birth).equals("="));
		System.out.println("Done.");
	}


	
	public void testMonthChange(){
		
		System.out.println("Test method 'monthChange' ...");
		assertTrue(5 == UserStory_09.monthChange(birth, 2).get(1));
		assertTrue(2 == UserStory_09.monthChange(birth, -1).get(1));
		assertFalse(8 == UserStory_09.monthChange(birth, 4).get(1));
		assertTrue((4 == UserStory_09.monthChange(birth, 13).get(1)) && (1994 == UserStory_09.monthChange(birth, 13).get(0)));
		assertTrue((7 == UserStory_09.monthChange(birth, -8).get(1)) && (1992 == UserStory_09.monthChange(birth, -8).get(0)));
		assertFalse(0 == UserStory_09.monthChange(birth, -3).get(1));
		assertFalse(1993 == UserStory_09.monthChange(birth, 15).get(0));
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