package com.leet.briEd;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Fibonacci().recursiveFibonacci(10));
		System.out.println(new Fibonacci().iterativeFibonacci(10));
		System.out.println(new Fibonacci().dpFibonacci(10));
	}
	
	public int recursiveFibonacci(int n){
		if(n == 0 || n == 1)
			return 1;
		return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}

	public int iterativeFibonacci(int n){
		if(n == 0 || n == 1)
			return 1;
		int prepre = 1;
		int pre = 1;
		int num = 2;
		int result = 0;
		while(num <= n){
			result = prepre + pre;
			prepre = pre;
			pre = result;
			num++;
		}
		return result;
	}
	
	public int dpFibonacci(int n){
		int[] result = new int[n+1];
		
		for(int i = 0; i < result.length; i++){
			if(i == 0 || i == 1)
				result[i] = 1;
			else
				result[i] = result[i-1] + result[i-2];
		}
		return result[n];
	}
}
