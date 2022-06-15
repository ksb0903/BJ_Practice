package bj_collection.G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16927 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, R, A[][];
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n = N;
		int m = M;
		
		for(int i=1; i<=Math.min(N, M)/2; i++) {
			rotate(i, 2*n + 2*m - 4);
			n -= 2;
			m -= 2;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				bw.write(A[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void rotate(int start, int len) {
		int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1}}; 
		int rCnt = R%len;
		
		for(int i=0; i<rCnt; i++) {
			int x = start;
			int y = start;
			int idx = 0;
			int pre = A[start][start];
			int tmp = 0;
			
			while(idx<4) {
				int nx = x + deltas[idx][0];
				int ny = y + deltas[idx][1];
				
				if(nx>=start && ny>=start && nx<=N-start+1 && ny<=M-start+1) {
					tmp = A[nx][ny];
					A[nx][ny] = pre;
					pre = tmp;
					x = nx;
					y = ny;
				}else idx++;
				
			}
		}
	}
}
