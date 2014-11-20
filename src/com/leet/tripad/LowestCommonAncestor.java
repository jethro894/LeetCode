package com.leet.tripad;

import java.util.ArrayList;
import java.util.List;

import com.leet.TreeNode;

public class LowestCommonAncestor {

	public TreeNode withParent(TreeNode p, TreeNode q){
		if(p == null || q == null)
			return null;
		
		List<TreeNode> p_path = new ArrayList<TreeNode>();
		List<TreeNode> q_path = new ArrayList<TreeNode>();
			
		TreeNode cur_p = p;
		TreeNode cur_q = q;
		
		while(cur_p != null){
			p_path.add(0, cur_p);
			cur_p = cur_p.parent;
		}
		
		while(cur_q != null){
			q_path.add(0, cur_q);
			cur_q = cur_q.parent;
		}
		
		for(int i = 0; i < Math.min(p_path.size(), q_path.size()) - 2; i++){
			if(p_path.get(i+1) != q_path.get(i+1)){
				return p_path.get(i);
			}
		}
		
		if(p_path.size() > q_path.size())
			return q_path.get(q_path.size()-1);
		else
			return p_path.get(p_path.size()-1);
	}
	
	public TreeNode withoutParent(TreeNode root, TreeNode p, TreeNode q){
		if(p == null || q == null || root == null)
			return null;
		
		if(root == p || root == q)
			return root;
		
		TreeNode findFromLeft = withoutParent(root.left, p ,q);
		TreeNode findFromRight = withoutParent(root.right, p ,q);
		if(findFromLeft != null && findFromRight != null)
			return root;
		else if(findFromLeft != null)
			return findFromLeft;
		else
			return findFromRight;
	}
}
