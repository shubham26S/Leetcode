import java.util.*;
import java.lang.*;
class BalancedTree{
	static class TNode {
		TNode left;
		TNode right;
		int val;
		public TNode(int val)
		{
			this.val = val;
			right= null;
			left = null;
		}
	}	

	public static void main(String[] args) {
		TNode a = new TNode(1);
		a.left = new TNode(2);
		a.right = new TNode(3);
		a.left.left = new TNode(4);
		a.right.left = new TNode (5);
		a.right.left.left = new TNode(6);
		// System.out.println(height(a));
		System.out.println(isBalanced(a));
	}
	static int heightUtil(TNode root) {
		if(root == null){
			return 0;
		}
		int l = heightUtil(root.left);
		if(l == -1){
			return -1;
		}
		int r = heightUtil(root.right);
		if(r == -1){
			return -1;
		}
		if(l - r< -1 || l - r > 1){
			return -1;
		}
		return Math.max(l,r)+1;
	}
	static boolean isBalanced(TNode root){
		if(root == null){
			return true;
		}
		if(heightUtil(root) == -1){
			return false;
		}
		return true;
	}
}
