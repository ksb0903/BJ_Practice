package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, liquids[], min, minIdx[];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		liquids = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		minIdx = new int[2];
		
		find();
		System.out.print(minIdx[0] + " " + minIdx[1]);
	}
	
	public static void find() {
		int start = 0;
		int end = liquids.length-1;
		
		while(start<end) {
			int sum = liquids[start] + liquids[end];
			int abs = Math.abs(sum);
			
			if(min>abs) {
				min = abs;
				minIdx[0] = liquids[start];
				minIdx[1] = liquids[end];
			}
			
			if(sum>=0) {
				end--;
			}else {
				start++;
			}
		}
	}
}
