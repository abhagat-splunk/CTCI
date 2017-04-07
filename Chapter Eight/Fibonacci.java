public class Fibonacci{
	public static int fibonacci(int i){
		return fibonacci(i, new int[i+1]);
	}

	public static int fibonacci(int i, int[] arr){
		if(i==0||i==1){
			return i;
		}
		if(arr[i]==0){
			arr[i] = fibonacci(i-1,arr) + fibonacci(i-2,arr);
		}
		return arr[i];
	}

	public static int bottomUp(int i){
		if(i==0||i==1){
			return i;
		}
		int[] memory = new int[i];
		memory[0] = 0;
		memory[1] = 1;
		for(int x=2;x<i;x++){
			memory[x] = memory[x-1]+memory[x-2];
		}
		return memory[i-1]+memory[i-2];
	}
	public static void main(String args[]){
		int n = 6;
		System.out.println(fibonacci(n));
		System.out.println(bottomUp(n));
	}
}