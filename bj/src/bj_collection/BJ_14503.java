package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_14503 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[][] arr;
	
	class Robot{
		private int r;
		private int c;
		private int d;
		private int count=0;
		
		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		public int getCount() {
			return this.count;
		}
		
		public void clean() {
			if(arr[r][c]==0) {
				arr[r][c]=-1;
				this.count++;
			}
		}
		
		public boolean move() {
			switch(d) {
			case 0:
				if(c-1>=0 && arr[r][c-1]==0) {
					this.c = c-1;
					this.d = 3;
					return true;
				}
				this.d = 3;
				break;
			case 1:
				if(r-1>=0 && arr[r-1][c]==0) {
					this.r = r-1;
					this.d = 0;
					return true;
				}
				this.d = 0;
				break;
			case 2:
				if(c+1<M && arr[r][c+1]==0) {
					this.c = c+1;
					this.d = 1;
					return true;
				}
				this.d = 1;
				break;
			case 3:
				if(r+1<N && arr[r+1][c]==0) {
					this.r = r+1;
					this.d = 2;
					return true;
				}
				this.d = 2;
				break;
			}
			
			return false;
		}
		
		public boolean moveBack() {
			switch(d) {
			case 0:
				if(r+1>=N || arr[r+1][c]==1) {
					return false;
				}else {
					this.r = r+1;
					return true;
				}
			case 1:
				if(c-1<=0 || arr[r][c-1]==1) {
					return false;
				}else {
					this.c = c-1;
					return true;
				}
			case 2:
				if(r-1<=0 || arr[r-1][c]==1) {
					return false;
				}else {
					this.r = r-1;
					return true;
				}
			case 3:
				if(c+1>=M || arr[r][c+1]==1) {
					return false;
				}else {
					this.c = c+1;
					return true;
				}
			}
			return false;
		}
	}

	
	public static void main(String[] args) throws IOException{
		BJ_14503 bj = new BJ_14503();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		Robot robot = bj.new Robot(r, c, d);
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		outer: while(true) {
			robot.clean();
			for(int i=0; i<4; i++) {
				if(robot.move()) break;
				
				if(i==3) {
					if(!robot.moveBack()) {
						break outer;
					}
				}
			}
		}
		
		bw.write(robot.getCount()+"");
		bw.flush();
		bw.close();
		
	}
}
