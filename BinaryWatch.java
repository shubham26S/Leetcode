import java.util.*;
class BinaryWatch{
	public static void readBinaryWatch(int num) {
        List<String> ls = new LinkedList<>();
        if(num == 0){
            return ;
        }
        for(int i = 0 ; i <= 4 ; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(1<<i)).append(':');
            System.out.println(sb);
            for(int j = i; j <= num-i; j++){
                sb.append(Integer.toString(1<<j));
            }
        	System.out.println(sb);
        }
        
    }
    public static void main(String[] args) {
    	readBinaryWatch(1);
    }
}