package bj_collection.G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_14500 {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(solve() + "");
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int max=0;
		
		max = Math.max(max, shape1());
		max = Math.max(max, shape2());
		max = Math.max(max, shape3());
		max = Math.max(max, shape4());
		max = Math.max(max, shape5());
		
		return max;
	}
	
	public static int shape1() { // 길쭉한거
		int max=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-3; j++) {
				int sum=0;
				for(int k=0; k<4; k++) {
					sum+=map[i][j+k];
				}
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-3; i++) {
			for(int j=0; j<M; j++) {
				int sum=0;
				for(int k=0; k<4; k++) {
					sum+=map[i+k][j];
				}
				max=max>sum?max:sum;
			}
		}
		
		return max;
	}
	
	public static int shape2() { // 정사각형
		int max=0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-1; j++) {
				int sum=0;
				for(int k=0; k<2; k++) {
					for(int l=0; l<2; l++) {
						sum+=map[i+k][j+l];
					}
				}
				max=max>sum?max:sum;
			}
		}
		
		return max;
	}
	
	public static int shape3() { // ㅗ
		int max=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-2; j++) {
				int sum=0;
				for(int k=0; k<3; k++) {
					sum+=map[i][j+k];
				}
				if(i==0) {
					sum+=map[i+1][j+1];
				}else if(i==N-1) {
					sum+=map[i-1][j+1];
				}else {
					sum+=Math.max(map[i+1][j+1], map[i-1][j+1]);
				}
				
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M; j++) {
				int sum=0;
				for(int k=0; k<3; k++) {
					sum+=map[i+k][j];
				}
				if(j==0) {
					sum+=map[i+1][j+1];
				}else if(j==M-1) {
					sum+=map[i+1][j-1];
				}else {
					sum+=Math.max(map[i+1][j+1], map[i+1][j-1]);
				}
				
				max=max>sum?max:sum;
			}
		}
		
		return max;
	}
	
	public static int shape4() { // 번개
		int max=0;
		
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M-1; j++) {
				int sum=0;
				sum+=map[i][j];
				sum+=map[i+1][j];
				sum+=map[i+1][j+1];
				sum+=map[i+2][j+1];
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-2; i++) {
			for(int j=1; j<M; j++) {
				int sum=0;
				sum+=map[i][j];
				sum+=map[i+1][j];
				sum+=map[i+1][j-1];
				sum+=map[i+2][j-1];
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<M-2; j++) {
				int sum=0;
				sum+=map[i][j];
				sum+=map[i][j+1];
				sum+=map[i+1][j+1];
				sum+=map[i+1][j+2];
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=2; j<M; j++) {
				int sum=0;
				sum+=map[i][j];
				sum+=map[i][j-1];
				sum+=map[i+1][j-1];
				sum+=map[i+1][j-2];
				max=max>sum?max:sum;
			}
		}
		
		return max;
	}
	
	public static int shape5() { // 총
		int max=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M-2; j++) {
				int sum=0;
				for(int k=0; k<3; k++) {
					sum+=map[i][j+k];
				}
				if(i==0) {
					sum+=Math.max(map[i+1][j], map[i+1][j+2]);
				}else if(i==N-1) {
					sum+=Math.max(map[i-1][j], map[i-1][j+2]);
				}else {
					sum+=Math.max(Math.max(map[i+1][j], map[i+1][j+2]), Math.max(map[i-1][j], map[i-1][j+2]));
				}
				
				max=max>sum?max:sum;
			}
		}
		
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<M; j++) {
				int sum=0;
				for(int k=0; k<3; k++) {
					sum+=map[i+k][j];
				}
				if(j==0) {
					sum+=Math.max(map[i][j+1], map[i+2][j+1]);
				}else if(j==M-1) {
					sum+=Math.max(map[i][j-1], map[i+2][j-1]);
				}else {
					sum+=Math.max(Math.max(map[i][j+1], map[i+2][j+1]), Math.max(map[i][j-1], map[i+2][j-1]));
				}
				
				max=max>sum?max:sum;
			}
		}
		
		return max;
	}
}
