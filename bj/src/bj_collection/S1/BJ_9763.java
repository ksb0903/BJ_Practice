package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9763 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, v[][];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		v = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			v[i][0] = Integer.parseInt(st.nextToken());
			v[i][1] = Integer.parseInt(st.nextToken());
			v[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			int min1 = Integer.MAX_VALUE;
			int min2 = Integer.MAX_VALUE;
			
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				
				int d = Math.abs(v[i][0] - v[j][0]) + Math.abs(v[i][1] - v[j][1]) + Math.abs(v[i][2] - v[j][2]);
				
				if(min1>d) {
					min2 = min1;
					min1 = d;
				}else if(min2>d) {
					min2 = d;
				}
			}
			
			min = Math.min(min, min1+min2);
		}
		
		System.out.println(min);
	}
}
