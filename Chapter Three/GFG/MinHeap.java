public class MinHeap{
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public MinHeap(int maxsize){
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize+1];
		Heap[0] = Integer.MIN_VALUE;
	}


	public void swap(int fpos, int spos){
		int temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}

	public void insert(int element){
		Heap[++size] = element;
		int current = size;
		while(Heap[current]<Heap[parent(current)]){
			swap(current,parent(current));
			current = parent(current);
		}
	}


	public int leftChild(int pos){
		return 2*pos;
	}
	public int rightChild(int pos){
		return 2*pos+1;
	}
	public int parent(int pos){
		return pos/2;
	}


	public void print(){
		for(int i=1;i<=size/2;i++){
			System.out.println("Parent: "+Heap[i]+" Left Child: "+Heap[2*i]+" Right Child: "+Heap[2*i+1]);
			System.out.println();
		}
	}


	public boolean isLeaf(int pos){
		if(pos >= size/2 && pos<=size){
			return true;
		}
		return false;
	}

	public void minHeapify(int pos){
		if(!isLeaf(pos)){
			if(Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]){
				if(Heap[leftChild(pos)]<Heap[rightChild(pos)]){
					swap(pos,leftChild(pos));
					minHeapify(leftChild(pos));
				}else{
					swap(pos,rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}

	public void minHeap(){
		for(int i=(size/2);i>=1;i++){
			minHeapify(i);
		}
	}

	public int remove(){
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}


	public static void main(String args[]){
		MinHeap mh = new MinHeap(10);
		mh.insert(5);
		mh.insert(4);
		mh.insert(3);
		mh.insert(6);
		mh.insert(7);
		//mh.insert(8);
		//mh.print();
		System.out.println(mh.remove());
		System.out.println(mh.remove());
		System.out.println(mh.remove());
		System.out.println(mh.remove());
		System.out.println(mh.remove());
		
	}

}