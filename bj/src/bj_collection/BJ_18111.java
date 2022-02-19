package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_18111 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, B, resBlock, resTime=Integer.MAX_VALUE, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(map[i][j], min);
				max = Math.max(map[i][j], max);
			}
		}
		for(int i=min; i<=max; i++) {
			int[] tmp = solve(i);
			if(resTime>=tmp[0] && tmp[1]>=0) {
				resTime = tmp[0];
				resBlock = i;
			}
		}
		System.out.println(resTime + " " + resBlock);
	}
	
	public static int[] solve(int n) {
		int time = 0;
		int b = B;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int x = map[i][j]-n;
				if(x>0) {
					time += x*2;
					b += x;
				}
				if(x<0) {
					time += x*-1;
					b += x;
				}
			}
		}
		
		return new int[] {time, b};
	}
}
