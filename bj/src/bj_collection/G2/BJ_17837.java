package bj_collection.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17837 {
	
	static class Horse{
		int r, c, dir;

		public Horse(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, map[][], turn;
	static Horse[] horse;
	static ArrayList<Integer>[][] floor;
	static int deltas[][] = {{0,0},{0,1},{0,-1},{-1,0},{1,0}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		horse = new Horse[K];
		floor = new ArrayList[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				floor[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			horse[i] = new Horse(r-1, c-1, d);
			floor[r-1][c-1].add(i);
		}
		
		while(turn<=1000) {
			turn++;
			if(move()) {
				System.out.println(turn);
				break;
			}
			
			if(turn==1000) System.out.println(-1);
		}
	}
	
	public static boolean move() {
		for(int i=0; i<K; i++) {
			int r = horse[i].r;
			int c = horse[i].c;
			int dir = horse[i].dir;
			int nr = r + deltas[dir][0];
			int nc = c + deltas[dir][1];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]==2) {
				if(dir%2==0) {
					horse[i].dir--;
				}else {
					horse[i].dir++;
				}
				dir = horse[i].dir;
				nr = r + deltas[dir][0];
				nc = c + deltas[dir][1];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(map[nr][nc]!=2) {
					i--;
					continue;
				}
			}else {
				boolean bottom = false;
				ArrayList<Integer> tmp = new ArrayList<>();
				for(int j=0; j<floor[r][c].size(); j++) {
					int num = floor[r][c].get(j);
					
					if(num==i) {
						bottom = true;
						tmp.add(i);
						floor[r][c].remove(j);
						j--;
						continue;
					}
					
					if(bottom) {
						horse[num].r = nr;
						horse[num].c = nc;
						tmp.add(num);
						floor[r][c].remove(j);
						j--;
					}
				}
				
				horse[i].r = nr;
				horse[i].c = nc;
				if(map[nr][nc]==0) {
					for(int j=0; j<tmp.size(); j++) {
						floor[nr][nc].add(tmp.get(j));
					}
				}else if(map[nr][nc]==1) {
					for(int j=tmp.size()-1; j>=0; j--) {
						floor[nr][nc].add(tmp.get(j));
					}
				}
				
				if(floor[nr][nc].size()>=4) {
					return true;
				}
			}
		}
		
		return false;
	}
}
