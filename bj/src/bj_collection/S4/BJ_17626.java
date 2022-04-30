package bj_collection.S4;

import java.io.IOException;
import java.util.Scanner;

public class BJ_17626 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[50001];
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				min = Math.min(min, 1+dp[i-j*j]);
			}
			dp[i] = min;
		}
		
		System.out.println(dp[n]);
	}
}
