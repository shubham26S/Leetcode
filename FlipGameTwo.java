import java.util.*;
class FlipGameTwo{
	public static void main(String[] args) {
		String s = "++++";
		System.out.println(FlipGame(s));

	}
	static boolean FlipGame(String s){
		if(s.length() == 0){
			return false;
		}
		HashMap<String, Boolean> map = new HashMap<>();
		return flipgamesHashMap(s, map);
		// return FlipGameUtil(s);
	}
	static boolean FlipGameUtil(String s){
		boolean secWin = true;
		for(int i = 0; i < s.length()-1; i++){
			if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i+1)){
				String opponent = s.substring(0,i)+"--"+s.substring(i+2);
				// System.out.println(opponent);
				secWin = FlipGameUtil(opponent);
				if(!secWin){
					return true;
				}
			}
		}
	return false;
	}
	static boolean flipgamesHashMap(String s, HashMap<String, Boolean> map){
		if(map.containsKey(s)){
			return map.get(s);
		}
		for(int i = 0 ; i < s.length() -1; i++){
			if(s.charAt(i) == '+' && s.charAt(i) == s.charAt(i+1)){
				String opponent = s.substring(0,i)+"--"+s.substring(i+2);
				if(!flipgamesHashMap(opponent, map)){
					map.put(opponent, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}


}