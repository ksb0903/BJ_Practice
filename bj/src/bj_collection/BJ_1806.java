package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S, sum, end, res;
	static int[] nums;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		res = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int start=0; start<N; start++) {
			while(end<N && sum<S) {
				sum += nums[end++];
			}
			if(sum>=S) {
				res = Math.min(res, end-start);
			}
			sum -= nums[start];
		}
		if(res == Integer.MAX_VALUE) res = 0;
		System.out.println(res);
	}
}
