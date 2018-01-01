import java.util.*;

class ValidateBST{
	static class Node{
		Node left, right;
		int val;
		public Node(int val){
			this.val = val;
			left = null;
			right = null;
		}
	};
	public static void main(String[] args) {
		Node a = new Node (2);
		a.left = new Node(1);
		a.right = new Node(3);
		// a.left.left = new Node(-5);
		// a.right.right = new Node(8);
		// a.right.left = new Node(5);
		// a.right.left.right = new Node(9);
		System.out.println(isValidBST(a));
	}
	static boolean isValidBST(Node root){
		return BSTUtil(root, null, null);
	}
	static boolean BSTUtil(Node root, Integer min, Integer max){
		if(root == null){
			return true;
		}
		if((min != null && root.val <= min) || (max != null && root.val >= max)){
			return false;
		}
		if(!BSTUtil(root.left, min, root.val) || !BSTUtil(root.right, root.val, max)){
			return false;
		}
		return true;
	}
	static Integer lastVal = null;
		
	static boolean inOrderBSTValid(Node root){
		if(root == null){
			return true;
		}
		if(!inOrderBSTValid(root.left)){
			return false;
		}
		if(lastVal != null && lastVal >= root.val){
			return false;
		}
		lastVal = root.val;
		if(!inOrderBSTValid(root.right)){
			return false;
		}
		return true;
	}
}