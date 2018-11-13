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
	
	
	
}