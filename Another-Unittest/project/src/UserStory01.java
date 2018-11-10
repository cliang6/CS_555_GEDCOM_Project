/*import java.util.*;

public class UserStory01 {


    //read string file from GEDCOM where months were described in abbreviation
    // birth date before current date ,only invalid data will be output



    public static void birthbeforedeath(List<List<String>> idList, List<List<String>> faList){


        checkBirthDateBeforeCurrentForIndi(idList, faList);

        checkDeathDateBeforeCurrentForIndi(idList, faList);

        checkMarriageDateBeforeCurrentForFam(idList, faList);

        checkDivorceDateBeforeCurrentForFam(idList, faList);
    }



    public static String checkBirthDateBeforeCurrentForIndi(List<List<String>> idList, List<List<String>> faList){
            String res = "";
            Calendar cal = Calendar.getInstance();
            int currentDay, currentMonth, currentYear;
            currentDay = cal.get(Calendar.DATE);
            currentMonth = cal.get(Calendar.MONTH)+1;
            currentYear = cal.get(Calendar.YEAR);
            for(int i=1;i<idList.size();i++){
                String birth =  idList.get(i).get(3);
                if(birth != null){
                    int birthYear, birthMon, birthDay;
                    String [] birthNextLine = birth.split("\\-") ;
                    birthYear = Integer.parseInt(birthNextLine[0]);
                    birthMon = Integer.parseInt(birthNextLine[1]);
                    birthDay = Integer.parseInt(birthNextLine[2]);
                    if(birthYear < currentYear){
                        res = "";
                    }
                    else if(birthYear == currentYear){
                        if(birthMon < currentMonth){
                            res = "";
                        }
                        else if(birthMon == currentMonth){
                            if(birthDay <= currentDay){
                                res = "";
                            }
                            else
                                res = "ERROR: Individual:US01:I"+String.valueOf(i)+" Birth Date "+birth+ " occurs in the future";
                            System.out.println(res);
                        }
                    }
                    else{
                        res = "ERROR: Individual:US01:I"+String.valueOf(i)+" Birth Date "+birth+ " occurs in the future";
                        System.out.println(res);
                    }
                }
                else{
                    res = "ERROR: Individual:US01:I"+String.valueOf(i) +" Birth Date "+birth+ " occurs in the future";
                    System.out.println(res);
                }
            }
            return res;
    }

    // death date before current date only invalid data will be output

    public static String checkDeathDateBeforeCurrentForIndi(List<List<String>> idList, List<List<String>> faList){
            String res = "";
            Calendar cal = Calendar.getInstance();
            int currentDay, currentMonth, currentYear;
            currentDay = cal.get(Calendar.DATE);
            currentMonth = cal.get(Calendar.MONTH) + 1;
            currentYear = cal.get(Calendar.YEAR);
            for (int i = 1; i < idList.size(); i++) {
                String death = idList.get(i).get(6);
                if (!death.equals("NA")) {
                    int deathYear, deathMon, deathDay;
                    String[] deathNextLine = death.split("\\-");
                    deathYear = Integer.parseInt(deathNextLine[0]);
                    deathMon = Integer.parseInt(deathNextLine[1]);
                    deathDay = Integer.parseInt(deathNextLine[2]);
                    if (deathYear < currentYear) {
                        res = "";
                    } else if (deathYear == currentYear) {
                        if (deathMon < currentMonth) {
                            res = "";
                        } else if (deathMon == currentMonth) {
                            if (deathDay <= currentDay) {
                                res = "";
                            } else {
                                res = "ERROR: Individual:US01:I" + String.valueOf(i) + " Death Date " + death + " occurs in the future";
                                System.out.println(res);
                            }
                        } else {
                            res = "ERROR: Individual:US01:I" + String.valueOf(i) + " Death Date " + death + " occurs in the future";
                            System.out.println(res);
                        }
                    } else {
                        res = "ERROR: Individual:US01:I" + String.valueOf(i) + " Death Date " + death + " occurs in the future";
                        System.out.println(res);
                    }
                }
                return res;
            }
    }



    // marriage date before current date only invalid data will be output

    public static String checkMarriageDateBeforeCurrentForFam(List<List<String>> idList, List<List<String>> faList) {
        String res = "";
        Calendar cal = Calendar.getInstance();
        int currentDay, currentMonth, currentYear;
        currentDay = cal.get(Calendar.DATE);
        currentMonth = cal.get(Calendar.MONTH) + 1;
        currentYear = cal.get(Calendar.YEAR);
        for (int i = 1; i < faList.size(); i++) {
            String Wedd = faList.get(i).get(1);
            if (!Wedd.equals("NA")) {

                int weddYear, weddMon, weddDay;
                String[] weddNextLine = Wedd.split("\\-");
                weddYear = Integer.parseInt(weddNextLine[0]);
                weddMon = Integer.parseInt(weddNextLine[1]);
                weddDay = Integer.parseInt(weddNextLine[2]);
                if (weddYear < currentYear) {
                    res = "";
                } else if (weddYear == currentYear) {
                    if (weddMon < currentMonth) {
                        res = "";
                    } else if (weddMon == currentMonth) {
                        if (weddDay <= currentDay) {
                            res = "";
                        } else {
                            res = "ERROR: Family:US01:F" + String.valueOf(i) + " Marriage Date " + Wedd + " occurs in the future";
                            System.out.println(res);
                        }
                    } else {
                        res = "ERROR: Family:US01:F" + String.valueOf(i) + " Marriage Date " + Wedd + " occurs in the future";
                        System.out.println(res);
                    }
                } else {
                    res = "ERROR: Family:US01:F" + String.valueOf(i) + " Marriage Date " + Wedd + " occurs in the future";
                    System.out.println(res);
                }
            }
            return res;
        }
    }


        // check divorce date before current date only invalid data will be output

        public static String checkDivorceDateBeforeCurrentForFam(List < List < String >> idList, List < List < String >> faList){

            String res = "";
            Calendar cal = Calendar.getInstance();
            int currentDay, currentMonth, currentYear;
            currentDay = cal.get(Calendar.DATE);
            currentMonth = cal.get(Calendar.MONTH) + 1;
            currentYear = cal.get(Calendar.YEAR);
            for (int i = 1; i < faList.size(); i++) {
                String Divor = faList.get(i).get(2);
                if (!Divor.equals("NA")) {

                    int divYear, divMon, divDay;
                    String[] divNextLine = Divor.split("\\-");
                    divYear = Integer.parseInt(divNextLine[0]);
                    divMon = Integer.parseInt(divNextLine[1]);
                    divDay = Integer.parseInt(divNextLine[2]);
                    if (divYear < currentYear) {
                        res = "";
                    } else if (divYear == currentYear) {
                        if (divMon < currentMonth) {
                            res = "";
                        } else if (divMon == currentMonth) {
                            if (divDay <= currentDay) {
                                res = "";
                            } else {
                                res = "ERROR: Family:US01:F" + String.valueOf(i) + " Divorce Date " + Divor + " occurs in the future";
                                System.out.println(res);
                            }
                        } else {
                            res = "ERROR: Family:US01:F" + String.valueOf(i) + " Divorce Date " + Divor + " occurs in the future";
                            System.out.println(res);
                        }
                    } else {
                        res = "ERROR: Family:US01:F" + String.valueOf(i) + " Divorce Date " + Divor + " occurs in the future";
                        System.out.println(res);
                    }
                }
                return res;
            }
        }

    }


    */