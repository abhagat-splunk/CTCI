import java.util.*;
class PermutationsWithDup{
	public static ArrayList<String> printperms(String s){
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character,Integer> bFreq = buildFreqTable(s);
		printperms(bFreq,"",s.length(),result);
		return result;
	}
	public static HashMap<Character,Integer> buildFreqTable(String s){
		HashMap<Character,Integer> bf = new HashMap<Character,Integer>();
		for(char c:s.toCharArray()){
			if(!bf.containsKey(c)){
				bf.put(c,0);
			}
			bf.put(c,bf.get(c)+1);
		}
		return bf;
	}

	public static void printperms(HashMap<Character,Integer> map, String prefix, int remaining, ArrayList<String> result){
		if(remaining==0){
			result.add(prefix);
			return;
		}
		for(Character c:map.keySet()){
			int count = map.get(c);
			if(count>0){
				map.put(c,count-1);
				printperms(map,prefix+c,remaining-1,result);
				map.put(c,count);
			}
		}
	}
	public static void main(String args[]){
		ArrayList<String> a = printperms("ankita");
		for(String s: a){
			System.out.println(s);
		}
	}
}