package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657 {
	static int N, M;
	static int nums[], res[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		res = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		perm(0, 0, bw);
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt, int prev, BufferedWriter bw) throws IOException{
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				bw.write(res[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=prev; i<N; i++) {
			res[cnt] = nums[i];
			perm(cnt+1, i, bw);
		}
	}
}
