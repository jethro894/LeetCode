package com.leet;

import java.util.HashMap;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
        	return 0;
        int max = 1;
        
        HashMap<Double, Integer> gradients;
        double gradient = 0.0;
        for(int i = 0; i < points.length; i++){
        	gradients = new HashMap<Double, Integer>();
        	int same_points = 0;
        	int max_this_point = 1;
        	for(int j = i+1; j < points.length; j++){
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			same_points++;
        			continue;
        		}else if(points[i].y == points[j].y){
        			gradient = 0.0;
        		}else if(points[i].x == points[j].x){
        			gradient = Double.MAX_VALUE;
        		}
        		else{
        			gradient = (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
        		}
        		
        		if(gradients.containsKey(gradient))
        			gradients.put(gradient, gradients.get(gradient) + 1);
        		else
        			gradients.put(gradient, 2);
        	}
        	
        	for(int v : gradients.values()){
        		max_this_point = Math.max(v, max_this_point);
        	}
        	
        	max_this_point += same_points;
        	max = Math.max(max, max_this_point);
        }
        return max;
    }
}
