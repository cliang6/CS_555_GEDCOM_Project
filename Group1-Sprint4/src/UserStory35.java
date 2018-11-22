import java.util.Calendar;
import java.util.List;

public class UserStory35 {
    public static void listrecentbirths(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = listrecentbirthspeopleForIndi(idList, faList);
    }


    public static String listrecentbirthspeopleForIndi(List<List<String>> idList, List<List<String>> faList){
        String res = "";
        for (int i = 1; i < idList.size(); i++) {
                String birthname = idList.get(i).get(1);
                String[] namenextline = birthname.split("/");
                String firstname = namenextline[0];
                String lastname = namenextline[1];
                String birthdate = idList.get(i).get(3);
                if (!birthdate.equals("NA")) {
                    String[] birthnextline = birthdate.split("\\-");
                    int birthYear = Integer.parseInt(birthnextline[0]);
                    int birthMon = Integer.parseInt(birthnextline[1]);
                    int birthDay = Integer.parseInt(birthnextline[2]);

                    Calendar cal = Calendar.getInstance();
                    int currentDay, currentMonth, currentYear;
                    currentDay = cal.get(Calendar.DATE);
                    currentMonth = cal.get(Calendar.MONTH) + 1;
                    currentYear = cal.get(Calendar.YEAR);

                    if (birthMon == currentMonth) {
                        if (birthDay < currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else if (birthDay == currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else {
                            res = "";
                        }
                    } else if ((currentMonth - birthMon ) == 1) {
                        if (birthDay < currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else if (birthDay == currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else {
                            res = "";
                        }
                    } else if ((birthMon - currentMonth) == 11) {
                        if (birthDay < currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else if (birthDay == currentDay) {
                            res = "List:INDIVIDUAL:US35:list recent births " + firstname + " " + lastname;
                            System.out.println(res);
                        } else {
                            res = "";
                        }
                    } else {
                        res = "";
                    }
                }
        }
        return res ;
    }
}
