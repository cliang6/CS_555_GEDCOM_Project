import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserStory05Test {

    @Test
    public void weddbeforedeath() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<String>(Arrays.asList("I01", "mike","male","2020-01-01","-20", "True","2030-01-01","None","{'I01'}"));
        idlist.add(id);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("F01","2000-01-01","NA","I01","mike","None","NA","NA"));
        falist.add(fa);
    }

    @Test
    public void checkWeddDateBeforeDeathDateForIndi() {
        List<List<String>> idlist = new ArrayList<List<String>>();
        List<String> id = new ArrayList<String>(Arrays.asList("I01", "mike","male","2020-01-01","-20", "True","2030-01-01","None","{'I01'}"));
        idlist.add(id);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("F01","2100-01-01","NA","I01","mike","None","NA","NA"));
        falist.add(fa);
    }
}