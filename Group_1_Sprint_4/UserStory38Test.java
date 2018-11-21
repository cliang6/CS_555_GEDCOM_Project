import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory38Test {

    @Test
    public void listupcomingbirthdate() {
    }

    @Test
    public void listupcomingbirthdatepeopleForIndi() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J","male","2000-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        idlist.add(id);
        idlist.add(id2);
        System.out.println("not coming"+ idlist);

        List<List<String>> idlistupcoming1 = new ArrayList<List<String>>();
        List<String> id3 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I02", "tom/J","male","1900-11-20","-20", "True","2030-01-01","None","{'F02'}"));
        idlistupcoming1.add(id3);
        idlistupcoming1.add(id4);
        System.out.println("upcoming "+idlistupcoming1);

        List<List<String>> idlistupcoming2 = new ArrayList<List<String>>();
        List<String> id5 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I03", "jack/J","male","1900-11-10","-20", "True","2030-01-01","None","{'F03'}"));
        idlistupcoming2.add(id5);
        idlistupcoming2.add(id6);
        System.out.println("upcoming "+idlistupcoming2);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa2 = new ArrayList<String>(Arrays.asList("F01","2000-01-01","2010-01-01","I01","mike/J","None","NA","NA"));
        List<String> fa3 = new ArrayList<String>(Arrays.asList("F02","2000-01-01","2010-01-01","I02","tom/J","None","NA","NA"));
        List<String> fa4 = new ArrayList<String>(Arrays.asList("F03","2000-01-01","2010-01-01","I03","tom/J","None","NA","NA"));
        falist.add(fa);
        falist.add(fa2);
        falist.add(fa3);
        falist.add(fa4);
        System.out.println(falist);

        String exp1 = "";
        String exp2 = "ERROR:INDIVIDUAL:US38 "+"tom J";
        String exp3 = "ERROR:INDIVIDUAL:US38 "+"jack J";
        String act1 = UserStory38.listupcomingbirthdatepeopleForIndi(idlist,falist);
        String act2 = UserStory38.listupcomingbirthdatepeopleForIndi(idlistupcoming1,falist);
        String act3 = UserStory38.listupcomingbirthdatepeopleForIndi(idlistupcoming2,falist);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);
        assertEquals(exp3,act3);
    }
}