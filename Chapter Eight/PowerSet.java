import java.util.*;
class PowerSet{
	public static ArrayList<ArrayList<Integer>> getPowerSetRecursion(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(set.size()==index){
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>()); //Empty set
		}
		else{
			allSubsets = getPowerSetRecursion(set,index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset:allSubsets){
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moresubsets.add(newSubset);
			}
			allSubsets.addAll(moresubsets);
		}
		return allSubsets;
	}

	public static void main(String args[]){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<3;i++){
			arr.add(i);
		}
		ArrayList<ArrayList<Integer>> ar = getPowerSetRecursion(arr,0);
		for(ArrayList<Integer> a: ar){
			for(int i=0;i<a.size();i++){
				System.out.print(a.get(i));
			}
			System.out.println();
		}
	}
}