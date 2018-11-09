import java.util.*;



public class UserStory07{
	

	public static void lessthan150(List<List<String>> idList, List<List<String>> faList){
		
		String result;
		result = checkLessThan150ForIndi(idList, faList);
	}
	

	public static String checkLessThan150ForIndi(List<List<String>> idList, List<List<String>> faList){
		try{
			String res = "";
			for(int i=1;i<idList.size();i++){
			String birth =  idList.get(i).get(3);
			String death =  idList.get(i).get(6);
			String alive =  idList.get(i).get(5);
			
			if(!birth.equals("NA") && !death.equals("NA") && alive.equals("False")){
				//int alive;
				int birthYear, birthMon, birthDay;
				int deathYear, deathMon, deathDay;
				String [] birthNextLine = birth.split("\\-") ;
				birthYear = Integer.parseInt(birthNextLine[0]);
				birthMon = Integer.parseInt(birthNextLine[1]);
				birthDay = Integer.parseInt(birthNextLine[2]);
				String [] deathNextLine = death.split("\\-") ;	
				deathYear = Integer.parseInt(deathNextLine[0]);
				deathMon = Integer.parseInt(deathNextLine[1]);
				deathDay = Integer.parseInt(deathNextLine[2]);
				if(deathYear - birthYear <= 150){
					res = "";
				}
				else if(deathYear - birthYear == 150 ){
					if(birthMon < deathMon){
						res = "";
					}
					else if(birthMon == deathMon){
						if(birthDay < deathDay){
							res = "";
						}
						else
							res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old from "+birth+ " to " +death;
						        System.out.println(res);
						}
					}
					else{
						res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old from "+birth+ " to " +death;
						System.out.println(res);
					}
				}
				else{
					//res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old "+birth+death;
					//System.out.println(res);
				}
			
			
			
			if (!birth.equals("NA") && !death.equals("NA") &&  alive.equals("True")){
			Calendar cal = Calendar.getInstance();
            
			int currentDay, currentMonth, currentYear;
            
			currentDay = cal.get(Calendar.DATE);
            
			currentMonth = cal.get(Calendar.MONTH);
            
			currentYear = cal.get(Calendar.YEAR);
			int birthYear, birthMon, birthDay;
			String [] birthNextLine = birth.split("\\-") ;
			birthYear = Integer.parseInt(birthNextLine[0]);
			birthMon = Integer.parseInt(birthNextLine[1]);
			birthDay = Integer.parseInt(birthNextLine[2]);
			if(currentYear - birthYear <= 150){
					res = "";
				}
				else if(currentYear - birthYear == 150 ){
					if(birthMon < currentMonth){
						res = "";
					}
					else if(birthMon == currentMonth){
						if(birthDay < currentDay){
							res = "";
						}
						else
							res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old "+birth;
						        System.out.println(res);
						}
					}
					else{
						res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old "+birth;
						System.out.println(res);
					}
				}
				else{
					//res = "ERROR: Individual:US07:I"+String.valueOf(i)+" More than 150 years old "+birth;
					//System.out.println(res);
				}
			}
			return res;
			}
		catch(Exception e){
			return "This individual does not have birth date information you need";
		}
	}
}