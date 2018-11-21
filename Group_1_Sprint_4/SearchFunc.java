/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class SearchFunc{
	
	public static List<String> fetchChildren(String id, List<List<String>> faList){
		
		List<String> children = new ArrayList<String>();
		
		int begin = 0, end = 0;
		
		for(int i = 0; i < faList.size(); i++){
			if(faList.get(i).get(0).equals(id)){
				if(faList.get(i).get(7).equals("NA")){
					children.add("NA");
					break;
				}
				String ch = faList.get(i).get(7).substring(1, faList.get(i).get(7).length() - 1);
				while(ch.indexOf("'") != -1){
					begin = ch.indexOf("'");
					end = ch.indexOf("'", begin + 1);
					children.add(ch.substring(begin + 1, end));
					ch = ch.substring(end + 1);
				}
			}
		}
		
		return children;
	}
	
	
	public static String fetchSurname(String id, List<List<String>> idList){
		
		String surname = null;
		int begin = -1;
		int end = -1;
		
		for(int j = 0; j < idList.size(); j++){
			if(idList.get(j).get(0).equals(id)){
				begin = idList.get(j).get(1).indexOf("/");
				end = idList.get(j).get(1).indexOf("/", begin + 1);
				surname = idList.get(j).get(1).substring(begin + 1, end);
			}
		}
		
		return surname;
	}
	
	
	public static boolean checkMale(String id, List<List<String>> idList){
		
		for(int i = 0; i < idList.size(); i++){
			if(idList.get(i).get(0).equals(id)){
				if(idList.get(i).get(2).equals("M")){
					return true;
				}
				else{
					return false;
				}
			}
			
		}
		
		return false;
	}
	
}