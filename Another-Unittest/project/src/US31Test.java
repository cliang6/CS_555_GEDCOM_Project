import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class US31Test {

    @Test
    public void listLivingSingle() {
        List<List<String>> idlist1 = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J/","male","1980-01-01","38", "True","NA","None","NA"));
        idlist1.add(id);
        idlist1.add(id2);
        System.out.println("Ture"+idlist1);  // ""

        List<List<String>> idlist2 = new ArrayList<List<String>>();
        List<String> id3 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I01", "mike","male","1980-01-01","1", "False","1981-01-01","None","NA"));
        idlist2.add(id3);
        idlist2.add(id4);
        System.out.println("Ture"+idlist2);  // ""

        List<List<String>> idlist3 = new ArrayList<List<String>>();
        List<String> id5 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I01", "mike","male","2000-01-01","18", "True","NA","None","NA"));
        idlist3.add(id5);
        idlist3.add(id6);
        System.out.println("Ture"+idlist3);  // ""

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        falist.add(fa);
        System.out.println("falist"+ falist);

        String exp1 = "List:INDIVIDUAL:US31: [I01, mike/J/, male, 1980-01-01, 38, True, NA, None, NA]";
        String exp2 = "";
        String exp3 = "";
        String act1 = US31.ListLivingSingle(idlist1,falist);
        String act2 = US31.ListLivingSingle(idlist2,falist);
        String act3 = US31.ListLivingSingle(idlist3,falist);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);
        assertEquals(exp3,act3);
    }
}