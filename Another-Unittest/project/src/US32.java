import java.util.*;

public class US32 {

	public static String ListMultipleBirths(List<List<String>> idList, List<List<String>> faList){
		String res = "";
		for (int i = 1; i < idList.size(); i++) {
			for (int j = 1; j < idList.size(); j++) {
				if (idList.get(i).get(3) == idList.get(j).get(3) && i !=j) {
					// && idList.get(i).get(1).split("/")[1] == idList.get(j).get(1).split("/")[1]
					res = i+"\n"+j+"\n"+ idList.get(i).get(1).split("/")[1]+"\n" + idList.get(j).get(1).split("/")[1];
					System.out.println(res);
				}
			}
		}
		return res;
		// System.out.println("-------------------------------------------------");

		// for (int i = 0; i < faList.size(); i++) {
		// 	System.out.println(faList.get(i));
		// }
		// for(int j = 0; j < result.size(); j++)
		// {
		// 	System.out.println("List:INDIVIDUAL:US32: " + result.get(j));
		// }
	}
}