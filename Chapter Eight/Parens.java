import java.util.*;
public class Parens{
	public static Set<String> generateParens(int remaining){
		Set<String> set = new HashSet<String>();
		if(remaining==0){
			set.add("");
		}
		else{
			Set<String> prev = generateParens(remaining-1);
			for(String pre: prev){
				for(int i=0;i<pre.length();i++){
					if(pre.charAt(i)=='('){
						String s = insertInside(pre,i);
						set.add(s);//Checked for duplicates
					}
				}
				set.add("()"+pre);
			}
		}
		return set;
	} 
	public static String insertInside(String str, int leftIndex){
		String left = str.substring(0,leftIndex+1);
		String right = str.substring(leftIndex+1,str.length());
		return left+"()"+right;
	}
	public static void main(String args[]){
		Set<String> set = generateParens(3);
		for(String str:set){
			System.out.println(str);
		}
	}
}