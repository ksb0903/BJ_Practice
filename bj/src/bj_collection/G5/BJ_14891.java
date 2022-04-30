package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14891 {
	static int[][] gear = new int[5][8];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=1; i<=4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				gear[i][j] = (int)(s.charAt(j)-'0');
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			rotateProcess(gearNum, dir);
		}
		
		int res = 0;
		for(int i=1; i<=4; i++) {
			if(gear[i][0]==1) {
				res += Math.pow(2, i-1);
			}
		}
		System.out.println(res);
	}
	
	public static void rotateProcess(int gearNum, int dir) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[5];
		q.offer(new int[] {gearNum, dir});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int n = poll[0];
			int d = poll[1];
			if(visited[n]) continue;
			visited[n] = true;
			
			if(n==1) {
				if(gear[1][2] != gear[2][6]) {
					q.offer(new int[] {2, d*-1});
				}
			}else if(n==4) {
				if(gear[4][6] != gear[3][2]) {
					q.offer(new int[] {3, d*-1});
				}
			}else {
				if(gear[n][2] != gear[n+1][6]) {
					q.offer(new int[] {n+1, d*-1});
				}
				if(gear[n][6] != gear[n-1][2]) {
					q.offer(new int[] {n-1, d*-1});
				}
			}
			rotate(n, d);
		}
	}
	
	public static void rotate(int gearNum, int dir) {
		if(dir==1) {
			int tmp = gear[gearNum][7];
			for(int i=7; i>0; i--) {
				gear[gearNum][i] = gear[gearNum][i-1];
			}
			gear[gearNum][0] = tmp;
		}else {
			int tmp = gear[gearNum][0];
			for(int i=0; i<7; i++) {
				gear[gearNum][i] = gear[gearNum][i+1];
			}
			gear[gearNum][7] = tmp;
		}
	}
}
