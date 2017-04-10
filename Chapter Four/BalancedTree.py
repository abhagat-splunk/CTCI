class BinaryTree:
	def __init__(self,content):
		self.content = content
		self.left = None
		self.right = None
		self.depth = -1

	def __str__(self):
		return "("+ str(self.content) + "("+ str(self.left) + "|" + str(self.left) + "))"


def NaiveBalanced(btree):
	if btree is None:
		return True
	else:
		return (abs(depth(btree.left)-depth(btree.right)) <=1) and is_balanced_btree(btree.left) and is_balanced_btree(btree.right)


def depth(btree):
	if btree is None:
		return True
	else:
		if btree.depth!=-1:
			return btree.depth
		else:
			btree.depth = 1+max(depth(btree.left),depth(btree.right))
			return btree.depth

def is_balanced_btree(btree):
	#print btree.content
	if btree is None:
		return True,0
	else:
		left_balanced, left_depth = is_balanced_btree(btree.left)
		right_balanced, right_depth = is_balanced_btree(btree.right)
		btree.depth = 1 + max(left_depth,right_depth)
		return left_balanced and right_balanced and (abs(left_depth-right_depth)<=1)

bt = BinaryTree(2)
bt.left = BinaryTree(1)
bt.left.left = BinaryTree(0)
#bt.left.left.left = BinaryTree(-1)
bt.right = BinaryTree(3)
print NaiveBalanced(bt)