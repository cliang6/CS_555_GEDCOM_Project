import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class US32Test {

    @Test
    public void listMultipleBirths() {
        List<List<String>> idlist1 = new ArrayList<List<String>>();
        List<String> id = new ArrayList<>(Arrays.asList("ID","Name","Gender","Birthday","Age","Alive","Death","Child","Spouse"));
        List<String> id2 = new ArrayList<String>(Arrays.asList("I01", "mike/J/","male","1980-01-01","38", "True","NA","None","NA"));
        List<String> id3 = new ArrayList<String>(Arrays.asList("I02", "duck/J/","male","1980-01-01","38", "True","NA","None","NA"));
        idlist1.add(id);
        idlist1.add(id2);
        idlist1.add(id3);

        List<List<String>> falist = new ArrayList<List<String>>();
        List<String> fa = new ArrayList<String>(Arrays.asList("ID","Married","Divorced","Husband ID","Husband Name","Wife ID","Wife Name","Children"));
        falist.add(fa);

        String exp1 = "2"+"\n"+"1"+"\n"+"J"+"\n"+"J";

        String act1 =  US32.ListMultipleBirths(idlist1,falist);

        assertEquals(exp1,act1);

    }
}