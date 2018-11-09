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
			
			marriageDate = dateStringToList(faList.get(i).get(1));
			
			husBirt = UserStory_09.fetchBirthday(faList.get(i).get(3), idList);
			wifBirt = UserStory_09.fetchBirthday(faList.get(i).get(5), idList);
			
			husBirt.set(0, husBirt.get(0) + 14);
			wifBirt.set(0, wifBirt.get(0) + 14);
			
			hus = UserStory_09.dateCompare(marriageDate, husBirt);
			wif = UserStory_09.dateCompare(marriageDate, wifBirt);
			
			if(hus.equals("<")){
				System.out.println("ERROR: FAMILY: US10: " + faList.get(i).get(0) + ": Husband (" + faList.get(i).get(3) + ") who was born at " + dateListToString(husBirt) + " marriaged " + faList.get(i).get(1) + " before 14");
			}
			
			if(wif.equals("<")){
				System.out.println("ERROR: FAMILY: US10: " + faList.get(i).get(0) + ": Wife (" + faList.get(i).get(5) + ") who was born at " + dateListToString(wifBirt) + " marriaged " + faList.get(i).get(1) + " before 14");
			}
		}
	
	}
	
	
	
	public static List<Integer> dateStringToList(String date){
		
		List<Integer> listDate = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
		
		listDate.set(0, Integer.parseInt(date.substring(0, 4)));
		listDate.set(1, Integer.parseInt(date.substring(5, 7)));
		listDate.set(2, Integer.parseInt(date.substring(8)));
		
		return listDate;
	}
	
	
	public static String dateListToString(List<Integer> datelist){
		
		String date = "";
		
		date = date + String.valueOf(datelist.get(0)) + "-";
		if(datelist.get(1) < 10){
			date = date + "0" + String.valueOf(datelist.get(1));
		}
		else{
			date = date + String.valueOf(datelist.get(1));
		}
		date = date + "-" + String.valueOf(datelist.get(2));
		
		return date;
	}


}