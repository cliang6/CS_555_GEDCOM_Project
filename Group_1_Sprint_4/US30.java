import java.util.*;

public class US30 {

	public static void ListLivingMarried(List<List<String>> idList, List<List<String>> faList){
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 1; i < idList.size(); i++) {
			if (idList.get(i).get(5) == "True" && idList.get(i).get(8) != "NA") {
				result.add(idList.get(i));
			}
		}
		for(int j = 0; j < result.size(); j++)
		{
			System.out.println("List:INDIVIDUAL:US30: " + result.get(j));
		}
	}
}
