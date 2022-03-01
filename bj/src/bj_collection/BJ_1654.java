package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, N;
	static long ans;
	static int[] lines;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lines = new int[K];
		
		long max = 0;
		for(int i=0; i<K; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lines[i]);
		}
		
		bi_search(1, max);
		System.out.println(ans);
	}
	
	public static void bi_search(long start, long end) {
		if(start>end) return;
		long mid = (start+end)/2;
		int lineCnt = getLine(mid);
		
		if(lineCnt>=N) {
			ans = Math.max(ans, mid);
			bi_search(mid+1, end);
		}else if(lineCnt<N) {
			bi_search(start, mid-1);
		}
	}
	
	public static int getLine(long x) {
		int ret = 0;
		for(int i=0; i<K; i++) {
			ret += lines[i]/x;
		}
		return ret;
	}
}
