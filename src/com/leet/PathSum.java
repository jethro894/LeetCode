package com.leet;

public class PathSum {
	
	boolean found = false;
	int target_sum;
	public boolean hasPathSum(TreeNode root, int sum) {
        target_sum = sum;
        dfs(root, 0);
        return found;
    }
	
	public void dfs(TreeNode node, int sumExcludeThisNode){
		if(node == null || found)
			return;
		
		if(node.left == null && node.right == null){
			if(sumExcludeThisNode + node.val == target_sum){
				found = true;
				return;
			}
		}
		dfs(node.left, sumExcludeThisNode + node.val);
		dfs(node.right, sumExcludeThisNode + node.val);
	}
}
