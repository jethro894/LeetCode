package com.leet;

import com.leet.RangeSumQueryImmutable.NumArrayImmutable;

public class RangeSumQueryMutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
		NumArrayMutable numArray = new NumArrayMutable(nums);
		
		numArray.update(4, 3);
		System.out.println(numArray.sumRange(2,5));
	}

	static class NumArrayMutable{
		
		SegmentTreeNode root;
		
		public NumArrayMutable(int[] nums) {
			if(nums == null || nums.length == 0){
	            return;
	        }
			
	        root = constructTree(nums, 0, nums.length - 1);
	    }
		
		public SegmentTreeNode constructTree(int[] nums, int start, int end){
	    	if(start == end){
	    		return new SegmentTreeNode(start, end, nums[start]);
	    	}
	    	
	    	SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
	    	int mid = start + (end - start)/2;
	    	root.left = constructTree(nums, start, mid);
	    	root.right = constructTree(nums, mid+1, end);
	    	root.sum = root.left.sum + root.right.sum;
	    	
	    	return root;
	    }

	    void update(int i, int val) {
	    	updateHelper(root, i, val);
	    }
	    
	    public void updateHelper(SegmentTreeNode root, int i, int val){
	    	if(root.start == i && root.end == i){
	    		root.sum = val;
	    		return;
	    	}
	    	
	    	int mid = root.start + (root.end - root.start)/2;
	    	if(i <= mid){
	    		updateHelper(root.left, i, val);
	    	}else{
	    		updateHelper(root.right, i, val);
	    	}
	    	root.sum = root.left.sum + root.right.sum;
	    }

	    public int sumRange(int i, int j) {
	    	return sumRangeHelper(root, i, j);
	    }
	    
	    public int sumRangeHelper(SegmentTreeNode root, int i, int j){
	    	if(root == null || i > root.end || j < root.start){
	    		return 0;
	    	}
	    	if(i <= root.start && j >= root.end){
	    		return root.sum;
	    	}
	    	int mid = root.start + (root.end - root.start)/2;
	    	
	    	if(mid >= j){
	    		return sumRangeHelper(root.left, i, j);
	    	}
	    	
	    	if(mid + 1 <= i){
	    		return sumRangeHelper(root.right, i, j);
	    	}
	    	
	    	return sumRangeHelper(root.left, i, mid) +
	                sumRangeHelper(root.right, mid+1, j);
	    	
	    }
	 
	    static class SegmentTreeNode{
	    	int start;
	    	int end;
	    	int sum;
	    	SegmentTreeNode left;
	    	SegmentTreeNode right;
	    	
	    	public SegmentTreeNode(int s, int e, int sum){
	    		this.start = s;
	    		this.end = e;
	    		this.sum = sum;
	    		this.left = null;
	    		this.right = null;
	    	}
	    }
	}
}
