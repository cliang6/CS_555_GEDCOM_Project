/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_10{
	
	
	public static void marriageAfter_14(List<List<String>> idList, List<List<String>> faList){
		
		
		for(int i = 1; i < faList.size(); i++){
			
			String hus = "NA", wif = "NA";
			
			List<Integer> husBirt = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
			List<Integer> wifBirt = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
			
			List<Integer> marriageDate = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
			
			marriageDate = DateFunc.dateStringToList(faList.get(i).get(1));
			
			husBirt = DateFunc.fetchDay(faList.get(i).get(3), idList, "Birthday");
			wifBirt = DateFunc.fetchDay(faList.get(i).get(5), idList, "Birthday");
			
			husBirt.set(0, husBirt.get(0) + 14);
			wifBirt.set(0, wifBirt.get(0) + 14);
			
			hus = DateFunc.dateCompare(marriageDate, husBirt);
			wif = DateFunc.dateCompare(marriageDate, wifBirt);
			
			if(hus.equals("<")){
				System.out.println("ERROR: FAMILY: US10: " + faList.get(i).get(0) + ": Husband (" + faList.get(i).get(3) + ") who was born at " + DateFunc.dateListToString(husBirt) + " marriaged " + faList.get(i).get(1) + " before 14");
			}
			
			if(wif.equals("<")){
				System.out.println("ERROR: FAMILY: US10: " + faList.get(i).get(0) + ": Wife (" + faList.get(i).get(5) + ") who was born at " + DateFunc.dateListToString(wifBirt) + " marriaged " + faList.get(i).get(1) + " before 14");
			}
		}
	
	}

}