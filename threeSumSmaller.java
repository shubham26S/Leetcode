import java.util.*;
public class threeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
    	Arrays.sort(nums);
    	int count = 0;
    	for(int i = 0 ; i < nums.length -2; i++){
    		int start = i+1;
    		int end = nums.length -1;
    		while(start < end){
    			int sum = nums[i] + nums[start] + nums[end];
    			if(sum >= target){
    				end--;
    			}
    			else{
    				count+=end - start;
    				start++;
    			}
    		}
    	}
    	return count;
    }
    public static void main(String args[]){
    	int[] arr = {0,1,-2,3, -3};
    	System.out.println(threeSumSmaller(arr, 2));
    }
}