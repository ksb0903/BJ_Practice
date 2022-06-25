package bj_collection.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202 {

	static class Jewel{
		int m, v;

		public Jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, C[];
	static Jewel[] jewel;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewel = new Jewel[N];
		C = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jewel[i] = new Jewel(m, v);
		}
		
		Arrays.sort(jewel, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.m == o2.m) {
					return o2.v - o1.v;
				}
				
				return o1.m - o2.m;
			}
		});
		
		for(int i=0; i<K; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(C);
		
		System.out.println(solve());
	}
	
	public static long solve() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long result = 0;
		
		for(int i=0, j=0; i<K; i++) {
			while(j<N && jewel[j].m<=C[i]) {
				pq.offer(jewel[j++].v);
			}
			
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		
		return result;
	}
}
