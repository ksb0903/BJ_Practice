package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12100 {
	static int N, max = 0;
	static char[] select, cmd = {'U', 'D', 'R', 'L'};
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		select = new char[5];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//perm(0);
		test();
		System.out.println(max);
	}
	
	public static void test() {
		map = move(map, 'L');
		max = Math.max(max, getMax(map));
	}
	
	public static void perm(int cnt) {
		if(cnt==5) {
			int[][] copy = new int[N][N];
			for(int i=0; i<N; i++) {
				copy[i] = map[i].clone();
			}
			
			for(int i=0; i<5; i++) {
				copy = move(copy, select[i]);
			}
			
			max = Math.max(max, getMax(copy));
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			select[cnt] = cmd[i];
			perm(cnt+1);
		}
	}
	
	public static int getMax(int[][] arr) {
		int res = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				res = Math.max(res, arr[i][j]);
			}
		}
		
		return res;
	}
	
	public static int[][] move(int[][] arr, char cmd){
		boolean[][] flag = new boolean[N][N];
		
		if(cmd=='U') {
			for(int j=0; j<N; j++) {
				for(int i=1; i<N; i++) {
					if(arr[i][j]!=0) {
						int ni = i-1;
						while(true) {
							if(ni<0 || flag[ni][j]) break;
							
							if(arr[ni][j]==0) {
								arr[ni][j] = arr[ni+1][j];
								arr[ni+1][j] = 0;
							}else if(arr[ni][j]==arr[ni+1][j]) {
								arr[ni][j] *= 2;
								arr[ni+1][j] = 0;
								flag[ni][j] = true;
								break;
							}else break;
							
							ni--;
						}
					}
				}
			}
		}else if(cmd=='D') {
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>=0; i--) {
					if(arr[i][j]!=0) {
						int ni = i+1;
						while(true) {
							if(ni>=N || flag[ni][j]) break;
							
							if(arr[ni][j]==0) {
								arr[ni][j] = arr[ni-1][j];
								arr[ni-1][j] = 0;
							}else if(arr[ni][j]==arr[ni-1][j]) {
								arr[ni][j] *= 2;
								arr[ni-1][j] = 0;
								flag[ni][j] = true;
								break;
							}else break;
							
							ni++;
						}
					}
				}
			}
		}else if(cmd=='L') {
			for(int i=0; i<N; i++) {
				for(int j=1; j<N; j++) {
					if(arr[i][j]!=0) {
						int nj = j-1;
						while(true) {
							if(nj<0 || flag[i][nj]) break;
							
							if(arr[i][nj]==0) {
								arr[i][nj] = arr[i][nj+1];
								arr[i][nj+1] = 0;
							}else if(arr[i][nj]==arr[i][nj+1]) {
								arr[i][nj] *= 2;
								arr[i][nj+1] = 0;
								flag[i][nj] = true;
								break;
							}else break;
							
							nj--;
						}
					}
				}
			}
		}else if(cmd=='R') {
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					if(arr[i][j]!=0) {
						int nj = j+1;
						while(true) {
							if(nj>=N || flag[i][nj]) break;
							
							if(arr[i][nj]==0) {
								arr[i][nj] = arr[i][nj-1];
								arr[i][nj-1] = 0;
							}else if(arr[i][nj]==arr[i][nj-1]) {
								arr[i][nj] *= 2;
								arr[i][nj-1] = 0;
								flag[i][nj] = true;
								break;
							}else break;
							
							nj++;
						}
					}
				}
			}
		}
		
		return arr;
	}
}
