import java.util.*;
class GeneralizedAbbreviation{
	public static void main(String[] args) {
		List<String> res = generateAbbreviations("word");
		for(String s: res){
			System.out.println(s);
		}
	}
	public static List<String> generateAbbreviations(String word) {
		List<String> ls = new ArrayList<>();
		dfs(ls, new StringBuilder(), word.toCharArray(), 0, 0);
		return ls;
	}
	static void dfs(List<String> res, StringBuilder sb, char[] word, int i, int num){
		int len = sb.length();
		if(i == word.length){
			if(num != 0){
				sb.append(num);
			}
			res.add(sb.toString());
		}
		else{
			dfs(res,sb, word, i+1, num+1);
			if(num != 0){
				sb.append(num);
			}
			dfs(res, sb.append(word[i]), word, i+1, 0);
		}
		sb.setLength(len);
	}
}