package bj_collection.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305 {
	
	static long N, dist[], cost[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Long.parseLong(br.readLine());
		dist = new long[(int)N-1];
		cost = new long[(int)N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		long minCost = cost[0];
		long res = 0;
		
		for(int i=0; i<N-1; i++) {
			if(minCost>cost[i]) minCost = cost[i];
			res += minCost * dist[i];
		}
		
		System.out.println(res);
	}
}
