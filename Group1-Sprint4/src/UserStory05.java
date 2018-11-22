import java.util.*;
public class UserStory05 { //read string file from GEDCOM where months were described in abbreviation
    // birth date before death date ,only invalid data will be output


    public static void weddbeforedeath(List<List<String>> idList, List<List<String>> faList) {
        String result;
        result = checkWeddDateBeforeDeathDateForIndi(idList, faList);
    }


    public static String checkWeddDateBeforeDeathDateForIndi(List<List<String>> idList, List<List<String>> faList) {
        String res = "";
        String validdeath;
        String valididID = "";
        int deathYear = 0, deathMon = 0, deathDay = 0;
        int weddYear = 0, weddMon = 0, weddDay = 0;
        for (int i = 1; i < idList.size(); i++) {
            String death = idList.get(i).get(6);
            String faID = idList.get(i).get(8);
            if (!death.equals("NA") && !faID.equals("NA")) {
                validdeath = idList.get(i).get(6);
                valididID = idList.get(i).get(0);
                String[] deathNextLine = validdeath.split("\\-");
                deathYear = Integer.parseInt(deathNextLine[0]);
                deathMon = Integer.parseInt(deathNextLine[1]);
                deathDay = Integer.parseInt(deathNextLine[2]);
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
                        if (weddYear<deathYear) {
                            res = "";
                        } else if (weddYear == deathYear) {
                            if ( weddMon < deathMon) {
                                res = "";
                            } else if (deathMon == weddMon) {
                                if (weddDay <= deathDay) {
                                    res = "";
                                } else
                                    res = "ERROR: Family: US05: " + valididID + " Married " + validwedddate + " after "+ valididID + " death on " + validdeath;
                                System.out.println(res);
                            }
                        } else {
                            System.out.println("ERROR: Family: US05: " + valididID + " Married " + validwedddate + " after "+ valididID + " death on " + validdeath);
                        }
                    }
                }
            }
        }
        return res;
    }
}

 		    
		

                    
		  
                   
                   