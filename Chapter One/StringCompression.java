public class StringCompression{
	public static String BadCompress(String s){
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i=0;i<s.length();i++){
			countConsecutive++;
			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
				compressed.append(s.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive=0;
			}
		}
		return compressed.length()<s.length()? compressed.toString():s;
	}
	public static String Compress(String s){
		int finalLength = countCompression(s);
		if (finalLength>=s.length()){
			return s;
		}
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i=0;i<s.length();i++){
			countConsecutive++;
			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
				compressed.append(s.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive=0;
			}
		}
		return compressed.toString();
	}
	public static int countCompression(String s){
		int compressedLength = 0;
		int countConsecutive = 0;
		for(int i=0;i<s.length();i++){
			countConsecutive++;
			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive=0;
			}
		}
		return compressedLength;
	} 
	public static void main(String args[]){
		String str = "aabcccccaaa";
		System.out.println(BadCompress(str));
		System.out.println(Compress(str));
	}
}