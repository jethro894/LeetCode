package com.leet;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	List<List<Integer>> result;
	int target_sum;
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		target_sum = sum;
		result = new ArrayList<List<Integer>>();
		
		dfs(root, 0, new ArrayList<Integer>());
		return result;
    }
	
	public void dfs(TreeNode node, int sumExcludeThisNode, List<Integer> path){
		if(node == null)
			return;
		
		path = new ArrayList<Integer>(path);
		path.add(node.val);
		
		if(node.left == null && node.right == null){
			if(sumExcludeThisNode + node.val == target_sum){
				result.add(path);
				return;
			}
		}
		
		dfs(node.left, sumExcludeThisNode + node.val, path);
		dfs(node.right, sumExcludeThisNode + node.val, path);
	}
}
