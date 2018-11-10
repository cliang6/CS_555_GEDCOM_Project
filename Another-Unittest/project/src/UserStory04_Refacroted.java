import java.util.*;



public class UserStory04_Refacroted{

	public static void marriagebeforedeath(List<List<String>> idList, List<List<String>> faList){
		
		String result;
		result = checkMarriageDateBeforeDeathDateForIndi(idList, faList);
	}
	

	public static String checkMarriageDateBeforeDeathDateForIndi(List<List<String>> idList, List<List<String>> faList){
		try{
			String res = "";
			for(int i=1;i<idList.size();i++){
				String birth =  idList.get(i).get(1);
				String death =  idList.get(i).get(2);

				String marriage =  faList.get(i).get(1);
				int birthYear = Integer.parseInt( idList.get(i).get(3));
			
				if(!marriage.equals("NA") && !death.equals("NA")){
				int marriageYear, marriageMon, marriageDay;
				int deathYear, deathMon, deathDay;
				String [] marriageNextLine = marriage.split("\\-") ;
				marriageYear = Integer.parseInt(marriageNextLine[0]);
				marriageMon = Integer.parseInt(marriageNextLine[1]);
				marriageDay = Integer.parseInt(marriageNextLine[2]);
				String [] deathNextLine = death.split("\\-") ;	
				deathYear = Integer.parseInt(deathNextLine[0]);
				deathMon = Integer.parseInt(deathNextLine[1]);
				deathDay = Integer.parseInt(deathNextLine[2]);
				if(birthYear < deathYear){
					res = "";
				}
				else if(marriageYear == deathYear){
					if(marriageMon < deathMon){
						res = "";
					}
					else if(marriageMon == deathMon){
						if(marriageDay <= deathDay){
							res = "";
						}
						else
							res = "ERROR: Individual:US04:I"+String.valueOf(i)+" Divorced "+death+ " before married "+marriage;
						        System.out.println(res);
						}
					}
					else{
						res = "ERROR: Individual:US04:I"+String.valueOf(i)+" Divorced "+death+ " before married "+marriage;
						System.out.println(res);
					}
				}
				else{
					//res = "ERROR: Individual:US04:I"+String.valueOf(i) +" Divorced "+death+ " before married "+marriage;
					//System.out.println(res);
				}
			}
			return res;
		}
		catch(Exception e){
			return "This individual does not have marriage date information you need";
		}
	}
}