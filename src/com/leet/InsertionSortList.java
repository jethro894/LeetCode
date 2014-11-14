package com.leet;

public class InsertionSortList {
	public static void main(String[] args){
		
	}
	public ListNode insertionSortList(ListNode head) {
		if(head == null)
			return null;
        ListNode insertion_head = new ListNode(head.val);
        ListNode current = head.next;
        while(current != null){
        	//System.out.println("Inserting: " + current.val);
        	if(insertion_head.val >= current.val){
        		ListNode newNode = new ListNode(current.val);
        		newNode.next = insertion_head;
        		insertion_head = newNode;
        		current = current.next;
        		continue;
        	}
        	
        	ListNode insertion_current = insertion_head;
        	while(insertion_current.val < current.val){
        		if(insertion_current.next != null && insertion_current.next.val < current.val){
        			insertion_current = insertion_current.next;
        			continue;
        		}
        		else if(insertion_current.next == null){
        			insertion_current.next = new ListNode(current.val);
        			break;
        		}else{
        			ListNode newNode = new ListNode(current.val);
        			newNode.next = insertion_current.next;
        			insertion_current.next = newNode;
        			break;
        		}
        	}
        	current = current.next;
        }
        
        return insertion_head;
    }
}
