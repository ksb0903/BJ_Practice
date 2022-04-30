package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20058 {
	static int N, Q, map[][], L[], sum, area;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		L = new int[Q];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<Q; i++) {
			map = fireStorm(L[i]);
		}
		//print();
		
		getSum();
		getArea();
		
		System.out.println(sum);
		System.out.println(area);
	}
	
	public static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void getSum() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum += map[i][j];
			}
		}
	}
	
	public static void getArea() {
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]!=0) 
					area = Math.max(bfs(i, j), area);
			}
		}
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int cnt = 1;
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			
			for(int d=0; d<4; d++) {
				int nx = poll[0] + deltas[d][0];
				int ny = poll[1] + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]!=0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static int[][] fireStorm(int cmd) {
		int[][] clone = new int[N][N];
		int n = (int)Math.pow(2, cmd);
		
		for(int i=0; i<N; i=i+n) {
			for(int j=0; j<N; j=j+n) {
				
				for(int ii=0; ii<n; ii++) {
					for(int jj=0; jj<n; jj++) {
						clone[i+jj][j-ii+n-1] = map[i+ii][j+jj];
					}
				}
			}
		}
		
		boolean[][] melt = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(clone[i][j]==0) continue;
				int iceCnt = 0;
				
				for(int d=0; d<4; d++) {
					int x = i+deltas[d][0];
					int y = j+deltas[d][1];
					
					if(x>=0 && y>=0 && x<N && y<N && clone[x][y]!=0) {
						iceCnt++;
					}
				}
				
				if(iceCnt<3) melt[i][j] = true;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(melt[i][j]) clone[i][j]--;
			}
		}
		
		return clone;
	}
}
