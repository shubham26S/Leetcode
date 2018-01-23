import java.util.*;
class KnightsTour{
	public static void main(String[] args) {
		tour();
	}
	static boolean isValid(int[][] chess, int x, int y){
		if(x >= 0 && x < chess.length && y >= 0 && y < chess[0].length && chess[x][y] == -1){
			return true;
		}
		return false;
	}
	static boolean tour(){
		int[][] chess = new int[8][8];
		for(int i = 0 ; i < 8; i ++){
			for(int j = 0 ; j < 8 ;j++){
				chess[i][j] = -1;
			}
		}
		chess[0][0] =0;
		int[] movex = {2, -2, 2, -2, 1, -1, 1, -1};
		int[] movey = {1, 1, -1, -1, 2, 2, -2, -2};
		if(!tourUtil(chess, movex, movey, 0, 0, 1)){
			return false;
		}
		else {
			for(int i = 0 ; i < chess.length; i++){
				for(int j = 0 ; j < chess[0].length; j++){
					System.out.print(chess[i][j]+" ");
				}
				System.out.println();
			}
		}
		return true;
	}
	static boolean tourUtil(int[][] chess, int[] movex, int[] movey, int x, int y,int movei){
		if(chess.length *chess[0].length == movei){
			return true;
		}
		for(int i = 0 ; i < 8; i++){
			int px = movex[i] + x;
			int py = movey[i] + y;
			if(isValid(chess, px, py)){
				chess[px][py] = movei;
				if(tourUtil(chess, movex, movey, px, py, movei+1)){
					return true;
				}
				else{
					chess[x][y] = -1;
				}
			}
		}
		return false;
	}
}