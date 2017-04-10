class Node{
	private int data;
	Node next;
	Node(int x){
		data = x;
		next = null;
	}
	public int getData(){
		return data;
	}
}

class CircularQueue{
	private int limit;
	private int filled_up = 0;
	Node front,rear;
	CircularQueue(int l){
		limit = l;
		front = null;
		rear = null;
	}
	CircularQueue(){
		limit = 5;
		front = null;
		rear = null;
	}
	void enQueue(int x){
		
		if(filled_up==limit){

		}else{
			if(front==null){
				Node newNode = new Node(x);
				front = newNode;
				rear = newNode;
				filled_up+=1;
			}
			else{
				Node newNode = new Node(x);
				rear.next = newNode;
				rear = newNode;
				filled_up+=1;
			}

		}
		
	}
}