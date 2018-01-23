import java.util.*;
class PalindromePermutation{
	public static void main(String[] args) {
		System.out.println(isPermutation("aab"));
	}
	static boolean isPermutation(String str){
		if(str == null || str.length() == 0){
			return false;
		}
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c: arr){
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		int count = 0;
		for(char key : map.keySet()){
			count += map.get(key)%2;
		}
		return count <= 1;
	}
}