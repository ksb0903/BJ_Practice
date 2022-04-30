package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9663 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, result;
	static int row[];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		row = new int[N];
		dfs(0);
		System.out.println(result);
	}
	
	public static void dfs(int n) {
		if(n==N) result++;
		else {
			for(int i=0; i<N; i++) {
				row[n] = i;
				if(promising(n)) dfs(n+1);
			}
		}
	}
	
	public static boolean promising(int n) {
		for(int i=0; i<n; i++) {
			if(row[n]==row[i] || Math.abs(row[n]-row[i])==n-i) {
				return false;
			}
		}
		
		return true;
	}
}
