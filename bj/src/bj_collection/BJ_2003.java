package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003 {
	
	static int N, num[];
	static long M, sum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		sum = 0;
		int start = 0;
		int end = 0;
		int cnt = 0;
		while(true) {
			if(sum>=M) {
				sum -= num[start++];
			}else if(end==N){
				break;
			}else {
				sum += num[end++];
			}
			
			if(sum == M) cnt++;
		}
		System.out.println(cnt);
	}
}
