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


	public static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index){
		if(leftRem<0||rightRem<leftRem){
			return;
		}
		if(leftRem==0 && rightRem==0){
			list.add(String.copyValueOf(str));
		}else{
			str[index] = '(';
			addParen(list,leftRem-1,rightRem,str,index+1);
			str[index] = ')';
			addParen(list,leftRem,rightRem-1,str,index+1);	
		}
	}

	public static ArrayList<String> generateParen(int count){
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list,count,count,str,0);
		return list;
	}


	public static void main(String args[]){
		Set<String> set = generateParens(3);
		ArrayList<String> al = generateParen(4);
		for(String str:set){
			System.out.println(str);
		}
		for(String str:al){
			System.out.println(str);
		}
	}
}