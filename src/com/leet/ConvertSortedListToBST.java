package com.leet;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        
        if(head.next == null)
        	return new TreeNode(head.val);
        
        List<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        
        while(cur != null){
        	list.add(cur.val);
        	cur = cur.next;
        }
        
        return helper(list, 0, list.size()-1);
    }
	
	public TreeNode helper(List<Integer> list, int start, int end){
		if(start > end)
			return null;
		if(start == end){
			return new TreeNode(list.get(start));
		}
		int m = start + (end-start)/2;
		
		TreeNode n = new TreeNode(list.get(m));
		n.left = helper(list, start, m-1);
		n.right = helper(list, m+1, end);
		
		return n;
	}
}
