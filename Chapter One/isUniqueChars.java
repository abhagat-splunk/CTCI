import java.util.*;
public class UniqueChars{
	public static boolean isUnique(String str){
		if(str.length()>128){
			return false;
		}
		boolean[] char_set = new boolean[128];
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			else{
				char_set[val] = true;
			}
		}
		return true;
	}
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		isUnique(s);
	}
}