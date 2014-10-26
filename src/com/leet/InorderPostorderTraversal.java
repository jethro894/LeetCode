package com.leet;

public class InorderPostorderTraversal {

	/**
	 * @param args
	 */
	protected static TreeNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {3,5,6,7,10,12,13,15,16,18,20,23};
		int[] postorder = {3,7,6,10,13,12,5,18,23,20,16,15};
		
		//int[] inorder = {-1};
		//int[] postorder = {-1};
		//root = new TreeNode(postorder[postorder.length-1]);
		root = buildTree(inorder, postorder);
		printTree(root);
	}
	
	public static void printTree(TreeNode tn){
		tn.print();
		if(tn.left != null)
			printTree(tn.left);
		
		if(tn.right != null)
			printTree(tn.right);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder){
		if(inorder.length != postorder.length)
            return null;
        if(inorder.length == 0)
            return null;
        
		return growFromRoot(root, postorder);
	}
	
	public static TreeNode growFromRoot(TreeNode subroot, int[] postorder){
		if(postorder.length == 1){
			subroot.val = postorder[0];
			return subroot;
		}
			
		subroot = new TreeNode(postorder[postorder.length-1]);
		
		int pivot_index = -1;
		for(int i = postorder.length-1; i >= 0; i--){
			if(postorder[i] < subroot.val){
				//System.out.println("pivot: " + i);
				pivot_index = i;
				TreeNode leftNode = new TreeNode(postorder[pivot_index]);
				//from postorder[0] to postorder[pivot_index]
				int[] leftpostorder = new int[pivot_index+1];
				for(int j=0; j < leftpostorder.length; j++)
					leftpostorder[j] = postorder[j];
				/*System.out.print("left node added: " + postorder[pivot_index] + " po: ");
				for(int m : leftpostorder)
					System.out.print(m + ", ");
				System.out.println();*/
				subroot.left = growFromRoot(leftNode, leftpostorder);
				
				break;
			}
		}
		//from postorder[pivot_index+1] to postorder[postorder.length-2]
		int[] rightpostorder = new int [postorder.length-2+1-(pivot_index+1)];
		for(int j=0; j < postorder.length-2+1-(pivot_index+1); j++)
			rightpostorder[j] = postorder[pivot_index+1 + j];
		if(rightpostorder.length > 0){
			TreeNode rightNode = new TreeNode(postorder[postorder.length-2]);
			/*System.out.print("right node added: " + postorder[postorder.length-2] + " po: ");
			for(int m : rightpostorder)
				System.out.print(m + ", ");
			System.out.println();*/
			subroot.right = growFromRoot(rightNode, rightpostorder);
		}
		
		return subroot;
	}
	

}
