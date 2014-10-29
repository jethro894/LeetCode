package com.leet;

public class SameTree {
	
	boolean isSame = true;
	public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
		return isSame;
    }
	
	public void dfs(TreeNode n1, TreeNode n2){
		if(!isSame)
			return;
		
		if(n1 == null){
			if(n2 != null)
				isSame = false;
			return;
		}
		
		if(n2 == null){
			if(n1 != null)
				isSame = false;
			return;
		}
		
		if(n1.val != n2.val){
		    isSame = false;
			return;
		}
		
		if(n1.left != null){
			if(n2.left != null)
				dfs(n1.left, n2.left);
			else{
				isSame = false;
				return;
			}
		}else{
			if(n2.left != null){
				isSame = false;
				return;
			}
		}
		
		if(n1.right != null){
			if(n2.right != null)
				dfs(n1.right, n2.right);
			else{
				isSame = false;
				return;
			}
		}else{
			if(n2.right != null){
				isSame = false;
				return;
			}
		}
	}
}
