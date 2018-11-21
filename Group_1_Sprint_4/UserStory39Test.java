import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory39Test {

    @Test
    public void listupcominganniversaries() {
    }

    @Test
    public void listupcominganniversariespeopleForIndi() {
        ///////idlist
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J","male","2000-01-01","-20", "True","2030-01-01","None","{'F01'}"));
        List<String> id3 = new ArrayList<String>(Arrays.asList("I02", "tom/J","female","1900-11-20","-20", "True","2030-01-01","None","{'F02'}"));
        idlist.add(id);
        idlist.add(id2);
        idlist.add(id3);
        System.out.println("idlist: "+ idlist);///True

        List<List<String>> idlistfalse1 = new ArrayList<List<String>>();
        List<String> id8 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id4 = new ArrayList<String>(Arrays.asList("I03", "jack/J","male","1900-11-20","-20", "True","2030-01-01","None","{'F02'}"));
        List<String> id5 = new ArrayList<String>(Arrays.asList("I04", "jerry/J","female","1900-11-20","-20", "False","2030-01-01","None","{'F02'}"));
        idlistfalse1.add(id8);
        idlistfalse1.add(id4);
        idlistfalse1.add(id5);
        System.out.println("idlistfalse1" + idlistfalse1);//false because jerry/J is not alive

        List<List<String>> idlistfalse2 = new ArrayList<List<String>>();
        List<String> id9 = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id6 = new ArrayList<String>(Arrays.asList("I05", "nick/J","male","1900-11-20","-20", "True","2030-01-01","None","{'F02'}"));
        List<String> id7 = new ArrayList<String>(Arrays.asList("I06", "mario/J","female","1900-11-20","-20", "True","2030-01-01","None","{'F02'}"));
        idlistfalse2.add(id9);
        idlistfalse2.add(id6);
        idlistfalse2.add(id7);
        System.out.println("idlistfalse2" + idlistfalse2);//false

        //////////falist
        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa2 = new ArrayList<String>(Arrays.asList("F01","2000-12-01","2010-01-01","I01","mike/J","I02","tom/J","NA"));
        falist.add(fa);
        falist.add(fa2);
        System.out.println("falist"+falist); //compare to idlist, true

        List<List<String>> falistfalse1 = new ArrayList<List<String>>();
        List<String> fa3 = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa4 = new ArrayList<String>(Arrays.asList("F02","2000-12-01","2010-01-01","I03","jack/J","I04","jerry/J","NA"));
        falistfalse1.add(fa3);
        falistfalse1.add(fa4);
        System.out.println("falistfalse1"+falistfalse1); //compare to idlistfalse1

        List<List<String>> falistfalse2 = new ArrayList<List<String>>();
        List<String> fa5 = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        List<String> fa6 = new ArrayList<String>(Arrays.asList("F03","2000-01-01","2010-01-01","I05","nick/J","I06","mario/J","NA"));
        falistfalse2.add(fa5);
        falistfalse2.add(fa6);
        System.out.println("falistfalse2"+falistfalse2); //compare to idlistfalse2, false because the wedding date is not upcoming.

        String exp1 = "UserStory39: List living couples' upcoming anniversaries: " + " The husband's name is: " + "mike" +" "+ "J" + " ,and the wife's name is :" +"tom" +" " +"J";
        String exp2 = "";
        String exp3 = "";
        String act1 = UserStory39.ListupcominganniversariespeopleForIndi(idlist,falist);
        String act2 = UserStory39.ListupcominganniversariespeopleForIndi(idlistfalse1,falistfalse1);
        String act3 = UserStory39.ListupcominganniversariespeopleForIndi(idlistfalse2,falistfalse2);

        assertEquals(exp1,act1);
        assertEquals(exp2,act2);
        assertEquals(exp3,act3);
    }
}