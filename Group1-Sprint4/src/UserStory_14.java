/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_14{
	
	
	public static void multipleBirthLessThanFive(List<List<String>> idList, List<List<String>> faList){
		

		for(int i = 0; i < faList.size(); i++){
			
			List<String> children = new ArrayList<String>();
			
			int begin = 0, end = 0;
			
			if(faList.get(i).get(7).equals("NA")){
				continue;
			}
			
			String ch = faList.get(i).get(7).substring(1, faList.get(i).get(7).length() - 1);
			
			while(ch.indexOf("'") != -1){
				begin = ch.indexOf("'");
				end = ch.indexOf("'", begin + 1);
				children.add(ch.substring(begin + 1, end));
				ch = ch.substring(end + 1);
			}
			
			if(children.size() > 5){
				
				List<List<Integer>> dateList = new ArrayList<List<Integer>>();
				List<Integer> count = new ArrayList<Integer>();
				
				dateList.add(DateFunc.fetchDay(children.get(0), idList, "Birthday"));
				count.add(1);

				
				for(int j = 1; j < children.size(); j++){
					
					List<Integer> date = new ArrayList<Integer>();
					
					date = DateFunc.fetchDay(children.get(j), idList, "Birthday");
					
					
					for(int k = 0; k < dateList.size(); k++){
						
						if((dateList.get(k).get(0).equals(date.get(0))) && (dateList.get(k).get(1)).equals(date.get(1)) && (dateList.get(k).get(2)).equals(date.get(2))){
							count.set(k, count.get(k) + 1);
						}
						else{
							dateList.add(date);
							count.add(1);
						}
					}	
				}
				
				
				for(int c = 0; c < count.size(); c++){
					if(count.get(c) > 5 && dateList.get(c).get(2) != 0){
						System.out.println("ERROR: FAMILY: US14: " + faList.get(i).get(0) + ": Multiple births bigger than 5.");
					}
				}
			}
			
		}
		
		
	}

}