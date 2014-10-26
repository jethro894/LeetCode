package com.leet;

public class MinimumDepthOfTree {
	public static int min;
	
	public int minDepth(TreeNode root) {
		if(root == null)
            return 0;
        min = 999999;
        dfs(root, 0);
        return min;
    }
	
	public void dfs(TreeNode subroot, int depthSoFar){
		int depthNow = depthSoFar+1;
		
		if(subroot.left == null && subroot.right == null){
			min = (min > depthNow) ? depthNow : min;
			return;
		}
		
		if(subroot.left != null){
			dfs(subroot.left, depthNow);
		}
		
		if(subroot.right != null){
			dfs(subroot.right, depthNow);
		}
	}
}
