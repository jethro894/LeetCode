package com.leet;

public class PredictTheWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 5, 233, 7};
		System.out.println(new PredictTheWinner().PredictTheWinner(nums));
	}
	
	int[][] res;
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length % 2 == 0){
            return true;
        }
        
        int n = nums.length;
        res = new int[n][n];
        for(int i = 0; i <n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = -1;
            }
        }
        
        int maxCanWin = canWin(nums, 0, n-1);
        
        int sum = 0;
        for(int num : nums){
        	sum += num;
        }
        
        if(maxCanWin*2 >= sum){
            return true;
        }else{
            return false;
        }
    }
    
    public int canWin(int[] nums, int start, int end){
    	int val = 0;
    	
        if(start == end){
        	val = nums[start];
        }
        
        else if(start + 1 == end){
        	val = Math.max(nums[start], nums[end]);
        }
        
        else if(res[start][end] >= 0){
            return res[start][end];
        }
        else{
        	val =  Math.max(
                    nums[start] + Math.min(
                        canWin(nums, start+1, end-1), 
                        canWin(nums, start+2, end)
                        ),
                    Math.min(
                        canWin(nums, start, end-2),
                        canWin(nums, start+1, end-1)
                        ) + nums[end]
                    );
        }
        
        res[start][end] = val;
        return val;
    }

}
