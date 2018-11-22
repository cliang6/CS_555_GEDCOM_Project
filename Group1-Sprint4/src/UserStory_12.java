/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_12{
	
	
	public static void parentsNotTooOld(List<List<String>> idList, List<List<String>> faList){
		
		String familyID = "NA";
		
		for(int i = 1; i < idList.size(); i++){
			if(!idList.get(i).get(7).equals("NA")){
				familyID = idList.get(i).get(7).substring(2, 5);
			}
			else{
				continue;
			}
			
			for(int j = 1; j < faList.size(); j++){
				
				if(faList.get(j).get(0).equals(familyID)){
					
					List<Integer> fatherAgeLine = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
					List<Integer> motherAgeLine = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
					
					List<Integer> fatherAge = new ArrayList<Integer>(DateFunc.fetchDay(faList.get(j).get(3), idList, "Birthday"));
					List<Integer> motherAge = new ArrayList<Integer>(DateFunc.fetchDay(faList.get(j).get(5), idList, "Birthday"));
					
					
					fatherAgeLine.set(0, fatherAge.get(0) + 80);
					fatherAgeLine.set(1, fatherAge.get(1));
					fatherAgeLine.set(2, fatherAge.get(2));
					motherAgeLine.set(0, motherAge.get(0) + 60);
					motherAgeLine.set(1, motherAge.get(1));
					motherAgeLine.set(2, motherAge.get(2));
					
					if((!faList.get(j).get(3).equals("NA")) && DateFunc.dateCompare(fatherAgeLine, DateFunc.dateStringToList(idList.get(i).get(3))).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US12: " + idList.get(i).get(0) + ": Child's father (" + faList.get(j).get(3) + ") is too old.");
					}
					
					if((!faList.get(j).get(5).equals("NA")) && DateFunc.dateCompare(motherAgeLine, DateFunc.dateStringToList(idList.get(i).get(3))).equals("<")){
						System.out.println("ERROR: INDIVIDUAL: US12: " + idList.get(i).get(0) + ": Child's mother (" + faList.get(j).get(5) + ") is too old.");
					}
				}
			}
		}
		
	}

}