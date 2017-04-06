import java.util.*;
public class CheckPermutation{
	public static String sorting(String s1){
		char[] content = s1.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content); 
	}

	public static boolean isPermutation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		return(sorting(s1).equals(sorting(s2)));
	}


	public static boolean optimizedIsPermutation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}

		int[] characters = new int[128];
		for(char c: s1.toCharArray()){
			characters[c]+=1;
		}

		for(int i=0;i<s2.length();i++){
			int c  = Integer.parseInt(s2.charAt(i));
			letters[c]--;
			if(letters[c]<0){
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]){
		String s1 = "ankit";
		String s2 = "tikna";
		System.out.println(isPermutation(s1,s2));
	}
}