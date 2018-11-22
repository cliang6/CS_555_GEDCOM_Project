import java.util.Calendar;
import java.util.List;

public class US33 {
    public static void listorphans(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = listorphansForIndi(idList, faList);
    }


    public static String listorphansForIndi(List<List<String>> idList, List<List<String>> faList){
        String res = "";
        for (int i =1 ; i < faList.size() ; i++){
            String children = faList.get(i).get(7);

            if (!children.equals("NA")){
                String husbandID = faList.get(i).get(3);
                String wifeID = faList.get(i).get(5);
                for (int k =0; k < idList.size();k++) {
                    String idID = idList.get(k).get(0);
                    if (husbandID.equals(idID)) {
                        String husbandalive = idList.get(k).get(5);

                        if (husbandalive.equals("False")) {
                            for (int l = 0 ; l < idList.size(); l++) {
                                String idID2 = idList.get(l).get(0);
                                if (wifeID.equals(idID2)) {
                                    String wifealive = idList.get(l).get(5);
                                    if (wifealive.equals("False")) {
                                        String[] child = children.split("'");
                                        for (int j = 0; j < child.length; j++) {
                                            if (j % 2 != 0) {
                                                for ( int a =0; a < idList.size();a ++){
                                                    String idID3 = idList.get(a).get(0);
                                                    if (child[j].equals(idID3)){
                                                        String birth = idList.get(a).get(3);
                                                        String death = idList.get(a).get(6);
                                                        if (death.equals("NA")) {
                                                            Calendar cal = Calendar.getInstance();
                                                            int currentDay, currentMonth, currentYear;
                                                            currentDay = cal.get(Calendar.DATE);
                                                            currentMonth = cal.get(Calendar.MONTH)+1;
                                                            currentYear = cal.get(Calendar.YEAR);

                                                            String[] birthnextline = birth.split("\\-");
                                                            int birthYear = Integer.parseInt(birthnextline[0]);
                                                            int birthMon = Integer.parseInt(birthnextline[1]);
                                                            int birthDay = Integer.parseInt(birthnextline[2]);

                                                            if (currentYear - birthYear < 18) {
                                                                res = "US33:list orphans whose age under 18 years old " + child[j];
                                                                System.out.println(res);
                                                            }
                                                        }else {
                                                            String[] birthnextline = birth.split("\\-");
                                                            int birthYear = Integer.parseInt(birthnextline[0]);
                                                            int birthMon = Integer.parseInt(birthnextline[1]);
                                                            int birthDay = Integer.parseInt(birthnextline[2]);

                                                            String[] deathnextline = death.split("\\-");
                                                            int deathYear = Integer.parseInt(birthnextline[0]);
                                                            int deathMon = Integer.parseInt(birthnextline[1]);
                                                            int deathDay = Integer.parseInt(birthnextline[2]);
                                                            if (deathYear - birthYear < 18){
                                                                res = "US33:list orphans whose age under 18 years old " + child[j];
                                                                System.out.println(res);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res ;
    }
}
