import java.util.Calendar;
import java.util.List;

public class UserStory39 {
    public static void Listupcominganniversaries(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = ListupcominganniversariespeopleForIndi(idList, faList);
    }


    public static String ListupcominganniversariespeopleForIndi(List<List<String>> idList, List<List<String>> faList){
        String res = "";
        for (int i = 1; i<faList.size();i++){
            String Wedddate = faList.get(i).get(1);
            String[] birthnextline = Wedddate.split("\\-");
            int WeddYear = Integer.parseInt(birthnextline[0]);
            int WeddMon = Integer.parseInt(birthnextline[1]);
            int WeddDay = Integer.parseInt(birthnextline[2]);


            Calendar cal = Calendar.getInstance();
            int currentDay, currentMonth, currentYear;
            currentDay = cal.get(Calendar.DATE);
            currentMonth = cal.get(Calendar.MONTH)+1;
            currentYear = cal.get(Calendar.YEAR);

            String husbandID = faList.get(i).get(3);
            String wifeID = faList.get(i).get(5);

            if (WeddMon == currentMonth){
                if (WeddDay > currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else if (WeddDay == currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    res = "";
                }
            }else if ((WeddMon - currentMonth )==1){
                if (WeddDay < currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else if (WeddDay == currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    res = "";
                }
            }else if ((currentMonth - WeddMon)==11){
                if (WeddDay < currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else if (WeddDay == currentDay){
                    for (int j = 1; j < idList.size(); j++){
                        String ID1 = idList.get(j).get(0);
                        if (husbandID.equals(ID1)){
                            String alive_hus = idList.get(j).get(5);
                            String husbandname = idList.get(j).get(1);
                            String[] namenextline_hus = husbandname.split("/");
                            String firstname_Husband = namenextline_hus[0];
                            String lastname_Husband = namenextline_hus[1];
                            if (alive_hus.equals("True")){
                                for (int k =1; k < idList.size(); k++){
                                    String ID2 = idList.get(k).get(0);
                                    if (wifeID.equals(ID2)){
                                        String alive_wife = idList.get(k).get(5);
                                        String wifename = idList.get(k).get(1);
                                        String[] namenextline_wife = wifename.split("/");
                                        String firstname_wife = namenextline_wife[0];
                                        String lastname_wife = namenextline_wife[1];
                                        if (alive_wife.equals("True")) {
                                            res = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + firstname_Husband +" "+ lastname_Husband + " ,and the wife's name is :" + firstname_wife +" " +lastname_wife;
                                            System.out.println(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    res = "";
                }
            }else {
                res = "";
            }

        }
        return res;
    }

}
