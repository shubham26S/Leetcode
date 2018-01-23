import java.util.*;
class MeetingRoomsOne{
	public static void main(String[] args) {
		int[][] intervals = {{0,30}, {5,10}, {15, 20}};
		System.out.println(meeting(intervals));
	}
	static boolean meeting(int[][] intervals){
		if(intervals == null){
			return false;
		}
		Arrays.sort(intervals, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return a[1] - b[1];
			}
		});
		for(int[] i : intervals){
			System.out.println(i[0] +" "+i[1]);
		}
		for(int i = 1 ; i < intervals.length; i++){
			if(intervals[i-1][1] > intervals[i][0]){
				return false;
			}
		}
		return true;
	}
}