package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long res = 0;
		for(int i=0; i<N; i++) {
			if(room[i]>0) {
				room[i] -= B;
				res++;
			}
			
			if(room[i]>0) {
				res += (room[i])/C;
				
				if(room[i]%C != 0) res++;
			}
		}
		
		System.out.println(res);
	}
}
