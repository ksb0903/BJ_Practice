package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15684 {
	
	static int N, M, H, size, map[][], min;
	static boolean flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		
		min = -1;
		solve();
	}
	
	public static void solve() {
		/* 1. 가로 사다리를 놓을 수 있는 모든 장소를 찾는다.(map[a][b-1]!=0) 
		 * 2. 0개부터 3개까지 사다리를 놓아본다.
		 * 3. 하나라도 i번째에서 i번째에 도착하지 않으면 return
		 * */
		
		ArrayList<int[]> list = new ArrayList<>();
		find(list);
		size = list.size();
		for(int i=0; i<=3; i++) {
			putLadder(list, i, 0, 0);
			if(flag) break;
		}
		
		System.out.println(min);
	}
	
	public static void putLadder(ArrayList<int[]> list, int idx, int cnt, int prev) {
		if(cnt==idx) {
			if(check()) {
				min = idx;
				flag = true;
			}
			
			return;
		}
		
		for(int i=prev; i<size; i++) {
			int[] point = list.get(i);
			int r = point[0];
			int c = point[1];
			
			if(c>1 && map[r][c-1]==1) continue;
			if(c<N-1 && map[r][c+1]==1) continue;
			
			map[r][c] = 1;
			putLadder(list, idx, cnt+1, i+1);
			map[r][c] = 0;
		}
	}
	
	public static boolean check() {
		for(int i=1; i<=N; i++) {
			int num = i;
			for(int j=1; j<=H; j++) {
				if(num==1) {
					if(map[j][num]==1) num++;
				}else {
					if(map[j][num]==1) num++;
					else if(map[j][num-1]==1) num--;
				}
			}
			if(num!=i) return false;
		}
		
		return true;
	}
	
	public static void find(ArrayList<int[]> list) {
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(j==1) {
					if(map[i][1]==0) list.add(new int[] {i, 1});
				}else {
					if(map[i][j]==0 && map[i][j-1]!=1) {
						list.add(new int[] {i, j});
					}
				}
			}
		}
	}
}
