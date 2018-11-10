import java.util.*;



public class UserStory04_Original{

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
				int mY, mM, mD;//mY=marriageYear,mM=marriageMon,mD=marriageDay
				int dY, dM, dD;//mD=marriageDay,dM=divorceMon,dD=divorceDay
				String [] marriageNextLine = marriage.split("\\-") ;
				mY = Integer.parseInt(marriageNextLine[0]);//mY=marriageYear
				mM = Integer.parseInt(marriageNextLine[1]);//mM=marriageMon
				mD = Integer.parseInt(marriageNextLine[2]);//mD=marriageDay
				String [] divorceNextLine = divorce.split("\\-") ;	
				dY = Integer.parseInt(divorceNextLine[0]);//dY=divorceYear
				dM = Integer.parseInt(divorceNextLine[1]);//dM=divorceMon
				dD = Integer.parseInt(divorceNextLine[2]);//dD=divorceDay
				if(mY < dY){//mY=marriageYear,dY=divorceYear
					res = "";
				}
				else if(mY == dY){//mY=marriageYear,dY=divorceYear
					if(mM < dM){//mM=marriageMon,dM=divorceMon
						res = "";
					}
					else if(mM == dM){//mM=marriageMon,dM=divorceMon
						if(mD <= dD){//mD=marriageDay,dD=divorceDay
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