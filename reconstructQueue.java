//406. Queue Reconstruction by Height
import java.util.*;
public class reconstructQueue{
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
        Arrays.sort(people, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] == b[0]){
                   return a[1] - b[1];
               }
               return b[0] - a[0];
           } 
        });
        ArrayList<int[]> arr = new ArrayList<>();
        for(int[] cur : people){
            if(cur[1] >= arr.size()){
                arr.add(cur);
            }
            else{
                arr.add(cur[1], cur);
            }
        }
        return arr.toArray(new int[people.length][]);
    }
}