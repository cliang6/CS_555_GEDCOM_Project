import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory_15Test {

    @Test
    public void fewerThanFifteenSiblings() {

        List<List<String>> testFaList1 = new ArrayList<List<String>>();
        List<List<String>> testFaList2 = new ArrayList<List<String>>();
        List<List<String>> testIdList = new ArrayList<List<String>>();
        List<String> tempid;


        String ACT1, ACT2, EXP1, EXP2;

        tempid = new ArrayList<String>( Arrays.asList("F01", "1990-01-01", "NA", "I01", "JACK/MA/", "I11", "MARY/DONG/", "{'I51','I52'}"));
        testFaList1.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("F02", "2003-04-05", "NA", "I02", "ROBIN/LI/", "I12", "KATHY/WANG/", "{'I61', 'I62', 'I63'}"));
        testFaList1.add(tempid);

        tempid = new ArrayList<String>( Arrays.asList("F01", "1990-01-01", "NA", "I01", "JACK/MA/", "I11", "MARY/DONG/", "{'I51','I52'}"));
        testFaList2.add(tempid);
        tempid = new ArrayList<String>( Arrays.asList("F02", "2003-04-05", "NA", "I02", "ROBIN/LI/", "I12", "KATHY/WANG/", "{'I601', 'I602', 'I603', 'I604', 'I605', 'I606', 'I607', 'I608', 'I609', 'I610', 'I611', 'I612', 'I613', 'I614', 'I615'}"));
        testFaList2.add(tempid);

        EXP1 = null;
        EXP2 = "ERROR: FAMILY: US15: F02: This family's siblings are euqal or more than 15.";

        ACT1 = UserStory_15.fewerThanFifteenSiblings(testIdList, testFaList1);
        assertEquals(EXP1, ACT1);
        ACT2 = UserStory_15.fewerThanFifteenSiblings(testIdList, testFaList2);
        assertEquals(EXP2, ACT2);

    }
}