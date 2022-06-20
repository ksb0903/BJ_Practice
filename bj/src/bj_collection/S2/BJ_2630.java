package bj_collection.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, arr[][], white, blue;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void solve(int x, int y, int range) {
		int std = arr[x][y];
		boolean flag = true;
		
		outer:for(int i=x; i<x+range; i++) {
			for(int j=y; j<y+range; j++) {
				if(arr[i][j] != std) {
					solve(x, y, range/2);
					solve(x+range/2, y, range/2);
					solve(x, y+range/2, range/2);
					solve(x+range/2, y+range/2, range/2);
					flag = false;
					break outer;
				}
			}
		}
		
		if(flag) {
			if(std==0) white++;
			else blue++;
		}
	}
}
