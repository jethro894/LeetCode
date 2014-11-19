package com.leet.tripad;

import com.leet.ListNode;

public class LinkedList {
	ListNode head;
	
	public LinkedList(){
		head = null;
	}
	
	//Returns true if list is empty
    public boolean isEmpty() {
	    return head == null;
    }
    
    //Inserts a new Link at the first of the list
    public void insert(int val) {
    	ListNode newNode = new ListNode(val);
    	newNode.next = head;
    	head = newNode;
    }
    
    public ListNode delete(){
    	ListNode newHead = head.next;
    	head.next = null;
    	head = newHead;
    	return head;
    }
    
    public ListNode deleteCertain(){
    	ListNode helper = new ListNode(0);
    	helper.next = head;
    	ListNode current = helper;
    	while(current.next != null){
    		//say 99
    		if(current.next.val == 99)
    			current.next = current.next.next;
    		current = current.next;
    	}
    	return helper.next;
    }
	
	public void print(){
		if(head == null)
			return;
		ListNode current = head;
		while(current!= null){
			System.out.println(current.val);
			current = current.next;
		}
	}
}
