package bj_collection.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17143 {
	static class Shark{
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, M, res, map[][], row[], col[];
	static Shark[] sharks;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R+1][C+1];
		sharks = new Shark[M+1];
		row = new int[2*R-2];
		col = new int[2*C-2];
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(r, c, s, d, z);
			map[r][c] = i;
		}
		
		for(int i=0; i<R; i++) {
			row[i] = i+1;
		}
		for(int i=R; i<2*R-2; i++) {
			row[i] = 2*R-i-1;
		}
		
		for(int i=0; i<C; i++) {
			col[i] = i+1;
		}
		for(int i=C; i<2*C-2; i++) {
			col[i] = 2*C-i-1;
		}
		
		solve();
	}
	
	public static void solve() {
		res = 0;
		for(int i=1; i<=C; i++) {
			getShark(i); // 상어 잡기
			moveShark(); // 상어 움직이기
		}
		System.out.println(res);
	}
	
	
	public static void getShark(int idx) {
		for(int i=1; i<=R; i++) {
			int num = map[i][idx];
			
			if(num>0) {
				res += sharks[num].z;
				sharks[num] = null;
				return;
			}
		}
	}
	
	public static void moveShark() {
		map = new int[R+1][C+1];
		
		for(int i=1; i<=M; i++) {
			if(sharks[i]==null) continue;
			
			int s = sharks[i].s;
			int r = sharks[i].r;
			int c = sharks[i].c;
			int x = 0;
			
			switch(sharks[i].d) {
			case 1:
				x = (s-r+1)%(2*R-2);
				if(x<0) x = x+(2*R-2);
				if(x<R-1) sharks[i].d=2; 
				sharks[i].r = row[x];
				break;
			case 2:
				x = (s+r-1)%(2*R-2);
				sharks[i].r = row[x];
				if(x>=R-1) sharks[i].d=1;
				break;
			case 3:
				x = (s+c-1)%(2*C-2);
				sharks[i].c = col[x];
				if(x>=C-1) sharks[i].d=4;
				break;
			case 4:
				x = (s-c+1)%(2*C-2);
				if(x<0) x = x+(2*C-2);
				sharks[i].c = col[x];
				if(x<C-1) sharks[i].d=3;
				break;
			}
			
			if(map[sharks[i].r][sharks[i].c]==0) {
				map[sharks[i].r][sharks[i].c] = i;
			}else {
				int prev = map[sharks[i].r][sharks[i].c];
				if(sharks[prev].z > sharks[i].z) {
					sharks[i] = null;
				}else {
					sharks[prev] = null;
					map[sharks[i].r][sharks[i].c] = i;
				}
			}
		}
	}
}
