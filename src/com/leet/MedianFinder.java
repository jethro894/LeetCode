package com.leet;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://segmentfault.com/a/1190000003709954

public class MedianFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianFinder obj = new MedianFinder();
		obj.addNum(-1);
		System.out.println(obj.findMedian());
		obj.addNum(-2);
		System.out.println(obj.findMedian());
		obj.addNum(-3);
		System.out.println(obj.findMedian());
		obj.addNum(-4);
		System.out.println(obj.findMedian());
		obj.addNum(-5);
		System.out.println(obj.findMedian());
	}
	
	Queue<Integer> max;
	Queue<Integer> min;
	/** initialize your data structure here. */
    public MedianFinder() {
    	max = new PriorityQueue<Integer>(10, Collections.reverseOrder());
    	min = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
    	if(max.size() == 0 || num <= max.peek()){
    		if(max.size() > min.size()){
    			min.add(max.poll());
    		}
    		max.add(num);
    	}else if(min.size() == 0 || num >= min.peek()){
    		if(min.size() > max.size()){
    			max.add(min.poll());
    		}
    		min.add(num);
    	}else{
    		if(max.size() > min.size()){
        		min.add(num);
        	}else{
        		max.add(num);
        	}
    	}
    }
    
    public double findMedian() {
        if(max.size() > min.size()){
        	return (double) max.peek();
        }else if(max.size() < min.size()){
        	return (double) min.peek();
        }else if(max.size() == 0 && min.size() == 0){
        	return 0d;
        }else{
        	return ((double)max.peek() + (double)min.peek())/2;
        }
    }
}
