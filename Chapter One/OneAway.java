public class OneAway{
	public static boolean OneEdit(String a, String b){
		if(Math.abs(a.length()-b.length())>1){
			return false;
		}
		String s1, s2;
		s1 = a.length()>b.length()? b:a;
		s2 = a.length()>b.length()? a:b;
		int index1=0,index2=0;
		boolean flag_replace = (s1.length()==s2.length());
		boolean foundDifference = false;
		while(index1<s1.length() && index2<s2.length()){
			if(s1.charAt(index1)!=s2.charAt(index2)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
				if(flag_replace){
					index1++;
				}
			}
			else{
				index1++;
			}
			index2++;
		}
		return true;
	}
	public static void main(String args[]){
		String s1 = "Ankit";
		String s2 = "Abkit";
		System.out.println(OneEdit(s1,s2));
	}
}