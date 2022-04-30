package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12931 {
	
	static int N, B[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		int zeroCnt = 0;
		int tCnt = 0;
		
		for(int i=0; i<N; i++) {
			if(B[i]==0) zeroCnt++;
			if(B[i]%2==0) tCnt++;
		}
		
		while(true) {
			if(zeroCnt==N) break;
			zeroCnt = 0;
			if(tCnt==N) {
				tCnt = 0;
				for(int i=0; i<N; i++) {
					B[i] = B[i]/2;
					if(B[i]%2==0) tCnt++;
					if(B[i]==0) zeroCnt++;
				}
			}else {
				tCnt = 0;
				for(int i=0; i<N; i++) {
					if(B[i]%2==1) {
						B[i] = B[i] - 1;
						break;
					}
				}
				for(int i=0; i<N; i++) {
					if(B[i]==0) zeroCnt++;
					if(B[i]%2==0) tCnt++;
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
