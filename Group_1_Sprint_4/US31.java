import java.util.*;

public class US31 {

	public static String ListLivingSingle(List<List<String>> idList, List<List<String>> faList){
		String res = "";
		for (int i = 1; i < idList.size(); i++) {
			if (idList.get(i).get(5) == "True" &&  Integer.parseInt(idList.get(i).get(3).split("-")[0]) < 2018 - 30 && idList.get(i).get(8) == "NA") {
				res = "List:INDIVIDUAL:US31: " + idList.get(i);
				System.out.println(res);
			}
		}
		return res ;
	}
}
