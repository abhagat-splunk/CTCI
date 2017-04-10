class Task{
	private String job;
	private int priority;
	Task(String x, int y){
		this.job = x;
		this.priority = y;
	}
	public int getPriority(){
		return priority;
	} 
	public String toString(){
		return "Job Name: "+job+"\n Priority: "+priority;
	}
}
class PriorityQ{
	private Task[] heap;
	private int heapSize, capacity;

	public PriorityQ(int capacity){
		this.capacity = capacity+1;
		heap = new Task[capacity];
		heapSize = 0;
	}

	public void clear(){
		heap = new Task[capacity];
		heapSize = 0;
	}

	public boolean isEmpty(){
		return heapSize==0;
	}

	public boolean isFull(){
		return heapSize==capacity-1;
	}

	public int getSize(){
		return heapSize;
	}

	public void insert(String job, int priority){
		Task newTask = new Task(job,priority);
		heap[++heapSize] = newTask;
		int pos = heapSize;
		while(pos!=1 && priority>heap[pos/2].getPriority()){
			heap[pos] = heap[pos/2];
			pos = pos/2;
		}
		heap[pos] = newTask;
	}

	public Task remove(){
		int parent, child;
		Task item, temp;
		if(isEmpty()){
			System.out.println("Queue is empty!");
			return null;
		}
		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;
		while(child<=heapSize){
			if(child<heapSize && heap[child].getPriority()<heap[child+1].getPriority()){
				child++;
			}
			if(temp.getPriority() >= heap[child].getPriority()){
				break;
			}
			heap[parent] = heap[child];
			parent = child;
			child *=2;
		}
		heap[parent] = temp;
		return item;
	}
}



public class PriorityQueue{
	public static void main(String args[]){
		PriorityQ pq = new PriorityQ(10);
		pq.insert("Task 1", 20);
		pq.insert("Task 2", 30);
		pq.insert("Task 3", 40);
		System.out.println(pq.remove().toString());
		System.out.println(pq.remove().toString());
		System.out.println(pq.remove().toString());	
	}
}