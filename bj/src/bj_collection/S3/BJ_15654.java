package bj_collection.S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int nums[], select[];
	static boolean selected[];
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		select = new int[M];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		perm(0);
		bw.flush();
		bw.close();
	}
	
	public static void perm(int cnt) throws IOException{
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				bw.write(select[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			select[cnt] = nums[i];
			perm(cnt+1);
			selected[i] = false;
		}
	}
}
