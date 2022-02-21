package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, res;
	static int[][] map, select, deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	static ArrayList<int[]> zeros = new ArrayList<>();
	static ArrayList<int[]> virus = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		select = new int[3][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) zeros.add(new int[] {i, j});
				if(map[i][j]==2) virus.add(new int[] {i, j});
			}
		}
		
		selectWall(0, 0);
		System.out.println(res);
	}
	
	public static void selectWall(int cnt, int start) {
		if(cnt==3) {
			int[][] clone = new int[N][M];
			for(int i=0; i<N; i++) {
				clone[i] = map[i].clone();
			}
			res = Math.max(res, getSafeZone(clone));
			return;
		}
		
		for(int i=start, size=zeros.size(); i<size; i++) {
			select[cnt] = zeros.get(i);
			selectWall(cnt+1, i+1);
		}
	}
	
	public static int getSafeZone(int[][] clone) {
		int zeroCnt = 0;
		for(int i=0; i<3; i++) {
			clone[select[i][0]][select[i][1]] = 1;
		}
		
		bfs(clone);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(clone[i][j]==0) zeroCnt++;
			}
		}
		
		return zeroCnt;
	}
	
	public static void bfs(int[][] clone) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] virusIdx;
		for(int i=0, size=virus.size(); i<size; i++) {
			virusIdx = virus.get(i);
			queue.offer(virusIdx);
			visited[virusIdx[0]][virusIdx[1]] = true;
		}
		
		while(!queue.isEmpty()) {
			virusIdx = queue.poll();
			int x = virusIdx[0];
			int y = virusIdx[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				if(nx>=0 && ny>=0 && nx<N && ny<M && clone[nx][ny]==0) {
					clone[nx][ny]=2;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
