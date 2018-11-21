import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class US32Test {

    @Test
    public void listMultipleBirths() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J/","male","2000-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        List<String> id3 = new ArrayList<String>(Arrays.asList("I02", "nick/J/","male","2000-01-01","-20", "True","2030-01-01","None","{'F02'}"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I03", "dick/J/","male","2000-01-01","-20", "True","2030-01-01","None","{'F03'}"));
        idlist.add(id);
        idlist.add(id2);
        idlist.add(id3);
        idlist.add(id4);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa2 = new ArrayList<String>(Arrays.asList("F04","2000-01-01","2010-01-01","I04","a/J/","None","NA","{'I01','I02','I03'}"));
        falist.add(fa);
        falist.add(fa2);

        String exp1 = "";
        String exp2 = "US32:FAMILY:" + "F04" + "MULTIPLE BIRTHS " + "I01"+" AND  "+"I02" +"US32:FAMILY:" + "F04" + "MULTIPLE BIRTHS " + "I01"+" AND  "+"I03" + "US32:FAMILY:" + "F04" + "MULTIPLE BIRTHS " + "I02"+" AND  "+"I03" ;

        List<String> res = new ArrayList<String>();
        res = US32.ListMultipleBirths(idlist,falist);
        String act = res.get(0)+res.get(1)+res.get(2);
        assertEquals(exp2,act);

    }
}