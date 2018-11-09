/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_09{
	
	
	public static void birthBeforeParentsDeath(List<List<String>> idList, List<List<String>> faList){
	
		System.out.println("\r\n");
		System.out.println("\r\n");
		
		for(int i = 1; i < faList.size(); i++){
		
			List<Integer> husdeat = new ArrayList<Integer>();
			List<Integer> wifdeat = new ArrayList<Integer>();
			List<List<Integer>> birt = new ArrayList<List<Integer>>();
		
			husdeat = fetchDeathday(faList.get(i).get(3), idList);
			wifdeat = fetchDeathday(faList.get(i).get(5), idList);
			
			if(husdeat.get(2) == 0 && wifdeat.get(2) == 0){
				continue;
			}
			else{
				int cur = 2;
				List<Integer> tempbirth = new ArrayList<Integer>();
				while((cur = faList.get(i).get(7).indexOf("I", cur)) != -1){
					
					tempbirth = fetchBirthday(faList.get(i).get(7).substring(cur, cur + 3), idList);
					if(tempbirth.get(2) != 0){
						birt.add(tempbirth);
					}
					
					cur++;
				}
			}
			
			husdeat = monthChange(husdeat, 9);
			
			
			if(husdeat.get(2) != 0){
				for(int j = 0; j < birt.size(); j++){
					if(dateCompare(husdeat, birt.get(j)).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US09: " + faList.get(i).get(7).substring(j * 6 + 2, j * 6 + 5) + ": Child's birthday: " + String.valueOf(birt.get(j).get(0)) + "-" + String.valueOf(birt.get(j).get(1)) + "-" + String.valueOf(birt.get(j).get(2)) + " after death of father: (" + faList.get(i).get(3) + "), deathday: " + String.valueOf(husdeat.get(0)) + "-" + String.valueOf(husdeat.get(1)) + "-" + String.valueOf(husdeat.get(2)));
					}
				}
			}
			
			
			if(wifdeat.get(2) != 0){
				for(int j = 0; j < birt.size(); j++){
					if(dateCompare(wifdeat, birt.get(j)).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US09: " + faList.get(i).get(7).substring(j * 6 + 2, j * 6 + 5) + ": Child's birthday: " + String.valueOf(birt.get(j).get(0)) + "-" + String.valueOf(birt.get(j).get(1)) + "-" + String.valueOf(birt.get(j).get(2)) + " after death of mother: (" + faList.get(i).get(5) + "), deathday: " + String.valueOf(wifdeat.get(0)) + "-" + String.valueOf(wifdeat.get(1)) + "-" + String.valueOf(wifdeat.get(2)));
					}
				}
			}
			
			
			
			
		}
	}

	
	
	
	
	public static List<Integer> fetchBirthday(String id, List<List<String>> idList){
		
		List<Integer> birt = new ArrayList<Integer>();
		birt.add(0);
		birt.add(0);
		birt.add(0);
		
		for(int i = 1; i < idList.size(); i++){
			
			if(id.equals("NA")){
				return birt;
			}
			if(idList.get(i).get(0).equals(id)){
				
				if(idList.get(i).get(3).equals("NA")){
					return birt;
				}
				birt.set(0, Integer.parseInt(idList.get(i).get(3).substring(0, 4)));
				birt.set(1, Integer.parseInt(idList.get(i).get(3).substring(5, 7)));
				birt.set(2, Integer.parseInt(idList.get(i).get(3).substring(8)));	
			}
		}
		
		return birt;
	}
	
	
	
	public static List<Integer> fetchDeathday(String id, List<List<String>> idList){		
		
		List<Integer> deat = new ArrayList<Integer>();
		deat.add(0);
		deat.add(0);
		deat.add(0);
		
		for(int i = 1; i < idList.size(); i++){
			
			if(id.equals("NA")){
				return deat;
			}
			if(idList.get(i).get(0).equals(id)){
				
				if(idList.get(i).get(6).equals("NA")){
					return deat;
				}
				deat.set(0, Integer.parseInt(idList.get(i).get(6).substring(0, 4)));
				deat.set(1, Integer.parseInt(idList.get(i).get(6).substring(5, 7)));
				deat.set(2, Integer.parseInt(idList.get(i).get(6).substring(8)));
			}
		}
		
		return deat;
	}
	
	
	
	public static String dateCompare(List<Integer> date1, List<Integer> date2){
		
		String cmp;
		if(date1.get(0) > date2.get(0)){
			cmp = ">";
		}
		else if(date1.get(0) == date2.get(0)){
			if(date1.get(1) > date2.get(1)){
				cmp = ">";
			}
			else if(date1.get(1) == date2.get(1)){
				if(date1.get(2) > date2.get(2)){
					cmp = ">";
				}
				else if(date1.get(2) == date2.get(2)){
					cmp = "=";
				}
				else{
					cmp = "<";
				}
			}
			else{
				cmp = "<";
			}
		}
		else{
			cmp = "<";
		}
		
		return cmp;
	}
	
	
	public static List<Integer> monthChange(List<Integer> date, int monchange){
		
		List<Integer> newDate = new ArrayList<Integer>();
		newDate.add(0);
		newDate.add(0);
		newDate.add(0);
		
		newDate.set(0, date.get(0)); 
		newDate.set(2, date.get(2));
		
		newDate.set(1, date.get(1) + monchange);
		if(newDate.get(1) > 12){
			newDate.set(0, newDate.get(0) + 1);
			newDate.set(1, newDate.get(1) - 12);
		}
		else if(newDate.get(1) <= 0){
			newDate.set(0, newDate.get(0) - 1);
			newDate.set(1, newDate.get(1) + 12);
		}
		
		return newDate;
	}
	
	
	
}
