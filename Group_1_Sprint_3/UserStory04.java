import java.util.*;



public class UserStory04{

	public static void marriagebeforedivorce(List<List<String>> idList, List<List<String>> faList){
		
		String result;
		result = checkMarriageDateBeforeDivorceDateForIndi(idList, faList);
	}
	

	public static String checkMarriageDateBeforeDivorceDateForIndi(List<List<String>> idList, List<List<String>> faList){
		try{
			String res = "";
			for(int i=1;i<idList.size();i++){

				String marriage =  faList.get(i).get(1);
				String divorce =  faList.get(i).get(2);
			
				if(!marriage.equals("NA") && !divorce.equals("NA")){
				int marriageYear, marriageMon, marriageDay;
				int divorceYear, divorceMon, divorceDay;
				String [] marriageNextLine = marriage.split("\\-") ;
				marriageYear = Integer.parseInt(marriageNextLine[0]);
				marriageMon = Integer.parseInt(marriageNextLine[1]);
				marriageDay = Integer.parseInt(marriageNextLine[2]);
				String [] divorceNextLine = divorce.split("\\-") ;	
				divorceYear = Integer.parseInt(divorceNextLine[0]);
				divorceMon = Integer.parseInt(divorceNextLine[1]);
				divorceDay = Integer.parseInt(divorceNextLine[2]);
				if(marriageYear < divorceYear){
					res = "";
				}
				else if(marriageYear == divorceYear){
					if(marriageMon < divorceMon){
						res = "";
					}
					else if(marriageMon == divorceMon){
						if(marriageDay <= divorceDay){
							res = "";
						}
						else
							res = "ERROR: Individual:US04:I"+String.valueOf(i)+" Divorced "+divorce+ " before married "+marriage;
						        System.out.println(res);
						}
					}
					else{
						res = "ERROR: Individual:US04:I"+String.valueOf(i)+" Divorced "+divorce+ " before married "+marriage;
						System.out.println(res);
					}
				}
				else{
					
				}
			}
			return res;
		}
		catch(Exception e){
			return "This individual does not have marriage date information you need";
		}
	}
}