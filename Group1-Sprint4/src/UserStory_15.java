/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class UserStory_15{
	
	
	public static String fewerThanFifteenSiblings(List<List<String>> idList, List<List<String>> faList){

		String res = null;
		for(int i = 0; i < faList.size(); i++){
			
			List<String> children;
			children = SearchFunc.fetchChildren(faList.get(i).get(0), faList);
			
			if(children.size() >= 15){

				res =  "ERROR: FAMILY: US15: " + faList.get(i).get(0) + ": This family's siblings are euqal or more than 15.";
				System.out.println(res);
			}	
		}

		return res;
	}

}