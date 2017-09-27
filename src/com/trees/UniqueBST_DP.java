package com.trees;

public class UniqueBST_DP {
	
	public static void main(String args[]) {
		int n = 3;
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= n; i++) {
			for(int j = 0; j < i ; j++){
				count[i] += (count[j]*count[i-j-1]);
			}
		}
		System.out.println(count[n]);
	}

}
