package bj_collection.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int sum=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken()) * -1;
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for(int i=0; i<N; i++) {
			sum+=A[i]*B[i];
		}
		System.out.println(sum*-1);
	}
}
