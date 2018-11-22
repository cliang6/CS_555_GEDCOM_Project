import java.util.Calendar;
import java.util.List;

public class UserStory38 {
    public static void listupcomingbirthdate(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = listupcomingbirthdatepeopleForIndi(idList, faList);
    }


    public static String listupcomingbirthdatepeopleForIndi(List<List<String>> idList, List<List<String>> faList){
        String res = "";
        for (int i = 1; i < idList.size(); i++) {

            String Alive = idList.get(i).get(5);
            if (Alive.equals("True")) {
                String alivename = idList.get(i).get(1);
                String[] namenextline = alivename.split("/");
                String firstname = namenextline[0];
                String lastname = namenextline[1];
                String birth = idList.get(i).get(3);
                String[] birthnextline = birth.split("\\-");
                int birthYear = Integer.parseInt(birthnextline[0]);
                int birthMon = Integer.parseInt(birthnextline[1]);
                int birthDay = Integer.parseInt(birthnextline[2]);

                Calendar cal = Calendar.getInstance();
                int currentDay, currentMonth, currentYear;
                currentDay = cal.get(Calendar.DATE);
                currentMonth = cal.get(Calendar.MONTH)+1;
                currentYear = cal.get(Calendar.YEAR);

                if (birthMon == currentMonth){
                    if (birthDay > currentDay){
                        res ="ERROR:INDIVIDUAL:US38 " +firstname + " " + lastname;
                        System.out.println(res);
                    }else if (birthDay == currentDay){
                        res = "ERROR:INDIVIDUAL:US38 "+firstname + " " + lastname;
                        System.out.println(res);
                    } else {
                        res = "";
                    }
                }else if ((birthMon - currentMonth )==1){
                    if (birthDay < currentDay){
                        res ="ERROR:INDIVIDUAL:US38 "+ firstname + " " + lastname;
                        System.out.println(res);
                    }else if (birthDay == currentDay){
                        res ="ERROR:INDIVIDUAL:US38 " +firstname + " " + lastname;
                        System.out.println(res);
                    } else {
                        res = "";
                    }
                }else if ((currentMonth - birthMon)==11){
                    if (birthDay < currentDay){
                        res = "ERROR:INDIVIDUAL:US38 "+firstname + " " + lastname;
                        System.out.println(res);
                    }else if (birthDay == currentDay){
                        res = "ERROR:INDIVIDUAL:US38 "+firstname + " " + lastname;
                        System.out.println(res);
                    } else {
                        res = "";
                    }
                }else {
                    res = "";
                }
            }
        }
        return res ;
    }
}
