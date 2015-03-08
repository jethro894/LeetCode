package com.leet;

import java.util.HashMap;
import java.util.Map;

public class FractionRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)
        	return "";
        if(numerator == 0)
        	return "0";
        
        StringBuilder sb = new StringBuilder();
        if((denominator>0 && numerator<0)||(denominator<0 && numerator>0))
        	sb.append("-");
        
        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);
        
        sb.append(numeratorL/denominatorL);
        long remainder = numeratorL % denominatorL;
        if(remainder == 0)
        	return sb.toString();
        
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        
        while(remainder != 0 && !map.containsKey(remainder)){
        	map.put(remainder, sb.length());
        	remainder *= 10;
        	sb.append(remainder/denominatorL);
        	remainder %= denominatorL;
        }
        
        if(map.containsKey(remainder)){
        	sb.insert(map.get(remainder), "(");
        	sb.append(")");
        }
        
        return sb.toString();
    }
}
