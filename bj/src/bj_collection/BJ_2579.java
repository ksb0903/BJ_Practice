package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2579 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int N;
	static int[] score;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		score = new int[300];
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		bw.write(solve()+"");
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int[] sum = new int[300];
		sum[0] = score[0];
		sum[1] = score[0]+score[1];
		sum[2] = Math.max(score[0]+score[2], score[1]+score[2]);
		for(int i=3; i<N; i++) {
			sum[i] = Math.max(score[i]+sum[i-2], score[i]+score[i-1]+sum[i-3]);
		}
		
		return sum[N-1];
	}
}
