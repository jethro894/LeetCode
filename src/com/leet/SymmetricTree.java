package com.leet;

public class SymmetricTree {
	public boolean result = true;
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return result;
		
		if(root.left == null && root.right == null){
			return result;
		}
		else if(root.left == null ^ root.right == null){
        	result = false;
        }
		else if(root.left.val == root.right.val){
        	comparePair(root.left, root.right);
        }else
            result = false;
        
        return result;
    }
	
	public void comparePair(TreeNode left, TreeNode right){
		if(result == false)
			return;
		
		if(left.left == null && left.right == null && right.left == null && right.right == null)
			return;
		
		if(left.left != null && left.right != null && right.left != null && right.right != null){
			if(left.left.val == right.right.val && left.right.val == right.left.val){
				comparePair(left.left, right.right);
				comparePair(left.right, right.left);
			}else{
				result = false;
			}
		}else if(left.left != null && left.right == null && right.left == null && right.right != null){
			if(left.left.val == right.right.val){
				comparePair(left.left, right.right);
			}else{
				result = false;
			}
		}else if(left.left == null && left.right != null && right.left != null && right.right == null){
			if(left.right.val == right.left.val){
				comparePair(left.right, right.left);
			}else{
				result = false;
			}
		}else{
			result = false;
		}
	}
}
