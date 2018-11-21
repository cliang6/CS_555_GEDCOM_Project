/**
This project's copyright belongs to CHENG LIANG. 
*/

import java.util.*;
import java.math.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class US_15_Test extends TestCase{

	
	public US_15_Test(String testMethod){
		super(testMethod);
	}

	List<List<String>> testFaList = new ArrayList<List<String>>();
	List<String> tempid = new ArrayList<String>();

	
	List<String> ACT1, ACT2, EXP1, EXP2 = new ArrayList<String>();

	protected void setUp(){
		
		tempid = new ArrayList<String>( Arrays.asList("F01", "1990-01-01", "NA", "I01", "JACK/MA/", "I11", "MARY/DONG/", "{'I51','I52'}"));
		testFaList.add(tempid);
		tempid = new ArrayList<String>( Arrays.asList("F02", "2003-04-05", "NA", "I02", "ROBIN/LI/", "I12", "KATHY/WANG/", "{'I61', 'I62', 'I63'}"));
		testFaList.add(tempid);
		
		EXP1 = new ArrayList<String>( Arrays.asList("I51", "I52"));
		EXP2 = new ArrayList<String>( Arrays.asList("I61", "I62", "I63"));
		
	}

	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new US_15_Test("testFetchChildren"));
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
	
	public static void main(String[] args){
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(suite());
		System.out.println("Start testing: ");
		TestRunner.run(testSuite);
		System.out.println("All tests done.");
	}
	
}