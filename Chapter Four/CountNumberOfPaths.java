class Node{
	private int data;
	Node left, right,parent;
	Node(int x){
		this.data = x;
		left = null;
		right = null;
		parent = null;
	}
	int getData(){
		return data;
	}
}


class CountNumberOfPaths{
	public static Node head;
	public CountNumberOfPaths(){
	head = null;
	}
	public static void insert(int x){
		Node newNode = new Node(x);
		if(head==null){
			head = newNode;
			newNode.parent = null;
		}
		else{
			Node temp = head;
			while(temp!=null){
				if(temp.getData()<x){
					if(temp.right==null){
						temp.right = newNode;
						temp.right.parent = temp;
						break;
					}
					else{
					temp = temp.right;
					}
				}
				else{
					if(temp.left==null){
						temp.left = newNode;
						temp.left.parent = temp;
						break;
					}
					else{
						temp = temp.left;	
					}
				}
			}
		}
	}

	
}