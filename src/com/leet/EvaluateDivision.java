package com.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] equations = new String[][]{new String[]{"a","b"}, new String[]{"b","c"}, new String[]{"e","f"}};
		double[] values = new double[] {2.0, 3.0, 2.0};
		String[][] queries = new String[][] {new String[]{"e","f"}};
		double[] result = new EvaluateDivision().calcEquation(equations, values, queries);
		
		System.out.println("Result: ");
		for(double d : result){System.out.println(d);}
	}
	String currentUnit = null;

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Double> res = new HashMap<String, Double>();
		
		List<Triplet> savedForLater = enumerate(equations ,values, res);
		
		List<Triplet> noResult = new ArrayList<Triplet>();
		for(Triplet t : savedForLater){
			process(t.dividend, t.divisor, t.fraction, res, noResult);
			//System.out.println(t.dividend + "/" + t.divisor + "=" + t.fraction);
		}
		
		System.out.println("Not Processed");
		Map<String, Map<String, Double>> notProcessed = new HashMap<String, Map<String, Double>>();
		for(Triplet t : noResult){
			//System.out.println(t.dividend + "/" + t.divisor + "=" + t.fraction);
			Map<String, Double> inner = new HashMap<String, Double>();
			inner.put(t.divisor, t.fraction);
			notProcessed.put(t.dividend, inner);
		}
		
		
		System.out.println("currentUnit: " + currentUnit);
		for(String key : res.keySet()){
			System.out.println(key + ": " + res.get(key));
		}
		
		double[] result = new double[queries.length];
		for(int i = 0; i < result.length; i++){
			String[] query = queries[i];
			String dividend = query[0];
			String divisor = query[1];
			
			if(res.containsKey(dividend) && res.containsKey(divisor)){
				result[i] = res.get(dividend)/res.get(divisor);
			}else if(notProcessed.containsKey(dividend) && notProcessed.get(dividend).containsKey(divisor)){
				result[i] = notProcessed.get(dividend).get(divisor);
			}else{
				result[i] = -1d;
			}
		}
		
		return result;
    }
	
	public List<Triplet> enumerate(String[][] equations, double[] values, Map<String, Double> res){
		List<Triplet> savedForLater = new ArrayList<Triplet>();
		
		for(int i = 0; i < equations.length; i++){
        	String[] equation = equations[i];
        	String dividend = equation[0];
        	String divisor = equation[1];
        	double fraction = values[i];
        	
        	process(dividend, divisor, fraction, res, savedForLater);
        }
		
		return savedForLater;
	}
	
	public void process(String dividend, String divisor, double fraction, Map<String, Double> res, List<Triplet> savedForLater){
		if(currentUnit == null){
    		currentUnit = divisor;
    		res.put(divisor, 1d);
    		res.put(dividend, fraction);
    	}else{
    		if(divisor.equals(currentUnit)){
    			//Insert dividend
    			res.put(dividend, fraction);
    		}else if(dividend.equals(currentUnit)){
    			//Change currentUnit
    			for(String key : res.keySet()){
    				res.put(key, res.get(key) * fraction);
    			}
    			currentUnit = divisor;
    			res.put(dividend, fraction);
    		}else{
    			if(res.containsKey(divisor)){
    				//Insert dividend
    				res.put(dividend, fraction * res.get(divisor));
    			}else if(res.containsKey(dividend)){
    				if(fraction > res.get(dividend)){
    					//Change currentUnit
    					double relFrac = fraction/res.get(dividend);
    					for(String key : res.keySet()){
    	    				res.put(key, res.get(key) * relFrac);
    	    			}
    					currentUnit = divisor;
    					res.put(divisor, 1d);
    				}else{
    					//Insert divisor
    					res.put(divisor, res.get(dividend)/fraction);
    				}
    			}else{
    				//Save for later
    				savedForLater.add(new Triplet(dividend, divisor, fraction));
    			}
    		}
    	}
	}
	
	class Triplet{
		String dividend ;
    	String divisor;
    	double fraction;
    	
    	Triplet(String a, String b, double adb){
    		dividend = a;
    		divisor = b;
    		fraction = adb;
    	}
	}
}
