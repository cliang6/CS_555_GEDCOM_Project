import java.util.*;

public class US32 {

	public static List<String> ListMultipleBirths(List<List<String>> idList, List<List<String>> faList){
		// List<List<String>> result = new ArrayList();
		// for (int i = 1; i < faList.size(); i++){
		// 	List<String> subresult = new ArrayList();
		// 	List<String> childrenId = new ArrayList();
		// 	for (String str: faList.get(i).get(7).split("'|,")) {
		// 		if (str.length() > 5) {
		// 			childrenId.add(str);
		// 		}
		// 	}
		// 	for (int j = 0; j < childrenId.size(); j++) {
		// 		for (int k = j + 1; k < childrenId.size(); k++) {
		// 			for (int l = 1; l < idList.size(); l++) {
		// 				for (int m = 1; m < idList.size(); m++) {
		// 					if (idList.get(l).get(0) == childrenId.get(j) && idList.get(m).get(0) == childrenId.get(k) && idList.get(l).get(3) == idList.get(m).get(3)) {
		// 						System.out.println(idList.get(l));								
		// 						System.out.println(idList.get(m));								
		// 					}
		// 				}
		// 			}
		// 		}
		// 	}
		// }
		List<String> children = new ArrayList<String>();
		List<String> res = new ArrayList<>() ;
		for(int id = 0; id <faList.size(); id++){
			children = SearchFunc.fetchChildren(faList.get(id).get(0),faList);
			if(children.size() > 1){
				for(int x = 0; x < children.size()-1; x++){
					for(int y = x+1; y <children.size(); y++){
						List<Integer> bir1 = new ArrayList<Integer>();
						List<Integer> bir2 = new ArrayList<Integer>();
						bir1 = DateFunc.fetchDay(children.get(x),idList,"Birthday");
						bir2 = DateFunc.fetchDay(children.get(y),idList,"Birthday");
						if(bir1.get(0).equals(bir2.get(0)) && bir1.get(1).equals(bir2.get(1)) && bir1.get(2).equals(bir2.get(2)))
							res.add("US32:FAMILY:" + faList.get(id).get(0) + "MULTIPLE BIRTHS " + children.get(x) + " AND  "+ children.get(y));
						System.out.println(res.get(res.size()-1));
					}
				}
			}
		}
		return res;
	}
}
