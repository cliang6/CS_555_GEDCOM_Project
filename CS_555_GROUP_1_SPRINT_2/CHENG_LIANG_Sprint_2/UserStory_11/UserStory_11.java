/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_11{
	
	
	public static void noBigamy(List<List<String>> faList){
		
		for(int i = 1; i < faList.size(); i++){
			
			List<List<String>> dupHusList = new ArrayList<List<String>>();
			List<List<String>> dupWifList = new ArrayList<List<String>>();
			
			dupHusList.add(new ArrayList<String>( Arrays.asList(faList.get(i).get(0), faList.get(i).get(1), faList.get(i).get(2), faList.get(i).get(5))));
			dupWifList.add(new ArrayList<String>( Arrays.asList(faList.get(i).get(0), faList.get(i).get(1), faList.get(i).get(2), faList.get(i).get(3))));
			
			for(int j = i + 1; j < faList.size(); j++){
				
				if(faList.get(j).get(3).equals(faList.get(i).get(3))){
					
					for(int k = 0; k < dupHusList.size(); k++){
						if(DateFunc.marriageOverlap(DateFunc.dateStringToList(dupHusList.get(k).get(1)), DateFunc.dateStringToList(dupHusList.get(k).get(2)), DateFunc.dateStringToList(faList.get(j).get(1)), DateFunc.dateStringToList(faList.get(j).get(2)))){
							System.out.println("ERROR: FAMILY: US11: " + faList.get(i).get(0) + ": Husband (" + faList.get(i).get(3) + ") bigamy, he got married with " + faList.get(j).get(5) + " and " + dupHusList.get(k).get(3) + " in same period of time.");
						}
					}
					
					dupHusList.add(new ArrayList<String>( Arrays.asList(faList.get(j).get(0), faList.get(j).get(1), faList.get(j).get(2), faList.get(j).get(5))));
				}
				
				if(faList.get(j).get(5).equals(faList.get(i).get(5))){
					
					for(int k = 0; k < dupWifList.size(); k++){
						if(DateFunc.marriageOverlap(DateFunc.dateStringToList(dupWifList.get(k).get(1)), DateFunc.dateStringToList(dupWifList.get(k).get(2)), DateFunc.dateStringToList(faList.get(j).get(1)), DateFunc.dateStringToList(faList.get(j).get(2)))){
							System.out.println("ERROR: FAMILY: US11: " + faList.get(i).get(0) + ": Wife (" + faList.get(i).get(5) + ") bigamy, she got married with " + faList.get(j).get(3) + " and " + dupHusList.get(k).get(3) + " in same period of time.");
						}
					}
					
					dupWifList.add(new ArrayList<String>( Arrays.asList(faList.get(j).get(0), faList.get(j).get(1), faList.get(j).get(2), faList.get(j).get(3))));
				}
			}
		}
				
	}

}