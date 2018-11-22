import java.util.*;

public class US29 {

	public static void ListDeceased(List<List<String>> idList, List<List<String>> faList){
		List<List<String>> result = new ArrayList<List<String>>();
		for (int i = 1; i < idList.size(); i++) {
			if (idList.get(i).get(5) == "False") {
				result.add(idList.get(i));
			}
		}
		for(int j = 0; j < result.size(); j++)
		{
			System.out.println("List:INDIVIDUAL:US29: " + result.get(j));
		}
	}
}