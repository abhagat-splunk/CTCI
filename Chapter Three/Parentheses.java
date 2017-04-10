import java.util.*;
public class Parenteses{
	public static boolean find(char[] array, Stack<Character> stack){
		for(char c: array){
			if(c=='{'||c=='['||c=='('){
				stack.push(c);
			}
			else{
				if(c=='}'){
					if(stack.peek()!='{'){
						return false;
					}
					stack.pop();
				}
				if(c==')'){
					if(stack.peek()!='('){
						return false;
					}
					stack.pop();
				}
				if(c==']'){
					if(stack.peek()!='['){
						return false;
					}
					stack.pop();
				}
			}
		}
		return true;
	}
	public static void main(String args[]){
		String str = "(()[{()}])";
		char[] strToArray = str.toCharArray();
		for(char c: strToArray){
			System.out.println(c);
		}
		if(strToArray.length%2==0){
			Stack<Character> stack = new Stack<Character>();
			System.out.println(find(strToArray,stack));
		}
		else{
			System.out.println("Not balanced!");
		}
		
	}
}