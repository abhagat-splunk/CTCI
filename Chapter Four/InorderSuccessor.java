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

public class InorderSuccessor{
	public static Node head;
	public InorderSuccessor(){
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

	public static void inOrderPrint(Node temp){
		if(temp.left!=null){
			inOrderPrint(temp.left);
		}
		System.out.println(temp.getData());
		if(temp.right!=null){
			inOrderPrint(temp.right);
		}
	}

	public static Node getInorderSuccessor(Node temp){
		if(temp==null){
			return new Node(-1);
		}
		if(temp.right!=null){
			return returnLeftMostChild(temp.right);
		}
		else{
			Node t1 = temp;
			Node t2 = temp.parent;
			while(t2!=null && t2.left!=t1){
				t1 = t2;
				t2 = t2.parent;
			}
			if(t2==null){
				return new Node(-1);
			}
			return t2;
		}
	}

	public static Node returnLeftMostChild(Node temp){
		while(temp.left!=null){
			temp = temp.left;
		}
		return temp;

	}


	public static void main(String args[]){
		InorderSuccessor in = new InorderSuccessor();
		in.insert(5);
		in.insert(2);
		in.insert(3);
		in.insert(6);
		in.insert(4);
		in.inOrderPrint(head);
		System.out.println(in.getInorderSuccessor(head.left.left).getData());
	}

}