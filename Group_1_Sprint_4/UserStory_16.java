/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_16{
	
	
	public static void maleLastNames(List<List<String>> idList, List<List<String>> faList){
		

		for(int i = 0; i < faList.size(); i++){
			
			List<String> children = new ArrayList<String>();
			String familyName;
			
			children = SearchFunc.fetchChildren(faList.get(i).get(0), faList);
			
			familyName = SearchFunc.fetchSurname(faList.get(i).get(3), idList);
			
			for(int j = 0; j < children.size(); j++){
				if(SearchFunc.checkMale(children.get(j), idList)){
					if(!SearchFunc.fetchSurname(children.get(j), idList).equals(familyName)){
						System.out.println("ERROR: FAMILY: US16: " + faList.get(i).get(0) + ": This family's male members have different last name: Son '" + children.get(j) + "' has a last name which is different from his father's.");
					}
				}
			}
		}
	}

}