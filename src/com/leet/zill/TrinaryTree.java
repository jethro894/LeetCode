package com.leet.zill;

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
		
		if(val < subroot.val){
			subroot.left = deletionHelper(val, subroot.left);
		}else if(val > subroot.val){
			subroot.right = deletionHelper(val, subroot.right);
		}else if(val == subroot.val){
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
	
	public int findSuccessorVal(TrinaryTreeNode subroot){
		if(subroot == null)
			return Integer.MIN_VALUE;
		TrinaryTreeNode cur = subroot;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur.val;
	}
	
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
