package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16918 {
	static int R, C, N, deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static char[][][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[3][R][C];
		Queue<int[]> q1 = new LinkedList<int[]>();
		Queue<int[]> q2 = new LinkedList<int[]>();
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[2][i][j] = s.charAt(j);
				if(map[2][i][j]=='O') {
					q1.offer(new int[] {i,j});
				}
				map[0][i][j] = 'O';
				map[1][i][j] = 'O';
			}
		}
		
		while(!q1.isEmpty()) { // get 0
			int[] point = q1.poll();
			int x = point[0];
			int y = point[1];
			map[0][x][y] = '.';
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<R && ny<C) {
					map[0][nx][ny] = '.';
				}
			}
		}
		
		// get 1
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[0][i][j]=='O') q2.offer(new int[] {i, j});
			}
		}
		
		while(!q2.isEmpty()) {
			int[] point = q2.poll();
			int x = point[0];
			int y = point[1];
			map[1][x][y] = '.';
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<R && ny<C) {
					map[1][nx][ny] = '.';
				}
			}
		}
		
		
		if(N<=1) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[2][i][j]);
				}
				System.out.println();
			}
		}else if(N%2==0){
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
		}else if(N%4==1){
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[1][i][j]);
				}
				System.out.println();
			}
		}else if(N%4==3) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[0][i][j]);
				}
				System.out.println();
			}
		}
	}
}
