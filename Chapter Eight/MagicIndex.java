public class MagicIndex{
	public static int slowMagic(int[] array){
		for(int i=0;i<array.length;i++){
			if(i==array[i]){
				return i;
			}
		}
		return -1;
	}

	public static int fasterMagic(int[] array){
		return fasterMagic(array,0,array.length-1);
	}
	public static int fasterMagic(int[] array, int start, int end){
		if(end<start){
			return -1;
		}
		int mid = (start+end)/2;
		if(array[mid]==mid){
			return mid;
		}
		else if(array[mid]>mid){
			return fasterMagic(array,start,mid-1);
		}
		else{
			return fasterMagic(array,mid+1,end);
		}
	}

	public static int fasterMagicWithRepeatedElements(int[] array){
		return fasterMagicWithRepeatedElements(array, 0, array.length-1);
	}

	public static int fasterMagicWithRepeatedElements(int[] arr, int start, int end){
		if(end<start){
			return -1;
		}
		int mid = (start+end)/2;
		if(arr[mid]==mid){
			return mid;
		}

		int leftIndex = Math.min(mid-1, arr[mid]);
		int left = fasterMagicWithRepeatedElements(arr,start,leftIndex);
		if(left>=0){
			return left; 
		}

		int rightIndex = Math.max(mid+1,arr[mid]);
		int right = fasterMagicWithRepeatedElements(arr,rightIndex,end);
		if(right>=0){
			return right;
		}
		return -1;
	}


	public static void main(String args[]){
		int[] arr = {-10,0,1,2,3,5,6,7,8,9};
		System.out.println(slowMagic(arr));
		System.out.println(fasterMagic(arr));
		int[] arrTwo = {-10,0,3,3,3,4,6,7};
		System.out.println(fasterMagicWithRepeatedElements(arrTwo));
	}
}