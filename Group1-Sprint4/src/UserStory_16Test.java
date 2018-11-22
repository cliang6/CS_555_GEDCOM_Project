import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory_16Test {

    @Test
    public void maleLastNames() {

        List<List<String>> testFaList = new ArrayList<List<String>>();
        List<List<String>> testIdList1 = new ArrayList<List<String>>();
        List<List<String>> testIdList2 = new ArrayList<List<String>>();
        List<String> tempid;


        String ACT1, ACT2, EXP1, EXP2;


        tempid = new ArrayList<String>( Arrays.asList("F01", "1990-01-01", "NA", "I01", "JACK/MA/", "I11", "MARY/DONG/", "{'I51','I52'}"));
        testFaList.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("F02", "2003-04-05", "NA", "I02", "ROBIN/LI/", "I12", "KATHY/WANG/", "{'I61', 'I62', 'I63'}"));
        testFaList.add(tempid);


        tempid = new ArrayList<String>( Arrays.asList("I01", "JACK/MA/", "M", "1970-03-15", "null", "True", "NA", "NA", "{'F01'}"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I51", "JUN/MA/", "M", "2010-03-15", "null", "True", "NA", "{'F01'}", "NA"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I52", "HUA/MA/", "M", "2010-04-15", "null", "True", "NA", "{'F01'}", "NA"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I02", "ROBIN/LI/", "M", "1967-11-25", "null", "True", "NA", "NA", "{'F02'}"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I61", "JUN/LI/", "M", "2010-03-16", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I62", "HUA/LI/", "M", "2011-03-15", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I63", "JUN/LI/", "M", "2018-03-15", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I11", "MARY/DONG/", "F", "1980-06-11", "null", "True", "NA", "NA", "{'F01'}"));
        testIdList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I12", "KATHY/WANG/", "F", "1990-01-12", "null", "True", "NA", "NA", "{'F02'}"));
        testIdList1.add(tempid);


        tempid = new ArrayList<String>( Arrays.asList("I01", "JACK/MA/", "M", "1970-03-15", "null", "True", "NA", "NA", "{'F01'}"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I51", "JUN/MA/", "M", "2010-03-15", "null", "True", "NA", "{'F01'}", "NA"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I52", "HUA/MA/", "M", "2010-04-15", "null", "True", "NA", "{'F01'}", "NA"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I02", "ROBIN/LI/", "M", "1967-11-25", "null", "True", "NA", "NA", "{'F02'}"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I61", "JUN/LI/", "M", "2010-03-16", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I62", "HUA/LI/", "M", "2011-03-15", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I63", "JUN/ZHAO/", "M", "2018-03-15", "null", "True", "NA", "{'F02'}", "NA"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I11", "MARY/DONG/", "F", "1980-06-11", "null", "True", "NA", "NA", "{'F01'}"));
        testIdList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("I12", "KATHY/WANG/", "F", "1990-01-12", "null", "True", "NA", "NA", "{'F02'}"));
        testIdList2.add(tempid);


        EXP1 = null;
        EXP2 = "ERROR: FAMILY: US16: F02: This family's male members have different last name: Son 'I63' has a last name which is different from his father's.";

        ACT1 = UserStory_16.maleLastNames(testIdList1, testFaList);
        assertEquals(EXP1, ACT1);
        ACT2 = UserStory_16.maleLastNames(testIdList2, testFaList);
        assertEquals(EXP2, ACT2);

    }
}