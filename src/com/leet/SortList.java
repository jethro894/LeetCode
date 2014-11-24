package com.leet;

public class SortList {
	public ListNode sortList(ListNode head) { 
        return mergeSort(head);
    }
	
	public ListNode mergeSort(ListNode head){
		if(head == null || head.next == null)
        	return head;
		
		ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        
        return mergeTwoLists(head1, head2);
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
        ListNode head, l1lead, l2lead, current;
        
        if(l1.val <= l2.val){
        	head = l1;
        	l1lead = l1.next;
        	l2lead = l2;
        }
        else{
        	head = l2;
        	l1lead = l1;
        	l2lead = l2.next;
        }
        
        current = head;
        while(l1lead != null || l2lead != null){
        	if(l1lead == null){
        		current.next = l2lead;
        		current = current.next;
        		if(l2lead != null)
        		    l2lead = l2lead.next;
        	}
        	if(l2lead == null){
        		current.next = l1lead;
        		current = current.next;
        		if(l1lead != null)
        		    l1lead = l1lead.next;
        	}
        	
        	if(l1lead != null && l2lead != null){
        		if(l1lead.val <= l2lead.val){
        			current.next = l1lead;
            		current = current.next;
            		l1lead = l1lead.next;
        		}else{
        			current.next = l2lead;
            		current = current.next;
            		l2lead = l2lead.next;
        		}
        	}
        }
        return head;
        
    }
}
