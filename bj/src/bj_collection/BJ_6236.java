package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_6236 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K, max;
	static int[] expenditure;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.MAX_VALUE;
		expenditure = new int[N];
		for(int i=0; i<N; i++) {
			expenditure[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, expenditure[i]);
		}
		search(max, sum(expenditure));
		System.out.println(K);
	}
	
	public static void search(int start, int end) {
		if(start>end) return;
		
		int count = 0;
		int mid = (start+end)/2;
		int money = 0;
		for(int i=0; i<N; i++) {
			if(money<expenditure[i]) {
				money = mid;
				count++;
			}
			money -= expenditure[i];
		}
		
		if(count>M || mid<max) {
			search(mid+1, end);
		}else {
			search(start, mid-1);
			K = Math.min(mid, K);
		}
	}
	
	public static int sum(int[] arr) {
		int sum=0;
		for(int i=0, size = arr.length; i<size; i++) {
			sum+=arr[i];
		}
		return sum;
	}
}
