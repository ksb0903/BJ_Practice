package bj_collection.G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11404 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, cost[][];
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++) {
				cost[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(cost[from][to] == INF) cost[from][to] = c;
			else cost[from][to] = Math.min(cost[from][to], c);
		}
		
		floyd();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(cost[i][j]==INF) bw.write("0 ");
				else bw.write(cost[i][j] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void floyd() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
	}
}
