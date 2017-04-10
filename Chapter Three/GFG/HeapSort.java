public class HeapSort{
	private int size;
	private int maxSize;
	int[] Heap;

	private static final int FRONT = 1;
	HeapSort(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[maxSize+1];
		Heap[0] = Integer.MAX_VALUE;
	}

	public int getParent(int x){
		return x/2;
	}

	public void swap(int first, int second){
		int temp = Heap[first];
		Heap[first] = Heap[second];
		Heap[second] = temp;
	}
	public void insert(int x){
		Heap[++size] = x;
		int current = size;
		while(Heap[current]>Heap[getParent(current)]){
			swap(current,getParent(current));
			current = getParent(current);
		}
	}

	public boolean isLeaf(int x){
		if(x>=size/2 && x<=size){
			return true;
		}
		return false;
	}

	public int leftChild(int pos){
		return 2*pos;
	}

	public int rightChild(int pos){
		return 2*pos+1;
	}

	public void maxHeapify(int pos){
		if(!isLeaf(pos)){
			if(Heap[pos]<Heap[leftChild(pos)] || Heap[pos]<Heap[rightChild(pos)]){
				if(Heap[leftChild(pos)]>Heap[rightChild(pos)]){
					swap(pos,leftChild(pos));
					maxHeapify(leftChild(pos));
				}
				else{
					swap(pos,rightChild(pos));
					maxHeapify(rightChild(pos));
				}
			}
		}
	}

	public void maxHeap(){
		for(int i=1;i<size/2;i++){
			maxHeapify(i);
		}

	}

	// public void print(){
	// 	int current_size = size;
	// 	while(current_size>0){
	// 		for(int i=1;i<=size;i++){
	// 		System.out.print(Heap[i]);
	// 		}
	// 		System.out.println();
	// 		swap(FRONT,current_size-1);
	// 		for(int i=1;i<=size;i++){
	// 		System.out.print(Heap[i]);
	// 		}
	// 		System.out.println();
	// 		current_size = current_size-1;
	// 		maxHeap(current_size);

	// 	}
		
	//}	

	public int remove(){
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		maxHeapify(FRONT);
		return popped;
	}

	public static void main(String args[]){
		HeapSort hs = new HeapSort(10);
		hs.insert(4);
		hs.insert(3);
		hs.insert(2);
		hs.insert(1);
		hs.maxHeap(hs.size);
		System.out.println(hs.remove());
		System.out.println(hs.remove());
		System.out.println(hs.remove());
		System.out.println(hs.remove());
	}
}
