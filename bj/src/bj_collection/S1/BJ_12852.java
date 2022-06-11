package bj_collection.S1;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][2];

		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][0] + 1;
			dp[i][1] = i-1;
			
			if(i%3==0) {
				if(dp[i][0]>(dp[i/3][0]+1)) {
					dp[i][0] = dp[i/3][0] + 1;
					dp[i][1] = i/3;
				}
			}
			
			if(i%2==0) {
				if(dp[i][0]>(dp[i/2][0]+1)) {
					dp[i][0] = dp[i/2][0] + 1;
					dp[i][1] = i/2;
				}
			}
		}
		
		System.out.println(dp[N][0]);
		int x = N;
		while(x>0) {
			System.out.print(x);
			
			if(x==1) break;
			
			System.out.print(" ");
			x = dp[x][1];
		}
	}
}
