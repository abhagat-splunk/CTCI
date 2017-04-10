class Node{
	private int data;
	Node left, right;
	int sumOfSubTree;
	Node(int x){
		this.data = x;
		left = null;
		right = null;
		this.sumOfSubTree = 0;
	}
	public int getData(){
		return data;
	}
	public int getSum(){
		return sumOfSubTree;
	}
	public String toString(){
		return "Data: "+data+" Sum Of Subtree: "+sumOfSubTree;
	}
	public void setData(int x){
		this.data = x;
	}
}

class Tree{
	Node root;
	Tree(){
		root = null;
	}
	public void insertNode(int x){
		Node newNode = new Node(x);
		if(root==null){
			root = newNode;
		}
		else{
			Node temp = root;
			while(temp!=null){
				if(temp.getData()>x){
					if(temp.left!=null){
						temp = temp.left;
					}
					else{
						temp.left=  newNode;
						break;
					}
				}	
				else{
					if(temp.right!=null){
						temp = temp.right;
					}
					else{
						temp.right=  newNode;
						break;
					}
				}
			}
		}
	}

	public int getTotalSum(Node temp){
		int l=0,r=0;
		if(temp.left!=null){
			l = getTotalSum(temp.left);
		}
		if(temp.right!=null){
			r = getTotalSum(temp.right);
		}
		temp.sumOfSubTree = temp.getData()+l+r;
		return temp.sumOfSubTree;
	}

	public void print(Node temp){
		if(temp.left!=null){
			print(temp.left);
		}
		System.out.println(temp.toString());
		if(temp.right!=null){
			print(temp.right);
		}
	}

	public Node remove(int x){
		return remove(x,root);
	}

	public Node remove(int x, Node root){
		if(root==null){
			return root;
		}
		if(x<root.getData()){
			root.left = remove(x,root.left);
		}
		else if(x>root.getData()){
			root.right = remove(x,root.right);
		}
		else{
			if(root.left==null){
				return root.right;
			}
			else if(root.right==null){
				return root.left;
			}
			root.setData(minValue(root.right));
			root.right = remove(root.getData(),root.right);
		}
		return root;
	}
	

	public int minValue(Node root){
		int minv = root.getData();
		while(root.left!=null){
			minv = root.left.getData();
			root = root.left;
		}
		return minv;	
	}

}


class SumOfNode{
	public static void main(String args[]){
		Tree tr = new Tree();
		tr.insertNode(10);
		tr.insertNode(5);
		tr.insertNode(15);
		tr.insertNode(7);
		//tr.insertNode(17);
		tr.insertNode(3);
		//tr.insertNode(13);
		tr.print(tr.root);
		System.out.println(tr.getTotalSum(tr.root));
		tr.remove(15);
		System.out.println(tr.getTotalSum(tr.root));
		
	}
}


