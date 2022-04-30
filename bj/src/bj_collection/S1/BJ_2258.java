package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2258 {
	
	static class Meat implements Comparable<Meat>{
		int weight, price;

		public Meat(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Meat o) {
			if(this.price==o.price) {
				return o.weight - this.weight;
			}
			return this.price - o.price;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans, sum[];
	static Meat[] meats;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		meats = new Meat[N];
		sum = new int[N];
		ans = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			meats[i] = new Meat(w, p); 
		}
		
		Arrays.sort(meats);
		
		int total_w = 0;
		int total_p = 0;
		boolean flag = false;
		for(int i=0; i<N; i++) {
			total_w += meats[i].weight;
			
			if(i!=0 && meats[i].price == meats[i-1].price) {
				total_p += meats[i].price;
			}else {
				total_p = meats[i].price;
			}
			
			if(total_w >= M) {
				ans = Math.min(ans, total_p);
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println(-1);
		}else System.out.println(ans);
	}
}
