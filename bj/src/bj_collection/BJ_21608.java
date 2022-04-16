package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21608 {
	static class Student{
		int x, y, like[];

		public Student(int x, int y, int[] like) {
			super();
			this.x = x;
			this.y = y;
			this.like = like;
		}
	}
	
	static class Pos implements Comparable<Pos>{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			
			return this.x-o.x;
		}
	}
	
	static int N, seat[][];
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static Student[] sList;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		seat = new int[N+1][N+1];
		sList = new Student[N*N+1];
		selected = new boolean[N*N+1];
		
		for(int i=1; i<N*N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			int[] like = new int[4];
			for(int j=0; j<4; j++) {
				like[j] = Integer.parseInt(st.nextToken());
			}
			
			if(i==1) {
				sList[num] = new Student(2, 2, like);
				seat[2][2] = num;
				selected[num] = true;
			}else {
				int[] pos = getSeat(num, like);
				sList[num] = new Student(pos[0], pos[1], like);
				seat[pos[0]][pos[1]] = num;
				selected[num] = true;
			}
		}
		
		System.out.println(getRes());
	}
	
	public static int getRes() {
		int res = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int cnt = 0;
				int num = seat[i][j];
				
				for(int d=0; d<4; d++) {
					int x = i + deltas[d][0];
					int y = j + deltas[d][1];
					
					if(x>0 && y>0 && x<=N && y<=N) {
						for(int k=0; k<4; k++) {
							if(seat[x][y]==sList[num].like[k]) {
								cnt++;
								break;
							}
						}
					}
				}
				
				if(cnt>0) {
					res += (int)Math.pow(10, cnt-1);
				}
			}
		}
		
		return res;
	}

	public static int[] getSeat(int num, int[] like) {
		int[][] map = new int[N+1][N+1];
		Queue<Pos> q = new LinkedList<>();
		
		for(int i=0; i<4; i++) {
			if(!selected[like[i]]) continue;
			
			int x = sList[like[i]].x;
			int y = sList[like[i]].y;
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>0 && ny>0 && nx<=N && ny<=N && seat[nx][ny]==0) {
					map[nx][ny]++;
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j]>max) {
					max = map[i][j];
					q.clear();
					q.offer(new Pos(i, j));
				}else if(map[i][j]==max) {
					q.offer(new Pos(i, j));
				}
			}
		}
		
		if(q.size()==1) { // 자리가 하나면
			Pos p = q.poll();
			return new int[] {p.x, p.y};
		}
		
		// 자리가 여러 개이면
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		map = new int[N+1][N+1];
		max = 0;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			if(seat[x][y]!=0) continue;
			int cnt = 0;
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>0 && ny>0 && nx<=N && ny<=N && seat[nx][ny]==0) {
					cnt++;
				}
			}
			
			if(cnt>max) {
				max = cnt;
				pq.clear();
				pq.offer(pos);
			}
			else if(cnt==max) {
				pq.offer(pos);
			}
		}
		
		Pos p = pq.poll();
		return new int[] {p.x, p.y};
	}
	
}
