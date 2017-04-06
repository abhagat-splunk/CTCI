import java.util.*;
public class TripleStep{
	public static int countSteps(int n){
		int[] memory = new int[n+1];
		Arrays.fill(memory,-1);
		return countWays(n,memory);
	}

	public static int countWays(int n, int[] memory){
		if(n<0){
			return 0;
		}
		else if(n==0){
			return 1;
		}
		else if(memory[n]!=-1){
			return memory[n];
		}
		else{
			memory[n] = countWays(n-1,memory)+countWays(n-2,memory)+countWays(n-3,memory);
			return memory[n];
		}
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countSteps(n));
	}
}