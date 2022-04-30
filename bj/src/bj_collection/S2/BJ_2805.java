package bj_collection.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long N, M;
	static long[] tree;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[(int)N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(tree);
		bs(1, tree[(int)N-1]);
	}
	
	public static void bs(long start, long end) {
		if(start>end) {
			System.out.println(end);
			return;
		}
		long mid = (start+end)/2;
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			long cut = tree[i]-mid;
			sum += cut>0 ? cut: 0;
		}
		if(sum>=M) {
			bs(mid+1, end);
		}else if(sum<M) {
			bs(start, mid-1);
		}
	}
}
