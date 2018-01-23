import java.util.*;
class MeetingRoomsTwo{
	public static void main(String[] args) {
		int[][] intervals = {{2,3},{0,4},{6,7},{0,9},{5,8}};
		System.out.println(count(intervals));
	}
	static int count(int[][] intervals){
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return a[0] - b[0];
			}
		});
		for(int[] i : intervals){
			System.out.println(i[0]+","+i[1]);
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(intervals[0][1]);
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i][0] >= q.peek()){
				q.poll();
			}
			q.offer(intervals[i][1]);

		}
		return q.size();
	}
}