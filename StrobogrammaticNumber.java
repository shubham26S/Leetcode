import java.util.*;
public class StrobogrammaticNumber{
	public static boolean StrobogrammaticNumber(String nums){
		HashMap<Character, Character> map = new HashMap<>();
		map.put('1','1');
		map.put('6','9');
		map.put('9','6');
		map.put('0','0');
		map.put('8','8');
		int start = 0;
		int end = nums.length()-1;
		while(start < end){
			if(!map.containsKey(nums.charAt(start)) || (map.get(nums.charAt(start)) != nums.charAt(end)))
			{
				return false;
			}
			end--;
			start++;
		}
		return true;
		// if(nums.length()== 0 || (nums.length() == 1 && (nums.equals(1) || nums.equals(8) || nums.equals(0)))){
		// 	return true;
		// }
		// StringBuilder sb = new StringBuilder(nums);
		// for(int i = 0 ; i < nums.length(); i++){
		// 	if(nums.charAt(i) == '2' || nums.charAt(i) == '4' || nums.charAt(i) == '3' || nums.charAt(i) == '7' || nums.charAt(i) == '5'){
		// 		return false;
		// 	}
		// 	if(nums.charAt(i) == '6'){
		// 		sb.replace(i,i+1, "9");
		// 	}
		// 	if(nums.charAt(i) == '9'){
		// 		sb.replace(i,i+1, "6");
		// 	}
			
		// }
		// sb.reverse();
		// String str2 = sb.toString();
		// System.out.println(str2);
		// if(!nums.equals(str2)){
		// 	return false;
		// }
		// return true;


	}
	public static void main(String [] args){
		String s = "916";
		System.out.println(StrobogrammaticNumber(s));
	}
}