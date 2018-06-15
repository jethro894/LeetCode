package com.leet;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5};
		int k = 4;
		int x = -3;
		
		System.out.println(new FindKClosestElements().findClosestElements(arr, k, x));
	}

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        
        int center = -1;
        int[] centers = null;
        if (x <= arr[0]) {
            center = 0;
        } else if (x >= arr[arr.length-1]) {
            center = arr.length-1;
        }
        
        if (center < 0) {
            double xPos = findPos(arr,x,0,arr.length);
            if (xPos % 1  == 0) {
                //x exists in arr. 
                center = (int)xPos;
            } else {
                centers = new int[] {(int)Math.floor(xPos), (int)Math.ceil(xPos)};
            }
        }
        
        System.out.println(center);
        System.out.println(centers);
        
        if (center >= 0) {
            grow(arr, k, x, center, center, res);
        } else if (centers != null) {
            grow(arr, k, x, centers[0], centers[1], res);
        }
        
        return res;
    }
    
    public double findPos (int[] arr, int x, int start, int end) {
        if (start == end-1) {
            return ((double)start + (double)end)/2;
        }
        int mid = (start + end)/2;
        if (arr[mid] < x) {
            return findPos(arr,x,mid,end);
        } else if (arr[mid] > x) {
            return findPos(arr,x,start,mid);
        } else {
            return mid;
        }
    }
    
    public void grow(int[] arr, int k, int x, int left, int right, List<Integer> res) {
        int count = 0;
        if (left == right) {
            left--;
        }
        while (count < k) {
        	System.out.println("count: " + count + ", left: " + left + ", right: " + right);
        	
        	//smaller is preferred, so <= is used here when trying to go left
        	if (left >= 0 && (right >= arr.length || x-arr[left] <= arr[right]-x)) {
                res.add(0, arr[left]);
                left--;
                count++;
            }
        	else if (right < arr.length && (left < 0 || x-arr[left] > arr[right]-x)) {
                res.add(arr[right]);
                right++;
                count++;
            }
        }
    }
}
