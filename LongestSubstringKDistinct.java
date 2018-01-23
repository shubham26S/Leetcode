import java.util.*;
class LongestSubstringKDistinct{
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("abcadcacacaca",3));
	}
	// public static int lengthOfLongestSubstringKDistinct(String str, int k){
	// 	int[] count = new int[256];
	// 	int j = 0 ;
	// 	int num = 0;
	// 	int res = 0;
	// 	for(int i = 0 ; i < str.length(); i++){
	// 		if(count[str.charAt(i)] == 0){
	// 			count[str.charAt(i)]++;
	// 			num++;
	// 		}
	// 		while(num > k && j < str.length()){
	// 			count[str.charAt(j)]--;
	// 			if(count[str.charAt(j)] == 0){
	// 				num--;
	// 			}
	// 			j++;
	// 		}
	// 		res = Math.max(res, i-j+1);
	// 	}
	// 	return res;
	// }
	//solution2
	public static int lengthOfLongestSubstringKDistinct(String str, int k){
		HashMap<Character, Integer> map = new HashMap<>();
		int res = 0;
		int lowerIndex = 0;
		for(int i = 0 ; i < str.length(); i++){
			if(!map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), 1);
			}
			else map.put(str.charAt(i), map.get(str.charAt(i))+1);
			if(map.size() > k){
				map.put(str.charAt(lowerIndex), map.get(str.charAt(lowerIndex))-1);
				if(map.get(str.charAt(lowerIndex)) == 0){
					map.remove(str.charAt(lowerIndex));
				}
				lowerIndex++;
			}
			res = Math.max(res, i-lowerIndex +1); 
		}
		return res;
	}
}