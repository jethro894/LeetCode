package com.leet;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
        	return null;
        }
        
        int k = lists.length;
        
        Comparator<ListNode> comparator = new ListNodeComparator();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(k, comparator);
        
        for(ListNode list : lists){
        	if(list != null){
        		minHeap.add(list);
        	}
        }
        
        ListNode head = null, pre = null, cur = null;
        while(!minHeap.isEmpty()){
        	ListNode min = minHeap.poll();
        	
        	cur = min;
        	if(head == null){
        		head = cur;
        	}else{
        		pre.next = cur;
        	}
        	
        	if(min.next != null){
        		minHeap.offer(min.next);
        	}
        	
        	pre = cur;
        }
        
        return head;
    }
	
	class ListNodeComparator implements Comparator<ListNode> {

		@Override
		public int compare(ListNode arg0, ListNode arg1) {
			// TODO Auto-generated method stub
			return arg0.val - arg1.val;
		}
		
	}
}
