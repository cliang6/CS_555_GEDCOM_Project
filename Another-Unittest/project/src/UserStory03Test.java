import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserStory03Test {

    @Test
    public void birthbeforedeath() {
    }

    @Test
    public void checkBirthDateBeforeDeathDateForIndi() {
        List<List<String>> idlist1 = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J","male","2020-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        idlist1.add(id);
        idlist1.add(id2);
        System.out.println("Ture"+idlist1);  // ""

        List<List<String>> idlist2 = new ArrayList<List<String>>();
        List<String> id3 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I02", "tom/J","male","2020-01-01","-20", "False","NA","None","{'F01'}"));
        idlist2.add(id3);
        idlist2.add(id4);
        System.out.println("Ture"+idlist2);  // ""


        List<List<String>> idlist3 = new ArrayList<List<String>>();
        List<String> id5 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I03", "jack/J","male","1900-01-01","-20", "False","2020-01-01","None","{'F01'}"));
        idlist3.add(id5);
        idlist3.add(id6);
        System.out.println("Ture"+idlist3);  // ""


        List<List<String>> idlistfalse = new ArrayList<List<String>>();
        List<String> idf = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> idf2 = new ArrayList<String>(Arrays.asList("I1", "jerry/J","male","1940-01-01","-20", "False","1930-01-01","None","{'F01'}"));
        idlistfalse.add(idf);
        idlistfalse.add(idf2);
        System.out.println("false"+idlistfalse);  //error

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        falist.add(fa);
        System.out.println("falist"+ falist);

        String exp1 = "";
        String exp2 =  "ERROR: Individual:US03:I1"+" Died "+"1930-01-01"+ " before born "+"1940-01-01";
        String act1 = UserStory03.checkBirthDateBeforeDeathDateForIndi(idlist1,falist);
        String act2 = UserStory03.checkBirthDateBeforeDeathDateForIndi(idlist2,falist);
        String act3 = UserStory03.checkBirthDateBeforeDeathDateForIndi(idlist3,falist);
        String act4 = UserStory03.checkBirthDateBeforeDeathDateForIndi(idlistfalse,falist);

        assertEquals(exp1,act1);
        assertEquals(exp1,act2);
        assertEquals(exp1,act3);
        assertEquals(exp2,act4);
    }
}