package com.leet;

public class SumRootToLeafNumbers {
	
	private int total;
	public int sumNumbers(TreeNode root) {
        total = 0;
        if(root == null)
        	return total;
        
        dfs(root, "");
        return total;
    }
	
	public void dfs(TreeNode n, String sum){
		sum += Integer.toString(n.val);
		
		if(n.left != null)
			dfs(n.left, sum);
		if(n.right != null)
			dfs(n.right, sum);
		
		if(n.left == null && n.right == null)
			total += Integer.parseInt(sum);
		
	}
}
