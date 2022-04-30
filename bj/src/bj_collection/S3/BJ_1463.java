package bj_collection.S3;

import java.util.Scanner;

public class BJ_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println(0);
		}else if(n==2||n==3) {
			System.out.println(1);
		}else {
			System.out.println(solve(n));
		}
		sc.close();
	}
	
	public static int solve(int n) {
		int dp[] = new int[n+1];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=n; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i%2==0 && dp[i]>dp[i/2]+1) {
				dp[i] = dp[i/2]+1;
			}
			if(i%3==0 && dp[i]>dp[i/3]+1) {
				dp[i] = dp[i/3]+1;
			}
		}
		
		return dp[n];
	}
}
