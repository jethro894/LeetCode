package com.leet;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null || head.next == null)
			return head;
		
		ListNode helper = new ListNode(0);
		helper.next = head;
		
		int count = 1;
		ListNode pre = helper;
		
		while(pre.next != null && count < m){
			pre = pre.next;
			count++;
		}
		
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;
		
		while(cur != null && count < n){
			ListNode post = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			mNode.next = post;
			cur = post;
			count++;
		}
		return helper.next;
	}	
}
