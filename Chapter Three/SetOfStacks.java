import java.util.*;


public class SetOfStacks{
	public static void main(String args[]){
		SetStacks ss = new SetStacks(3);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		System.out.println(ss.pop());
	}
}

class SetStacks{
	ArrayList<Stack<Integer>> arStacks;
	int StackSize;
	SetStacks(int n){
		StackSize = n;
		arStacks = new ArrayList<Stack<Integer>>();
	}
	void push(int v){
		Stack<Integer> last = GetLastStack();
		if(last==null && !isFull(last)){
			last.push(v);
		}
		else{
			Stack<Integer> s = new Stack<Integer>();
			s.push(v);
			arStacks.add(s);
		}
	}
	Integer pop(){
		Stack<Integer> last = arStacks.get(arStacks.size()-1);
		if(last==null){
			System.out.println("Stack empty!");
			return null;
		}
		int v = last.pop();
		if(last.size()==0){
			arStacks.remove(arStacks.size()-1);
		}
		return v;
	}
	Stack<Integer> GetLastStack(){
		if(arStacks.isEmpty()){
			return new Stack<Integer>();
		}
		else{
			int index = arStacks.size();
			return arStacks.get(index-1);
		}
	}
	boolean isFull(Stack<Integer> last){
		if(last==null){
			return false;
		}
		return StackSize==last.size();
	}

}