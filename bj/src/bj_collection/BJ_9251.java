package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		char[] s1 = br.readLine().toCharArray();
		int len1 = s1.length;
		char[] s2 = br.readLine().toCharArray();
		int len2 = s2.length;
		int[][] dp = new int[len1+1][len2+1];
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(s1[i-1]==s2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[len1][len2]);
	}
}
