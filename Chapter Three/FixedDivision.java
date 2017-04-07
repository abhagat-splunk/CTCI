public class FixedDivision{
	public static void main(String args[]){
		ArrayStack as = new ArrayStack(3,3);
		as.push(1,0);
		as.push(2,0);
		as.push(3,0);
		as.push(4,0);
		as.push(4,1);
		as.push(5,1);
		as.push(6,1);
		as.push(7,2);
		as.push(8,2);
		as.push(9,2);
		System.out.println(as.pop(0));
		System.out.println(as.pop(0));
		System.out.println(as.pop(0));
		System.out.println(as.pop(0));
		System.out.println(as.pop(1));
		System.out.println(as.pop(2));
	}
}

class ArrayStack{
	private int[] values;
	private int[] sizes;
	private int stackSize;
	private int numberOfStacks;
	ArrayStack(int ss, int number){
		this.stackSize = ss;
		this.numberOfStacks = number;
		values = new int[this.numberOfStacks*this.stackSize];
		sizes = new int[this.numberOfStacks];
	}
	void push(int number, int stackNumber){
		if(isFull(stackNumber)){
			System.out.println("Stack out of space!");
		}
		else{
			this.sizes[stackNumber]+=1;
			this.values[indexOfTop(stackNumber)] = number;	
		}
		
	}
	
	int pop(int stackNumber){
		if(isEmpty(stackNumber)){
			System.out.println("Empty stack!");
			return -1;
		}
		int topIndex = indexOfTop(stackNumber);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNumber]-=1;
		return value;
	}

	boolean isFull(int stackNumber){
		return sizes[stackNumber]==stackSize;
	}

	boolean isEmpty(int stackNumber){
		return sizes[stackNumber]==0;
	} 

	int peek(int stackNumber){
		if(isEmpty(stackNumber)){
			System.out.println("Empty stack!");
		}
		else{
			return values[indexOfTop(stackNumber)];
		}
		return -1;
	}

	int indexOfTop(int stackNumber){
		int offset = stackNumber*stackSize;
		int size = sizes[stackNumber];
		return offset+size-1;
	}
}