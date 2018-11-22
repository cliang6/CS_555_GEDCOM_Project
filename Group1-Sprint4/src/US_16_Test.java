/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_16_Test extends TestCase{

	
	public US_16_Test(String testMethod){
		super(testMethod);
	}

	List<List<String>> testIdList = new ArrayList<List<String>>();
	List<List<String>> testFaList = new ArrayList<List<String>>();
	List<String> tempid = new ArrayList<String>();

	
	List<String> ACT1, ACT2, EXP1, EXP2 = new ArrayList<String>();
	String ACT3, ACT4, EXP3, EXP4;

	protected void setUp(){
		
		tempid = new ArrayList<String>( Arrays.asList("F01", "1990-01-01", "NA", "I01", "JACK/MA/", "I11", "MARY/DONG/", "{'I51','I52'}"));
		testFaList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("F02", "2003-04-05", "NA", "I02", "ROBIN/LI/", "I12", "KATHY/WANG/", "{'I61', 'I62', 'I63'}"));
		testFaList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I01", "JACK/MA/", "M", "1970-03-15", "null", "True", "NA", "NA", "{'F01'}"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I02", "ROBIN/LI/", "M", "1967-11-25", "null", "True", "NA", "NA", "{'F02'}"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I11", "MARY/DONG/", "F", "1980-06-11", "null", "True", "NA", "NA", "{'F01'}"));
		testIdList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("I12", "KATHY/WANG/", "F", "1990-01-12", "null", "True", "NA", "NA", "{'F02'}"));
		testIdList.add(tempid);
		
		EXP1 = new ArrayList<String>( Arrays.asList("I51", "I52"));
		EXP2 = new ArrayList<String>( Arrays.asList("I61", "I62", "I63"));
		
		EXP3 = "MA"; 
		EXP4 = "LI"; 
		
	}

	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new US_16_Test("testFetchChildren"));
		suite.addTest(new US_16_Test("testFetchSurname"));
		suite.addTest(new US_16_Test("testCheckMale"));
		return suite;
	}
	
	public void testFetchChildren(){
		
		System.out.println("Test method 'fetchChildren' ...");
		
		ACT1 = SearchFunc.fetchChildren("F01", testFaList);
		assertEquals(EXP1, ACT1);
		ACT2 = SearchFunc.fetchChildren("F02", testFaList);
		assertEquals(EXP2, ACT2);
		
		System.out.println("Done.");
	}
	
	public void testFetchSurname(){
		
		System.out.println("Test method 'fetchSurname' ...");
		
		ACT3 = SearchFunc.fetchSurname("I01", testIdList);
		assertEquals(EXP3, ACT3);
		ACT4 = SearchFunc.fetchSurname("I02", testIdList);
		assertEquals(EXP4, ACT4);
		
		assertFalse(EXP3.equals(SearchFunc.fetchSurname("I11", testIdList)));
		assertFalse(EXP4.equals(SearchFunc.fetchSurname("I12", testIdList)));
		
		System.out.println("Done.");
	}
	
	public void testCheckMale(){
		
		System.out.println("Test method 'checkMale' ...");
		
		assertTrue(SearchFunc.checkMale("I01", testIdList));
		assertTrue(SearchFunc.checkMale("I02", testIdList));
		
		assertFalse(SearchFunc.checkMale("I11", testIdList));
		assertFalse(SearchFunc.checkMale("I12", testIdList));
		
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