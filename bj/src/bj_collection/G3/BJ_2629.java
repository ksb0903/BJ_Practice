package bj_collection.G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2629 {
	
	static int N, weight[], M;
	static boolean dp[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		weight = new int[N+1];
		dp = new boolean[31][15001];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int marble = Integer.parseInt(st.nextToken());
			if(marble>15000) bw.write("N ");
			else {
				if(dp[N][marble]) bw.write("Y ");
				else bw.write("N ");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void solve(int idx, int w) {
		if(dp[idx][w]) return;
		dp[idx][w] = true;
		if(idx==N) return;
		
		solve(idx+1, w+weight[idx+1]);
		solve(idx+1, w);
		solve(idx+1, Math.abs(w-weight[idx+1]));
	}
}
