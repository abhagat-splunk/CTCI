public class MakeChanges{
	public static int MakeChanges(int amount, int[] denom, int index){
		if(index>= denom.length-1){
			return 1;
		}
		int denomAmount = denom[index];
		int ways = 0;
		for(int i=0;i*denomAmount<=amount;i++){
			int amountRemaining = amount - (i*denomAmount);
			ways+=MakeChanges(amountRemaining,denom,index+1);
		}
		return ways;
	}

	public static int countWays(int n){
		int[] denom = {25,10,5,1};
		return MakeChanges(n,denom,0);
	}


	public static int countWaysOptimized(int n){
		int[] denom = {25,10,5,1};
		int[][] map = new int[n+1][denom.length];
		return makeChanges(n,denom,0,map);
	}

	public static int makeChanges(int amount, int[] denom, int index, int[][] map){
		if(map[amount][index]>0){
			return map[amount][index];
		}
		if(index>=denom.length-1){
			return 1;
		}
		int denomAmount = denom[index];
		int ways = 0;
		for(int i=0;i*denomAmount<=amount;i++){
			int amountRemaining = amount - (i*denomAmount);
			ways+=makeChanges(amountRemaining,denom,index+1,map);
		}
		map[amount][index] = ways;
		return ways;
	}
	public static void main(String args[]){
		System.out.println(countWays(100));
		System.out.println(countWaysOptimized(100));
	}
}