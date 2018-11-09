/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;



public class GedcomQuery{
	
	public static void main(String[] args){
		String gs = new String("CHENG_LIANG_BloodTree.ged"); //Default GEDCOM file is my file.
		String fn, cm = null;
		boolean st = false;
		int len = 0;
		Scanner sc = new Scanner(System.in);
		
		List<List<List<String>>> allList = new ArrayList<List<List<String>>>();
		List<List<String>> idList = new ArrayList<List<String>>();
		List<List<String>> faList = new ArrayList<List<String>>();
		
		
		
		System.out.println("Please input the GEDCOM file's name: ");
		if(!(fn = sc.nextLine()).equals("")){
			gs = fn;
		}
		
		while(true){
			System.out.println("Do you need to shorten your id? (yes/no)");
			cm = sc.nextLine();
			if(cm.equals("yes")){
				st = true;
				while(true){
					System.out.println("Please input the length of new Id you want to change to (a positive integer):");
					try{
						len = Integer.parseInt(sc.nextLine());
						break;
					}
					catch(Exception e){
						System.out.println("Bad input, please input a positive integer.");
					}
				}
				break;
			}
			else if(cm.equals("no")){
				break;
			}
			else{
				System.out.println("Bad input, please input either 'yes' or 'no'. ");
			}
		}
		
		
		allList = Gedcom_ls.prtList(gs, st, len);
		idList = allList.get(0);
		faList = allList.get(1);
	
	
	
	
	
	
		//Print out two lists.
		
		
		System.out.println("\r\n");
		System.out.println("\r\n");
		
		
		
		
		String sign = null;
		
		
		System.out.println("Individuals:");
		
		for(int i = 0; i <= 189; i++){
			if((i%21) == 0){
				System.out.print("+");
			}
			else{
				System.out.print("-");
			}
			if(i == 189){
				System.out.print("\r\n");
			}
		}
		
		for(int i = 0; i < idList.size(); i++){
			
			if(i == 1){
				for(int k = 0; k <= 189; k++){
					if((k%21) == 0){
						System.out.print("+");
					}
					else{
						System.out.print("-");
					}
					if(k == 189){
						System.out.print("\r\n");
					}
				}
			}
			
			
			System.out.print("|");

			for(int j = 0; j < idList.get(0).size(); j++){
				if(j == (idList.get(0).size() - 1)){
					sign = "|\r\n";
				}
				else{
					sign = "|";
				}
				System.out.printf("%-20s%s", idList.get(i).get(j), sign);
			}
		}
		
		
		for(int i = 0; i <= 189; i++){
			if((i%21) == 0){
				System.out.print("+");
			}
			else{
				System.out.print("-");
			}
			if(i == 189){
				System.out.print("\r\n");
			}
		}
		
		
		System.out.println("\r\n");
		System.out.println("\r\n");
		
		
		
		System.out.println("Families:");
		
		for(int i = 0; i <= 168; i++){
			if((i%21) == 0){
				System.out.print("+");
			}
			else{
				System.out.print("-");
			}
			if(i == 168){
				System.out.print("\r\n");
			}
		}
			
		for(int i = 0; i < faList.size(); i++){
			
			if(i == 1){
				for(int k = 0; k <= 168; k++){
					if((k%21) == 0){
						System.out.print("+");
					}
					else{
						System.out.print("-");
					}
					if(k == 168){
						System.out.print("\r\n");
					}
				}
			}
			
			System.out.print("|");
			for(int j = 0; j < faList.get(0).size(); j++){
				if(j == (faList.get(0).size() - 1)){
					sign = "|\r\n";
				}
				else{
					sign = "|";
				}
				System.out.printf("%-20s%s", faList.get(i).get(j), sign);
			}
			
			
		}
			
		for(int i = 0; i <= 168; i++){
			if((i%21) == 0){
				System.out.print("+");
			}
			else{
				System.out.print("-");
			}
			if(i == 168){
				System.out.print("\r\n");
			}
		}
			
		
		UserStory_09.birthBeforeParentsDeath(idList, faList);
		UserStory_10.marriageAfter_14(idList, faList);
		UserStory01.birthbeforedeath(idList, faList);
		UserStory03.birthbeforedeath(idList, faList);
		UserStory04.marriagebeforedivorce(idList, faList);
		UserStory07.lessthan150(idList, faList);
		UserStory_11.noBigamy(faList);
		UserStory_12.parentsNotTooOld(idList, faList);
		UserStory02.birthbeforewedd(idList, faList);
		UserStory05.weddbeforedeath(idList, faList);
		US29.ListDeceased(idList, faList);
		US30.ListLivingMarried(idList, faList);
		

	
	}


}