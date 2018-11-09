/**
This program's copyright belongs to CHENG LIANG.
*/


import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;


public class Gedcom_ls{
	
	
	
	public static List<List<List<String>>> prtList(String fileName, boolean st, int len){
		File file = new File(fileName);
		BufferedReader reader = null;
		
		List<List<List<String>>> allList = new ArrayList<List<List<String>>>();
		
		
		List<List<String>> idList = new ArrayList<List<String>>();
		String[] sarr = new String[10];
		String idstr = new String();
		String str = new String();
		
		
		List<String> title = new ArrayList<String>(9);
		title.add("ID");
		title.add("Name");
		title.add("Gender");
		title.add("Birthday");
		title.add("Age");
		title.add("Alive");
		title.add("Death");
		title.add("Child");
		title.add("Spouse");
		idList.add(title);
		
		//System.out.println(IdList.get(0).get(1));
		
		
		
		List<List<String>> faList = new ArrayList<List<String>>();
		String[] sarr2 = new String[10];
		String idstr2 = new String();
		String str2 = new String();
		
		
		List<String> title2 = new ArrayList<String>(9);
		title2.add("ID");
		title2.add("Married");
		title2.add("Divorced");
		title2.add("Husband ID");
		title2.add("Husband Name");
		title2.add("Wife ID");
		title2.add("Wife Name");
		title2.add("Children");
		faList.add(title2);
		
		
		
		Map<String, String> idDictionary = new HashMap<String, String>();
		int idcount = 0;

		
		
		
		
		try{
			String rstr = new String();
			
			try{
				reader = new BufferedReader(new FileReader(file));
			}
			catch(Exception efile){
				System.out.println("Can't find the file, please check the directory.");
				System.exit(0);
			}
			String tstr = null;
			int count = 0;			
			
			
			//Below is our Individuals' List making. 
			
			
			while((tstr = reader.readLine()) != null){
				count++;
				if(count == 1){//This part is used to eliminate BOM.
					tstr = tstr.substring(3);
				}
				sarr = tstr.split(" ");
				
				if((sarr.length == 3) && (sarr[0].equals("0")) && !(sarr[1].equals("NOTE"))){
					
					if(sarr[2].equals("INDI")){
						if(sarr[1].substring(0, 1).equals("@")){
							
							List<String> person = new ArrayList<String>(9);
							idstr = sarr[1].substring(1, sarr[1].length() - 1);
							idcount++;
							if(st == true){
								if(idcount > Math.pow(10.0, (double)len)){
									System.out.println("Have not enough new " + len +"-digit number for assigning shorten new id. Please restart and choose proper length.");
									System.exit(0);
								}
								person.add(idShorten(idstr, len, idDictionary));
							}
							else{
								person.add(idstr);
							}
							String sub, sur, name, birt, deat, idc, ids;
							String age = null;
							String[] items, date = new String[10];
							boolean isAlive = true;
							
							while(!((sub = reader.readLine()).split(" ")[1].equals("CHAN"))){
								items = sub.split(" ");
								if(items[1].equals("NAME")){
									if(items.length == 4){
										name = items[2] + items[3];
										person.add(name);
									}
									else{
										reader.readLine();
										sur = reader.readLine().split(" ")[2];
										name = items[2] + "/" + sur + "/";
										person.add(name);
									}
								}
								else if(items[1].equals("SEX")){
									person.add(items[2]);
								}
								else if(items[1].equals("BIRT")){
									date = reader.readLine().split(" ");
									birt = dateformat(date[2], date[3], date[4]);
									person.add(birt);
									person.add(age);
									person.add("True");
									person.add("NA");
									person.add("NA");
									person.add("NA");
								}
								else if(items[1].equals("DEAT")){
									isAlive = false;
									person.set(person.size() - 4, "False");
									date = reader.readLine().split(" ");
									deat = dateformat(date[2], date[3], date[4]);
									person.set(person.size() - 3, deat);
								}
								else if(items[1].equals("FAMS")){
									if(!person.get(person.size() - 1).equals("NA")){
										person.set(person.size() - 1, person.get(person.size() - 1).substring(0, person.get(person.size() - 1).length() - 1) + ", '" + items[2].substring(1, items[2].length() - 1) + "'}");
										continue;
									}
									ids = "{'" + items[2].substring(1, items[2].length() - 1) + "'}";
									person.set(person.size() - 1, ids);
								}
								else if(items[1].equals("FAMC")){
									idc = "{'" + items[2].substring(1, items[2].length() - 1) + "'}";
									person.set(person.size() - 2, idc);
								}
								
							}
							
							idList.add(person);
						}
					}
				}
			}
			
			
			
			
			reader = new BufferedReader(new FileReader(file));
			String tstr2 = null;
			int count2 = 0;
			int numfa = 0;
			boolean fam = false;
			
			
			//Below is our Families' List making. 
			
			while((tstr2 = reader.readLine()) != null){
				count2++;
				if(count2 == 1){//This part is used to eliminate BOM.
					tstr2 = tstr2.substring(3);
				}
				sarr2 = tstr2.split(" ");
				
				
				String sub2, marr, wid, hid, cid, idc, ids = null;
				String[] date2 = new String[10];
				
				
				if(sarr2[0].equals("0")){
					if((sarr2.length == 3) && !(sarr2[1].equals("NOTE")) && sarr2[2].equals("FAM")){
						if(fam == false){
							fam = true;
						}
					
					numfa++;
					List<String> family = new ArrayList<String>(8);
					idstr2 = sarr2[1].substring(1, sarr2[1].length() - 1);
					if(st == true){
						family.add(idShorten(idstr2, len, idDictionary));
					}
					else{
						family.add(idstr2);
					}
					family.add("NA");
					family.add("NA");
					family.add("NA");
					family.add("NA");
					family.add("NA");
					family.add("NA");
					family.add("NA");
					
					faList.add(family);
					
					}
					else{
						fam = false;
					}
				}
				
				if(fam == true){
					
					if(sarr2[1].equals("MARR")){
						date2 = reader.readLine().split(" ");
						marr = dateformat(date2[2], date2[3], date2[4]);
						faList.get(numfa).set(1, marr);
					}
					else if(sarr2[1].equals("DIV")){
						date2 = reader.readLine().split(" ");
						marr = dateformat(date2[2], date2[3], date2[4]);
						faList.get(numfa).set(2, marr);
					}
					else if(sarr2[1].equals("HUSB")){
						hid = sarr2[2].substring(1, sarr2[2].length() - 1);
						if(st == true){
							faList.get(numfa).set(3, idDictionary.get(hid));
						}
						else{
							faList.get(numfa).set(3, hid);
						}
					}
					else if(sarr2[1].equals("WIFE")){
						wid = sarr2[2].substring(1, sarr2[2].length() - 1);
						if(st == true){
							faList.get(numfa).set(5, idDictionary.get(wid));
						}
						else{
							faList.get(numfa).set(5, wid);
						}
					}
					else if(sarr2[1].equals("CHIL")){
						cid = sarr2[2].substring(1, sarr2[2].length() - 1);
						if(st == true){
							cid = idDictionary.get(cid);
						}
						if(faList.get(numfa).get(7).equals("NA")){
							faList.get(numfa).set(7, "{'" + cid + "'}");
						}
						else{
							faList.get(numfa).set(7, faList.get(numfa).get(7).substring(0, faList.get(numfa).get(7).length() - 2) + ", '" + cid + "'}");
							continue;
						}
					}
				}
			}
			
			
			reader.close();
        } 
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try{
					reader.close();
				}
				catch (IOException e1){
					e1.printStackTrace();
				}
			}
		}
		
		
		
		
		//To complete the Families' List, look up the husband's and the wife's name in Individuals's List.
		
		for(int i = 1; i < faList.size(); i++){
			String hid, wid;
			String hname = null;
			String wname = null;
			hid = faList.get(i).get(3);
			wid = faList.get(i).get(5);

			for(int j = 1; j < idList.size(); j++){
				if(idList.get(j).get(0).equals(hid)){
					hname = idList.get(j).get(1);
				}
				if(idList.get(j).get(0).equals(wid)){
					wname = idList.get(j).get(1);
				}
			}
			faList.get(i).set(4, hname);
			faList.get(i).set(6, wname);
		}
		

		
		
		//If chosen, to switch long id to short id in column Child & Spouse of Individuals' List.
		
		if(st == true){
		
			for(int i = 1; i < idList.size(); i++){
				String ts1, ts2 = null;
				int idx = 0;
				
				
				ts1 = idList.get(i).get(7);
				if((idx = ts1.indexOf("F")) != -1){
					idx = -1;
					while((idx = ts1.substring(idx + 1).indexOf("F")) != -1){
						if(ts2 == null){
							ts2 = "{'" + idDictionary.get(ts1.substring(idx, (ts1.substring(idx).indexOf("'") + idx))) + "'}";
						}
						else{
							ts2 = ts2.substring(0, ts2.length() - 2) + ", " + idDictionary.get(ts1.substring(idx, (ts1.substring(idx).indexOf("'") + idx))) + "'}";
						}
					}	
				}
				else{
					ts2 = ts1;
				}
				
				idList.get(i).set(7, ts2);
				
				ts1 = idList.get(i).get(8);
				ts2 = null;
				idx = 0;
				
				
				if((idx = ts1.indexOf("F")) != -1){
					idx = 0;
					while(ts1.substring(idx).indexOf("F") != -1){
						idx = ts1.substring(idx).indexOf("F") + idx;
						if(ts2 == null){
							ts2 = "{'" + idDictionary.get(ts1.substring(idx, (ts1.substring(idx).indexOf("'") + idx))) + "'}";
							idx = ts1.substring(idx).indexOf("'") + idx;
						}
						else{
							ts2 = ts2.substring(0, ts2.length() - 2) + "', '" + idDictionary.get(ts1.substring(idx, (ts1.substring(idx).indexOf("'") + idx))) + "'}";
							idx = ts1.substring(idx).indexOf("'") + idx;
						}
					}	
				}
				else{
					ts2 = ts1;
				}
				
				idList.get(i).set(8, ts2);
				
			}
		}
		
		
		
		allList.add(idList);
		allList.add(faList);
		
		
		return allList;
	}
	
	
	public static String dateformat(String day, String mt, String yr){
		String mday = day, mmt = mt;
		if(Integer.parseInt(day) < 10){
			mday = "0" + day;
		}
		switch (mt){
			case "JAN" : mmt = "01"; break;
			case "FEB" : mmt = "02"; break;
			case "MAR" : mmt = "03"; break;
			case "APR" : mmt = "04"; break;
			case "MAY" : mmt = "05"; break;
			case "JUN" : mmt = "06"; break;
			case "JUL" : mmt = "07"; break;
			case "AUG" : mmt = "08"; break;
			case "SEP" : mmt = "09"; break;
			case "OCT" : mmt = "10"; break;
			case "NOV" : mmt = "11"; break;
			case "DEC" : mmt = "12"; break;
			default : break;
		}
		
		return (yr + "-" + mmt + "-" + mday);
	}
	
	
	public static String idShorten(String id, int len, Map<String, String> idexist){
			String idnew = id.substring(0, 1) + id.substring(id.length() - len, id.length());
			boolean isExist = false;
			while(true){
				
				for(String key : idexist.keySet()){
					if(idexist.get(key).equals(idnew)){
						isExist = true;
						idnew = idnew.substring(0, 1) + String.valueOf((int)((Integer.parseInt(idnew.substring(1)) + 1)%(Math.pow(10.0, (double)len))));
						break;
					}
					else{
						isExist = false;
					}
				}
				
				
				if(isExist == false){
					idexist.put(id, idnew);
					break;
				}
			}
			
			return idnew;
	}
	
	
	
	
	
}