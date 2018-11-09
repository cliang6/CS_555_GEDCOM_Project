import java.util.*;
public class UserStory06 { //read string file from GEDCOM where months were described in abbreviation
    // birth date before death date ,only invalid data will be output


    public static void divbeforedeath(List<List<String>> idList, List<List<String>> faList) {
        String result;
        result = checkDivDateBeforeDeathDateForIndi(idList, faList);
    }


    public static String checkDivDateBeforeDeathDateForIndi(List<List<String>> idList, List<List<String>> faList) {
        String res = "";
        String validdeath;
        String valididID = "";
        int deathYear = 0, deathMon = 0, deathDay = 0;
        int divYear = 0, divMon = 0, divDay = 0;
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
                    String divdate = faList.get(j).get(2);
                    String husID = faList.get(j).get(3);
                    String wifeID = faList.get(j).get(5);
                    String spouseID =faList.get(j).get(0);
                    if ((husID.equals(valididID) || wifeID.equals(valididID))&& !divdate.equals("NA")) {
                        String validspouseID = faList.get(j).get(0);
                        String validdivdate = faList.get(j).get(2);
                        String[] divNextLine = validdivdate.split("\\-");
                        divYear = Integer.parseInt(divNextLine[0]);
                        divMon = Integer.parseInt(divNextLine[1]);
                        divDay = Integer.parseInt(divNextLine[2]);
                        if (divYear<deathYear) {
                            res = "";
                        } else if (divYear == deathYear) {
                            if ( divMon < deathMon) {
                                res = "";
                            } else if (deathMon == divMon) {
                                if (divDay <= deathDay) {
                                    res = "";
                                } else
                                    res = "ERROR: Family: US06: " + valididID + " Divorced " + validdivdate + " after "+ valididID +"("+ validspouseID+")"+ " death on " + validdeath;
                                System.out.println(res);
                            }
                        } else {
                            res = "ERROR: Family: US06: " + valididID + " Divorced " + validdivdate + " after "+ valididID +"("+ validspouseID+")"+ " death on " + validdeath;
                            System.out.println(res);
                        }
                    }
                }
            }
        }
        return res;
    }
}
