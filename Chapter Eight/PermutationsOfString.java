import java.util.*;
public class PermutationsOfString{
	public static ArrayList<String> getPermutations(String str){
		if(str==null){
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length()==0){
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> Words = getPermutations(remainder);
		for(String word:Words){
			for(int j=0;j<=word.length();j++){
				String s = insertCharAt(word,first,j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word,char c, int i){
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start+c+end;
	}

	public static void main(String args[]){
		String str = "ankit";
		ArrayList<String> arr = getPermutations(str);
		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
	}
}