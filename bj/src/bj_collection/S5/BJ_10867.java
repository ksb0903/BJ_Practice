package bj_collection.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10867 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		boolean arr[] = new boolean[1001];
		boolean arrMinus[] = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(x>0) {
				arr[x] = true;
			}else {
				arrMinus[x*-1] = true;
			}
		}
		
		for(int i=1000; i>=0; i--) {
			if(arrMinus[i]) sb.append(-i + " ");
		}
		for(int i=0; i<=1000; i++) {
			if(arr[i]) sb.append(i + " ");
		}
		
		System.out.println(sb.toString());
	}
}
