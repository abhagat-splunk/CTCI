public class PermutationOfPalindrome{
	public static boolean isPermutation(String str){
		int[] table = buildCharFreqTable(str);
		return CheckMaxOddOne(table);
	}

	public static boolean CheckMaxOddOne(int[] table){
		boolean foundOne = false;
		for(int count: table){
			if(count%2==1){
				if(foundOne){
					return false;
				}
				foundOne = true;
			}
		}
		return true;
	}

	public static int[] buildCharFreqTable(String str){
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c:str.toCharArray()){
			int x = getCharNumber(c);
			if(x!=-1){
				table[x]+=1;
			}
		}
		return table;
	}

	public static int getCharNumber(Character x){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(x);
		if(val>=a && val<=z){
			return val-a;
		}
		return -1;
	}


	public static void main(String args[]){
		String x = "abcba";
		System.out.println(isPermutation(x));
		String y = "abbacd";
		System.out.println(isPermutation(y));
	}
}