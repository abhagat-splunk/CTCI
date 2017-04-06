public class RecursiveMultiply{
	public static int minProduct(int a, int b){
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		int[] memory = new int[smaller+1];
		return minProduct(memory,smaller,bigger);
	}

	public static int minProduct(int[] memory, int smaller, int bigger){
		if(smaller==0){
			return 0;
		}
		if(smaller==1){
			return bigger;
		}
		else if(memory[smaller]>0){
			return memory[smaller];
		}
		int s = smaller>>1;
		int side1 = minProduct(memory,s,bigger);
		int side2 = side1;
		if(smaller%2==1){
			side2 = minProduct(memory,smaller-s,bigger);
		}
		memory[smaller] = side1+side2;
		return memory[smaller];
	}
	public static void main(String args[]){
		int x1 = 19;
		int x2 = 33;
		System.out.println(minProduct(x1,x2));
	}
}