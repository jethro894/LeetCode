package com.leet;

public class BalancedBinaryTree {
	
	boolean unbalanced = false;
	public boolean isBalanced(TreeNode root) {
		dfs(root);
        return !unbalanced;
    }
	
	public int dfs(TreeNode node){
		if(unbalanced)
			return -1;
		
		int leftHeight;
		int rightHeight;
		
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		
		if(node.left == null){
			leftHeight = 0;
		}else{
			leftHeight = dfs(node.left);
		}
		
		if(node.right == null){
			rightHeight = 0;
		}else{
			rightHeight = dfs(node.right);
		}
		
		if(Math.abs(leftHeight - rightHeight) > 1){
			unbalanced = true;
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight)+1;
		}
		
	}
}
