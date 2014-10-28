package com.leet;

public class MaxDepthOfBinaryTree {

	int max;
	public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 0);
        return max;
    }
	
	public void dfs(TreeNode node, int depthSoDarWithoutCurrentNode){
		int depthSoFar;
		
		if(node == null)
			return;
		
		if(node.left == null && node.right == null){
			depthSoFar = depthSoDarWithoutCurrentNode + 1;
			if(depthSoFar > max)
				max = depthSoFar;
		}
		
		if(node.left != null)
			dfs(node.left, depthSoDarWithoutCurrentNode + 1);
		if(node.right != null)
			dfs(node.right, depthSoDarWithoutCurrentNode + 1);
	}
}
