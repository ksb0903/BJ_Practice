package bj_collection.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_8980 {
	
	static class Box implements Comparable<Box>{
		int from, to, cnt;

		public Box(int from, int to, int cnt) {
			super();
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Box o) {
			if(this.to==o.to) {
				return this.from - o.from;
			}
			
			return this.to - o.to;
		}
	}
	
	static int N, C, M, arr[];
	static Box[] box;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		box = new Box[M];
		arr = new int[N];
		Arrays.fill(arr, C);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			box[i] = new Box(from, to, cnt);
		}
		Arrays.sort(box);
		
		int res = 0;
		for(int i=0; i<M; i++) {
			Box b = box[i];
			
			int maxCnt = Integer.MAX_VALUE;
			
			for(int j=b.from; j<b.to; j++) {
				maxCnt = Math.min(maxCnt, arr[j]);
			}
			
			if(maxCnt>=b.cnt) {
				for(int j=b.from; j<b.to; j++) {
					arr[j] -= b.cnt;
				}
				
				res += b.cnt;
			}else {
				for(int j=b.from; j<b.to; j++) {
					arr[j] -= maxCnt;
				}
				
				res += maxCnt;
			}
		}
		
		System.out.println(res);
	}
}
