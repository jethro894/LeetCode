package com.leet.zill;

/*
 * Trinary Tree with node class and insert/delete methods
 * 		insertion():
 * 				-	insert a value into the tree
 * 				-	if root is null, create the root
 * 				-	using iteration to find the node to add
 * 				-	it is guaranteed that only the highest (most upper) node with the same value, will have left and right children. 
 * 						This has eliminated the difficult situation of deleting a mid child and merging its own left and right children with its ancestor's children
 * 	
 * 		deletion():
 * 				-	delete a copy of the value in the tree, and reset the root if necessary
 * 				-	if multiple copies of the value is found, the lowest leaf will be deleted.(it must be a leaf, according to the insertion() method)
 * 				-	otherwise the deletion will be the same with methods in binary tree. Subtree transplanting is necessary when deleting a node with two children.
 * 				-	i'm using resursion here because it is easier to implement
 */

public class TrinaryTree {
	private TrinaryTreeNode root;
	
	public static void main(String[] args){
		TrinaryTree myTree = new TrinaryTree();
		int[] A = {5,4,9,5,7,2,2};
		for(int i : A)
			myTree.insertion(i);
		myTree.print();
		myTree.deletion(5);
		System.out.println();
		myTree.print();
	}
	
	public void insertion(int val){
		if(root == null){
			root = new TrinaryTreeNode(val);
			return;
		}
		
		TrinaryTreeNode cur = root;
		while(cur != null){
			if(val < cur.val){
				if(cur.left == null){
					cur.left = new TrinaryTreeNode(val);
					return;
				}
				cur = cur.left;
				continue;
			}
			
			if(val == cur.val){
				if(cur.mid == null){
					cur.mid = new TrinaryTreeNode(val);
					return;
				}
				cur = cur.mid;
				continue;
			}
			
			if(val > cur.val){
				if(cur.right == null){
					cur.right = new TrinaryTreeNode(val);
					return;
				}
				cur = cur.right;
				continue;
			}
		}
	}
	
	public void deletion(int val){
		root = deletionHelper(val, root);
	}
	
	//only delete one copy of val
	private TrinaryTreeNode deletionHelper(int val, TrinaryTreeNode subroot){
		if(subroot == null)
			return null;
		
		if(val < subroot.val)
			subroot.left = deletionHelper(val, subroot.left);
		else if(val > subroot.val)
			subroot.right = deletionHelper(val, subroot.right);
		else{
			if(subroot.mid != null)
				subroot.mid = deletionHelper(val, subroot.mid);
			else if(subroot.isLeaf())
				return null;
			else if(subroot.right != null){
				if(subroot.left == null)
					subroot = subroot.right;
				else{
					subroot.val = findSuccessorVal(subroot);
					subroot.right = deletionHelper(subroot.val, subroot.right);
				}
			}else
				subroot = subroot.left;
		}
		return subroot;
	}
	
	private int findSuccessorVal(TrinaryTreeNode subroot){
		if(subroot == null)
			return Integer.MIN_VALUE;
		TrinaryTreeNode cur = subroot;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur.val;
	}
	
	//Node definition class
	class TrinaryTreeNode {
		int val;
		TrinaryTreeNode left, mid, right;
		TrinaryTreeNode(int v){
			val = v;
			left = null;
			mid = null;
			right = null;
		}
		
		boolean isLeaf(){
			if(left == null && mid == null && right == null)
				return true;
			return false;
		}
	}
	
	public void print(){
		preOrderPrint(root);
	}
	
	private void preOrderPrint(TrinaryTreeNode n){
		if(n == null)
			return;
		System.out.print(n.val+",");
		preOrderPrint(n.left);
		preOrderPrint(n.mid);
		preOrderPrint(n.right);
	}
}
