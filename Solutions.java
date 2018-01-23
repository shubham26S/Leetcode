import java.util.*;
import java.math.*;
class Solutions{
	static int maxsize = 0;
	public static void main(String[] args) {
		Node a = new Node(6);
		// a.left = new Node(4);
		a.right = new Node(9);
		a.right.left = new Node(7);
		a.right.right = new Node(10);
		a.right.right.right = new Node(11);
		// a.left.left.right = new Node(61);
		// a.left.right = new Node(2);
		// a.left.right.left = new Node(4);
		// a.left.right.right = new Node(3);
		//System.out.println("inOrder");
		// inOrder(a);
		// System.out.println("preOrder");
		// preOrder(a);
		// System.out.println("Iterative Post Order");
		// postOrderIterative(a);
		// movingWindow obj = new movingWindow(3);
		// System.out.println(obj.next(5));
		// System.out.println(obj.next(10));
		// System.out.println(obj.next(1));
		// System.out.println(obj.next(12));
		// System.out.println(obj.next(3));
		// longestSequence(a.left, a.val, 1);
		// longestSequence(a.right, a.val, 1);
		// System.out.println(maxsize);
		// String[] s = {"hello", "world"};
		// System.out.println(wordsTyping(s,2,8));
		// char[][] grid = {{'0', 'E','0','0'}, {'E','0','W','E'}, {'0','E','0','0'}};
		// System.out.println(maxKilledEnemies(grid));
		// int[] val =  {0, 1, 3, 50, 75};
		// System.out.println(findMissingRanges(val,0,99));
		// String[] arr = {"abc","123"};
		// System.out.println(addBoldTag("abcxyz123",arr));
		int[] warr = {1, 1, 1, 3, 3, 3, 2, 2, 2};
		wiggleSort(warr);
		for(int i: warr){
			System.out.println(i);
		}
	}
	static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.println(root.val);
			inOrder(root.right);
		}
	}
	static void preOrder(Node root){
		if(root != null){
			System.out.println(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	static void postOrderIterative(Node root){
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		if(root != null){
			s1.add(root);
		}
		while(!s1.isEmpty()){
			Node tmp = s1.pop();
			if(tmp.left != null){
				s1.push(tmp.left);
			}
			if(tmp.right != null){
				s1.push(tmp.right);
			}
			s2.push(tmp);
		}
		while(!s2.isEmpty()){
			Node tmp = s2.pop();
			System.out.println(tmp.val);
		}
	}
	static ArrayList<Integer> postOrderOneStack(Node root){
		Stack<Node> s = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		s.push(root);
		Node prev = null;
		while(!s.isEmpty()){
			Node curr = s.peek();
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left != null){
					s.push(curr.left);
				}
				else if(curr.right != null){
					s.push(curr.right);
				}
				else{
					s.pop();
					list.add(curr.val);
				}
			}
			else if(curr.left == prev){
				if(curr.right != null){
					s.push(curr.right);
				}
				else{
					s.pop();
					list.add(curr.val);
				}
			}
			else if(curr.right == prev){
				s.pop();
				list.add(curr.val);
			}
			prev =curr;
		}
		return list;
	}
//Leetcode:298 Binary Tree Longest Consecutive Sequence
	static	void longestSequence(Node n, int val, int size){
		// if(size > maxsize){
		// 	maxsize = size;
		// }
		if(n == null){
			return;
		}
		if(n.val == val+1){
			if(size+1 > maxsize){
				maxsize = size+1;
			}
			System.out.println("Child " +n.val);
			if(n.left != null){
				longestSequence(n.left, n.val, size+1);
			}
			if(n.right != null){
				longestSequence(n.right, n.val, size+1);
			}
		}
		else{
			if(n.left != null){
				longestSequence(n.left, n.val, 1);
			}
			if(n.right != null){
				longestSequence(n.right, n.val, 1);
			}
		}
	}

//418 LeetCode Sentence Screen Fitting
	static public int wordsTyping(String[] sentence, int rows, int cols) {
		int r = 0;
		int i = 0;
		int left = cols;
		int times = 0;
		while(r < rows && left >= 0){
			while(left >= sentence[i].length()){
				left = left - sentence[i].length() - 1;
				if(i == sentence.length-1){
					times++;
				}
				i = (i+1)%(sentence.length);

			}
			r++;
			left = cols;

		}
		return times;
	}
	//Another Solution
// public int wordsTyping(String[] sentence, int rows, int cols) {
//         String all = "";
//         for (String s : sentence) {
//             all += s + " ";
//         }
//         int pos = 0;
//         int len = all.length();
//         for (int i = 0; i < rows; i++) {
//             pos += cols;
//             if (all.charAt(pos % len) == ' ') {
//                 pos++;
//             } else {
//                 while (pos > 0 && all.charAt((pos - 1) % len) != ' ') {
//                     pos--;
//                 }
//             }
//         }
//         return pos / len;
//     }
	//361 Bomb Enemy
 public static int maxKilledEnemies(char[][] grid) {
 		int rows = grid.length;
 		int cols = grid[0].length;
 		if(rows == 0){
 			return 0;
 		}
 		int maxVal = 0;
 		for(int i = 0 ; i < rows; i++){
 			for(int j = 0 ; j < cols; j++){
 				if(grid[i][j] == '0'){
 					maxVal = Math.max(maxVal, colVal(grid, j) + rowVal(grid, i));
 				}
 			}
 		}
 		return maxVal;
	}
	static int colVal(char[][] grid, int col){
		int val = 0;
		int row = grid.length;
		int ptr = 0;
		while(ptr < row){
			if(grid[ptr][col] == 'E'){
				val++;
			}
			else if(grid[ptr][col] == 'W'){
				break;
			}
			ptr++;
		}
		return val;
	}
	static int rowVal(char[][] grid, int row){
		int val = 0;
		int col = grid[0].length;
		int ptr = 0;
		while(ptr < col){
			if(grid[row][ptr] == 'E'){
				val++;
			}
			else if(grid[row][ptr] == 'W'){
				break;
			}
			ptr++;
		}
		return val;
	}

//163 Missing Range
	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ls = new ArrayList<>();
		
		if(vals.length == 0){
			ls.add(Integer.toString(start)+"->"+Integer.toString(end));
			return ls;
		}
		if(vals.length == end-start+1){
			return ls;
		}

		int prev = start -1;
		for (int i = 0 ; i <= vals.length;i++){
			int cur = i == vals.length ? end+1 : vals[i];
			if(cur - prev >=2){
				if(cur-1 == prev+1){
					ls.add(Integer.toString(prev+1));
				}
				else{
					ls.add(Integer.toString(prev+1) +"->" + Integer.toString(cur-1));
				}
			}
			prev = cur;
		}
		// while(fast < vals.length){
		// 	if(vals[fast] > vals[start]){
		// 		if(vals[fast] - vals[start] == 2){
		// 			ls.add(Integer.toString(start+1));
		// 		}
		// 		else if(vals[fast] - vals[start] > 2){
		// 			String temp = "";
		// 			if(fast == 0) {
		// 				temp = Integer.toString(vals[start]) + "->"+Integer.toString(vals[fast]-1);
		// 			}
		// 			else {
		// 				temp = Integer.toString(vals[start]+1) + "->"+Integer.toString(vals[fast]-1);
		// 				}
		// 			ls.add(temp);
		// 		}
		// 		start = fast;
		// 		fast = fast+1;
		// 	}
		// 	else{
		// 		start =fast;
		// 		fast = fast+1;	
		// 	}
		// 	if(fast == vals.length -1 && vals[fast] < end){
		// 		if(vals[fast] - vals[fast-1] == 2){
		// 			ls.add(Integer.toString(vals[fast]+1));
		// 		}
		// 		else{
		// 			String temp = Integer.toString(vals[fast]+1) + "->"+Integer.toString(end);
		// 			ls.add(temp);	
		// 		}
		// 	}
		// }
		return ls;
	}


	//616 Add bold tag
	static String addBoldTag(String s, String[] ls){
		if(s.length() == 0 || ls.length == 0){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		boolean[] bold = new boolean[s.length()];
		for(String str : ls){
				for(int i = 0; i<= s.length() - str.length(); i++){
					if(s.substring(i,i+str.length()).equals(str)){
						for(int j = i ; j < i+str.length();j++){
							bold[j] = true;
						}
					}
				}
			}
			for(int i = 0; i < bold.length;){
				if(bold[i]){
					sb.append("<br>");
					while(i < s.length() && bold[i]){
						sb.append(s.charAt(i));
						i++;
					}
					sb.append("</br>");
				}
				else{
					sb.append(s.charAt(i++));
				}
			}

		return sb.toString();
	}

	//271 - Encode-Decode-String
	public List<String> decode(String s) {
		LinkedList<String> ls = new LinkedList<>();
		if(s.length() == 0){
			return ls;
		}
		int start = 0;
		int end = 0;
		while(end < s.length()){
			if(s.charAt(end) == '#'){
				int len = Integer.valueOf(s.substring(start, end));
				String res = s.substring(end+1, end+1+len);
				ls.add(res);

				start = end+1+ len;
				end= start;
			}
			end++;
		}
		return ls;
	}
	public String encode(List<String> strs) {
		if(strs.size() == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(String s : strs){
			int count = s.length();
			sb.append(count).append("#").append(s);
		}
		return sb.toString();

	}
// 288 Unique Word Abbreviation
	static HashMap<String, String> map;
	public void ValidWordAbbr(String[] dict) {
		map = new HashMap<>();

		for(String s: dict){
			String temp = getKey(s);
			if(map.containsKey(temp)){
				if(!map.get(temp).equals(s)){
					map.put(temp,"");
				}
			}
			else map.put(temp, s);
		}
	}
	static String getKey(String s){
		if(s.length() > 2){
				StringBuilder sb = new StringBuilder();
				sb.append(s.charAt(0)).append(s.length()-2).append(s.charAt(s.length()-1));
				return sb.toString();
			}
		return s;
	}
	static boolean isUnique(String word){
		String s = getKey(word);
		if(!map.containsKey(s) || map.get(s).equals(word)){
			return true;
		}
		return false;
	}

	static void wiggleSort(int[] arr){
		if(arr.length == 0){
			return;
		}
		for(int i = 0 ; i < arr.length -1; i++){
			if(i % 2 == 0){
				if(arr[i] > arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			else{
				if(arr[i] < arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}



}
class Node{
	int val;
	Node left;
	Node right;
	Node(int val){
		this.val = val;
		left = null;
		right = null;
	}
}

//Leetcode 346
class movingWindow{
	int size;
	Queue<Integer> q;
	double sum;

	public movingWindow(int size){
		q = new LinkedList<>();
		this.size = size;
		sum = 0;		
	}
	double next(int val){
		if(q.size() >= size){
			sum -= q.remove();
		}
		sum += val;
		q.add(val);
		return sum / q.size();
	}
}
//281 Zig Zag iterator
class ZigzagIterator {
	 List<Integer> v1;
	 List<Integer> v2;
	 int i;
	 int j;
	 boolean isFirstList;
	 public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	 	this.v1 = v1;
	 	this.v2 = v2;
	 	i = 0; j = 0;
	 	isFirstList = true;
	 }
	 int next(){
	 	int res = 0;
	 	if(i >= v1.size()){
	 		res = v2.get(j);
	 		j++;
	 	}
	 	else if(j >= v2.size()){
	 		res = v1.get(i);
	 		i++;
	 	}
	 	else{
	 		if(isFirstList){
	 			res = v1.get(i);
	 			i++;
	 			isFirstList = false;
	 		}
	 		else{
	 			res = v2.get(j);
	 			j++;
	 			isFirstList = true;
	 		}
	 	}
	 	return res;
	 }
	 boolean hasNext(){
	 	if(i < v1.size() || j < v2.size()){
	 		return true;
	 	}
	 	return false;
	 }
}