package com.leet;

import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> levels = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        Collections.reverse(levels);
		return levels;
    }
}
