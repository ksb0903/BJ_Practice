package bj_collection.G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4485 {
	static int N, map[][], dp[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1; true; tc++){
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			dp = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bw.write(String.format("Problem %d: ", tc));
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<int[]> q = new LinkedList<int[]>();
		dp[0][0] = map[0][0];
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					if(dp[nx][ny]>(dp[x][y]+map[nx][ny])) {
						dp[nx][ny] = dp[x][y]+map[nx][ny];
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		return dp[N-1][N-1];
	}
}
