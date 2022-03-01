package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_9177 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			char[] s1 = st.nextToken().toCharArray();
			char[] s2 = st.nextToken().toCharArray();
			char[] s3 = st.nextToken().toCharArray();
			if(solve(s1, s2, s3)) {
				bw.write("Data set " + t + ": yes\n");
			}else {
				bw.write("Data set " + t + ": no\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean solve(char[] s1, char[] s2, char[] s3) {
		boolean dp[][] = new boolean[s1.length+1][s2.length+1];
		dp[0][0] = true;
		for(int i=1; i<s1.length+1; i++) {
			if(!dp[i-1][0]) dp[i][0] = false;
			else if(s1[i-1]==s3[i-1]) dp[i][0] = true;
		}
		
		for(int i=1; i<s2.length+1; i++) {
			if(!dp[0][i-1]) dp[0][i] = false;
			else if(s2[i-1]==s3[i-1]) dp[0][i] = true;
		}
		
		for(int i=1; i<s1.length+1; i++) {
			for(int j=1; j<s2.length+1; j++) {
				if(s1[i-1]!=s3[i+j-1] && s2[j-1]!=s3[i+j-1]) {
					dp[i][j] = false;
				}else if(s1[i-1]==s3[i+j-1] && s2[j-1]!=s3[i+j-1]) {
					dp[i][j] = dp[i-1][j];
				}else if(s1[i-1]!=s3[i+j-1] && s2[j-1]==s3[i+j-1]) {
					dp[i][j] = dp[i][j-1];
				}else {
					dp[i][j] = dp[i][j-1] || dp[i-1][j];
				}
			}
		}
		
		return dp[s1.length][s2.length];
	}
}
