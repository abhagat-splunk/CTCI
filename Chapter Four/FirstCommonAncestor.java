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


class FirstCommonAncestor{
	public static Node head;
	public FirstCommonAncestor(){
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

	public static Node WithParents(Node left, Node right){
		
		int delta = depth(left)-depth(right);
		
		Node first = delta>0?right:left;
		Node second = delta>0?left:right;

		second = goUpBy(second, Math.abs(delta));

		while(first!=second && first!=null && second!=null){
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null? null:first; 
	}

	public static int depth(Node x){
		int depth = 0;
		while(x!=null){
			depth++;
			x = x.parent;
		}
		return depth;
	}

	public static Node goUpBy(Node temp, int x){
		while(x>0 && temp!=null){
			temp = temp.parent;
			x--;
		}
		return temp;
	}

	public static Node withoutParents(Node p, Node q){
		if(!covers(head,p)||!covers(head,q)){
			return null;
		}
		return ancestorHelper(head,p,q);
	}

	public static Node ancestorHelper(Node root, Node p, Node q){
		if(root==null||root==p||root==q){
			return root;
		}

		boolean pIsOnLeft = covers(root.left,p);
		boolean qIsOnLeft = covers(root.left,q);
		if(pIsOnLeft != qIsOnLeft){
			return root;
		}
		Node childSide = pIsOnLeft? root.left:root.right;
		return ancestorHelper(childSide,p,q);
	}

	public static boolean covers(Node root, Node p){
		if(root==null){
			return false;
		}
		if(root==p){
			return true;
		}
		return covers(root.left,p)||covers(root.right,p);
	}


	public static void main(String args[]){
		FirstCommonAncestor in = new FirstCommonAncestor();
		in.insert(5);
		in.insert(2);
		in.insert(3);
		in.insert(6);
		in.insert(4);
		System.out.println(in.WithParents(in.head.left, in.head.left.right).getData());
		System.out.println(in.withoutParents(in.head.left, in.head.left.right).getData());
	}
}