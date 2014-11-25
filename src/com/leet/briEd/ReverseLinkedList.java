package com.leet.briEd;

import com.leet.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null)
			return head;
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode post;
		
		while(cur != null){
			post = cur.next;
			cur.next = pre;
			pre = cur;
			cur = post;
		}
		
		return pre;
	}
}
