package bj_collection.S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, A[];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			bw.write(search(x) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int search(int x) {
		int start = 0;
		int end = N-1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			
			if(x==A[mid]) return 1;
			else if(x<A[mid]) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return 0;
	}
}
