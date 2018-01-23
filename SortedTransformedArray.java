import java.util.*;
class SortedTransformedArray{
	public static long[] SortTransformedArray( int[] nums, int A, int B, int C) {
		long[] res = new long[nums.length];
		if(nums == null || nums.length == 0 || (A == 0 && B == 0 && C == 0) ){
			return res;
		}

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 0 ; i < res.length; i++){
			int num = A*nums[i]*nums[i] + B*nums[i] + C;
			q.add(num);
		}
		int count = 0;
		while(!q.isEmpty()){
			res[count++] = q.poll();
		}
		return res;
	}
	public static long[] sol2(int[] nums, int A, int B, int C){
		long[] res = new long[nums.length];
		if(nums == null || nums.length == 0 || (A == 0 && B == 0 && C == 0) ){
			return res;
		}
		if(A == 0){
			for(int i = 0 ; i < nums.length; i++){
				long n = (long)nums[i];
				res[i] = n*((long)B) + (long)C;
			}
		}
		else if(A > 0){
			int start = 0;
			int end = nums.length-1;
			int pos = nums.length-1;
			while(start <= end){
				double derivative = (double)-B / (2*((double)A));
				long n = 0;
				if(Math.abs(derivative - (double)nums[start]) > Math.abs(derivative - (double)nums[end])){
					n = (long)nums[start++];
				}
				else n = (long)nums[end--];
				res[pos--] = A*n*n + n*B + C;
			}
		}
		else{
			int start = 0;
			int end = nums.length-1;
			int pos = 0;
			while(start <= end){
				double derivative = (double)-B / (2*((double)A));
				long n = 0;
				if(Math.abs(derivative - (double)nums[start]) > Math.abs(derivative - (double)nums[end])){
					n = (long)nums[start++];
				}
				else n = (long)nums[end--];
				res[pos++] = A*n*n + B*n + C;
			}	
		}
		return res;
	}
	public static void main(String[] args) {
		// long[] res = SortTransformedArray(new int[]{-4, -2,2,4}, 1,3,5);
		long[] res = sol2(new int[]{-4, -2,2,4}, -1,3,5);
		for(long l : res){
			System.out.println(l);
		}
	}
}