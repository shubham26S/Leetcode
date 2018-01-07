import java.util.*;
class FlipGame{
	public static void main(String[] args) {
		String s = "+-++++--++";
		List<String> ls = FlipGame(s);
		for(String l : ls){
			System.out.println(l);
		}
	}
	static List<String> FlipGame(String s){
		char[] arr = s.toCharArray();
		List<String> res = new ArrayList<>();
		if(arr.length == 0){
			return res;
		}
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == arr[i-1] && arr[i] == '+'){
				arr[i] = '-';
				arr[i-1] = '-';
				res.add(Arrays.toString(arr));
				arr[i] = '+';
				arr[i-1] = '+';
			}
		}
		return res;
	}
}