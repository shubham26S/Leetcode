class PaintingFence{
	public static void main(String[] args) {
		System.out.println(paintFence(5, 3));
	}
	static int paintFence(int n, int k){
		if(n == 0 || k == 0 || (k == 1 && n >= 3)){
			return 0;
		}
		int w1 = k;
		int w2 = k*k;
		int w3;
		if(n == 1){
			return w1;
		}
		if(n== 2){
			return w2;
		}
		for(int i = 3 ; i <= n; i++){
			w3 = (k-1)*(w1+w2);
			w1 = w2;
			w2 = w3;
		}
		return w2;
	}
}