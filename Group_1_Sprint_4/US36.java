import java.util.Calendar;
import java.util.List;

public class US36 {
    public static void listRecentDeaths(List<List<String>> idList, List<List<String>> faList){

        String result;
        result = listrecentdeaths(idList, faList);
    }


    public static String listrecentdeaths(List<List<String>> idList, List<List<String>> faList){
        String res = "";
        for (int i = 1; i < idList.size(); i++) {

            String Death = idList.get(i).get(6);
            if (!Death.equals("NA")) {
                String deathname = idList.get(i).get(1);
                String[] namenextline = deathname.split("/");
                String firstname = namenextline[0];
                String lastname = namenextline[1];
                String deathdate = idList.get(i).get(6);
                String[] deathnextline = deathdate.split("\\-");
                int deathYear = Integer.parseInt(deathnextline[0]);
                int deathMon = Integer.parseInt(deathnextline[1]);
                int deathDay = Integer.parseInt(deathnextline[2]);

                Calendar cal = Calendar.getInstance();
                int currentDay, currentMonth, currentYear;
                currentDay = cal.get(Calendar.DATE);
                currentMonth = cal.get(Calendar.MONTH)+1;
                currentYear = cal.get(Calendar.YEAR);

                if (currentYear == deathYear){
                    if(deathMon == currentMonth){
                        if(currentDay > deathDay){
                            res = firstname + " " + lastname;
                            System.out.println("US36: list recent deaths:"+res); 
                        }
                    }else if(currentMonth - deathMon == 1){
                        if(currentDay < deathDay){
                            res = firstname + " " + lastname;
                            System.out.println("US36: list recent deaths:"+res); 
                        }
                    }
                }else if (currentYear - deathYear == 1){
                        if(currentDay < deathDay){
                            res = firstname + " " + lastname;
                            System.out.println("US36: list recent deaths:"+res); 
                    }
                }

                else {
                    res = "";
                }
            }
        }
        return res ;
    }
}
