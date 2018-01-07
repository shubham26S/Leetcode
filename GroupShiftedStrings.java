import java.util.*;

class GroupShiftedStrings{
	public static void main(String[] args) {
		String[] arr = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> ls = groupStrings(arr);
		for(List l : ls){
			System.out.println(l);
		}
	}
	static public List<List<String>> groupStrings(String[] s) {
		List<List<String>> ls = new LinkedList<>();
		if(s == null || s.length == 0){
			return ls;
		}
		Arrays.sort(s, new Comparator<String>(){
			public int compare(String a, String b){
				if(a.length() == b.length()){
					return a.charAt(0)- b.charAt(0);
				}
				else{
					return a.length() - b.length();
				}
			}
		});
		// for(String k : s){
		// 	System.out.println(k);
		// }
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(String str : s){
			//System.out.println(getDiffString(str));
			String temp = getDiffString(str);
			if(!map.containsKey(temp)){
				map.put(temp, new ArrayList<String>());
			}
			map.get(temp).add(str);

		}
		return new ArrayList<List<String>>(map.values());
	}
	static String getDiffString(String str){
		String key = "";
		for(int i = 1; i < str.length(); i++){
			int diff = str.charAt(i) - str.charAt(i-1);
			key += diff > 0 ? diff : diff+26;
			key += ",";
		}
		return key;
	}
}