package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R, C;
	static int[][] map, deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int prev = 0;
		int idx = 0;
		while(true) {
			int res = countM();
			findMelt(0,0);
			if(res!=0) {
				prev = res;
			}else {
				System.out.println(idx);
				System.out.println(prev);
				break;
			}
			idx++;
		}
	}
	
	public static void findMelt(int r, int c) {
		Queue<Integer> rq = new LinkedList<>();
		Queue<Integer> cq = new LinkedList<>();
		visited = new boolean[R][C];
		visited[r][c] = true;
		rq.offer(r);
		cq.offer(c);
		
		while(!rq.isEmpty()) {
			int pr = rq.poll();
			int pc = cq.poll();
			
			for(int d=0; d<4; d++) {
				int nr = pr + deltas[d][0];
				int nc = pc + deltas[d][1];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(!visited[nr][nc]) {
						if(map[r][c]==0 && map[nr][nc]==1) {
							map[nr][nc]=-1;
						}else if(map[nr][nc]==0) {
							rq.offer(nr);
							cq.offer(nc);
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	
	public static int countM() {
		int count=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==1) {
					count++;
				}
				if(map[i][j]==-1) {
					map[i][j]=0;
				}
			}
		}
		return count;
	}
}
