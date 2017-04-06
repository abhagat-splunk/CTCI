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


	public static ArrayList<String> getPerms(String str){
		int len = str.length();
		ArrayList<String> result = new ArrayList<String>();

		if(len==0){
			result.add("");
			return result;
		}
		for(int i=0;i<len;i++){
			String before = str.substring(0,i);
			String after = str.substring(i+1,len);
			ArrayList<String> partials = getPerms(before+after);
			for(String s: partials){
				result.add(str.charAt(i)+s);
			}
		}
		return result;
	}	


	public static ArrayList<String> getPer(String str){
		ArrayList<String> result = new ArrayList<String>();
		getPerms("",str,result);
		return result;
	}

	public static void getPerms(String prefix, String remainder, ArrayList<String> result){
		if(remainder.length()==0){
			result.add(prefix);
		}
		int len = remainder.length();
		for(int i=0;i<len;i++){
			String before = remainder.substring(0,i);
			String after = remainder.substring(i+1,len);
			char c = remainder.charAt(i);
			getPerms(prefix+c, before+after,result);
		}
	}



	public static void main(String args[]){
		String str = "ankit";
		ArrayList<String> arr = getPermutations(str);
		System.out.println(arr.size());
		// for(int i=0;i<arr.size();i++){
		// 	System.out.println(arr.get(i));
		// }
		ArrayList<String> arrTwo = getPer(str);
		for(int i=0;i<arr.size();i++){
			System.out.println(arrTwo.get(i));
		}
	}
}