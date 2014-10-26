package com.leet;

public class BinaryTreeMaxPathSum {

	/**
	 * @param args
	 */
	
	public int max;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxPathSum(TreeNode root){
		//null
		if(root == null)
			return 0;
				
		//leaf
		if(root.left == null && root.right == null)
			return root.val;
		
		max = root.val;
		maxDepthBranch(root);
		return max;
	}
	
	//excludes itself
	public int maxDepthBranch(TreeNode node){
		//null
		if(node == null)
			return 0;
		
		//otherwise
		int option1 = maxDepthBranch(node.left);
		int option2 = maxDepthBranch(node.right);
		
		option1 = option1>0? option1:0;
		option2 = option2>0? option2:0;
		
		if(option1 + option2 + node.val > max)
			max = option1 + option2 + node.val;
		
		return Math.max(option1, option2) + node.val;
	}
}
