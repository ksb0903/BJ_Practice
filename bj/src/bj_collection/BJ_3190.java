package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {
	static int N, K, L, X[], map[][];
	static char C[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
		}
		L = Integer.parseInt(br.readLine());
		X = new int[L+1];
		C = new char[L+1];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			C[i] = st.nextToken().charAt(0);
		}
		
		solve();
	}
	
	public static void solve() {
		int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		map[1][1] = -1;
		Queue<int[]> tail = new LinkedList<int[]>();
		tail.offer(new int[] {1,1});
		int head_x = 1, head_y = 1;
		int time = 0;
		int idx = 0;
		int d = 0;
		
		while(true) {
			++time;
			if(time==X[idx]+1) {
				if(C[idx]=='L') {
					d = (d+3)%4;
				}else if(C[idx]=='D') {
					d = (d+1)%4;
				}
				++idx;
			}
			
			head_x = head_x + deltas[d][0];
			head_y = head_y + deltas[d][1];
			
			if(head_x>=1 && head_y>=1 && head_x<=N && head_y<=N) {
				if(map[head_x][head_y]==0) {
					map[head_x][head_y] = -1;
					tail.offer(new int[] {head_x, head_y});
					int[] poll = tail.poll();
					map[poll[0]][poll[1]] = 0;
				}else if(map[head_x][head_y]==1) {
					map[head_x][head_y] = -1;
					tail.offer(new int[] {head_x, head_y});
				}else if(map[head_x][head_y]==-1) break;
			}else break;
		}
		
		System.out.println(time);
	}
}
