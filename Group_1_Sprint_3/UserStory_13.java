/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_13{
	
	
	public static void siblingsSpacing(List<List<String>> idList, List<List<String>> faList){
		
		
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
			
			if(children.size() > 1){
				for(int j = 0; j < children.size() - 1; j++){
					for(int k = j + 1; k < children.size(); k++){
						
						List<Integer> date1 = new ArrayList<Integer>();
						List<Integer> date2 = new ArrayList<Integer>();
						
						date1 = DateFunc.fetchDay(children.get(j), idList, "Birthday");
						date2 = DateFunc.fetchDay(children.get(k), idList, "Birthday");
						
						if(date1.get(2) != 0){
							
							if(Math.abs(date1.get(0) - date2.get(0)) == 0){
								if(Math.abs(date1.get(1) - date2.get(1)) <= 8){
									
									if(Math.abs(date1.get(1) - date2.get(1)) == 0 && Math.abs(date1.get(2) - date2.get(2)) < 2){
										continue;
									}
									else if(Math.abs(date1.get(1) - date2.get(1)) == 1){
										if(date1.get(1) < date2.get(1) && date2.get(2) == 1){
											if((date1.get(1) == 1 || date1.get(1) == 3 || date1.get(1) == 5 || date1.get(1) == 7 || date1.get(1) == 8 || date1.get(1) == 10) && date1.get(2) == 31){
												continue;
											}
											else if((date1.get(1) == 4 || date1.get(1) == 6 || date1.get(1) == 9 || date1.get(1) == 11) && date1.get(2) == 30){
												continue;
											}
											else if(date1.get(1) == 2 && date1.get(1) == 28){
												continue;
											}
											else{}
										}
										else if(date1.get(1) > date2.get(1) && date1.get(2) == 1){
											if((date2.get(1) == 1 || date2.get(1) == 3 || date2.get(1) == 5 || date2.get(1) == 7 || date2.get(1) == 8 || date2.get(1) == 10) && date2.get(2) == 31){
												continue;
											}
											else if((date2.get(1) == 4 || date2.get(1) == 6 || date2.get(1) == 9 || date2.get(1) == 11) && date2.get(2) == 30){
												continue;
											}
											else if(date2.get(1) == 2 && date2.get(1) == 28){
												continue;
											}
											else{}
										}
										else{}
									}
									else{}
									
									System.out.println("ERROR: FAMILY: US13: " + faList.get(i).get(0) + ": Siblings " + children.get(j) + " born at " + DateFunc.dateListToString(date1) + " and " + children.get(k) + " born at " + DateFunc.dateListToString(date2) + " are not twin and born too close.");
								}
							}
							else if(Math.abs(date1.get(0) - date2.get(0)) == 1){
								if(date1.get(0) < date2.get(0)){
									if(date1.get(1) - 4 >= date2.get(1)){
										if(date1.get(1) == 12 && date1.get(2) == 31 && date2.get(1) == 1 && date2.get(2) == 1){
											continue;
										}
										System.out.println("ERROR: FAMILY: US13: " + faList.get(i).get(0) + ": Siblings " + children.get(j) + " born at " + DateFunc.dateListToString(date1) + " and " + children.get(k) + " born at " + DateFunc.dateListToString(date2) + " are not twin and born too close.");
									}
								}
								else if(date1.get(0) > date2.get(0)){
									if(date2.get(1) - 4 >= date1.get(1)){
										if(date2.get(1) == 12 && date2.get(2) == 31 && date1.get(1) == 1 && date1.get(2) == 1){
											continue;
										}
										System.out.println("ERROR: FAMILY: US13: " + faList.get(i).get(0) + ": Siblings " + children.get(j) + " born at " + DateFunc.dateListToString(date1) + " and " + children.get(k) + " born at " + DateFunc.dateListToString(date2) + " are not twin and born too close.");
									}
								}
								else{}
							}
							else{}
						}
					}
				}
			}
			
		}
		
		
	}

}