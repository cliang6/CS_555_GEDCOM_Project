import java.util.*;// import all
public class UserStory03_smelly { 
	    // read string file from GEDCOM where months were described in abbreviation
        // birth date before death date ,only invalid data will be output

    public static void birthbeforedeath(List<List<String>> idList, List<List<String>> faList){ /*birthbeforedeath means what we do is to cheack birth date before death date */

        String result;
        result = checkBirthDateBeforeDeathDateForIndi(idList, faList);///*checkBirthDateBeforeDeathDateForIndi means we check Birthdate whether is before the Death Date as foe individual.*/
    }
    
    public static String checkBirthDateBeforeDeathDateForIndi(List<List<String>> idList, List<List<String>> faList){ /*checkBirthDateBeforeDeathDateForIndi means we check Birthdate whether is before the Death Date as foe individual.*/
        try{
            String res = "";
            for(int i=1;i<idList.size();i++){
                String birth =  idList.get(i).get(3); //get birth in chart in column 4
                String death =  idList.get(i).get(6); //get birth in chart in column 7


                if(!birth.equals("NA") && !death.equals("NA")){
                    int bY, bM, bD;//bY is for birthYear, bM is for birthMonth, bD is for birthDay
                    int dY, dM, dD;//dY is for deathYear, dM is for deathMonth, dD is for deathDay
		            String b0, b1, b2;/*b0 is for the first string in birthNextLine,b1 is for the second string in birthNextLine,b0 is for the third string in birthNextLine*/
		            String d0, d1, d2;/*b1 is for the first string in deathNextLine,b1 is for the second string in deathNextLine,b0 is for the third string in deathNextLine*/
                    String [] birthNextLine = birth.split("\\-");//we split the birth date into three line by "-"
		            b0 = birthNextLine[0];//b0 is a string now
		            b1 = birthNextLine[1];//b1 is a string now
                    b2 = birthNextLine[2];//b2 is a string now
                    bY = Integer.parseInt(b0);// store the year also parseInt into Integer in bY
                    bM = Integer.parseInt(b1);// store the month also parseInt into Integer in bM
                    bD = Integer.parseInt(b2);// store the day also parseInt into Integer in bD
                    String [] deathNextLine = death.split("\\-");//we split the death date into three line by "-"
                    d0 = deathNextLine[0];//d0 is a string
                    d1 = deathNextLine[1];//d1 is a string
                    d2 = deathNextLine[2];//d2 is a string
                    dY = Integer.parseInt(d0);// store the year also parseInt into Integer in bY
                    dM = Integer.parseInt(d1);// store the month also parseInt into Integer in bM
                    dD = Integer.parseInt(d2);// store the day also parseInt into Integer in bD
                    if(bY < dY){ //compare year if bY<dY , we don't print
                        res = "";
                    }
                    else if(bY == dY){ //compare year if bY==dY 
                        if(bM < dM){ //compare year if bM<dM , we don't print
                            res = "";
                        }
                        else if(bM == dM){ //compare month if bM<dM , we don't print
                            if(bD <= dD){  //compare day , if bD<=dD, we don't print
                                res = "";
                            }
                            else  // print as follows
                                res = "ERROR: Individual:US03:I"+String.valueOf(i)+" Died "+death+ " before born "+birth;
                            System.out.println(res);
                        }
                    }
                    else{  // print as follows
                        res = "ERROR: Individual:US03:I"+String.valueOf(i)+" Died "+death+ " before born "+birth;
                        System.out.println(res);
                    }
                }
                else{ //at this time, we don't print because this else is compare to the if(!birth.equals("NA") && !death.equals("NA"))
                    //res = "ERROR: Individual:US03:I"+String.valueOf(i) +" Died "+death+ " before born "+birth;
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
