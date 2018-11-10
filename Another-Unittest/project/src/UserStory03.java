import java.util.*;
public class UserStory03 { //read string file from GEDCOM where months were described in abbreviation
    // birth date before death date ,only invalid data will be output


    public static void birthbeforedeath(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = checkBirthDateBeforeDeathDateForIndi(idList, faList);
    }


    public static String checkBirthDateBeforeDeathDateForIndi(List<List<String>> idList, List<List<String>> faList){

            String res = "";
            for(int i=1;i<idList.size();i++){
                String birth =  idList.get(i).get(3);
                String death =  idList.get(i).get(6);


                if(!birth.equals("NA") && !death.equals("NA")){
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
                    if(birthYear < deathYear){
                        res = "";
                    }
                    else if(birthYear == deathYear){
                        if(birthMon < deathMon){
                            res = "";
                        }
                        else if(birthMon == deathMon){
                            if(birthDay <= deathDay){
                                res = "";
                            }
                            else
                                res = "ERROR: Individual:US03:I"+String.valueOf(i)+" Died "+death+ " before born "+birth;
                            System.out.println(res);
                        }
                    }
                    else{
                        res = "ERROR: Individual:US03:I"+String.valueOf(i)+" Died "+death+ " before born "+birth;
                        System.out.println(res);
                    }
                }
                else{
                    //res = "ERROR: Individual:US03:I"+String.valueOf(i) +" Died "+death+ " before born "+birth;
                    //System.out.println(res);
                }
            }
            return res;

    }
}
