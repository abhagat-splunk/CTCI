class URLify{
	public static void replaceSpaces(char[] str, int trueLength){
		int spaceCount = 0, index;
		for(int i=0;i<trueLength;i++){
			if(str[i]==' '){
				spaceCount+=1;
			}
		}
		index = trueLength + spaceCount*2;
		if(trueLength<str.length){
			str[trueLength] = '\0';
		}
		for(int i=trueLength-1;i>0;i--){
			if(str[i]==' '){
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index = index-3;
			}else{
				str[index-1] = str[i];
				index-=1;
			}
		}
	}
	public static void main(String args[]){
		String str = "Mr John Smith";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());
		String newString = new String(arr);
		System.out.println(newString);
	}
}