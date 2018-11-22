import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class US33Test {

    @Test
    public void listorphans() {
    }

    @Test
    public void listorphansForIndi() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J","male","2000-11-01","-20", "False","2030-01-01","None","{'F01'}"));
        List<String> id3 = new ArrayList<String>(Arrays.asList("I02", "tom/J","male","1900-10-20","-20", "False","2030-01-01","None","{'F02'}"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I05", "a/J","male","2013-01-01","-20", "True","NA","None","{'F02'}"));
        List<String> id7 = new ArrayList<String>(Arrays.asList("I06", "b/J","male","1900-10-20","-20", "False","1915-01-01","None","{'F02'}"));
        List<String> id8 = new ArrayList<String>(Arrays.asList("I07", "c/J","male","1900-10-20","-20", "True","2000-01-01","None","{'F02'}"));
        idlist.add(id);
        idlist.add(id2);
        idlist.add(id3);
        idlist.add(id6);
        idlist.add(id7);
        idlist.add(id8);

        List<List<String>> idlistupcoming2 = new ArrayList<List<String>>();
        List<String> id20 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I03", "tom/K","male","1900-10-20","-20", "True","2030-01-01","None","{'F02'}"));
        List<String> id5 = new ArrayList<String>(Arrays.asList("I04", "tom/K","male","1900-10-20","-20", "False","2030-01-01","None","{'F02'}"));
        List<String> id9 = new ArrayList<String>(Arrays.asList("I08", "d/K","male","2013-01-01","-20", "True","NA","None","{'F02'}"));
        List<String> id10 = new ArrayList<String>(Arrays.asList("I09", "e/K","male","1900-10-20","-20", "False","1915-01-01","None","{'F02'}"));
        List<String> id11 = new ArrayList<String>(Arrays.asList("I10", "f/K","male","1900-10-20","-20", "False","2000-01-01","None","{'F02'}"));
        idlistupcoming2.add(id20);
        idlistupcoming2.add(id4);
        idlistupcoming2.add(id5);
        idlistupcoming2.add(id9);
        idlistupcoming2.add(id10);
        idlistupcoming2.add(id11);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa2 = new ArrayList<String>(Arrays.asList("F01","Married","Divorced","I01","Husband Name","I02","Wife Name","{'I05','I06','I07'}"));
        List<String> fa3 = new ArrayList<String>(Arrays.asList("F02","Married","Divorced","I03","Husband Name","I04","Wife Name","{'I08','I09','I10'}"));
        falist.add(fa);
        falist.add(fa2);
        falist.add(fa3);

        String exp1 = "US33:list orphans whose age under 18 years old " + "I07";
        String exp2 = "";

        String act1 = US33.listorphansForIndi(idlist,falist);
        String act2 = US33.listorphansForIndi(idlistupcoming2,falist);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);
    }
}