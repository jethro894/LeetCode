package com.leet;

import java.util.HashMap;

public class LRUCache {
	class TwoWayNode{
		int key;
		int val;
		TwoWayNode next;
		TwoWayNode previous;
		public TwoWayNode(int k, int v) {
			this.key = k;
			this.val = v;
			this.next = null;
			this.previous = null;
		}
	}
	
	private int cap;
	private int num;
	//first: least recently used
	//last: most recently used
	private TwoWayNode first, last;
	private HashMap<Integer, TwoWayNode> map;
	
	public LRUCache(int capacity) {
        this.cap = capacity;
        this.num = 0;
        this.map = new HashMap<Integer, TwoWayNode>();
        this.first = null;
        this.last = null;
    }
    
    public int get(int key) {
        TwoWayNode node = map.get(key);
        if(node == null)
        	return -1;
        else if(node != last){
        	if(node == first)
        		first = first.next;
        	else{
        		node.previous.next = node.next;
        	}
        	node.next.previous = node.previous;
        	node.next = null;
        	node.previous = last;
        	last.next = node;
        	last = node;
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        TwoWayNode node = map.get(key);
        if(node != null){
        	node.val = value;
        	if(node != last){
        		if(node == first)
            		first = first.next;
            	else{
            		node.previous.next = node.next;
            	}
            	node.next.previous = node.previous;
            	node.next = null;
            	node.previous = last;
            	last.next = node;
            	last = node;
        	}
        }
        else{
        	node = new TwoWayNode(key, value);
        	if(num >= cap){
        		map.remove(first.key);
        		first = first.next;
        		if(first != null)
        			first.previous = null;
        		else
        			last = null;
        		num--;
        	}
        	if(num == 0){
        		first = node;
        		last = node;
        	}else{
        		last.next = node;
        		node.previous = last;
        		last = node;
        	}
        	map.put(key, node);
        	num++;	
        }
    }
}
