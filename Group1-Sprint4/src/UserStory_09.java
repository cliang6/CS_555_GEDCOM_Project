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
		
			husdeat = DateFunc.fetchDay(faList.get(i).get(3), idList, "Deathday");
			wifdeat = DateFunc.fetchDay(faList.get(i).get(5), idList, "Deathday");
			
			if(husdeat.get(2) == 0 && wifdeat.get(2) == 0){
				continue;
			}
			else{
				int cur = 2;
				List<Integer> tempbirth = new ArrayList<Integer>();
				while((cur = faList.get(i).get(7).indexOf("I", cur)) != -1){
					
					tempbirth = DateFunc.fetchDay(faList.get(i).get(7).substring(cur, cur + 3), idList, "Birthday");
					if(tempbirth.get(2) != 0){
						birt.add(tempbirth);
					}
					
					cur++;
				}
			}
			
			husdeat = DateFunc.monthChange(husdeat, 9);
			
			
			if(husdeat.get(2) != 0){
				for(int j = 0; j < birt.size(); j++){
					if(DateFunc.dateCompare(husdeat, birt.get(j)).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US09: " + faList.get(i).get(7).substring(j * 6 + 2, j * 6 + 5) + ": Child's birthday: " + String.valueOf(birt.get(j).get(0)) + "-" + String.valueOf(birt.get(j).get(1)) + "-" + String.valueOf(birt.get(j).get(2)) + " after death of father: (" + faList.get(i).get(3) + "), deathday: " + String.valueOf(husdeat.get(0)) + "-" + String.valueOf(husdeat.get(1)) + "-" + String.valueOf(husdeat.get(2)));
					}
				}
			}
			
			
			if(wifdeat.get(2) != 0){
				for(int j = 0; j < birt.size(); j++){
					if(DateFunc.dateCompare(wifdeat, birt.get(j)).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US09: " + faList.get(i).get(7).substring(j * 6 + 2, j * 6 + 5) + ": Child's birthday: " + String.valueOf(birt.get(j).get(0)) + "-" + String.valueOf(birt.get(j).get(1)) + "-" + String.valueOf(birt.get(j).get(2)) + " after death of mother: (" + faList.get(i).get(5) + "), deathday: " + String.valueOf(wifdeat.get(0)) + "-" + String.valueOf(wifdeat.get(1)) + "-" + String.valueOf(wifdeat.get(2)));
					}
				}
			}
			
			
		}
	}
	
}