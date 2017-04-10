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
class Queue{
	int limit;
	Node rear,front;

	Queue(int x){
		limit = x;
		front = null;
		rear = null;
	}
	Queue(){
		limit = 100;
		front = null;
		rear = null;
	}
	void enqueue(int x){
		Node newNode = new Node(x);
		if(front==null){
			newNode.next = null;
			front = newNode;
			rear = newNode;
		}
		else{
			rear.next = newNode;
			rear = newNode;
		}
	}

	int dequeue(){
		if(front==null){
			System.out.println("Queue empty!");
			return -1;
		}
		else{
			Node temp = front;
			front = front.next;
			return temp.getData();
		}
	}

	void printQueue(){
		Node temp = front;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.next;
		}
	}

	public static void main(String args[]){
		Queue q = new Queue(100);
		q.enqueue(4);
		q.enqueue(5);
		q.printQueue();
		System.out.println(q.dequeue());
		q.dequeue();
		q.dequeue();
		q.enqueue(3);
		q.enqueue(5);
		q.printQueue();
	}
}