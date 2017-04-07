import java.util.*;
public class SortStack{
	
	public static void sorting(Stack<Integer> s){
		//System.out.println("LOL");
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp =s.pop();
			while(!r.isEmpty() && r.peek()>temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		while(!r.isEmpty()){
			s.push(r.pop());
		}
	}

	public static void main(String args[]){
		//SortingStack s = new SortingStack();
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(1);
		sorting(s);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}


