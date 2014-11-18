package com.leet;

public class BestTimeBuySellStock {
	public int maxProfit(int[] prices) {
        if(prices.length == 0)
        	return 0;
        
        int lowest_price = prices[0];
        int max_ending_here = 0;
        int max_so_far = 0;
        
        for(int i = 1; i < prices.length; i++){
        	max_ending_here = prices[i] - lowest_price;
        	if(max_ending_here >= max_so_far)
        		max_so_far = max_ending_here;
        	if(prices[i] < lowest_price)
        		lowest_price = prices[i];
        }
        
        return max_so_far;
    }
}
