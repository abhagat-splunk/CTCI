import java.util.*;
public class StackMinimum{
	
	public static void main(String args[]){
		StackMin sm = new StackMin();
		sm.push(3);
		sm.push(2);
		sm.push(9);
		sm.push(10);
		System.out.println(sm.min());

		StackMinEfficient sme = new StackMinEfficient();
		sme.push(4);
		sme.push(2);
		sme.push(3);
		sme.push(1);
		System.out.println(sme.min());
		System.out.println(sme.pop());
		System.out.println(sme.min());	
	}
}


class StackMinEfficient extends Stack<Integer>{
	Stack<Integer> s2;
	StackMinEfficient(){
		s2 = new Stack<Integer>();
	}
	public void push(int x){
		if(x<min()){
			s2.push(x);
		}
		super.push(x);
	}

	public Integer pop(){
		int value = super.pop();
		if(value==min()){
			s2.pop();
		}
		return value;
	}

	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else{
			return s2.peek();
		}
	}
}




class StackMin extends Stack<NodeWithMin>{
	public void push(int value){
		int newMin = Math.min(value,min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min(){
		if(isEmpty()){
			return Integer.MAX_VALUE;
		}
		else{
			return peek().min;
		}
	}
}

class NodeWithMin{
	public int val,min;
	NodeWithMin(int v, int n){
		val = v;
		min = n;
	}
}
