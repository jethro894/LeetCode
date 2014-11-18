package com.leet;

public class ConvertSortedArrayToBST {
	public static void main(String[] args){
		int[] num = {1,3};
		new ConvertSortedArrayToBST().sortedArrayToBST(num);
	}
	public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0)
        	return null;
        return helper(num, 0, num.length-1);
	}
	
	public TreeNode helper(int[] num, int start, int end){
		if(start > end)
        	return null;
        
        if(start == end)
        	return new TreeNode(num[end]);
        
        int median_index = (start + end)/2;
        System.out.println("start: " + start + ", end: " + end+ ", median_index: " + median_index);
        int median = num[median_index];
        
        TreeNode node = new TreeNode(median);
        node.left = helper(num, start, median_index-1);
        node.right = helper(num, median_index+1, end);
        
        return node;
	}
}
