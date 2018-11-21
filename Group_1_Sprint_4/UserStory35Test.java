import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory35Test {

    @Test
    public void listrecentbirths() {
    }

    @Test
    public void listrecentbirthspeopleForIndi() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J","male","2000-11-01","-20", "True","2030-01-01","None","{'F01'}"));
        idlist.add(id);
        idlist.add(id2);
        System.out.println("not coming"+ idlist);

        List<List<String>> idlistupcoming1 = new ArrayList<List<String>>();
        List<String> id3 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I02", "tom/J","male","1900-10-20","-20", "True","2030-01-01","None","{'F02'}"));
        idlistupcoming1.add(id3);
        idlistupcoming1.add(id4);
        System.out.println("upcoming 1"+idlistupcoming1);

        List<List<String>> idlistupcoming2 = new ArrayList<List<String>>();
        List<String> id5 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I03", "jack/J","male","1900-11-20","-20", "True","2030-01-01","None","{'F03'}"));
        idlistupcoming2.add(id5);
        idlistupcoming2.add(id6);
        System.out.println("upcoming 2"+idlistupcoming2);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        falist.add(fa);

        String exp1 = "List:INDIVIDUAL:US35:list recent births mike J";
        String exp2 = "List:INDIVIDUAL:US35:list recent births tom J";
        String exp3 = "";



        String act1 = UserStory35.listrecentbirthspeopleForIndi(idlist,falist);
        String act2 = UserStory35.listrecentbirthspeopleForIndi(idlistupcoming1,falist);
        String act3 = UserStory35.listrecentbirthspeopleForIndi(idlistupcoming2,falist);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);
        assertEquals(exp3,act3);
    }
}