/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class DateFunc{
	
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
	
	
	public static List<Integer> fetchDay(String id, List<List<String>> checkList, String dayType){		
		
		int index = -1;
		if(dayType.equals("Birthday")){
			index = 3;
		}
		else if(dayType.equals("Deathday")){
			index = 6;
		}
		else if(dayType.equals("Marriage")){
			index = 1;
		}
		else if(dayType.equals("Divorce")){
			index = 2;
		}
		else{}
		
		List<Integer> day = new ArrayList<Integer>();
		day.add(0);
		day.add(0);
		day.add(0);
		
		for(int i = 1; i < checkList.size(); i++){
			
			if(id.equals("NA")){
				return day;
			}
			if(checkList.get(i).get(0).equals(id)){
				
				if(checkList.get(i).get(index).equals("NA")){
					return day;
				}
				day.set(0, Integer.parseInt(checkList.get(i).get(index).substring(0, 4)));
				day.set(1, Integer.parseInt(checkList.get(i).get(index).substring(5, 7)));
				day.set(2, Integer.parseInt(checkList.get(i).get(index).substring(8)));
			}
		}
		
		return day;
	}


	public static String dateListToString(List<Integer> datelist){
		
		String date = "";
		
		date = date + String.valueOf(datelist.get(0)) + "-";
		if(datelist.get(1) < 10){
			date = date + "0" + String.valueOf(datelist.get(1));
		}
		else{
			date = date + String.valueOf(datelist.get(1));
		}
		date = date + "-" + String.valueOf(datelist.get(2));
		
		return date;
	}
	
	
	public static List<Integer> dateStringToList(String date){
		
		List<Integer> listDate = new ArrayList<Integer>( Arrays.asList(0, 0, 0));
		
		if(date.equals("NA")){
			return listDate;
		}
		
		listDate.set(0, Integer.parseInt(date.substring(0, 4)));
		listDate.set(1, Integer.parseInt(date.substring(5, 7)));
		listDate.set(2, Integer.parseInt(date.substring(8)));
		
		return listDate;
	}
	
	
	public static boolean marriageOverlap(List<Integer> marriageDate1, List<Integer> divorceDate1, List<Integer> marriageDate2, List<Integer> divorceDate2){
		
		Calendar cal = Calendar.getInstance();
		
		if(divorceDate1.get(2) == 0){
			divorceDate1.set(0, cal.get(Calendar.YEAR));
			divorceDate1.set(1, cal.get(Calendar.MONTH) + 1);
			divorceDate1.set(2, cal.get(Calendar.DATE));
		}
		
		if(divorceDate2.get(2) == 0){
			divorceDate2.set(0, cal.get(Calendar.YEAR));
			divorceDate2.set(1, cal.get(Calendar.MONTH) + 1);
			divorceDate2.set(2, cal.get(Calendar.DATE));
		}
		
		if(dateCompare(marriageDate1, marriageDate2).equals("<")){
			if(dateCompare(divorceDate1, marriageDate2).equals("<")){
				return false;
			}
			else{
				return true;
			}
		}
		else if(dateCompare(marriageDate1, marriageDate2).equals("=")){
			return true;
		}
		else{
			if(dateCompare(divorceDate2, marriageDate1).equals("<")){
				return false;
			}
			else{
				return true;
			}
		}
		
	}
	
	
}