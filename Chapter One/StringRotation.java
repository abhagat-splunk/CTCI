public class StringRotation{
	public static boolean stringRotate(String s1, String s2){
		int len = s1.length();
		if(len==s2.length() && len>0){
			s1 = s1+s1;
			if(s1.contains(s2)){
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]){
		String s1 = "erbottlewat";
		String s2 = "waterbottle";
		System.out.println(stringRotate(s1,s2));
	}
}