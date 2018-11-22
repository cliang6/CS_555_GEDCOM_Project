import java.util.*;
public class UserStory02 { //read string file from GEDCOM where months were described in abbreviation
    // birth date before death date ,only invalid data will be output


    public static void birthbeforewedd(List<List<String>> idList, List<List<String>> faList) {
        String result;
        result = checkBirthDateBeforeWeddDateForIndi(idList, faList);
    }


    public static String checkBirthDateBeforeWeddDateForIndi(List<List<String>> idList, List<List<String>> faList) {
        String res = "";
        String validbirth;
        String valididID = "";
        int birthYear = 0, birthMon = 0, birthDay = 0;
        int weddYear = 0, weddMon = 0, weddDay = 0;
        for (int i = 1; i < idList.size(); i++) {
            String birth = idList.get(i).get(3);
            String faID = idList.get(i).get(8);
            if (!birth.equals("NA") && !faID.equals("NA")) {
                validbirth = idList.get(i).get(3);
                valididID = idList.get(i).get(0);
                String[] birthNextLine = validbirth.split("\\-");
                birthYear = Integer.parseInt(birthNextLine[0]);
                birthMon = Integer.parseInt(birthNextLine[1]);
                birthDay = Integer.parseInt(birthNextLine[2]);
                for (int j = 1; j < faList.size(); j++) {
                    String wedddate = faList.get(j).get(1);
                    String husID = faList.get(j).get(3);
                    String wifeID = faList.get(j).get(5);
                    if (husID.equals(valididID) || wifeID.equals(valididID)) {
                        String validwedddate = faList.get(j).get(1);
                        String[] weddNextLine = validwedddate.split("\\-");
                        weddYear = Integer.parseInt(weddNextLine[0]);
                        weddMon = Integer.parseInt(weddNextLine[1]);
                        weddDay = Integer.parseInt(weddNextLine[2]);
                        if (birthYear < weddYear) {
                            res = "";
                        } else if (birthYear == weddYear) {
                            if (birthMon < weddMon) {
                                res = "";
                            } else if (birthMon == weddMon) {
                                if (birthDay <= weddDay) {
                                    res = "";
                                } else
                                    res = "ERROR: Family: US02: " + valididID + " birthdate " + validbirth + " following marriage date "+ validwedddate;
                                System.out.println(res);
                            }
                        } else {
                            System.out.println("ERROR: Family: US02: " + valididID + " birthdate " + validbirth + " following marriage date "+ validwedddate);
                        }
                    }
                }
            }
        }
        return res;
    }
}

 		    
		

                    
		  
                   
                   