import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory02Test {

    @Test
    public void birthbeforewedd() {

    }

    @Test
    public void checkBirthDateBeforeWeddDateForIndi() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike","male","1900-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        idlist.add(id);
        idlist.add(id2);
        System.out.println(idlist);

        List<List<String>> idlistfalse = new ArrayList<List<String>>();
        List<String> id3 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I01", "mike","male","2020-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        idlistfalse.add(id3);
        idlistfalse.add(id4);
        System.out.println(idlistfalse);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa2 = new ArrayList<String>(Arrays.asList("F01","2000-01-01","NA","I01","mike","None","NA","NA"));
        falist.add(fa);
        falist.add(fa2);
        System.out.println(falist);

        String exp1 = "";
        String exp2 = "ERROR: Family: US02: " + "I01" + " birthdate " + "2020-01-01" + " following marriage date "+ "2000-01-01";
        String act1 = UserStory02.checkBirthDateBeforeWeddDateForIndi(idlist,falist);
        String act2 = UserStory02.checkBirthDateBeforeWeddDateForIndi(idlistfalse,falist);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);

    }
}