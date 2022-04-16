package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_4095 {
	static int N, M, map[][], max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N==0 && M==0) break;
			
			map = new int[N+1][M+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(map[i][j]==1) {
						map[i][j] = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1])+1;
					}
					
					if(map[i][j]>max) max = map[i][j];
				}
			}
			
			bw.write(max+"\n");
		}
		bw.flush();
		bw.close();
	}
	
}
